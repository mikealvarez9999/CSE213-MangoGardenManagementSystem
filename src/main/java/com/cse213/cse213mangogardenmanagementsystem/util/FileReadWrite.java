package com.cse213.cse213mangogardenmanagementsystem.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for saving and loading serializable lists of objects
 * to and from binary files.
 * This ensures persistence logic is centralized and reusable across all models.
 */
public class FileReadWrite {

    /**
     * Saves a serializable list of objects to a specified binary file.
     * @param dataList The List of objects to save.
     * @param fileName The name of the file (e.g., "transactions.bin").
     */
    public static <T extends Serializable> void saveData(List<T> dataList, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(dataList);
        } catch (IOException e) {
            System.err.println("Error saving data to " + fileName + ": " + e.getMessage());
        }
    }

    /**
     * Reads a list of serializable objects from a specified binary file.
     * @param fileName The name of the file (e.g., "transactions.bin").
     * @return The List of objects loaded, or a new empty ArrayList if the file does not exist or loading fails.
     */
    public static <T extends Serializable> List<T> loadData(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                if (obj instanceof List) {
                    // Suppress unchecked cast since we check for List instance type
                    @SuppressWarnings("unchecked")
                    List<T> loadedList = (List<T>) obj;
                    return loadedList;
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error reading data file " + fileName + ": " + e.getMessage());
            }
        }
        // If file not found or loading failed, return an empty list
        return new ArrayList<>();
    }
}