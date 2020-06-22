import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

//finding a maximum unique numbers in sub-array

public class Collections {

    public void uniqueMaxValue(int  theTotalNumberOfIntegers, int subArraySize, int... list) {

        int highestUniqueValue = 1;
        Deque<Integer> queue = new LinkedList<>();
        Integer[] subArray;

        // transferring queue contents into list
        for (int i = 0; i < theTotalNumberOfIntegers; i++) {
            queue.add(list[i]);
        }

        Integer[] queueArray = new Integer[queue.size()];
        queue.toArray(queueArray);

        System.out.println("List size: " + queue.size());
        System.out.println("SubArray: " + subArraySize);
        System.out.println("Queue: " + Arrays.toString(queueArray) + "\n");

        int begin = 0;

        //copy contents of queue into subArray
        for (int i = 0; i < theTotalNumberOfIntegers; i++) {
            subArray = Arrays.copyOfRange(queueArray, begin, subArraySize);

            if (queueArray[i].equals(queueArray[theTotalNumberOfIntegers - subArraySize + 2])) {
                continue;
            }
            int uniqueNumber = theUniqueNumber(subArray);

            System.out.println(Arrays.toString(subArray) + " has " + uniqueNumber + " unique numbers.");
            if (highestUniqueValue <= uniqueNumber) {
                highestUniqueValue = uniqueNumber;
                begin++;
                subArraySize++;
            }
        }
        System.out.println(" ");
        System.out.println("Highest unique number : " + highestUniqueValue);
    }

   // find highest unique number
    private int theUniqueNumber(Integer[] subArray) {
        int numberOfUniqueValues;
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(subArray));
        numberOfUniqueValues = hashSet.size();
        return numberOfUniqueValues;
    }

    public static void main(String[] args) {
        Collections collections = new Collections();
        collections.uniqueMaxValue(9,3,6, 2, 6, 8, 3, 7, 1, 4, 4);
    }
}
