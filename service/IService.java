package service;

import model.IProduct;
import model.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IService {

    void add(IProduct product);

    void change(IProduct product);

    void remove(IProduct product);

    String showProduct(int id);

    String showAll();

    IProduct getProductById(int id);

    Set<IProduct> getProductSet();

}