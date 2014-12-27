package db;

import model.IProduct;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IDB {
    void saveToFile(List list);
    Object  loadFromFile();
    String getCurrentPath() throws IOException;
}
