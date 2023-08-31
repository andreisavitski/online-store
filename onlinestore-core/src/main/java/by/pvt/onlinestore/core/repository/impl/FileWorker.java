package by.pvt.onlinestore.core.repository.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileWorker {
    public void serializeObject(Object o, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object> deserializeObjects(String path) {
        List<Object> objects = new ArrayList<>();
        try (FileInputStream fio = new FileInputStream(path)) {
            boolean isObjectExist = true;
            while (isObjectExist) {
                ObjectInputStream ois = new ObjectInputStream(fio);
                Object o = ois.readObject();
                if (o == null) {
                    isObjectExist = false;
                }
                objects.add(o);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("File not found");
        }
        return objects;
    }

    public Object deserializeObject(String path) {
        Object o;
        try (ObjectInputStream ois = new ObjectInputStream((new FileInputStream(path)))) {
            o = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new Object();
        }
        return o;
    }
}
