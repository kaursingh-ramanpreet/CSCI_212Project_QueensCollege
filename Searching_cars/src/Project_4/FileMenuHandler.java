package Project_4;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class FileMenuHandler implements ActionListener {
    JFrame jframe;
    JTextArea unsortedArea, sortedArea;
    UnsortedCarList unsorted;
    SortedCarList sorted;
    CarGUI gui;

    public FileMenuHandler(CarGUI jf, JTextArea ua, JTextArea sa,
                           UnsortedCarList ulist, SortedCarList slist) {
        jframe = jf;
        unsortedArea = ua;
        sortedArea = sa;
        unsorted = ulist;
        sorted = slist;
        gui = jf;  // store reference to the GUI
    }

    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showOpenDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                readFile(file);
            }
        } else if (menuName.equals("Quit")) {
            System.exit(0);
        }
    }

    private void readFile(File file) {
        // Clear previous display
        unsortedArea.setText("");
        sortedArea.setText("");

        // ✅ Create new shared lists and sync them with GUI
        gui.unsortedList = new UnsortedCarList();
        gui.sortedList = new SortedCarList();

        unsorted = gui.unsortedList;
        sorted = gui.sortedList;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    Car car = new Car(line);
                    unsorted.add(car);
                    sorted.add(car);
                } catch (IllegalCarException e) {
                    System.out.println(e.getMessage());
                }
            }
            // Update display
            unsortedArea.setText(unsorted.toString());
            sortedArea.setText(sorted.toString());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jframe, "File not found.");
        }
    }
}
