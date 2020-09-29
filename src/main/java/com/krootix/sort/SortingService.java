package com.krootix.sort;

import com.krootix.creation.ArrayCreator;

/**
 * Time Complexities of all Sorting Algorithms:
 * Algorithm        Best            Average         Worst
 * Bubble Sort      Ω(n)           θ(n^2)          O(n^2)
 * Insertion Sort   Ω(n)           θ(n^2)          O(n^2)
 * Selection Sort   Ω(n^2)         θ(n^2)          O(n^2)
 * Merge Sort       Ω(n log(n))    θ(n log(n))     O(n log(n))
 * Heap Sort        Ω(n log(n))    θ(n log(n))     O(n log(n))
 * Quick Sort       Ω(n log(n))    θ(n log(n))     O(n^2)
 * Bucket Sort      Ω(n+k)         θ(n+k)          O(n^2)
 * Radix Sort       Ω(nk)          θ(nk)           O(nk)
 */
public class SortingService {

    ArrayCreator arrayCreator;

    public SortingService(ArrayCreator arrayCreator) {
        this.arrayCreator = arrayCreator;
    }

    /**
     * Algorithm: Bubble sort
     * Time Complexity: O(n^2)
     * Bubble sort works by swapping adjacent elements if they're not in
     * the desired order. This process repeats from the beginning of the
     * array until all elements are in order.
     *
     * @param array input array
     */
    public void bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    /**
     * Algorithm: Insertion sort
     * Time Complexity: O(n^2)
     * The idea behind Insertion Sort is dividing the array into the sorted
     * and unsorted subarrays.
     *
     * @param array input array
     */
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            // at this point we've exited, so j is either -1
            // or it's at the first element where current >= a[j]
            array[j + 1] = current;
        }
    }

    /**
     * Algorithm: Selection sort
     * Time Complexity: O(n^2)
     * Selection Sort also divides the array into a sorted and unsorted subarray.
     * Though, this time, the sorted subarray is formed by inserting the minimum
     * element of the unsorted subarray at the end of the sorted array, by swapping.
     *
     * @param array input array
     */
    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            // swapping
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    /**
     * Algorithm: Merge sort
     * Time Complexity: O(nlog n)
     * Merge Sort uses recursion to solve the problem of sorting more efficiently than
     * algorithms previously presented, and in particular it uses a divide and conquer approach.
     * Using both of these concepts, we'll break the whole array down into two subarrays and then:
     * 1 Sort the left half of the array (recursively)
     * 2 Sort the right half of the array (recursively)
     * 3 Merge the solutions
     *
     * @param array input array
     * @param left  left-most element of the subarray we want to sort
     * @param right right-most element of the subarray we want to sort
     */
    public void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        // calculating lengths
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // creating temporary subarrays
        int[] leftArray = new int[lengthLeft];
        int[] rightArray = new int[lengthRight];

        // copying our sorted subarrays into temporaries
        // you can do copy first array that way:
        // System.arraycopy(array, left, leftArray, 0, lengthLeft);

        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left + i];

        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid + i + 1];

        // iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // copying from leftArray and rightArray back into array
        for (int i = left; i < right + 1; i++) {
            // if there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // if all the elements have been copied from rightArray, copy the rest of leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // if all the elements have been copied from leftArray, copy the rest of rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}