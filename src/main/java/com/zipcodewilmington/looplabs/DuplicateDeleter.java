package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

    public T[] removeDuplicates(int maxNumberOfDuplications) {
        if (maxNumberOfDuplications <= 1) {
            if (array[0] instanceof String) return (T[]) new String[0];
            if (array[0] instanceof Integer) return (T[]) new Integer[0];
        }
        if (array.length <= 1) return array;
        Arrays.sort(array);

        StringBuilder keeps = new StringBuilder();
        int counter = 0;
        for (T t : array) {
            for (T value : array) {
                if (t.equals(value)) counter++;
            }
            if (counter < maxNumberOfDuplications) {
                keeps.append(t).append(" ");
            }
            counter = 0;
        }
        String[] strArray = keeps.toString().split(" ");

        if (array[0] instanceof Integer) {
            Integer[] intArray = new Integer[strArray.length];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }
            return (T[])intArray;
        }
        return (T[])strArray;
    }
    public T[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        if (exactNumberOfDuplications < 1) {
            if (array[0] instanceof String) return (T[]) new String[0];
            if (array[0] instanceof Integer) return (T[]) new Integer[0];
        }
        if (array.length <= 1) return array;
        Arrays.sort(array);

        StringBuilder keeps = new StringBuilder();
        int counter = 0;
        for (T t : array) {
            for (T value : array) {
                if (t.equals(value)) counter++;
            }
            if (counter != exactNumberOfDuplications) {
                keeps.append(t).append(" ");
            }
            counter = 0;
        }
        String[] strArray = keeps.toString().split(" ");

        if (array[0] instanceof Integer) {
            Integer[] intArray = new Integer[strArray.length];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }
            return (T[])intArray;
        }
        return (T[])strArray;
    }
}
