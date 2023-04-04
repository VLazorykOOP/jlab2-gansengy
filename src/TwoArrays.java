import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TwoArrays {
    private int[] array1;
    private int[] array2;
    private int[] array3;

    public TwoArrays() {
        Scanner scanner = new Scanner(System.in);

        int firstArraySize = 0;
        while (firstArraySize <= 0) {
            try {
                System.out.print("Enter size of the first array (positive integer): ");
                firstArraySize = Integer.parseInt(scanner.nextLine());
                if (firstArraySize <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }

        int secondArraySize = 0;
        while (secondArraySize <= 0) {
            try {
                System.out.print("Enter size of the second array (positive integer): ");
                secondArraySize = Integer.parseInt(scanner.nextLine());
                if (secondArraySize <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }

        array1 = new int[firstArraySize];
        array2 = new int[secondArraySize];
        array3 = new int[firstArraySize + secondArraySize];
    }

    public void randomizeArrays() {
        Random random = new Random();

        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(100);
        }

        for (int i = 0; i < array2.length; i++) {
            array2[i] = random.nextInt(100);
        }
    }

    public void sort() {
        //System.arraycopy(firstArray, 0, thirdArray, 0, firstArray.length);
        //System.arraycopy(secondArray, 0, thirdArray, firstArray.length, secondArray.length);

        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            array3[index++] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            array3[index++] = array2[i];
        }

        int n = array3.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array3[j] > array3[j + 1]) {
                    int temp = array3[j];
                    array3[j] = array3[j + 1];
                    array3[j + 1] = temp;
                }
            }
        }

    }

    public void printArrays() {
        System.out.println("First array: " + Arrays.toString(array1));
        System.out.println("Second array: " + Arrays.toString(array2));
        System.out.println("Third array: " + Arrays.toString(array3));
    }
}

