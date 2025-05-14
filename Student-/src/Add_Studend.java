package Student_management_system;

import javax.swing.*;

public class AddStudentWindow extends JFrame {
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton submitButton;

    public AddStudentWindow() {
        setTitle("Add Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Only close this window
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(null);

        nameLabel = new JLabel("Enter Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 180, 30);
        add(nameField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(130, 120, 120, 30);
        add(submitButton);

        setVisible(true);
    }
}
