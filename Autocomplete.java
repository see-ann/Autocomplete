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

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class Autocomplete {
    private Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        this.terms = new Term[terms.length];
        for (int i = 0; i < terms.length; i++) {
            this.terms[i] = terms[i];
        }
        Arrays.sort(this.terms);


    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        Term[] matchedTerms;
        int index = 0;

        Term key = new Term(prefix, 0);
        Comparator<Term> prefixComparator = Term.byPrefixOrder(prefix.length());
        Comparator<Term> weightComparator = Term.byReverseWeightOrder();

        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, key, prefixComparator);
        int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, key, prefixComparator);

        if (firstIndex == -1) {
            matchedTerms = new Term[0];
            return matchedTerms;
        }

        matchedTerms = new Term[lastIndex - firstIndex + 1];
        while (firstIndex <= lastIndex) {
            matchedTerms[index++] = terms[firstIndex++];
        }
        Arrays.sort(matchedTerms, weightComparator);
        return matchedTerms;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        Term key = new Term(prefix, 0);
        Comparator<Term> prefixComparator = Term.byPrefixOrder(prefix.length());
        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, key, prefixComparator);
        int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, key, prefixComparator);
        if (firstIndex == -1) return 0;
        return (lastIndex - firstIndex + 1);

    }


    // unit testing (required)
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Term[] terms = new Term[n];
        for (int i = 0; i < n; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            StdOut.printf("%d matches\n", autocomplete.numberOfMatches(prefix));
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }

}
