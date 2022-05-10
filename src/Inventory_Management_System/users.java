package Inventory_Management_System;

import java.sql.SQLException;
import static Inventory_Management_System.Project.rg;
import static Inventory_Management_System.Project.stmg;

    public class users {

        public static void signin(int id, String pass, String name, String number) throws SQLException {
            String query = "insert into USERS values(" + id + ",'" + pass + "','" + name + "','" + number + "')";
            stmg.execute(query);
            System.out.println("done");
        }

        public static void updatename(String name, String newname) throws SQLException {
            rg.absolute(0);
            while (rg.next()) {
                if (rg.getString(3).equalsIgnoreCase(name)) {
                    rg.updateString(3, newname);
                    rg.updateRow();
                    System.out.println("done");
                }
            }
        }

        public static void updatepass(String pass, String newpass) throws SQLException {
            rg.absolute(0);
            while (rg.next()) {
                if (rg.getString(2).equalsIgnoreCase(pass)) {
                    rg.updateString(2, newpass);
                    rg.updateRow();
                    System.out.println("done");
                }
            }
        }

        public static void updatenumber(String number, String newnumber) throws SQLException {
            rg.absolute(0);
            while (rg.next()) {
                if (rg.getString(4).equalsIgnoreCase(number)) {
                    rg.updateString(4, newnumber);
                    rg.updateRow();
                    System.out.println("done");
                }
            }
        }
    }
