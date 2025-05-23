package Student_management_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame {
    private JLabel nameLabel;
    private JButton submitButton;

    public AddStudent() {
        setTitle("Add Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Only close this window
        setLayout(null);
        setSize(600, 500);
        setLocationRelativeTo(null);

        nameLabel = new JLabel("Enter Full Name:");
        nameLabel.setBounds(60, 50, 150, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 50, 250, 30);
        add(nameField);
        nameLabel = new JLabel("Enter Father Name:");
        nameLabel.setBounds(60, 80, 150, 30);
        add(nameLabel);

        JTextField fnameField = new JTextField();
        fnameField.setBounds(200, 80, 250, 30);
        add(fnameField);

        nameLabel = new JLabel("Select Gender:");
        nameLabel.setBounds(60, 110, 150, 30);
        add(nameLabel);
        String [] items={"Male","Female"};
        JComboBox comboBox = new JComboBox<>(items);
        comboBox.setBounds(200, 110, 180, 30);
        add(comboBox);

        nameLabel = new JLabel("Enter Date of Birth: ");
        nameLabel.setBounds(60, 140, 150, 30);
        add(nameLabel);
        JTextField DOBField = new JTextField();
        DOBField.setBounds(200, 140, 250, 30);
        add(DOBField);

        nameLabel = new JLabel("Enter Email: ");
        nameLabel.setBounds(60, 170, 150, 30);
        add(nameLabel);
        JTextField EmailField = new JTextField();
        EmailField.setBounds(200, 170, 250, 30);
        add(EmailField);

        nameLabel = new JLabel("Enter Phone Number: ");
        nameLabel.setBounds(60, 200, 150, 30);
        add(nameLabel);
        JTextField PHField = new JTextField();
        PHField.setBounds(200, 200, 250, 30);
        add(PHField);

        nameLabel = new JLabel("Enter Address: ");
        nameLabel.setBounds(60, 230, 150, 30);
        add(nameLabel);

        JTextArea textArea = new JTextArea(8,20);
        textArea.setBounds(205, 240, 150, 30);
        add(textArea);

        nameLabel = new JLabel("Select Course:");
        nameLabel.setBounds(60, 290, 150, 30);
        add(nameLabel);
        String [] item={"Computer Science","Mathematics","Physics","Political Science"};
        JComboBox ccomboBox = new JComboBox<>(item);
        ccomboBox.setBounds(200, 290, 180, 30);
        add(ccomboBox);

        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 380, 120, 30);
        add(submitButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(280, 380, 120, 30);
        add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int number = 100000 + rand.nextInt(900000); // 6-digit number
                String id =  "STU" + number;
                JOptionPane.showMessageDialog(AddStudent.this,"Student ID: "+id+
                        "\nName: "+nameField.getText()+"\nDob: "+DOBField.getText()+"\nfather Name: "+fnameField.getText()+
                        "\nCourse: "+ccomboBox.getSelectedItem()+"\nEmail: "+EmailField.getText()+
                        "\nPhone Number: "+PHField.getText()+"\nAddress: "+textArea.getText()+
                        "\nGender: "+comboBox.getSelectedItem()
                        ,"Add Student",JOptionPane.PLAIN_MESSAGE);
            }
        });

        setVisible(true);
    }
}
