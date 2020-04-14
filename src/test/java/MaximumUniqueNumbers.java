// Java Program to find maximum number of
// Unique integers in Sub-Array
// of given size
import java.util.*;
class MaximumUniqueNumbers {
    // Function to find maximum number of
    // Unique integers in Sub-Array
    // of given size
    public static int maxUniqueNum(int arr[],int N, int M)
    {
        int maxUnique = 0;
        // Generate all subarrays of size M
        for (int i = 0; i < N - M; i++) {
            int currentUnique = 0;
            //- The objects  implement the hashcode() class.
            //- This class makes no guarantees as to the order of the map; in particular,
            // it does not guarantee that the order will remain constant over time.
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int k = i; k < i + M; k++) {
                // if the key is new to the map,
                // push the key in map and increment
                // count for unique number
                if (!map.containsKey(arr[k])) {
                    map.put(arr[i],1);
                    currentUnique++;
                    continue;
                }
            }

            if (currentUnique > maxUnique)
                maxUnique = currentUnique;
        }
        return maxUnique;
    }

    public static void main(String[] args)
    {
//        there are n*(n+1)/2 non-empty subarrays.
        int[] arr = {3,2,3,2,3,2}; //Output 2
        int[] arr1 = {7,7,7,7,7,5}; //Output 1
        int intNumbers = 6;

        int subArraySizeM = 3;

        System.out.println("Output: "+maxUniqueNum(arr, intNumbers, subArraySizeM));
        System.out.println();
        System.out.println("Output: "+maxUniqueNum(arr1, intNumbers, subArraySizeM));
    }
}
