import javax.swing.*;
import java.awt.event.*;

public class Service extends JFrame {
    private JLabel label;
    private JComboBox<String> comboBox;
    private JButton button;

    public Service() {
        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400, 200);
        setLocationRelativeTo(null);

        label = new JLabel("Please select the service:");
        label.setBounds(100, 20, 200, 30);
        add(label);

        String[] items = {"Add Student", "Delete Student", "Search Student"};
        comboBox = new JComboBox<>(items);
        comboBox.setBounds(100, 60, 200, 30);
        add(comboBox);

        button = new JButton("Proceed");
        button.setBounds(130, 110, 140, 30);
        add(button);

        // Action Listener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = (String) comboBox.getSelectedItem();
                if (choice.equals("Add Student")) {
                    new Student_management_system.AddStudentWindow();
                }
                // else if (...) for other windows later
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Service();
    }
}
