package Inventory_Management_System;

import java.sql.SQLException;
import static Inventory_Management_System.Project.rp;

    public class Markting extends product {

        public void offers(String product, double n) throws SQLException {
            rp.absolute(0);
            while (rp.next()) {
                if (product.equalsIgnoreCase(rp.getString(1))) {
                    rp.updateDouble(2, (rp.getDouble(2) * n));
                    rp.updateRow();

                }

            }

            System.out.println("done");

        }

        public void info(String pro, String info) throws SQLException {

            rp.absolute(0);
            while (rp.next()) {
                if (pro.equalsIgnoreCase(rp.getString(1))) {
                    rp.updateString(4, info);
                    rp.updateRow();
                    System.out.println("done");

                }
            }

        }

    }

