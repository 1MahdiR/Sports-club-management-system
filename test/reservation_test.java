package test;

import client.*;
import club.Equipment;
import club.Game_Console;
import club.Game_Field;
import club.Game_Table;
import club.enums.*;
import custom_exceptions.DurationLimitException;
import custom_exceptions.ReservationDatePassedException;

import java.util.Date;
import java.util.GregorianCalendar;

public class reservation_test {

    public static void main (String[] args) {

        User user1 = new User("Mahdi");
        User user2 = new User("Ali");
        GregorianCalendar g = new GregorianCalendar(0,0,0,2,30);
        Date dg = g.getTime();
        GregorianCalendar g_2 = new GregorianCalendar(0,0,0,1,15);
        Date dg2 = g_2.getTime();
        GregorianCalendar g_3 = new GregorianCalendar(0,0,0,6,1);
        Date dg3 = g_3.getTime();
        /////////////
        Date now = new Date();
        Equipment eq = new Equipment(1000);
        GregorianCalendar g2 = new GregorianCalendar(2022,5,24);
        Reservation reserve;
        try {
            reserve = new Reservation(user1, eq, now, dg);
            System.out.println(reserve.getId());
            System.out.println(reserve.getUser());
            System.out.println(reserve.getEquipment());
            System.out.println(reserve.getReserve_date());
            System.out.println(reserve.getReserve_duration());
            System.out.println(reserve.getTotal_price());
            System.out.println(reserve.getSubmit_date());
            System.out.println(reserve.isPaid());
            System.out.println(reserve);
            reserve.change_reserve_date(g2.getTime());
            System.out.println(reserve.has_passed());
            System.out.printf("user's debt before paying: %d\n", user1.getDebt());
            reserve.pay();
            System.out.printf("user's debt after paying: %d\n", user1.getDebt());
            System.out.println(reserve.isPaid());
        } catch (DurationLimitException | ReservationDatePassedException e) {
            reserve = null;
            System.out.println(e);
        }
        System.out.println();
        /////////////
        Game_Field gf = new Game_Field(3500, 100, Field_Type.FUTSAL, Field_Class.B);
        GregorianCalendar g3 = new GregorianCalendar(2022,10,10);
        Date later = g3.getTime();
        GregorianCalendar g4 = new GregorianCalendar(2022, 10, 12);
        Date later_2 = g4.getTime();
        Reservation reserve_2;
        try {
            reserve_2 = new Reservation(user2, gf, later, dg);
            System.out.println(reserve_2.getId());
            System.out.println(reserve_2.getUser());
            System.out.println(reserve_2.getEquipment());
            System.out.println(reserve_2.getReserve_date());
            System.out.println(reserve_2.getReserve_duration());
            System.out.println(reserve_2.getTotal_price());
            System.out.println(reserve_2.isPaid());
            System.out.println(reserve_2);
            reserve_2.change_reserve_date(later_2);
            System.out.println(reserve_2.getReserve_date());
            System.out.println(reserve_2.has_passed());
            System.out.printf("user's debt before paying: %d\n", user2.getDebt());
            reserve_2.pay();
            System.out.printf("user's debt after paying: %d\n", user2.getDebt());
            System.out.println(reserve_2.isPaid());
        } catch (DurationLimitException | ReservationDatePassedException e) {
            reserve_2 = null;
            System.out.println(e);
        }
        System.out.println();
        /////////////
        Game_Table gt = new Game_Table(2000, Table_Type.PINGPONG, Table_Class.C);
        GregorianCalendar g5 = new GregorianCalendar(2021,10,10);
        Date later_3 = g5.getTime();
        GregorianCalendar g6 = new GregorianCalendar(2021, 10, 8);
        Date later_4 = g6.getTime();
        GregorianCalendar g7 = new GregorianCalendar(2021, 7, 5);
        Date before = g7.getTime();
        Reservation reserve_3;
        try {
            reserve_3 = new Reservation(user1, gt, later_3, dg);
            System.out.println(reserve_3.getId());
            System.out.println(reserve_3.getUser());
            System.out.println(reserve_3.getEquipment());
            System.out.println(reserve_3.getReserve_date());
            System.out.println(reserve_3.getReserve_duration());
            System.out.println(reserve_3.getTotal_price());
            System.out.println(reserve_3.isPaid());
            System.out.println(reserve_3);
            reserve_3.change_reserve_date(before);
            System.out.println(reserve_3.getReserve_date());
            System.out.println(reserve_3.has_passed());
            reserve_3.change_reserve_date(later_4);
            System.out.println(reserve_3.getReserve_date());
            System.out.printf("user's debt before paying: %d\n", user1.getDebt());
            reserve_3.pay();
            System.out.printf("user's debt after paying: %d\n", user1.getDebt());
            System.out.println(reserve_3.isPaid());
        } catch (DurationLimitException | ReservationDatePassedException e) {
            reserve_3 = null;
            System.out.println(e);
        }
        System.out.println();
        /////////////
        Game_Console gc = new Game_Console(4750, Console_Type.PS5);
        Date n = new Date();
        Reservation reserve_4;
        try {
            reserve_4 = new Reservation(user2, gc, n, dg);
            System.out.println(reserve_4.getId());
            System.out.println(reserve_4.getUser());
            System.out.println(reserve_4.getEquipment());
            System.out.println(reserve_4.getReserve_date());
            System.out.println(reserve_4.getReserve_duration());
            System.out.println(reserve_4.getTotal_price());
            System.out.println(reserve_4.isPaid());
            System.out.println(reserve_4);
            System.out.println(reserve_4.has_passed());
            reserve_4.change_reserve_date(later_4);
            System.out.println(reserve_4.getReserve_date());
            System.out.println(reserve_4.has_passed());
            System.out.printf("user's debt before paying: %d\n", user2.getDebt());
            reserve_4.pay();
            System.out.printf("user's debt after paying: %d\n", user2.getDebt());
            System.out.println(reserve_4.isPaid());
        } catch (DurationLimitException | ReservationDatePassedException e) {
            reserve_4 = null;
            System.out.println(e);
        }
        System.out.println();
        /////////////
        Game_Field gf2 = new Game_Field(3600, 200, Field_Type.BASKETBALL, Field_Class.A);
        GregorianCalendar g8 = new GregorianCalendar(2021,10,10);
        Date later_5 = g8.getTime();
        GregorianCalendar g9 = new GregorianCalendar(2021, 10, 8);
        Date later_6 = g9.getTime();
        GregorianCalendar g10 = new GregorianCalendar(2021, 7, 5);
        Date before_2 = g10.getTime();
        Reservation reserve_5;
        try {
            reserve_5 = new Reservation(user1, gf2, later_5, dg2);
            System.out.println(reserve_5.getId());
            System.out.println(reserve_5.getUser());
            System.out.println(reserve_5.getEquipment());
            System.out.println(reserve_5.getReserve_date());
            System.out.println(reserve_5.getReserve_duration());
            System.out.println(reserve_5.getTotal_price());
            System.out.println(reserve_5.isPaid());
            System.out.println(reserve_5);
            System.out.println(reserve_5.has_passed());
            reserve_5.change_reserve_date(before_2);
            System.out.println(reserve_5.getReserve_date());
            System.out.println(reserve_5.has_passed());
            reserve_5.change_reserve_date(later_6);
            System.out.println(reserve_5.getReserve_date());
            System.out.println(reserve_5.has_passed());
            System.out.printf("user's debt before paying: %d\n", user1.getDebt());
            reserve_5.pay();
            System.out.printf("user's debt after paying: %d\n", user1.getDebt());
            System.out.println(reserve_5.isPaid());
        } catch (DurationLimitException | ReservationDatePassedException e) {
            reserve_5 = null;
            System.out.println(e);
        }
        System.out.println();
        /////////////
        Game_Field gf3 = new Game_Field(1200, 200, Field_Type.BASKETBALL, Field_Class.B);
        GregorianCalendar g11 = new GregorianCalendar(2021,10,10);
        Date later_7 = g11.getTime();
        Reservation reserve_6;
        try {
            reserve_6 = new Reservation(user2, gf3, later_7, dg3);
        } catch (DurationLimitException | ReservationDatePassedException e) {
            reserve_6 = null;
            System.out.println(e);
        }
        System.out.println(reserve_6);
        System.out.println();
        /////////////
        Game_Field gf4 = new Game_Field(1500, 150, Field_Type.HANDBALL, Field_Class.B);
        GregorianCalendar g12 = new GregorianCalendar(2021,6,5);
        Date before_3 = g12.getTime();
        Reservation reserve_7;
        try {
            reserve_7 = new Reservation(user1, gf4, before_3, dg2);
        } catch (DurationLimitException | ReservationDatePassedException e) {
            reserve_7 = null;
            System.out.println(e);
        }
        System.out.println(reserve_7);
        System.out.println();
        /////////////

    }
}
