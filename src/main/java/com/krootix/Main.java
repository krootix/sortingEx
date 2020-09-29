package com.krootix;

import com.krootix.creation.ArrayCreator;
import com.krootix.sort.SortingService;

import java.util.Arrays;

public class Main {

    private static final int COUNT = 10;
    private static final int LENGTH_LEFT = 0;
    private static final int LENGTH_RIGHT = COUNT - 1;

    public static void main(String[] args) {

        ArrayCreator arrayCreator = new ArrayCreator();

        SortingService sortingService = new SortingService(arrayCreator);

        int[] ints = arrayCreator.createInts(COUNT);

        System.out.println("Bubble sorting:");
        Arrays.stream(ints).forEach(i -> System.out.format(" %d", i));

        sortingService.bubbleSort(ints);
        System.out.println();
        Arrays.stream(ints).forEach(i -> System.out.format(" %d", i));
        System.out.println("\n#--------------------------------------------------------------------------#");

        ints = arrayCreator.createInts(COUNT);
        System.out.println("\ninsertion sorting:");
        Arrays.stream(ints).forEach(i -> System.out.format(" %d", i));

        sortingService.insertionSort(ints);
        System.out.println();
        Arrays.stream(ints).forEach(i -> System.out.format(" %d", i));
        System.out.println("\n#--------------------------------------------------------------------------#");

        ints = arrayCreator.createInts(COUNT);
        System.out.println("\nselection sorting:");
        Arrays.stream(ints).forEach(i -> System.out.format(" %d", i));

        sortingService.selectionSort(ints);
        System.out.println();
        Arrays.stream(ints).forEach(i -> System.out.format(" %d", i));
        System.out.println("\n#--------------------------------------------------------------------------#");

        ints = arrayCreator.createInts(COUNT);
        System.out.println("\nmerge sort:");
        Arrays.stream(ints).forEach(i -> System.out.format(" %d", i));

        sortingService.mergeSort(ints, LENGTH_LEFT, LENGTH_RIGHT);
        System.out.println();
        Arrays.stream(ints).forEach(i -> System.out.format(" %d", i));
        System.out.println("\n#--------------------------------------------------------------------------#");

    }
}