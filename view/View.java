package view;

import db.IDbImpl;
import model.IProduct;
import model.Product;
import service.IService;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Set;

public class View extends JFrame {

    private JTextArea textArea;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private IService service;


    public View(IService iService) {
        super("Склад");

        service = iService;

        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
        setVisible(true);
    }

    private void init() {
        JPanel south = new JPanel(new GridLayout(6, 1));
        JPanel north = new JPanel(new GridLayout(1, 1));
        getContentPane().add(south, BorderLayout.SOUTH);
        getContentPane().add(south, BorderLayout.SOUTH);
        getContentPane().add(north, BorderLayout.NORTH);

        textArea = new JTextArea(19, 35);
        JScrollPane jScrollPane = new JScrollPane(textArea);
        textArea.setEditable(true);
        north.add(jScrollPane);

        textField1 = new JTextField("id");
        south.add(textField1);

        textField2 = new JTextField("name");
        south.add(textField2);
        textField3 = new JTextField("amount");
        south.add(textField3);
        textField4 = new JTextField("price");
        south.add(textField4);


        JPanel saveLoadButton = new JPanel(new GridLayout(1, 2));
        south.add(saveLoadButton);
        JButton save = new JButton("load");
        JButton load = new JButton("save");
        saveLoadButton.add(load);
        load.addActionListener(new LoadActionListener());
        saveLoadButton.add(save);
        load.addActionListener(new SaveActionListener());

        JPanel button = new JPanel(new GridLayout(1, 3));
        south.add(button);

        JButton add = new JButton("add");
        JButton change = new JButton("change");
        JButton showAll = new JButton("showAll");
        JButton remove = new JButton("remove");
        button.add(add);
        add.addActionListener(new AddButtonListener());
        // button.add(change);
        //change.addActionListener(new ChangeButtonListener());
        button.add(showAll);
        showAll.addActionListener(new ShowAllActionListener());
        button.add(remove);
        remove.addActionListener(new RemoveActionListener());

    }

    //method that defines empty Textfield or Textfield, which starts with "space".
    //returns the number of textfield in int;
    //if all textfields are not empty, returns 0;

    public int defineEmptyTextfield() {
        int textFieldNumber = 0;

        if ((textField1.getText().isEmpty()) || (textField1.getText().startsWith(" "))) {
            textFieldNumber = 1;
        }
        if ((textField2.getText().isEmpty()) || (textField2.getText().startsWith(" "))) {
            textFieldNumber = 2;
        }
        if ((textField3.getText().isEmpty()) || (textField3.getText().startsWith(" "))) {
            textFieldNumber = 3;
        }
        if ((textField4.getText().isEmpty()) || (textField4.getText().startsWith(" "))) {
            textFieldNumber = 4;
        }
        return textFieldNumber;


    }


    private class AddButtonListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (textField1.getText().equals("")) {
                PopUp warn = new PopUp("<html> Please input product in valid format <p> Valid format: id</html>");
            } else {

                IProduct product = new Product(Integer.parseInt(FormmatedUtils.toProduct(textField1.getText())));
                product.setName(FormmatedUtils.toProduct(textField2.getText()));
                product.setAmount(Integer.parseInt(FormmatedUtils.toProduct(textField3.getText())));
                product.setPrice(Double.parseDouble(FormmatedUtils.toProduct(textField4.getText())));
                service.add(product);
            }
        }
    }





    /*private class ChangeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (textField.getText().equals("") || FormmatedUtils.commaAmount(textField.getText()) != 3) {
                PopUp warn = new PopUp("<html> Please input product in valid format <p> Valid format: name,amount,price,id</html>");
            } else {
                service.change(FormmatedUtils.toProduct(FormmatedUtils.trimByComma(textField.getText())));
            }
        }
    }*/

    private class ShowAllActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                textArea.setText(service.showAll());
        }
    }

    private class RemoveActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) throws NoSuchElementException {
            String str = textField1.getText();
            try {
                if (service.getProductById(Integer.parseInt(str)) != null) {
                    service.remove(service.getProductById(Integer.parseInt(FormmatedUtils.toProduct(str))));

                } else throw new NoSuchElementException();
            } catch (NoSuchElementException ex) {
                PopUp warn = new PopUp("<html> There is no such element in the list</html>");

            }


        }
    }

    private class SaveActionListener implements ActionListener {
        IDbImpl iDb = new IDbImpl();

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Set<IProduct> set = service.getProductSet();
            iDb.saveToFile((java.util.List) set);

        }
    }

    private class LoadActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
