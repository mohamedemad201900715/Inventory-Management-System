package Inventory_Management_System;

import java.sql.SQLException;
import static Inventory_Management_System.Project.rp;
import static Inventory_Management_System.Project.stmp;

    public class product {

        public void add(String produc, double pri, int expiry) throws SQLException {
            String S = " ";
            String query = "insert into product values('" + produc + "'," + pri + " , " + expiry + ", '  '  )";
            stmp.execute(query);
            System.out.println("done");

        }

        public void delete(String pro) throws SQLException {
            rp.absolute(0);
            while (rp.next()) {
                if (pro.equalsIgnoreCase(rp.getString(1))) {
                    rp.deleteRow();
                    System.out.println("done");
                    break;
                }
            }
        }

        public void update(String pro, double pri) throws SQLException {
            rp.absolute(0);
            while (rp.next()) {
                if (rp.getString(1).equalsIgnoreCase(pro)) {
                    rp.updateDouble(2, pri);
                    rp.updateRow();
                    System.out.println("DONE");
                    return;
                }
                else{
                    System.out.println("NOT FOUND");
                    return;
                }
            }
        }

        public void print() throws SQLException {
            while (rp.next()) {
                System.out.println("the product Name  " + rp.getString(1) + "  the price  " + rp.getDouble(2) + "   the expiry of this prudect is comming after  " + rp.getDouble(3) + "day   " + "about product  " + rp.getString(4));
            }
        }

        public String search(String pro) throws SQLException {
            rp.absolute(0);
            while (rp.next()) {
                if (pro.equalsIgnoreCase(rp.getString(1))) {
                    return "the product Name  " + rp.getString(1) + "  the price  " + rp.getDouble(2) + "   the expiry of this prudect is comming after   " + rp.getDouble(3) + "day   " + "about product   " + rp.getString(4);
                }
            }
            return "this product is not found";
        }
    }

