/* *****************************************************************************
 *  Name: Sean Wang
 *  NetID:
 *  Precept:
 *
 *  Partner Name: Katie Lee
 *  Partner NetID: katieyl
 *  Partner Precept: P06
 *
 *  Hours to complete assignment (optional):
 *
 **************************************************************************** */

Programming Assignment 3: Autocomplete


/* *****************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that is equal to the search key.
 **************************************************************************** */
 The firstIndexOf() method iterates through the array until lo is not lower than
 hi. We compare the mid to the key, if key is less than or equal to the element
 at mid we adjust the hi pointer to be that index to cut subspace into half. On
 the other hand, if the value in mid is greater than the key we adjust the lo
 pointer to be the element after the mid because we've already checked that
 element. At the end we check if the element at the hi pointer is equivalent to
 the key and return hi if this is the case and -1 if not.

/* *****************************************************************************
 *  Identify which sorting algorithm (if any) that your program uses in the
 *  Autocomplete constructor and instance methods. Choose from the following
 *  options:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  If you are using an optimized implementation, such as Arrays.sort(),
 *  select the principal algorithm.
 **************************************************************************** */

Autocomplete() :

allMatches() :

numberOfMatches() :

/* *****************************************************************************
 *  How many compares (in the worst case) does each of the operations in the
 *  Autocomplete data type make, as a function of both the number of terms n
 *  and the number of matching terms m? Use Big Theta notation to simplify
 *  your answers.
 *
 *  Recall that with Big Theta notation, you should discard both the
 *  leading coefficients and lower-order terms, e.g., Theta(m^2 + m log n).
 **************************************************************************** */

Autocomplete():     Theta(    )

allMatches():       Theta(    )

numberOfMatches():  Theta(    )




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */

/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 **************************************************************************** */
NA

/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */
NA

/* *****************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */


/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */

