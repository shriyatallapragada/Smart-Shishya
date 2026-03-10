package proj.todo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.*;

import proj.org.SchedulePanel;

enum Priority {
    LOW, MEDIUM, HIGH
}

class Task {
    String description;
    LocalDate deadline;
    Priority priority;
    boolean isCompleted;

    Task(String description, LocalDate deadline, Priority priority) {
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.isCompleted = false;
    }
}

public class TodoGUI_CheckboxFirst extends JPanel {

    private static final DateTimeFormatter INPUT_FORMAT =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final String TASK_FILE =
            System.getProperty("user.dir") + File.separator + "data" + File.separator + "tasks.txt";

    private SchedulePanel schedulePanel;
    private ArrayList<Task> tasks = new ArrayList<>();

    private JTextField descField;
    private JTextField deadlineField;
    private JComboBox<Priority> priorityBox;
    private JTable table;
    private DefaultTableModel model;

    public TodoGUI_CheckboxFirst(SchedulePanel sp) {
        this.schedulePanel = sp;
        setSize(750, 400);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 10, 10));

        descField = new JTextField();
        deadlineField = new JTextField();
        priorityBox = new JComboBox<>(Priority.values());

        inputPanel.add(new JLabel("Description"));
        inputPanel.add(new JLabel("Deadline (dd-mm-yyyy)"));
        inputPanel.add(new JLabel("Priority"));
        inputPanel.add(new JLabel(""));

        inputPanel.add(descField);
        inputPanel.add(deadlineField);
        inputPanel.add(priorityBox);

        JButton addBtn = new JButton("Add Task");
        inputPanel.add(addBtn);

        add(inputPanel, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new Object[]{"Done", "Description", "Deadline", "Priority"}, 0
        ) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton deleteBtn = new JButton("Delete Task");
        add(deleteBtn, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addTask());
        deleteBtn.addActionListener(e -> deleteTask());

        model.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int col = e.getColumn();
            if (row >= 0 && col == 0) {
                tasks.get(row).isCompleted =
                        (Boolean) model.getValueAt(row, 0);
                rewriteAllTasks();
            }
        });

        loadTasksFromFile();
    }

    private void addTask() {
        try {
            String desc = descField.getText();
            LocalDate deadline =
                    LocalDate.parse(deadlineField.getText(), INPUT_FORMAT);
            Priority priority =
                    (Priority) priorityBox.getSelectedItem();

            Task task = new Task(desc, deadline, priority);
            tasks.add(task);
            saveTaskToFile(task);

            String formattedDate = deadline.format(INPUT_FORMAT);
            model.addRow(new Object[]{
                    false,
                    task.description,
                    formattedDate,
                    task.priority.toString()
            });

            schedulePanel.addAssignment(formattedDate, task.description);

            descField.setText("");
            deadlineField.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid input!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteTask() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        tasks.remove(row);
        model.removeRow(row);
        rewriteAllTasks();
    }

    private void loadTasksFromFile() {
        File file = new File(TASK_FILE);
        if (!file.exists()) return;

        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length != 4) continue;

                LocalDate date =
                        LocalDate.parse(parts[0].trim(), INPUT_FORMAT);
                Priority priority =
                        Priority.valueOf(parts[1].trim());
                String desc = parts[2].trim();
                boolean completed =
                        Boolean.parseBoolean(parts[3].trim());

                Task task = new Task(desc, date, priority);
                task.isCompleted = completed;
                tasks.add(task);

                model.addRow(new Object[]{
                        completed,
                        desc,
                        date.format(INPUT_FORMAT),
                        priority.toString()
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveTaskToFile(Task task) {
        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(TASK_FILE, true))) {

            bw.write(task.deadline.format(INPUT_FORMAT)
                    + " | " + task.priority
                    + " | " + task.description
                    + " | " + task.isCompleted);
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void rewriteAllTasks() {
        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(TASK_FILE))) {

            for (Task task : tasks) {
                bw.write(task.deadline.format(INPUT_FORMAT)
                        + " | " + task.priority
                        + " | " + task.description
                        + " | " + task.isCompleted);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
