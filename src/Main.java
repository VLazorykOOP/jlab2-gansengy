import java.util.Scanner;
public class Main {
    public static void FirstTask(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter hour: ");
        short hour = scanner.nextShort();

        System.out.print("Enter minute: ");
        short minute = scanner.nextShort();

        System.out.print("Enter second: ");
        short second = scanner.nextShort();

        Time t1 = new Time(hour, minute, second);

        System.out.print("Enter time string (hh:mm:ss): ");
        String timeString = scanner.next();

        Time t2 = new Time(timeString);

        System.out.print("Enter seconds: ");
        int seconds = scanner.nextInt();

        Time t3 = new Time(seconds);

        Time t4 = new Time(t1);

        t4.addSeconds(120);
        t3.subtractSeconds(60);

        int diffInSeconds = t1.differenceInSeconds(t2);
        int compareResult = t1.compareTo(t2);
        int sec = t1.toSeconds();
        int minutes = t3.toMinutes();

        System.out.println("1: " + t1);
        System.out.println("2: " + t2);
        System.out.println("3: " + t3);
        System.out.println("4: " + t4);

        System.out.println("\nDifference in seconds: " + diffInSeconds);
        System.out.println("Compare 1 to 2: " + compareResult);

        System.out.println("T1 to seconds: " + sec);
        System.out.println("T3 to minutes: " + minutes + "\n");

    }

    public static void SecondTask(){
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(3, 5, 'x');
        Circle circle3 = new Circle(2, 7, 'Y');

        System.out.println(circle1);
        System.out.println(circle2);
        System.out.println(circle3);

        double circumference = circle1.getCircumference();
        double area = circle1.getArea();

        System.out.println("\nCircumference (c1): " + circumference);
        System.out.println("Area (c1): " + area);

        boolean containsPoint = circle1.containsPoint(3, 4);

        System.out.println("Contains point ( c1 & point(3,4) ): " + containsPoint);

        int intersectionPoints = circle1.getIntersectionPoints(circle2);
        int intersectionPoints2 = circle1.getIntersectionPoints(circle3);
        int intersectionPoints3 = circle1.getIntersectionPoints(circle1);
        int intersectionPoints4 = circle2.getIntersectionPoints(circle3);

        System.out.println("\nIntersection points (c1&c2): " + intersectionPoints);
        System.out.println("Intersection points (c1&c3): " + intersectionPoints2);
        System.out.println("Intersection points (c1&c1): " + intersectionPoints3);
        System.out.println("Intersection points (c2&c3): " + intersectionPoints4 + "\n");
    }

    public static void ThirdTask(){
        TwoArrays test = new TwoArrays();

        test.randomizeArrays();

        test.printArrays();

        test.sort();

        System.out.println();

        test.printArrays();
    }

    public static void main(String[] args) {
        System.out.println("Java Lab 2 ");

        char answer;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Time");
            System.out.println("2. Circle");
            System.out.println("3. Two random arrays");
            System.out.println("E. Exit\n");
            System.out.print("Choose an option:");

            answer = scanner.nextLine().charAt(0);

            switch (answer) {
                case '1': FirstTask();
                    break;
                case '2': SecondTask();
                    break;
                case '3': ThirdTask();
                    break;
                case 'e':
                case 'E':
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (answer != 'e' && answer != 'E');
    }
}
