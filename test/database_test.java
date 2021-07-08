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
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
        System.out.println(Database.get_not_vip_consoles());
        System.out.println();
        // Reservation read
        User user_5 = new User("hos", "Hossein");
        User user_6 = new User("mam", "Mamad");
        Equipment eq5 = new Equipment("eq5", 1000);
        Equipment eq6 = new Equipment("eq6", 1500);
        Game_Field gf5 = new Game_Field("gf5", 2500, 150, Field_Type.BASKETBALL, Field_Class.B);
        GregorianCalendar later = new GregorianCalendar(2021, 6, 8, 20, 15);
        Date d_later = later.getTime();
        GregorianCalendar g_due_1 = new GregorianCalendar(0,0,1,1,45);
        GregorianCalendar g_due_2 = new GregorianCalendar(0,0,0,2,30);
        Date due_1 = g_due_1.getTime();
        Date due_2 = g_due_2.getTime();
        Date now = new Date();
        Reservation r3;
        Reservation r4;
        Reservation r5;
        try {
            r3 = new Reservation("R-first", user_5, eq5, now, due_1);
        } catch (Exception e) {
            System.out.println("Something happened!");
            r3 = null;
        }
        try {
            r4 = new Reservation("R-second", user_6, eq5, now, due_2);
        } catch (Exception e) {
            System.out.println("Something happened!");
            r4 = null;
        }
        try {
            r5 = new Reservation("R-third", user_5, gf5, d_later, due_1);
        } catch (Exception e) {
            System.out.println("Something happened!");
            r5 = null;
        }

        Database.insert_reservation(r3);
        Database.insert_reservation(r4);
        Database.insert_reservation(r5);

        try {
            System.out.println(Database.get_reservation_by_id("R-first"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println(Database.get_reservation_by_id("R-third"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println(Database.get_reservation_by_id("R-fourth"));
        } catch (Exception e) {
            System.out.println("Not found!");
        }

        System.out.println(Database.get_reservations_with_user(user_5));
        System.out.println(Database.get_reservations_with_user(user_6));
        System.out.println(Database.get_reservations_with_user(user_2));
        System.out.println(Database.get_reservations_with_equipment(eq5));
        System.out.println(Database.get_reservations_with_equipment(eq6));
        System.out.println(Database.get_reservations_with_equipment(gf5));
        System.out.println("now test");
        System.out.println(Database.get_reservations_with_reserve_date(new Date()));
        GregorianCalendar test = new GregorianCalendar(2021, 6, 8, 20, 15);
        Date d_test = test.getTime();
        System.out.println(Database.get_reservations_with_reserve_date(d_test));
        GregorianCalendar due_test_2 = new GregorianCalendar(0,1,0,2,30);
        Date d_due_test_2 = due_test_2.getTime();
        GregorianCalendar due_test_1 = new GregorianCalendar(1,1,1,1,45);
        Date d_due_test_1 = due_test_1.getTime();
        System.out.println("d_due_test_1");
        System.out.println(Database.get_reservations_with_reserve_duration(d_due_test_1));
        System.out.println("d_due_test_2");
        System.out.println(Database.get_reservations_with_reserve_duration(d_due_test_2));
        System.out.println(Database.get_reservations_with_total_price_less(1700));
        System.out.println(Database.get_reservations_with_total_price_less(2600));
        System.out.println("total price more than 2400");
        System.out.println(Database.get_reservations_with_total_price_more(2400));
        System.out.println(Database.get_reservations_with_total_price_more(2600));
        System.out.println(Database.get_reservations_with_total_price_equal(2500));
        System.out.println(Database.get_reservations_with_total_price_equal(1200));
        System.out.println(Database.get_reservations_with_submit_date(now));
        System.out.println(Database.get_reservations_with_submit_date(d_later));
        System.out.println(Database.get_paid_reservations());
        r5.pay();
        System.out.println(Database.get_paid_reservations());
        r4.pay();
        System.out.println(Database.get_paid_reservations());
        System.out.println(Database.get_not_paid_reservations());
        System.out.println(Database.get_past_reservations());
        System.out.println(Database.get_next_reservations());
        System.out.println();
        /////// UPDATE
        // Reservation update
        Reservation r;
        try {
            r = new Reservation("R-update", user_1, gf1, d_later, due_1);
            GregorianCalendar g_test = new GregorianCalendar(2022, 8, 10, 18, 20);
            Date d_g_test = g_test.getTime();
            Database.insert_reservation(r);
            System.out.println(Database.getReservation_list());
            Reservation r_2 = Database.get_reservation_by_id("R-update");
            System.out.println("Date before changing:");
            System.out.println(r_2.getReserve_date());
            Database.change_reservation_reserve_date(r_2.getId(), d_g_test);
            Reservation r_3 = Database.get_reservation_by_id("R-update");
            System.out.println("Date after changing:");
            System.out.println(r_3.getReserve_date());
        } catch (Exception e) {
            System.out.println("Something happened");
            r = null;
        }
        System.out.println();
        /////// DELETE
        // User delete
        System.out.println(Database.getUser_list());
        Database.delete_user("Dalam");
        System.out.println(Database.getUser_list());
        Database.delete_user("Hadi-R");
        System.out.println(Database.getUser_list());
        Database.delete_user("Hadi-H");
        System.out.println(Database.getUser_list());
        System.out.println();
        // Field delete
        System.out.println(Database.getField_list());
        Database.delete_equipment("F-first");
        System.out.println(Database.getField_list());
        System.out.println();
        // Table delete
        System.out.println(Database.getTable_list());
        Database.delete_equipment("T-second");
        System.out.println(Database.getTable_list());
        System.out.println();
        // Console delete
        System.out.println(Database.getConsole_list());
        Database.delete_equipment("C-first");
        System.out.println(Database.getConsole_list());
        System.out.println();
        // Equipment delete
        Equipment eq9 = new Equipment("eq9Id", 1500);
        Game_Field gf9 = new Game_Field("gf9Id", 1000, 100, Field_Type.FOOTBALL, Field_Class.B);
        Game_Table gt9 = new Game_Table("gt9Id", 1300, Table_Type.POOL, Table_Class.A);
        Game_Console gc9 = new Game_Console("gc9Id", 1500, Console_Type.PS5);
        Database.insert_equipment(eq9);
        Database.insert_equipment(gf9);
        Database.insert_equipment(gt9);
        Database.insert_equipment(gc9);
        System.out.println(Database.getEquipment_list());
        System.out.println(Database.getField_list());
        System.out.println(Database.getTable_list());
        System.out.println(Database.getConsole_list());
        Database.delete_equipment("eq9Id");
        Database.delete_equipment("gf9Id");
        Database.delete_equipment("gt9Id");
        Database.delete_equipment("gc9Id");
        System.out.println(Database.getEquipment_list());
        System.out.println(Database.getField_list());
        System.out.println(Database.getTable_list());
        System.out.println(Database.getConsole_list());
        System.out.println();
        // Reservation delete
        System.out.println(Database.getReservation_list());
        Database.delete_reservation("R-second");
        Database.delete_reservation("R-third");
        System.out.println(Database.getReservation_list());
        System.out.println();

    }
}
