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

import java.util.Comparator;

public class Term implements Comparable<Term> {
    public static Comparator<Term> BY_WEIGHT;
    public static Comparator<Term> BY_PREFIX;

    private String query;
    private long weight;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query == null || weight < 0) throw new IllegalArgumentException();
        this.query = query;
        this.weight = weight;
    }

    private static class ByReverseWeight implements Comparator<Term> {
        public int compare(Term v, Term w) {
            if (v.weight > w.weight) return -1;
            else if (v.weight < w.weight) return 1;
            return 0;
        }
    }

    private static class ByPrefixOrder implements Comparator<Term> {
        private int r;

        public ByPrefixOrder(int r) {
            this.r = r;
        }

        // probably need to modify to fit performance requirements
        public int compare(Term v, Term w) {
            String vQuery;
            String wQuery;

            int index = 0;
            while (v.query.charAt(index) == w.query.charAt(index)) {
                if (index == r - 1) break;
                if ((index == v.query.length() - 1) && (index == w.query.length() - 1)) return 0;
                else if (index == v.query.length() - 1) return -1;
                else if (index == w.query.length() - 1) return 1;
                index++;
            }
            if (v.query.charAt(index) < w.query.charAt(index)) return -1;
            else if (v.query.charAt(index) > w.query.charAt(index)) return 1;
            else return 0;

            /*
            if (v.query.length() < r) {
                vQuery = v.query;
            }
            else {
                vQuery = v.query.substring(0, r);
            }
            if (w.query.length() < r) {
                wQuery = w.query;
            }
            else {
                wQuery = w.query.substring(0, r);
            }
            return (vQuery.compareTo(wQuery));

             */
        }
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        BY_WEIGHT = new ByReverseWeight();
        return BY_WEIGHT;

    }

    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) throw new IllegalArgumentException();
        BY_PREFIX = new ByPrefixOrder(r);
        return BY_PREFIX;

    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return (this.weight + " \t" + this.query);
    }

    // unit testing (required)
    public static void main(String[] args) {


    }

}
