import java.util.Random;

public class Reverse_Array {
    public static void reverseArray(int[] data, int low, int high) {
        if (low < high) { // if at least two elements in subarray
            int temp = data[low]; // swap data[low] and data[high]
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1); // recur on the rest
        }
    }
    public static void main(String[] args) {
          Random input = new Random();
          int[] randomNums = new int[10];
          System.out.println("Original : ");
          for(int i = 0; i < 10; i++)
          {
              randomNums[i] = input.nextInt(0,6);
              System.out.print(randomNums[i] + " ");
          }
          System.out.println("\n");
          System.out.println("Modified : ");
          reverseArray(randomNums, 0, 9);
          for(int i = 0; i < 10; i++)
          {
              System.out.print(randomNums[i] + " ");
          }
    }
}