package Project_4;

/**
 * Project_4.UnsortedCarList class extends Project_4.CarList to maintain an unsorted linked list of Project_4.Car objects.
 * Cars are added to the end of the list in the order they are received.
 */
public class UnsortedCarList extends CarList {
    /**
     * Adds a car to the end of the unsorted list.
     * @param c The car to add to the list
     */
    public void add(Car c) {
        append(c);
    }
}