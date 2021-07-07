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
        System.out.println();
        // Game field read
        Game_Field gf3 = new Game_Field("F-first", 1000, 100, Field_Type.BASKETBALL, Field_Class.A);
        Game_Field gf4 = new Game_Field("F-second", 1500, 150, Field_Type.FOOTBALL, Field_Class.B);
        Database.insert_equipment(gf4);
        Database.insert_equipment(gf3);
        try {
            System.out.println(Database.get_field_by_code("F-first"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println(Database.get_field_by_code("F-seconds"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        System.out.println(Database.get_fields_with_price_less(1200));
        System.out.println(Database.get_fields_with_price_less(1600));
        System.out.println(Database.get_fields_with_price_more(1200));
        System.out.println(Database.get_fields_with_price_more(1600));
        System.out.println(Database.get_fields_with_price_equal(1000));
        System.out.println(Database.get_fields_with_price_equal(950));
        System.out.println(Database.get_fields_with_capacity_less(150));
        System.out.println(Database.get_fields_with_capacity_more(50));
        System.out.println(Database.get_fields_with_capacity_equal(100));
        System.out.println(Database.get_fields_with_capacity_equal(99));
        System.out.println(Database.get_fields_with_type(Field_Type.FOOTBALL));
        System.out.println(Database.get_fields_with_type(Field_Type.HANDBALL));
        System.out.println(Database.get_fields_with_class(Field_Class.A));
        System.out.println(Database.get_fields_with_class(Field_Class.D));
        System.out.println();
        // Game table read
        Game_Table gt1 = new Game_Table("T-first", 1500, Table_Type.FOOSBALL, Table_Class.B);
        Game_Table gt2 = new Game_Table("T-second", 1000, Table_Type.PINGPONG, Table_Class.C);
        Database.insert_equipment(gt1);
        Database.insert_equipment(gt2);
        try {
            System.out.println(Database.get_table_by_code("T-second"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println(Database.get_table_by_code("T-third"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        System.out.println(Database.get_tables_with_price_less(1500));
        System.out.println(Database.get_tables_with_price_less(1600));
        System.out.println(Database.get_tables_with_price_more(1000));
        System.out.println(Database.get_tables_with_price_more(1500));
        System.out.println(Database.get_tables_with_price_equal(1500));
        System.out.println(Database.get_tables_with_price_equal(1000));
        System.out.println(Database.get_tables_with_type(Table_Type.FOOSBALL));
        System.out.println(Database.get_tables_with_type(Table_Type.POOL));
        System.out.println(Database.get_tables_with_class(Table_Class.A));
        System.out.println(Database.get_tables_with_class(Table_Class.C));
        System.out.println();
        // Game console read
        Game_Console gc3 = new Game_Console("C-first", 1500, Console_Type.PS4, true);
        Game_Console gc4 = new Game_Console("C-second", 2000, Console_Type.PS5, false);
        Database.insert_equipment(gc3);
        Database.insert_equipment(gc4);
        try {
            System.out.println(Database.get_console_by_code("C-first"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println(Database.get_table_by_code("C-second"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println(Database.get_table_by_code("C-third"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        System.out.println(Database.get_consoles_with_price_less(2000));
        System.out.println(Database.get_consoles_with_price_less(1500));
        System.out.println(Database.get_consoles_with_price_more(1000));
        System.out.println(Database.get_consoles_with_price_more(1500));
        System.out.println(Database.get_consoles_with_price_equal(1000));
        System.out.println(Database.get_consoles_with_price_equal(1500));
        System.out.println(Database.get_consoles_with_type(Console_Type.PS4));
        System.out.println(Database.get_consoles_with_type(Console_Type.XBOX_ONE));
        System.out.println(Database.get_consoles_with_type(Console_Type.XBOX_ONE_X));
        System.out.println(Database.get_vip_consoles());
        System.out.println(Database.get_vip_consoles(Database.get_consoles_with_type(Console_Type.PS4)));
        System.out.println();

    }
}
