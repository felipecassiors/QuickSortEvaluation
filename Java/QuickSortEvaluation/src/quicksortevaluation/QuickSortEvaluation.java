package quicksortevaluation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class QuickSortEvaluation {
    public static final int N = 500000;
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        File file = new File("../../array.txt");
        Scanner scanner = new Scanner(file);
        int array[] = new int[N]; 
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();
        long endFileTime = System.currentTimeMillis();
        quickSort(array, 0, N-1);
        long endTime = System.currentTimeMillis();
        double totalTime = (double) ((endTime - startTime) / 1000000.0);
        double fileTime = (double) ((endFileTime - startTime) / 1000000.0);
        double quickSortTime = (double) ((endTime - endFileTime) / 1000000.0);
        System.out.printf("Total of numbers: %d\n",N);
        System.out.printf("File time: %f seconds\n",fileTime);
        System.out.printf("Quick Sort time: %f seconds\n",quickSortTime);
        System.out.printf("Total time: %f seconds\n",totalTime);
    }
    public static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if(left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if(index < right) {
            quickSort(arr, index, right);
        }
    }
    private static int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];
        while(i <= j) {
            while(arr[i] < pivot) {
                i++;
            }
            while(arr[j] > pivot) {
                j--;
            }
            if(i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
}