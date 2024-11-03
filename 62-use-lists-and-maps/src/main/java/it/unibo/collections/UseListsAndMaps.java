package it.unibo.collections;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int FROM = 1000; 
    private static final int TO = 2000; 
    private static final int ELEMS = 100_000;
    private static final long AFRICAPOPULATION = 1_110_635_000L;
    private static final long AMERICASPOPULATION = 972_005_000L;
    private static final long ANTARTICAPOPULATION = 0L;
    private static final long ASIAPOPULATION = 4_298_723_000L;
    private static final long EUROPEPOPULATION = 742_452_000L;
    private static final long OCEANIAPULATION = 38_304_000L;


    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {

         /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */

        final List<Integer> arrayList = new ArrayList<Integer>(); 

        for (int i = FROM; i < TO; i++) {
            arrayList.add(i); 
        }

        final List<Integer> list = new LinkedList<Integer>(); 

        list.addAll(arrayList); 

        final var temp = arrayList.get(0); 
        arrayList.set(0, arrayList.get(arrayList.size()-1)); 
        arrayList.set(arrayList.size()-1, temp); 

        for (Integer number: arrayList) {
            System.out.println(number);
        }

        long time = System.nanoTime();

        for (int i = 1; i <= ELEMS; i++) {
            arrayList.addFirst(i);
        }

        time = System.nanoTime() - time;
        System.out.println("ArrayList time: " + time);

        time = System.nanoTime();

        for (int i = 1; i <= ELEMS; i++) {
            list.addFirst(i);
        }

        time = System.nanoTime() - time;
        System.out.println("List time: " + time);

        time = System.nanoTime();

        for (int i = 1; i <= ELEMS; i++) {
            arrayList.get(arrayList.size()/2); 
        }

        time = System.nanoTime() - time;
        System.out.println("ArrayList time: " + time);

        time = System.nanoTime();

        for (int i = 1; i <= ELEMS; i++) {
            list.get(list.size()/2);
        }

        time = System.nanoTime() - time;
        System.out.println("List time: " + time);

        Map<String, Long> worldMap = new HashMap<>(); 

        worldMap.put("Africa", AFRICAPOPULATION); 
        worldMap.put("Americas", AMERICASPOPULATION); 
        worldMap.put("Antarctica", ANTARTICAPOPULATION); 
        worldMap.put("Asia", ASIAPOPULATION); 
        worldMap.put("Europe", EUROPEPOPULATION); 
        worldMap.put("Oceania", OCEANIAPULATION); 

        long sum = 0; 

        for (Long value: worldMap.values()) {
            sum += value; 
        }

        System.out.println(sum);
    }
}
