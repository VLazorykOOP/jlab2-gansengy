import java.util.Scanner;
import java.util.InputMismatchException;
public class Circle {
    private double radius;
    private double centerX;
    private double centerY;

    public Circle() {
        Scanner input = new Scanner(System.in);

        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the radius: ");
                this.radius = input.nextDouble();

                System.out.print("Enter the center X coordinate: ");
                this.centerX = input.nextDouble();

                System.out.print("Enter the center Y coordinate: ");
                this.centerY = input.nextDouble();

                validInput = true; // if all inputs are valid, exit the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine(); // Clear scanner buffer
            }
        }
    }

    public Circle(double radius) {
        this.radius = radius;
        this.centerX = 0;
        this.centerY = 0;
    }

    // компілятор буде однаково читати два конструктори з вхідними типами данних double, тому буде помилка
    // проблему можна вирішити створивши наступний конструктор
    public Circle(double radius, double num, char coordinateAssign) {
        this.radius = radius;

        if (coordinateAssign == 'x' || coordinateAssign == 'X') {
            this.centerX = num;
            this.centerY = 0;
        } else if (coordinateAssign == 'y' || coordinateAssign == 'Y') {
            this.centerX = 0;
            this.centerY = num;
        } else {
            throw new IllegalArgumentException("Invalid coordinateAssign: " + coordinateAssign);
        }
    }
    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public boolean containsPoint(double x, double y) {
        double distanceSquared = (x - centerX) * (x - centerX) + (y - centerY) * (y - centerY);
        return distanceSquared <= radius * radius;
    }

    public int getIntersectionPoints(Circle otherCircle) {
        double distanceBetweenCenters = Math.sqrt((centerX - otherCircle.centerX) * (centerX - otherCircle.centerX)
                + (centerY - otherCircle.centerY) * (centerY - otherCircle.centerY));
        double sumOfRadii = radius + otherCircle.radius;

        if (distanceBetweenCenters > sumOfRadii) {
            return 0;
        } else if (distanceBetweenCenters == sumOfRadii) {
            return 1;
        } else if (distanceBetweenCenters < sumOfRadii && distanceBetweenCenters > Math.abs(radius - otherCircle.radius)) {
            return 2;
        } else if (distanceBetweenCenters == 0 && radius == otherCircle.radius) {
            return -1;
        } else return 0;
    }
    public String toString() {
        return "Circle with radius " + radius + " and center at (" + centerX + ", " + centerY + ")";
    }

}

