package view;

import dao.IDaoImplement;
import db.IDbImpl;
import service.IService;
import service.ServiceImpl;


public class StartFrame {

    public static void main(String[] args) {
        IService iService = new ServiceImpl(new IDaoImplement());
        View view = new View(iService);
    }

}
