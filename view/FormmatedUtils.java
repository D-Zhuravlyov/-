package view;

import model.Product;

import java.util.ArrayList;
import java.util.IllegalFormatException;

public class FormmatedUtils {

    public static int commaAmount (String targ) {
        int res = 0;

        for (char temp : targ.toCharArray()) {
            if (temp == ',') {
                res++;
            }
        }

        return res;
    }

    public static String[] trimByComma (String targ) {
        String[] res = new String[4];
        int count = 0;
        String temp = "";
        for (char forRun : targ.toCharArray()) {
            if (forRun != ',') {
                temp += forRun;
            } else {
                res[count++] = temp;
                temp = "";
            }
            res[count] = temp;
        }
        return res;
    }

    public static String toProduct (String str) {
        try {
            return str;
        } catch (IllegalFormatException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /*public static Product toProduct (String[] targ) {
        try {
            Product product = new Product(targ[0], Integer.parseInt(targ[1]), Double.parseDouble(targ[2]), Integer.parseInt(targ[3]));
            return product;
        } catch (IllegalFormatException ex) {
            ex.printStackTrace();
        }
        return null;
    }*/
}
