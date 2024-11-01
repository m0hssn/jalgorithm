package io.github.jalgorithm.algorithms.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author Seyed Mohsen Sadeghi
 * The class which includes the implementation of bogo sort algorithm
 * @param <T> should implement the Comparable interface
 */
public class BogoSort<T extends Comparable<T>> extends SortAlgorithm {
    private ArrayList<T> data;
    private final Random random = new Random();

    /**
     * Constructor for creating a bogo sort instance via passing an array of data
     * @param dataArray an array of data of type T
     */
    public BogoSort(T[] dataArray) {
        this.data = new ArrayList<>(Arrays.asList(dataArray));
    }

    /**
     * Constructor for creating a bogo sort instance via passing an ArrayList of data
     * @param data an ArrayList of data of type T
     */
    public BogoSort(ArrayList<T> data) {
        this.data = data;
    }

    /**
     * Set new data to be sorted
     * @param data a new ArrayList that replaces the existing one
     */
    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    /**
     * Sorts the data array using bogo sort algorithm
     * It shuffles the data until it is sorted.
     * To access the sorted data, call the getData method.
     */
    public void sort() {
        while (!isSorted()) {
            shuffleData();
        }
    }

    /**
     * Helper method to check if the current data array is sorted
     * @return true if the data is sorted, false otherwise
     */
    private boolean isSorted() {
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).compareTo(data.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to shuffle the data array randomly
     */
    private void shuffleData() {
        Collections.shuffle(data, random);
    }

    /**
     * Returns the data array, which may be sorted if the sort method was called
     * @return data or sorted data
     */
    public ArrayList<T> getData() {
        return data;
    }
}
