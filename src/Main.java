import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void customSort(int[] arr) {
        // Phân loại các phần tử theo điều kiện
        int[] evenDivisibleBy3 = Arrays.stream(arr)
                .filter(x -> x % 2 == 0 && x % 3 == 0)
                .sorted()
                .toArray();

        int[] oddDivisibleBy3 = Arrays.stream(arr)
                .filter(x -> x % 2 != 0 && x % 3 == 0)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int[] otherElements = Arrays.stream(arr)
                .filter(x -> (x % 2 != 0 && x % 3 != 0) || (x % 2 == 0 && x % 3 != 0))
                .sorted()
                .toArray();

        // Gộp các mảng đã sắp xếp
        int index = 0;
        for (int i = 0; i < evenDivisibleBy3.length; i++) {
            arr[index++] = evenDivisibleBy3[i];
        }

        for (int i = 0; i < otherElements.length; i++) {
            arr[index++] = otherElements[i];
        }

        for (int i = 0; i < oddDivisibleBy3.length; i++) {
            arr[index++] = oddDivisibleBy3[i];
        }
    }

    public static void main(String[] args) {
        int[] myArray = {9, 18, 4, 6, 7, 12, 15, 21, 24, 27, 10};
        customSort(myArray);
        System.out.println("Sorted array:");
        for (int num : myArray) {
            System.out.print(num + " ");
        }
    }
}