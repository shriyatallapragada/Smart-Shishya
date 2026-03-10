package proj.main;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.BorderLayout;
import javax.swing.*;
import proj.lib.Lib;
import proj.org.SchedulePanel;
import proj.todo.TodoGUI_CheckboxFirst;

public class MenuApp {

    public static void main(String args[]) {
        JFrame f = new JFrame("Smart Shishya");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel Home = new JPanel(new BorderLayout());
        
        JLabel homeHeader = new JLabel("  Upcoming Reminders (Next 7 Days):");
        Home.add(homeHeader, BorderLayout.NORTH);
        
        JTextArea reminderDisplay = new JTextArea();
        reminderDisplay.setEditable(false); 
        
        String reminders = getUpcomingReminders("data/exams.txt");
        reminderDisplay.setText(reminders);
        
        Home.add(new JScrollPane(reminderDisplay), BorderLayout.CENTER);

        Lib libPanel = new Lib();
        
        SchedulePanel sp = new SchedulePanel();
        TodoGUI_CheckboxFirst To = new TodoGUI_CheckboxFirst(sp);

        JTabbedPane tp = new JTabbedPane();
        tp.add("Home", Home);
        tp.add("Library", libPanel);
        tp.add("Calendar", sp.getPanel());
        tp.add("To-Do List", To);

        f.add(tp);
        f.setSize(800, 400);
        f.setVisible(true);
    }

    private static String getUpcomingReminders(String filePath) {
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);

        if (!file.exists()) {
            return "File not found: " + filePath;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean foundAny = false;

            while ((line = br.readLine()) != null) {
                // CHANGED: Split by ":" instead of ","
                String[] parts = line.split(":");
                
                if (parts.length >= 2) {
                    String dateString = parts[0].trim();
                    String eventName = parts[1].trim();

                    try {
                        LocalDate eventDate = LocalDate.parse(dateString, formatter);

                        if (!eventDate.isBefore(today) && !eventDate.isAfter(nextWeek)) {
                            sb.append("• ").append(eventName)
                              .append(" (").append(eventDate).append(")\n");
                            foundAny = true;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Skipping invalid date format: " + dateString);
                    }
                }
            }
            
            if (!foundAny) {
                return "No exams in the next 7 days!";
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file.";
        }

        return sb.toString();
    }
}