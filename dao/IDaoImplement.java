package dao;

import model.IProduct;
import model.Product;

import java.util.HashSet;
import java.util.Set;

public class IDaoImplement implements IDao{

    Set<IProduct> productSet = new HashSet<IProduct>();


        // getter for our HashSet
        public Set<IProduct> getProductSet(){
        return  this.productSet;
    }



    @Override
    public void addNewProduct(IProduct product) {
        productSet.add(product);
    }

    @Override
    public void changeProduct(IProduct product) {
        if(productSet.contains(product)){

            IProduct tempProd = product;
            productSet.remove(product);
            productSet.add(tempProd);

        }else {
            productSet.add(product);
        }
    }


    @Override
    public void remove(IProduct product) {

        productSet.remove(product);

    }
}