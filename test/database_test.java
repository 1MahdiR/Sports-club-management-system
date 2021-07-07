package test;

import client.Reservation;
import client.User;
import club.Equipment;
import club.Game_Console;
import club.Game_Field;
import club.Game_Table;
import club.enums.*;
import utility.Database;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.GregorianCalendar;

public class database_test {

    public static void main (String[] args) {

        /////// INSERT
        User user_1 = new User("Mahdi");
        User user_2 = new User("Ali");
        Game_Field gf1 = new Game_Field(1000, 100, Field_Type.FOOTBALL, Field_Class.A);
        Game_Field gf2 = new Game_Field(1500, 150, Field_Type.BASKETBALL, Field_Class.A);
        Game_Table gt = new Game_Table(500, Table_Type.PINGPONG, Table_Class.A);
        Game_Console gc1 = new Game_Console(600, Console_Type.PS4, false);
        Game_Console gc2 = new Game_Console(800, Console_Type.XBOX_ONE, true);
        Equipment eq = new Equipment(1000);
        Date d = new Date();
        GregorianCalendar g = new GregorianCalendar(0,0,0,2,30);
        Date dg = g.getTime();
        Reservation r1;
        Reservation r2;
        try {
            r1 = new Reservation(user_1, eq, d, dg);
        } catch (Exception e) {
            r1 = null;
            System.out.println(e);
        }
        try {
            r2 = new Reservation(user_2, eq, d, dg);
        } catch (Exception e) {
            r2 = null;
            System.out.println(e);
        }

        System.out.println(Database.getUser_list());
        Database.insert_user(user_1);
        System.out.println(Database.getUser_list());
        Database.insert_user(user_2);
        System.out.println(Database.getUser_list());
        System.out.println();

        System.out.println(Database.getEquipment_list());
        Database.insert_equipment(gf1);
        System.out.println(Database.getEquipment_list());
        Database.insert_equipment(gf2);
        System.out.println(Database.getField_list());
        Database.insert_equipment(gt);
        System.out.println(Database.getTable_list());
        Database.insert_equipment(gc1);
        System.out.println(Database.getEquipment_list());
        Database.insert_equipment(gc2);
        System.out.println(Database.getEquipment_list());
        System.out.println(Database.getConsole_list());
        System.out.println();

        System.out.println(Database.getReservation_list());
        if (r1 != null)
            Database.insert_reservation(r1);
        System.out.println(Database.getReservation_list());
        if (r2 != null)
            Database.insert_reservation(r2);
        System.out.println(Database.getReservation_list());
        System.out.println();

        /////// READ
        // User read
        r1.pay();
        r2.pay();
        User user_3 = new User("Hadi-R", "Hadi");
        User user_4 = new User("Hadi-H", "Hadi");
        Database.insert_user(user_3);
        Database.insert_user(user_4);
        try {
            System.out.println(Database.get_user_by_id("Hadi-R"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println(Database.get_user_by_id("Hadi-H"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println(Database.get_user_by_id("Hadi-M"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        System.out.println(Database.get_users_by_name("Hadi"));
        System.out.println(Database.get_users_by_name("Mahdi"));
        System.out.println(Database.get_users_with_debt_less(2500));
        System.out.println(Database.get_users_with_debt_less(2501));
        System.out.println(Database.get_users_with_debt_more(2400));
        System.out.println(Database.get_users_with_debt_more(2500));
        System.out.println(Database.get_users_with_debt_equal(2500));
        System.out.println(Database.get_users_with_debt_equal(2600));
        System.out.println(Database.get_users_by_name(Database.get_users_with_debt_more(2400), "Ali"));
        System.out.println();
        // Equipment read
        Equipment eq1 = new Equipment("eq-1", 500);
        Equipment eq2 = new Equipment("eq-2", 1000);
        Equipment eq3 = new Equipment("eq-3", 2500);
        Database.insert_equipment(eq1);
        Database.insert_equipment(eq2);
        Database.insert_equipment(eq3);
        try {
            System.out.println(Database.get_equipment_by_code("eq-1"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println(Database.get_equipment_by_code("eq-2"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println(Database.get_equipment_by_code("eq-4"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        System.out.println(Database.get_equipments_with_price_less(2000));
        System.out.println(Database.get_equipments_with_price_less(400));
        System.out.println(Database.get_equipments_with_price_more(500));
        System.out.println(Database.get_equipments_with_price_more(2500));
        System.out.println(Database.get_equipments_with_price_equal(1000));
        System.out.println(Database.get_equipments_with_price_equal(1200));
        System.out.println(Database.get_equipments_with_price_less(Database.get_equipments_with_price_more(500), 2500));
    }
}
