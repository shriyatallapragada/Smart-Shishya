package proj.lib;
import javax.swing.*;
import java.awt.*;
import java.net.URI;
public class Lib extends JPanel {
    public Lib() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton menuButton1 = new JButton("I Btech Sem 1");

        JPanel subMenuPanel1 = new JPanel();
        subMenuPanel1.setLayout(new GridLayout(6, 1));
        subMenuPanel1.setVisible(false); 

        JButton b1 = new JButton("Matrices and Calculus");
        JButton b2 = new JButton("Engineering Chemistry");
        JButton b3 = new JButton("Programming for Problem Solving");
        JButton b4 = new JButton("Basic Electrical Engineering");
        JButton b5 = new JButton("Computer Aided Engineering Graphics");
        JButton b6 = new JButton("Elements of Computer Science & Engineering");
        b1.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1X4k8ZQ5yRbm3C2kM4OC_X764qRwQQ4mg?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b2.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1SrQqxKnX9ChWNTJb8L_vP7IO2-tP8gAh?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b3.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1UFs0mPXE97lx74qXw9f8cYFnDHJtrCz1?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b4.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1oJLFHvOWgHspdUzB9IOZYz1wpWukSmk7?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b5.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1P5pfWFs1dLzzcwIoKyeuhSRtv8GefuZY?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b6.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1rWU9ETI9cnl72TEWbqO52dnrJCBs8iUk?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        subMenuPanel1.add(b1);
        subMenuPanel1.add(b2);
        subMenuPanel1.add(b3);
        subMenuPanel1.add(b4);
        subMenuPanel1.add(b5);
        subMenuPanel1.add(b6);

        menuButton1.addActionListener(e -> {
            subMenuPanel1.setVisible(!subMenuPanel1.isVisible());
            this.revalidate();
            this.repaint();
        });
        this.add(menuButton1);
        this.add(subMenuPanel1);
        JButton menuButton2 = new JButton("I Btech Sem 2");

        JPanel subMenuPanel2 = new JPanel();
        subMenuPanel2.setLayout(new GridLayout(6, 1));
        subMenuPanel2.setVisible(false); 

        JButton b21 = new JButton("Ordinary Differential Equations and Vector Calculus");
        JButton b22 = new JButton("Applied Physics");
        JButton b23 = new JButton("Environmental Science");
        JButton b24 = new JButton("English for Skill Enhancement");
        JButton b25 = new JButton("Electronic Devices and Circuits");
        JButton b26 = new JButton("Python Programming Laboratory");
        b21.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1hZDGtFtqi4UJ96CL7rOl9ZPw4HW0gzw8?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b22.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1gTiEUlW6jka3wsHq0Fx-K4oTAtJxDX2d?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b23.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1-DEyE_IJnkk8GpDXoqLgTpe6V31mCAWz?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b24.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1-TOBnspUv-oPTQITszdKqHyhFmdVDg7o?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b25.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1GsFgIREAhLO9AVGsfQOdLSXTEYA94di5?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b26.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1BnmOfhUyfKgnUKfefKOCo2OOAx_u-wUh?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        subMenuPanel2.add(b21);
        subMenuPanel2.add(b22);
        subMenuPanel2.add(b23);
        subMenuPanel2.add(b24);
        subMenuPanel2.add(b25);
        subMenuPanel2.add(b26);

        menuButton2.addActionListener(e -> {
            subMenuPanel2.setVisible(!subMenuPanel2.isVisible());
            this.revalidate();
            this.repaint();
        });
        this.add(menuButton2);
        this.add(subMenuPanel2);
        JButton menuButton3 = new JButton("II Btech Sem 1");

        JPanel subMenuPanel3 = new JPanel();
        subMenuPanel3.setLayout(new GridLayout(6, 1));
        subMenuPanel3.setVisible(false); 

        JButton b31 = new JButton("Digital Electronics");
        JButton b32 = new JButton("Data Structures");
        JButton b33 = new JButton("Computer Oriented Statistical Methods");
        JButton b34 = new JButton("Computer Organization and Architecture");
        JButton b35 = new JButton("Object Oriented Programming through Java");
        JButton b36 = new JButton("Data visualization- R Programming/ Power BI");
        b31.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/17t8oLy1Ucr8pN1HquunAIQhqqUqFUOV_?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b32.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1PQvz3BcCpmBUpirf1-snz8Jb1h27nnFt?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b33.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1c9473Z7uXdno9k6fTn1AwebWH_GMUV2P?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b34.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1mR5qD2kryA7K8YApuU5jED34QC9stQDG?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b35.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1fnElUtdY086g1d8VumM61NXG4vHPLQjk?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b36.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1ckBzzROFZ9WpfdXFa_HBS2XObl19YjKD?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        subMenuPanel3.add(b31);
        subMenuPanel3.add(b32);
        subMenuPanel3.add(b33);
        subMenuPanel3.add(b34);
        subMenuPanel3.add(b35);
        subMenuPanel3.add(b36);

        menuButton3.addActionListener(e -> {
            subMenuPanel3.setVisible(!subMenuPanel3.isVisible());
            this.revalidate();
            this.repaint();
        });
        this.add(menuButton3);
        this.add(subMenuPanel3);
        JButton menuButton4 = new JButton("II Btech Sem 2");

        JPanel subMenuPanel4 = new JPanel();
        subMenuPanel4.setLayout(new GridLayout(6, 1));
        subMenuPanel4.setVisible(false); 

        JButton b41 = new JButton("Discrete Mathematics");
        JButton b42 = new JButton("Business Economics & Financial Analysis");
        JButton b43 = new JButton("Operating Systems");
        JButton b44 = new JButton("Database Management Systems");
        JButton b45 = new JButton("Software Engineering");
        JButton b46 = new JButton("Node JS/ React JS/ Django");
        b41.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/11cLiJk7dlJPpZxXFyP40a9UMOPGs--or?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b42.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/18CSOcrZYFBw0qJsO7OsjHQgNfOEg2nD9?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b43.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1Jn8PsdOEOwgd4XER1a92sI5pOm6hpA32?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b44.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1J-X1czYHdkIbRIuziCs2HHuaK-xfzhP8?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b45.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1sA2yEh7CLiqou7xaFqhnir-cTUhE76ue?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        b46.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1UVsnp8Let7XqxcxCyH1LkTkZ7m8fUHmV?usp=drive_link"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        subMenuPanel4.add(b41);
        subMenuPanel4.add(b42);
        subMenuPanel4.add(b43);
        subMenuPanel4.add(b44);
        subMenuPanel4.add(b45);
        subMenuPanel4.add(b46);

        menuButton4.addActionListener(e -> {
            subMenuPanel4.setVisible(!subMenuPanel4.isVisible());
            this.revalidate();
            this.repaint();
        });
        this.add(menuButton4);
        this.add(subMenuPanel4);
    }
}