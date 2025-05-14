package Project_4;

/**
 * Abstract class representing a linked list of Project_4.Car objects.
 * Provides basic functionality for managing a list of cars.
 */
public abstract class CarList {
    /** First node in the list (dummy head) */
    protected CarNode first;
    /** Last node in the list */
    protected CarNode last;
    /** Number of cars in the list */
    protected int length;

    /**
     * Constructor initializes an empty list with a dummy head node.
     */
    public CarList() {
        first = last = new CarNode(null); // dummy head
        length = 0;
    }

    /**
     * Appends a car to the end of the list.
     * @param c The car to append
     */
    protected void append(Car c) {
        CarNode node = new CarNode(c);
        last.next = node;
        last = node;
        length++;
    }

    /**
     * Abstract method to add a car to the list.
     * Implementation depends on whether the list should be sorted or unsorted.
     * @param c The car to add
     */
    public abstract void add(Car c);

    /**
     * Returns a string representation of the list.
     * Each car is printed on a new line.
     * @return String containing all cars in the list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        CarNode current = first.next;
        while (current != null) {
            sb.append(current.data.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}
