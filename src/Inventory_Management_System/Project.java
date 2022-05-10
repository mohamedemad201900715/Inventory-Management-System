package Inventory_Management_System;

import java.util.*;
import java.sql.*;

public class Project {

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public static ResultSet rp;
    public static Statement stmp;
    public static ResultSet rg;
    public static Statement stmg;
/////////////////////////////////////////DataBase/////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) throws Exception {
        try {
            String host = "jdbc:derby://localhost:1527/Hyper_Market_db";
            String uName = "user1";
            String uPass = "user1";
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM db";
            rs = stmt.executeQuery(sql);
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            stmp = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sqp = "SELECT * FROM product";
            rp = stmp.executeQuery(sqp);
            /////////////////////////////////////////////
            stmg = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sqg = "SELECT * FROM USERS";
            rg = stmg.executeQuery(sqg);
////////////////////////////////////////////////////////////////////////////////////////
            Scanner input = new Scanner(System.in);
            int choise = 1;
            int found = 0;
            while (choise == 1) {
                System.out.println("1-you are user \n2-you are employee or admin");
                int vv = input.nextInt();
                if (vv == 2) {

                    System.out.println("login: ");
                    System.out.print("Enter User name: ");
                    String userName = input.next();
                    System.out.print("\nEnter Password: ");
                    String password = input.next();

                    rs.absolute(0);

                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String user = rs.getString(2);
                        String pass = rs.getString(3);
                        String Jop = rs.getString(4);
                        if (user.equalsIgnoreCase(userName) && pass.equalsIgnoreCase(password)) {
                            if ("admin".equalsIgnoreCase(Jop)) {
                                found = 1;
                                int ccc = 0;
                                while (ccc == 0) {
                                    System.out.println("Enter number of your operation:");
                                    System.out.println("1-Edit your information \n2-manages employees \n3-logout");
                                    int choose1 = input.nextInt();
                                    if (choose1 == 1 || choose1 == 2 || choose1 == 3) {
                                        if (choose1 == 1) {
                                            int index = rs.getRow();
                                            if (index != 0) {
                                                int c = 1;
                                                while (c == 1) {
                                                    System.out.println("Enter number of your operation:\n1-change user name \n2-change password \n3-back\n");
                                                    int ch = input.nextInt();
                                                    if (ch == 1) {
                                                        try {
                                                            System.out.print("Enter new user name: ");
                                                            user = input.next();
                                                            rs.updateString(2, user);
                                                            rs.updateRow();
                                                            System.out.println("done");
                                                        } catch (SQLException e) {
                                                            System.out.print(e.getMessage());
                                                        }
                                                        System.out.print("enter any operation?\n1-Yes 2-No");
                                                        c = input.nextInt();

                                                    } else if (ch == 2) {
                                                        try {
                                                            System.out.print("Enter new password: ");
                                                            pass = input.next();
                                                            rs.updateString(3, pass);
                                                            rs.updateRow();
                                                            System.out.println("done");
                                                        } catch (SQLException e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                        System.out.print("enter any operation?\n1-Yes 2-No");
                                                        c = input.nextInt();
                                                    } else if (ch == 3) {
                                                        c = 3;
                                                    }
                                                }
                                            }
                                        } else if (choose1 == 2) {
                                            int m = 1;
                                            while (m == 1) {

                                                System.out.println("\n1-search by id \n2-delete by id \n3-insert employee \n4-print \n5-update\n0-back");
                                                int ex = input.nextInt();
                                                Admin xc = new Admin();
                                                int idd;
                                                String userr;
                                                String Pass;
                                                switch (ex) {
                                                    case 0:
                                                        ccc = 0;
                                                        m = 2;
                                                        break;
                                                    case 1:
                                                        System.out.println("Enter id");
                                                        idd = input.nextInt();
                                                        System.out.println(xc.search(idd));
                                                        System.out.println("\ndo you need any operation? \n1-yes \n2-no");
                                                        m = input.nextInt();
                                                        break;
                                                    case 2:
                                                        System.out.println("Enter id ");
                                                        idd = input.nextInt();
                                                        System.out.println(xc.delete(idd));
                                                        System.out.println("\ndo you need any operation? \n1-yes \n2-no");
                                                        m = input.nextInt();
                                                        break;
                                                    case 3:
                                                        System.out.print("Enter id: ");
                                                        idd = input.nextInt();
                                                        System.out.print("Enter user: ");
                                                        userr = input.next();
                                                        System.out.print("Enter password: ");
                                                        Pass = input.next();
                                                        System.out.print("Enter jop: ");
                                                        String jop = input.next();
                                                        xc.add(idd, userr, Pass, jop);
                                                        rs = stmt.executeQuery(sql);
                                                        System.out.println("\ndo you need any operation? \n1-yes \n2-no");
                                                        m = input.nextInt();
                                                        break;
                                                    case 4:
                                                        xc.print();
                                                        System.out.println("\ndo you need any operation? \n1-yes \n2-no");
                                                        m = input.nextInt();
                                                        break;
                                                    case 5:
                                                        int z = 1;
                                                        while (z == 1) {
                                                            System.out.print("1- update user name \n2-update password \n3-update user name & password \n4-back");
                                                            int cho = input.nextInt();

                                                            if (cho == 1) {
                                                                System.out.print("Enter id: ");
                                                                idd = input.nextInt();
                                                                System.out.print("Enter new user name: ");
                                                                userr = input.next();
                                                                xc.updateuser(idd, userr);
                                                                System.out.print("done");

                                                            } else if (cho == 2) {

                                                                System.out.print("Enter id: ");
                                                                idd = input.nextInt();
                                                                System.out.print("Enter new password: ");
                                                                Pass = input.next();
                                                                xc.updateuser(idd, Pass);
                                                                System.out.print("done");

                                                            } else if (cho == 3) {
                                                                System.out.print("Enter id: ");
                                                                idd = input.nextInt();
                                                                System.out.print("Enter new user name: ");
                                                                userr = input.next();
                                                                System.out.print("Enter new password: ");
                                                                Pass = input.next();
                                                                xc.updatepass(idd, Pass);
                                                                xc.updateuser(idd, userr);
                                                                System.out.print("done");
                                                            } else if (cho == 4) {
                                                                m = 0;
                                                                break;

                                                            }
                                                            System.out.print("\ndo you need any operation? \n1-yes \n2-no ");
                                                            z = input.nextInt();
                                                        }
                                                        if (m == 1) {
                                                            System.out.println("\ndo you need any operation? \n1-yes \n2-no");
                                                            m = input.nextInt();
                                                        }
                                                        break;
                                                    default:
                                                        System.out.println("invaild operation!!");
                                                        System.out.println("\ndo you need any operation? \n1-yes \n2-no");
                                                        m = input.nextInt();
                                                        break;
                                                }

                                            }

                                        } else if (choose1 == 3) {

                                            break;

                                        } else {
                                            System.out.println("invalid number try again ");
                                        }
                                    }

                                }
                            } else if ("marketing".equalsIgnoreCase(Jop)) {
                                found = 1;
                                int w = 1;
                                while (w == 1) {
                                    System.out.println("1-make offers \n2- make report \n3-logout");
                                    int v = input.nextInt();
                                    String na;
                                    Markting mm = new Markting();
                                    if (v == 1) {
                                        System.out.print("Enter name of product: ");
                                        na = input.next();
                                        if ("this product is not found".equalsIgnoreCase(mm.search(na))) {
                                            System.out.println("this product is not found");
                                        } else {
                                            System.out.print("the precenge of offer (ex: 0.3) : ");
                                            double u = input.nextDouble();
                                            mm.offers(na, u);
                                        }
                                    } else if (v == 2) {
                                        System.out.print("Enter name of product: ");
                                        na = input.next();
                                        if ("this product is not found".equalsIgnoreCase(mm.search(na))) {
                                            System.out.println("this product is not found");
                                        } else {
                                            System.out.print("the report :  ");
                                            String info = input.next();
                                            mm.info(na, info);
                                        }
                                    } else if (v == 3) {
                                        break;
                                    } else {
                                        System.out.println("invalid choice !!");
                                    }
                                    System.out.println("do you need try again? \nEnter 1(yes) 2 (no) ");
                                    w = input.nextInt();
                                }

                            } else if ("inventory".equalsIgnoreCase(Jop)) {
                                found = 1;
                                int i;
                                char c = 'y';
                                while (c == 'y' || c == 'Y') {

                                    System.out.println("1- add product");
                                    System.out.println("2- delete product");
                                    System.out.println("3- update product");
                                    System.out.println("4- print all product");
                                    System.out.println("5- search product");
                                    System.out.println("6- logout");
                                    i = input.nextInt();
                                    product p = new product();
                                    rp = stmp.executeQuery(sqp);
                                    switch (i) {
                                        case 1:
                                            System.out.println("enter the name of product");
                                            String name = input.next();
                                            System.out.println("enter the price of product");
                                            double price = input.nextDouble();
                                            System.out.println("enter how many date is less to the date expire of product");
                                            int expir = input.nextInt();
                                            p.add(name, price, expir);
                                            System.out.println("if you want to do any operation? (y/n)");
                                            c = input.next().charAt(0);
                                            break;
                                        case 2:
                                            System.out.println("enter the name of product");
                                            String name1 = input.next();
                                            rp = stmp.executeQuery(sqp);
                                            p.delete(name1);
                                            System.out.println("if you want to do any operation? (y/n)");
                                            c = input.next().charAt(0);
                                            break;
                                        case 3:
                                            System.out.println("enter the name of product");
                                            String name2 = input.next();
                                            System.out.println("enter the  new price of product");
                                            double newprice = input.nextDouble();
                                            p.update(name2, newprice);
                                            System.out.println("if you want to do any operation? (y/n)");
                                            c = input.next().charAt(0);
                                            break;
                                        case 4:
                                            p.print();
                                            System.out.println("if you want to do any operation? (y/n)");
                                            c = input.next().charAt(0);
                                            break;
                                        case 5:
                                            System.out.println("enter the name of product");
                                            String name3 = input.next();
                                            System.out.println(p.search(name3));

                                            System.out.println("if you want to do any operation? (y/n)");
                                            c = input.next().charAt(0);
                                            break;
                                        case 6:
                                            c = 'n';
                                            break;
                                    }
                                }
                            }

                        }
                    }
                    if (found == 0) {
                        System.out.println("User or password is invalid!!");
                    }
                    System.out.println("do you need try login again ? \nEnter 1 (Yes) or 2 (No)");
                    choise = input.nextInt();

                } else if (vv == 1) {
                    int chgg;
                    users u1 = new users();
                    System.out.println("1-create new acount \n2-login ");
                    chgg = input.nextInt();
                    int id;
                    String pass;
                    if (chgg == 1) {
                        found = 1;
                        System.out.println("enter your id");
                        id = input.nextInt();
                        System.out.println("enter your password");
                        pass = input.next();
                        System.out.println("enter your name");
                        String name = input.next();
                        System.out.println("enter your number");
                        String numb = input.next();
                        u1.signin(id, pass, name, numb);
                    } else if (chgg == 2) {
                        System.out.println("enter your id");
                        id = input.nextInt();
                        System.out.println("enter your password");
                        pass = input.next();
                        rg = stmg.executeQuery(sqg);
                        rg.absolute(0);
                        while (rg.next()) {
                            if (rg.getInt(1) == id && rg.getString(2).equalsIgnoreCase(pass)) {
                                found = 1;
                                String names = rg.getString(3);
                                String numb = rg.getString(4);
                                int klm = 1;
                                user uu = new user();
                                while (klm == 1) {
                                    System.out.println("your name is  " + names + "  your number is  " + numb);
                                    System.out.println("1-ubdate your information  \n2-make order \n3-logout");
                                    int n1 = input.nextInt();
                                    if (n1 == 1) {
                                        klm = 0;
                                        int mm = 1;
                                        while (mm == 1) {

                                            rg = stmg.executeQuery(sqg);
                                            System.out.println("1-if you want to ubdate your name");
                                            System.out.println("2-if you want to ubdate your password");
                                            System.out.println("3-if you want to ubdate your number \n4-back");
                                            int n2 = input.nextInt();
                                            if (n2 == 1) {
                                                System.out.println("enter your new name");
                                                String newname = input.next();
                                                u1.updatename(names, newname);
                                                System.out.println("do you want to do any operation? \n1-yes \n2-no(logout)");
                                                mm = input.nextInt();
                                            } else if (n2 == 2) {
                                                System.out.println("enter your new password");
                                                String newpass = input.next();
                                                u1.updatepass(pass, newpass);
                                                System.out.println("do you want to do any operation? \n1-yes \n2-no(logout)");
                                                mm = input.nextInt();
                                            } else if (n2 == 3) {
                                                System.out.println("enter your new number");
                                                String newnumber = input.next();
                                                u1.updatenumber(numb, newnumber);
                                                System.out.println("do you want to do any operation? \n1-yes \n2-no(logout)");
                                                mm = input.nextInt();
                                            } else if (n2 == 4) {
                                                mm = 0;
                                                klm = 1;
                                            } else {
                                                System.out.println("invalid choice");
                                                mm = 1;
                                            }
                                        }
                                    } else if (n1 == 2) {
                                        int zzz = 2;
                                        while (zzz == 2) {

                                            System.out.println("1-print all product\n2-search about name of product \n3- your order \n4-back");
                                            int cv = input.nextInt();
                                            if (cv == 1) {
                                                uu.print();
                                                int o = 1;
                                                while (o == 1) {
                                                    System.out.println("enter name of product you want to buy(if you dont need any thing enter 'x')");
                                                    String buy = input.next();
                                                    uu.add(buy);
                                                    System.out.println("you need buy new product? \n1-yes \n2-no");
                                                    o = input.nextInt();
                                                    zzz = 2;
                                                }
                                            } else if (cv == 2) {
                                                int cq = 0;
                                                while (cq == 0) {
                                                    System.out.println("enter name product");
                                                    String loll = input.next();
                                                    System.out.println(uu.search(loll));
                                                    if ("this product is not found".equalsIgnoreCase(uu.search(loll))) {
                                                        cq = 0;
                                                        System.out.println("you want make another operation? \n1-yes \n2-no (logout)");
                                                        zzz = input.nextInt();
                                                    } else {
                                                        cq = 1;
                                                        uu.add(loll);
                                                    }
                                                }
                                            } else if (cv == 3) {
                                                int po = 1;
                                                while (po == 1) {
                                                    uu.Order();
                                                    uu.total();
                                                    System.out.println("1-confirm order \n2-cancel product \n3- back");
                                                    int kk = input.nextInt();
                                                    if (kk == 1) {
                                                        uu.Confirm();
                                                        System.out.println("done , You will receive your order soon ");
                                                        po = 0;
                                                    } else if (kk == 2) {
                                                        System.out.println("enter name of product: ");
                                                        String lo = input.next();
                                                        uu.cansel(lo);
                                                        po = 1;
                                                    } else if (kk == 3) {
                                                        zzz = 1;
                                                        po = 0;
                                                    }
                                                }

                                            } else if (cv == 4) {
                                                klm = 1;
                                                break;
                                            }
                                        }
                                    } else if (n1 == 3) {
                                        klm = 0;
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        found = 1;
                        System.out.println("invalid choice");
                    }
                    if (found == 0) {
                        System.out.println("ID or password is invalid!!");
                    }

                }
            }

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

    }

}
