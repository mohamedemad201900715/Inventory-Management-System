package Inventory_Management_System;

import java.sql.SQLException;
import java.util.ArrayList;
import static Inventory_Management_System.Project.rp;

public class user extends product {

    private ArrayList<String> x = new ArrayList<>();
    private ArrayList<Double> y = new ArrayList<>();

    private double getPrice(String pro) throws SQLException {
        rp.absolute(0);
        while (rp.next()) {
            if (pro.equalsIgnoreCase(rp.getString(1))) {
                return rp.getDouble(2);
            }
        }
        return 0;

    }

    public void add(String product) throws SQLException {

        if (this.getPrice(product) != 0) {
            x.add(product);
            y.add(this.getPrice(product));
        } else {
            System.out.println("Not found");
        }

    }

    public void cansel(String product) throws SQLException {
        if (this.getPrice(product) != 0) {
            x.remove(product);
            y.remove(this.getPrice(product));
            System.out.println("done");
        }
    }

    public void Order() {
        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i) + "     " + y.get(i));
        }
    }

    public void total() {
        double g = 0;
        for (int i = 0; i < y.size(); i++) {

            g = g + y.get(i);

        }
        System.out.println("total price is  " + g);
    }

    public void Confirm() {
        for (int i = 0; i <= x.size(); i++) {
            x.remove(i);
            y.remove(i);
        }
    }

}
