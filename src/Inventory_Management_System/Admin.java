package Inventory_Management_System;

import java.sql.SQLException;
import static Inventory_Management_System.Project.rs;
import static Inventory_Management_System.Project.stmt;

    public class Admin {

        public void add(int id, String user, String pass, String Jop) throws SQLException {
            String query = "insert into DB values(" + id + ",'" + user + "' , '" + pass + "' ,'" + Jop + "')";
            stmt.execute(query);
        }

        public String delete(int id) throws SQLException {
            rs.absolute(0);
            while (rs.next()) {
                if (id == rs.getInt(1)) {
                    rs.deleteRow();
                    return "done";
                }
            }

            return "not found";

        }

        public String search(int id) throws SQLException {
            rs.absolute(0);
            while (rs.next()) {
                if (id == rs.getInt(1)) {
                    return "name is " + rs.getString(2) + "  the password " + rs.getString(3) + "  the type is " + rs.getString(4);
                }
            }
            return "not found";
        }

        public void print() throws SQLException {
            System.out.println("              Email             Password          Jop");
            rs.absolute(0);
            while (rs.next()) {
                System.out.println("              " + rs.getString(2) + "              " + rs.getString(3) + "              " + rs.getString(4));
            }

        }

        public void updateuser(int id, String user) throws SQLException {
            rs.absolute(0);
            while (rs.next()) {
                if (id == rs.getInt(1)) {
                    rs.updateString(2, user);
                    rs.updateRow();
                }
            }

        }

        public void updatepass(int id, String pass) throws SQLException {
            rs.absolute(0);
            while (rs.next()) {
                if (id == rs.getInt(1)) {
                    rs.updateString(3, pass);
                    rs.updateRow();
                }
            }

        }


    }

