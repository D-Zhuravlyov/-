package service;

import dao.IDao;
import dao.IDaoImplement;
import db.IDbImpl;
import model.IProduct;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

public class ServiceImpl implements IService {

    public ServiceImpl(IDao iDao) {
        this.iDao = iDao;

    }

    private IDao iDao;


    @Override
    public void add(IProduct product) {
        iDao.addNewProduct(product);
    }
    public Set<IProduct> getProductSet() {
   return iDao.getProductSet();
    }




    @Override
    public void change(IProduct product) {
        iDao.changeProduct(product);
    }

    @Override
    public void remove(IProduct product) {
        iDao.remove(product);
    }

    @Override
    public String showProduct(int id) {
        IProduct f = getProductById(id);
        return f.toString();
    }


    public IProduct getProductById(int id) {
        Set<IProduct> set = iDao.getProductSet();
        for (Iterator<IProduct> it = set.iterator(); it.hasNext(); ) {
            IProduct f = it.next();
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }


    public List sortHash(Set<IProduct> set) {
        List sortedList = new ArrayList(set);
        Collections.sort(sortedList);
        return sortedList;
    }




    @Override
    public String showAll() {


        Set<IProduct> set = iDao.getProductSet();
        String res="";
        for(IProduct product :set){
            res+=product.toString();
            res+="\n";
        }

        return res;
    }
}