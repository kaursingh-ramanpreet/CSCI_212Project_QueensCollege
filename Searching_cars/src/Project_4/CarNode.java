package Project_4;

/**
 * Project_4.CarNode class represents a node in a linked list of Project_4.Car objects.
 * Each node contains a Project_4.Car object and a reference to the next node.
 */
public class CarNode {
    /** The Project_4.Car object stored in this node */
    protected Car data;
    /** Reference to the next node in the linked list */
    protected CarNode next;

    /**
     * Constructor creates a new node with the specified Project_4.Car object.
     * @param c The Project_4.Car object to store in this node
     */
    public CarNode(Car c) {
        data = c;
        next = null;
    }
}
