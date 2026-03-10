package proj.org;
import javax.swing.*;
import java.awt.*;
import java.io.*;


public class SchedulePanel {

    private JPanel mainPanel;

    private DefaultListModel<String> holidayModel = new DefaultListModel<>();
    private DefaultListModel<String> examModel = new DefaultListModel<>();
    private DefaultListModel<String> paymentModel = new DefaultListModel<>();
    private void loadFromFile(String filePath, DefaultListModel<String> model) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    model.addElement(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load: " + filePath);
        }
    }

    public SchedulePanel() {

        mainPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // ---------- HOLIDAYS ----------
        JList<String> holidayList = new JList<>(holidayModel);
        JPanel holidayPanel = createPanel("Holidays", holidayList);
        loadFromFile("data/holidays.txt", holidayModel);


        // ---------- EXAMS & ASSIGNMENTS ----------
        JList<String> examList = new JList<>(examModel);
        JPanel examPanel = createPanel("Exams & Assignments", examList);
        loadFromFile("data/exams.txt", examModel);

        // ---------- PAYMENT REMINDERS ----------
        JList<String> paymentList = new JList<>(paymentModel);
        JPanel paymentPanel = createPanel("Payment Reminders", paymentList);
        loadFromFile("data/payments.txt", paymentModel);
        mainPanel.add(holidayPanel);
        mainPanel.add(examPanel);
        mainPanel.add(paymentPanel);
    }

    private JPanel createPanel(String title, JList<String> list) {
        JPanel p = new JPanel(new BorderLayout());
        JLabel l = new JLabel(title, JLabel.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 14));
        p.add(l, BorderLayout.NORTH);
        p.add(new JScrollPane(list), BorderLayout.CENTER);
        return p;
    }

    public JPanel getPanel() {
        return mainPanel;
    }
    private void appendToFile(String filePath, String text) {
        try (FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw)) {

            bw.newLine();
            bw.write(text);

        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
    public void addAssignment(String date, String description) {
        String entry = date + " : " + description;
        examModel.addElement(entry);
        appendToFile("data/exams.txt", entry);
    }
}
