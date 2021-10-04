/* *****************************************************************************
 *  Name:    Ada Lovelace
 *  NetID:   alovelace
 *  Precept: P00
 *
 *  Partner Name:    Dorothy Johnson Vaughan
 *  Partner NetID:   djvaughan
 *  Partner Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class BinarySearchDeluxe {


    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) throw new IllegalArgumentException();

        int lo = 0;
        int hi = a.length - 1;
        int comp = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            comp = comparator.compare(key, a[mid]);
            if (comp <= 0) hi = mid;
            else lo = mid + 1;
        }

        if (comp == 0) return hi;
        return -1;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) throw new IllegalArgumentException();

        int lo = 0;
        int hi = a.length - 1;
        int comp = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            comp = comparator.compare(key, a[mid]);
            if (comp >= 0) lo = mid;
            else hi = mid - 1;
        }
        
        if (comp == 0) return lo;
        return -1;

    }

    public static void main(String[] args) {
        int firstIndex, lastIndex;

        Integer[] a = { 1, 2, 1, 2, 4, 5, 6 };
        Integer key = 2;
        Comparator<Integer> sorted = Comparator.naturalOrder();
        firstIndex = BinarySearchDeluxe.firstIndexOf(a, key, sorted);
        StdOut.println("First: " + firstIndex);
        lastIndex = BinarySearchDeluxe.lastIndexOf(a, key, sorted);
        StdOut.println("Last: " + lastIndex);

        String[] b = { "A", "A", "C", "G", "G", "T" };
        firstIndex = BinarySearchDeluxe.firstIndexOf(b, "G", String.CASE_INSENSITIVE_ORDER);
        StdOut.println("First: " + firstIndex);
        lastIndex = BinarySearchDeluxe.lastIndexOf(b, "G", String.CASE_INSENSITIVE_ORDER);
        StdOut.println("Last: " + lastIndex);


    }
}
