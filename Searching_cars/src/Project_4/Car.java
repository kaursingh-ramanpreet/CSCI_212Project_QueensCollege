package Project_4;
/**
 * Project_4.Car class represents a car with make, model, year, and mileage attributes.
 * Implements Comparable interface to enable sorting of Project_4.Car objects.
 */
public class Car implements Comparable<Car> {
    // Instance variables to store car details
    String make, model;    // Make and model of the car
    int year, mileage;     // Year of manufacture and current mileage

    /**
     * Constructor that parses a comma-separated string to create a Project_4.Car object.
     * @param line A string in format "make,model,year,mileage"
     * @throws IllegalCarException if the input format is invalid or contains negative mileage
     */
    public Car(String line) throws IllegalCarException {
        String[] tokens = line.split(",");
        if (tokens.length != 4) {
            throw new IllegalCarException("Invalid number of tokens: " + line);
        }

        make = tokens[0].trim();
        model = tokens[1].trim();
        try {
            year = Integer.parseInt(tokens[2].trim());
            mileage = Integer.parseInt(tokens[3].trim());
        } catch (NumberFormatException e) {
            throw new IllegalCarException("Invalid number format: " + line);
        }

        if (mileage < 0) {
            throw new IllegalCarException("Negative mileage: " + line);
        }
    }

    /**
     * Returns a string representation of the car.
     * @return String in format "year make model mileage"
     */
    public String toString() {
        return year + " " + make + " " + model + " " + mileage;
    }

    /**
     * Compares this car to another car based on year, make, and model.
     * Comparison is case-insensitive for make and model.
     * @param other The car to compare with
     * @return negative if this car is less than other, 0 if equal, positive if greater
     */
    @Override
    public int compareTo(Car other) {
        if (this.year != other.year) {
            return this.year - other.year;
        }
        int makeCompare = this.make.compareToIgnoreCase(other.make);
        if (makeCompare != 0) {
            return makeCompare;
        }
        return this.model.compareToIgnoreCase(other.model);
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
    
}
