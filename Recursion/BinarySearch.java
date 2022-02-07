import java.util.Random;

public class BinarySearch {

    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high)
            return false; // interval empty; no match
        else {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return true; // found a match
            else if (target < data[mid])
                return binarySearch(data, target, low, mid - 1); // recur left of the middle
            else
                return binarySearch(data, target, mid + 1, high); // recur right of the middle
        }
    }

    public static void main(String[] args) {
        //I think it doesn't work all the time, don't know why
        Random input = new Random();
        int[] randomNums = new int[10];
        for(int i = 0; i < 10; i++)
        {
            randomNums[i] = input.nextInt(0,6);
            System.out.print(randomNums[i] + " ");
        }
        System.out.println("\n");
        if(binarySearch(randomNums, 5, 0, 9))
            System.out.println("TRUE");
        else
            System.out.println("FALSE"); 
    }
}
