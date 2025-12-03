package com.cse213.cse213mangogardenmanagementsystem.util;

import javafx.collections.*;
import java.io.*;
import java.util.ArrayList;


public class FileReadWrite {

    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
        }
    }

    
    public static <T> ObservableList<T> loadData(Class<T> className, String fileName) {
        ObservableList<T> list = FXCollections.observableArrayList();
        
        File file = new File(fileName);
        if (!file.exists()) {
            return list;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (className.isInstance(obj)) {
                        list.add(className.cast(obj));
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public static <T> void saveData(ObservableList<T> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (T obj : list) {
                oos.writeObject(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static <T> void append(T object, String fileName) {
        try {
            File file = new File(fileName);
            boolean appendRequiresSkip = file.exists() && file.length() > 0;
            ObjectOutputStream oos;

            if (appendRequiresSkip) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(fileName, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fileName, true));
            }

            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}