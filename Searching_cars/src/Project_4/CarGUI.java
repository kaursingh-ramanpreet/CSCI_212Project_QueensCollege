package Project_4;

import javax.swing.*;
import java.awt.*;

/**
 * Project_4.CarGUI class creates a graphical user interface for displaying and managing car lists.
 * It provides two text areas for showing unsorted and sorted car lists, along with
 * menu options for file operations and searching.
 */
public class CarGUI extends JFrame {
    // Text areas for displaying unsorted and sorted car lists
    JTextArea unsortedArea = new JTextArea();
    JTextArea sortedArea = new JTextArea();

    // Lists to store unsorted and sorted car data
    UnsortedCarList unsortedList = new UnsortedCarList();
    SortedCarList sortedList = new SortedCarList();

    /**
     * Constructor initializes the GUI with two text areas and menu options.
     * Sets up the window properties and creates File and Edit menus.
     */
    public CarGUI() {
        super("Project 4: Project_4.Car List");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        unsortedArea.setEditable(false);
        sortedArea.setEditable(false);

        // Add scrollable text areas to the frame
        add(new JScrollPane(unsortedArea));
        add(new JScrollPane(sortedArea));

        JMenuBar menuBar = new JMenuBar();

        // Create and configure File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem quit = new JMenuItem("Quit");
        fileMenu.add(open);
        fileMenu.add(quit);
        menuBar.add(fileMenu);

        // Set up file menu event handling
        FileMenuHandler fmh = new FileMenuHandler(this, unsortedArea, sortedArea, unsortedList, sortedList);
        open.addActionListener(fmh);
        quit.addActionListener(fmh);

        // Create and configure Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem search = new JMenuItem("Search");
        search.addActionListener(new EditMenuHandler(this));
        editMenu.add(search);
        menuBar.add(editMenu);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    /**
     * Returns the unsorted car list.
     * @return Project_4.UnsortedCarList containing unsorted car data
     */
    public UnsortedCarList getUnsortedList() {
        return unsortedList;
    }

    /**
     * Returns the sorted car list.
     * @return Project_4.SortedCarList containing sorted car data
     */
    public SortedCarList getSortedList() {
        return sortedList;
    }

    /**
     * Updates the text areas with new unsorted and sorted car data.
     * @param unsorted String representation of unsorted car list
     * @param sorted String representation of sorted car list
     */
    public void updateTextAreas(String unsorted, String sorted) {
        unsortedArea.setText(unsorted);
        sortedArea.setText(sorted);
    }

    /**
     * Main method to create and display the GUI.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new CarGUI();
    }
}
