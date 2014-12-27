
package db;

import dao.IDao;
import dao.IDaoImplement;
import model.IProduct;
import model.Product;
import service.IService;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IDbImpl implements IDB {

    public String setNewPath() {


        try {
            final String currentPath = getCurrentPath();
            String additionalPath = "/DB/Db.md";
            String PATH_TO_FILE = currentPath.concat(additionalPath);
            return PATH_TO_FILE;
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public Object loadFromFile() {
        //String path = "PATH_TO_FILE";
       /* String path = "aaa";
        try (FileInputStream file = new FileInputStream(path);
             ObjectInputStream obj = new ObjectInputStream(file)){
            try {
                return obj.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        return null;
    }

    @Override
    public String getCurrentPath() throws IOException {
        String current = "";
        return current = new java.io.File( "." ).getCanonicalPath();
    }


    //Method writes HashSet of products to file with address setNewPath() string;
    public void saveToFile (List list) {
        String path = setNewPath();

        FileOutputStream file = null;
        ObjectOutputStream obj = null;

        try {


            file = new FileOutputStream(path);
            obj = new ObjectOutputStream(file);
            obj.writeObject(list);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (obj != null) {
                try {
                    obj.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}

