import java.util.LinkedList;


public class ListFunctions {


    // find max long variable in a linked list
    public static Long findMaxLong(LinkedList<Long> list) {
        int size = list.size();
        long max = list.get(0);
        for (int i = 0; i < size; i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
        return max;
    }
    // find min long variable in a linked list
    public static Long findMinLong(LinkedList<Long> list) {
        int size = list.size();
        long min = list.get(0);
        for (int i = 1; i < size; i++) {
            if (min > list.get(i)) {
                min = list.get(i);
            }
        }
        return min;
    }

    // find median int variable in a linked list
    public static Integer findMedInt(LinkedList<Integer> list) {
        int size = list.size();
        int med = size/2;
        return list.get(med);
    }

    // find median long variable in a linked list
    public static Long findMedLong (LinkedList <Long> list) {
        int size = list.size();
        int med = size/2;
        return list.get(med);
    }
}