package dao;

import model.IProduct;
import model.Product;

import java.util.Set;

public interface IDao {

    public void addNewProduct(IProduct product);
    public void changeProduct(IProduct product);
    public void remove(IProduct product);
    public Set<IProduct> getProductSet();

}