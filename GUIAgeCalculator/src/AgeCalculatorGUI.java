
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AgeCalculatorGUI().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        addComponentsToPane(frame.getContentPane());

        frame.setVisible(true);
    }

    private void addComponentsToPane(Container pane) {
        pane.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel birthDateLabel = new JLabel("Enter your birth date (YYYY-MM-DD):");
        JTextField birthDateField = new JTextField();
        JButton calculateButton = new JButton("Calculate Age");
        JLabel ageLabel = new JLabel("Your age is: ");
        JLabel resultLabel = new JLabel();

        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(calculateButton);
        panel.add(ageLabel);
        panel.add(resultLabel);

        pane.add(panel, BorderLayout.CENTER);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String birthDateText = birthDateField.getText();
                try {
                    LocalDate birthDate = LocalDate.parse(birthDateText);
                    int age = calculateAge(birthDate, LocalDate.now());
                    resultLabel.setText(String.valueOf(age));
                } catch (Exception ex) {
                    resultLabel.setText("Invalid date format");
                }
            }
        });
    }

    private int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
	


