package Project_4;

import javax.swing.*;
import java.awt.event.*;

/**
 * Project_4.EditMenuHandler class handles the search functionality in the car list application.
 * Implements ActionListener to process search menu item clicks.
 */
public class EditMenuHandler implements ActionListener {
    /** Reference to the main GUI window */
    CarGUI gui;

    /**
     * Constructor initializes the handler with a reference to the main GUI.
     * @param gui The main Project_4.CarGUI instance
     */
    public EditMenuHandler(CarGUI gui) {
        this.gui = gui;
    }

    /**
     * Handles the search action when the search menu item is clicked.
     * Prompts user for input, searches for matching cars, and updates the display.
     * @param e The action event that triggered this handler
     */
    public void actionPerformed(ActionEvent e) {
        // Get search input from user
        String input = JOptionPane.showInputDialog(null, "Enter Project_4.Car Make or Model (e.g., Toyota or Corolla):");
        if (input == null || input.trim().isEmpty())
            return;

        // Initialize filtered lists for storing search results
        String search = input.trim().toLowerCase();
        UnsortedCarList filteredUnsorted = new UnsortedCarList();
        SortedCarList filteredSorted = new SortedCarList();

        // Search through the unsorted list for matches
        CarNode current = gui.getUnsortedList().first.next;
        while (current != null) {
            String make = current.data.getMake().toLowerCase();
            String model = current.data.getModel().toLowerCase();

            System.out.println("DEBUG: " + make + " | " + model); // ← print each car
            System.out.println("Comparing with: " + search);

            // Add matching cars to both filtered lists
            if (make.equals(search) || model.equals(search)) {
                System.out.println("MATCH FOUND!");
                filteredUnsorted.add(current.data);
                filteredSorted.add(current.data);
            }

            current = current.next;
        }

        // Display message if no matches found
        if (filteredUnsorted.toString().isBlank()) {
            JOptionPane.showMessageDialog(null, "No cars found for: " + input);
        }

        // Update the GUI with search results
        gui.updateTextAreas(filteredUnsorted.toString(), filteredSorted.toString());
    }
}
