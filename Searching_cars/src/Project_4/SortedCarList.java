package Project_4;

/**
 * Project_4.SortedCarList class extends Project_4.CarList to maintain a sorted linked list of Project_4.Car objects.
 * Cars are sorted based on their natural ordering (defined by compareTo method).
 */
public class SortedCarList extends CarList {
    /**
     * Adds a car to the list while maintaining sorted order.
     * Uses insertion sort algorithm to place the car in the correct position.
     * @param c The car to add to the sorted list
     */
    public void add(Car c) {
        // Create new node for the car
        CarNode newNode = new CarNode(c);
        // Start from the dummy head node
        CarNode prev = first;
        // Get the first actual car node
        CarNode curr = first.next;

        // Traverse list until we find the correct position
        // Stop when we reach the end or find a car that should come after the new car
        while (curr != null && c.compareTo(curr.data) > 0) {
            prev = curr;
            curr = curr.next;
        }

        // Insert the new node between prev and curr
        newNode.next = curr;
        prev.next = newNode;
        // Update last pointer if we inserted at the end
        if (newNode.next == null) {
            last = newNode;
        }
        // Increment the length counter
        length++;
    }
}
