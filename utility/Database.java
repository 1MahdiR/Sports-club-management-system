package utility;

import client.Reservation;
import client.User;
import club.Equipment;
import club.Game_Console;
import club.Game_Field;
import club.Game_Table;
import club.enums.*;
import custom_exceptions.EquipmentCodeNotFoundException;
import custom_exceptions.ReservationIdNotFoundException;
import custom_exceptions.UserIdNotFoundException;

import java.util.*;

public class Database {

    private static List<User> user_list = new ArrayList<User>();
    private static List<Equipment> equipment_list = new ArrayList<Equipment>();
    private static List<Game_Field> field_list = new ArrayList<Game_Field>();
    private static List<Game_Table> table_list = new ArrayList<Game_Table>();
    private static List<Game_Console> console_list = new ArrayList<Game_Console>();
    private static List<Reservation> reservation_list = new ArrayList<Reservation>();

    public static List<User> getUser_list() { return user_list; }
    public static List<Equipment> getEquipment_list() { return equipment_list; }
    public static List<Game_Field> getField_list() { return field_list; }
    public static List<Game_Table> getTable_list() { return table_list; }
    public static List<Game_Console> getConsole_list() { return console_list; }
    public static List<Reservation> getReservation_list() { return reservation_list; }

    public static void insert_user (User user) {
        user_list.add(user);
    }

    public static void insert_equipment (Equipment equipment) {
        equipment_list.add(equipment);
        if (equipment instanceof Game_Field) {
            field_list.add((Game_Field) equipment);
        } else if (equipment instanceof Game_Table) {
            table_list.add((Game_Table) equipment);
        } else if (equipment instanceof Game_Console) {
            console_list.add((Game_Console) equipment);
        }
    }

    public static void insert_reservation (Reservation reservation) {
        reservation_list.add(reservation);
    }

    public static User get_user_by_id(List<User> list, String id) throws UserIdNotFoundException {

        for (User user: list) {
            if (user.getId().equals(id))
                return user;
        }
        throw new UserIdNotFoundException();
    }

    public static User get_user_by_id(String id) throws UserIdNotFoundException {

        return get_user_by_id(user_list, id);
    }

    public static List<User> get_users_by_name(List<User> list, String name) {

        List<User> temp = new ArrayList<User>();
        for (User user: list) {
            if (user.getName().equalsIgnoreCase(name))
                temp.add(user);
        }
        return temp;
    }

    public static List<User> get_users_by_name(String name) {

        return get_users_by_name(user_list, name);
    }

    public static List<User> get_users_with_debt_less(List<User> list, long debt) {

        List<User> temp = new ArrayList<User>();
        for (User user: list) {
            if (user.getDebt() < debt)
                temp.add(user);
        }
        return temp;
    }

    public static List<User> get_users_with_debt_less(long debt) {

        return get_users_with_debt_less(user_list, debt);
    }

    public static List<User> get_users_with_debt_more(List<User> list, long debt) {

        List<User> temp = new ArrayList<User>();
        for (User user: list) {
            if (user.getDebt() > debt)
                temp.add(user);
        }
        return temp;
    }

    public static List<User> get_users_with_debt_more(long debt) {

        return get_users_with_debt_more(user_list, debt);
    }

    public static List<User> get_users_with_debt_equal(List<User> list, long debt) {

        List<User> temp = new ArrayList<User>();
        for (User user: list) {
            if (user.getDebt() == debt)
                temp.add(user);
        }
        return temp;
    }

    public static List<User> get_users_with_debt_equal(long debt) {

        return get_users_with_debt_equal(user_list, debt);
    }

    public static Equipment get_equipment_by_code(List<Equipment> list, String code) throws EquipmentCodeNotFoundException {

        for (Equipment equipment: list) {
            if (equipment.getCode().equals(code))
                return equipment;
        }
        throw new EquipmentCodeNotFoundException();
    }

    public static Equipment get_equipment_by_code(String code) throws EquipmentCodeNotFoundException {

        return get_equipment_by_code(equipment_list, code);
    }

    public static List<Equipment> get_equipments_with_price_less(List<Equipment> list, long price) {

        List<Equipment> temp = new ArrayList<Equipment>();
        for (Equipment equipment: list) {
            if (equipment.getPrice() < price)
                temp.add(equipment);
        }
        return temp;
    }

    public static List<Equipment> get_equipments_with_price_less(long price) {

        return get_equipments_with_price_less(equipment_list, price);
    }

    public static List<Equipment> get_equipments_with_price_more(List<Equipment> list, long price) {

        List<Equipment> temp = new ArrayList<Equipment>();
        for (Equipment equipment: list) {
            if (equipment.getPrice() > price)
                temp.add(equipment);
        }
        return temp;
    }

    public static List<Equipment> get_equipments_with_price_more(long price) {

        return get_equipments_with_price_more(equipment_list, price);
    }

    public static List<Equipment> get_equipments_with_price_equal(List<Equipment> list, long price) {

        List<Equipment> temp = new ArrayList<Equipment>();
        for (Equipment equipment: list) {
            if (equipment.getPrice() == price)
                temp.add(equipment);
        }
        return temp;
    }

    public static List<Equipment> get_equipments_with_price_equal(long price) {

        return get_equipments_with_price_equal(equipment_list, price);
    }

    public static Game_Field get_field_by_code(List<Game_Field> list, String code) throws EquipmentCodeNotFoundException {

        for (Game_Field field: list) {
            if (field.getCode().equals(code))
                return field;
        }
        throw new EquipmentCodeNotFoundException();
    }

    public static Game_Field get_field_by_code(String code) throws EquipmentCodeNotFoundException {

        return get_field_by_code(field_list, code);
    }

    public static List<Game_Field> get_fields_with_price_less(List<Game_Field> list, long price) {

        List<Game_Field> temp = new ArrayList<Game_Field>();
        for (Game_Field field: list) {
            if (field.getPrice() < price)
                temp.add(field);
        }
        return temp;
    }

    public static List<Game_Field> get_fields_with_price_less(long price) {

        return get_fields_with_price_less(field_list, price);
    }

    public static List<Game_Field> get_fields_with_price_more(List<Game_Field> list, long price) {

        List<Game_Field> temp = new ArrayList<Game_Field>();
        for (Game_Field field: list) {
            if (field.getPrice() > price)
                temp.add(field);
        }
        return temp;
    }

    public static List<Game_Field> get_fields_with_price_more(long price) {

        return get_fields_with_price_more(field_list, price);
    }

    public static List<Game_Field> get_fields_with_price_equal(List<Game_Field> list, long price) {

        List<Game_Field> temp = new ArrayList<Game_Field>();
        for (Game_Field field: list) {
            if (field.getPrice() == price)
                temp.add(field);
        }
        return temp;
    }

    public static List<Game_Field> get_fields_with_price_equal(long price) {

        return get_fields_with_price_equal(field_list, price);
    }

    public static List<Game_Field> get_fields_with_capacity_less(List<Game_Field> list, int capacity) {

        List<Game_Field> temp = new ArrayList<Game_Field>();
        for (Game_Field field: list) {
            if (field.getCapacity() < capacity)
                temp.add(field);
        }
        return temp;
    }

    public static List<Game_Field> get_fields_with_capacity_less(int capacity) {

        return get_fields_with_capacity_less(field_list, capacity);
    }

    public static List<Game_Field> get_fields_with_capacity_more(List<Game_Field> list, int capacity) {

        List<Game_Field> temp = new ArrayList<Game_Field>();
        for (Game_Field field: list) {
            if (field.getCapacity() > capacity)
                temp.add(field);
        }
        return temp;
    }

    public static List<Game_Field> get_fields_with_capacity_more(int capacity) {

        return get_fields_with_capacity_more(field_list, capacity);
    }

    public static List<Game_Field> get_fields_with_capacity_equal(List<Game_Field> list, int capacity) {

        List<Game_Field> temp = new ArrayList<Game_Field>();
        for (Game_Field field: list) {
            if (field.getCapacity() == capacity)
                temp.add(field);
        }
        return temp;
    }

    public static List<Game_Field> get_fields_with_capacity_equal(int capacity) {

        return get_fields_with_capacity_equal(field_list, capacity);
    }

    public static List<Game_Field> get_fields_with_type(List<Game_Field> list, Field_Type ft) {

        List <Game_Field> temp = new ArrayList<Game_Field>();
        for (Game_Field field: list) {
            if (field.getField_type().equals(ft))
                temp.add(field);
        }
        return temp;
    }

    public static List<Game_Field> get_fields_with_type(Field_Type ft) {

        return get_fields_with_type(field_list, ft);
    }

    public static List<Game_Field> get_fields_with_class(List<Game_Field> list, Field_Class fc) {

        List  <Game_Field> temp = new ArrayList<Game_Field>();
        for (Game_Field field: list) {
            if (field.getField_class().equals(fc))
                temp.add(field);
        }
        return temp;
    }

    public static List<Game_Field> get_fields_with_class(Field_Class fc) {

        return get_fields_with_class(field_list, fc);
    }

    public static Game_Table get_table_by_code(List<Game_Table> list, String code) throws EquipmentCodeNotFoundException {

        for (Game_Table table: list) {
            if (table.getCode().equals(code))
                return table;
        }
        throw new EquipmentCodeNotFoundException();
    }

    public static Game_Table get_table_by_code(String code) throws EquipmentCodeNotFoundException {

        return get_table_by_code(table_list, code);
    }

    public static List<Game_Table> get_tables_with_price_less(List<Game_Table> list, long price) {

        List<Game_Table> temp = new ArrayList<Game_Table>();
        for (Game_Table table: list) {
            if (table.getPrice() < price)
                temp.add(table);
        }
        return temp;
    }

    public static List<Game_Table> get_tables_with_price_less(long price) {

        return get_tables_with_price_less(table_list, price);
    }

    public static List<Game_Table> get_tables_with_price_more(List<Game_Table> list, long price) {

        List<Game_Table> temp = new ArrayList<Game_Table>();
        for (Game_Table table: list) {
            if (table.getPrice() > price)
                temp.add(table);
        }
        return temp;
    }

    public static List<Game_Table> get_tables_with_price_more(long price) {

        return get_tables_with_price_more(table_list, price);
    }

    public static List<Game_Table> get_tables_with_price_equal(List<Game_Table> list, long price) {

        List<Game_Table> temp = new ArrayList<Game_Table>();
        for (Game_Table table: list) {
            if (table.getPrice() == price)
                temp.add(table);
        }
        return temp;
    }

    public static List<Game_Table> get_tables_with_price_equal(long price) {

        return get_tables_with_price_equal(table_list, price);
    }

    public static List<Game_Table> get_tables_with_type(List<Game_Table> list, Table_Type tt) {

        List <Game_Table> temp = new ArrayList<Game_Table>();
        for (Game_Table table: list) {
            if (table.getTable_type().equals(tt))
                temp.add(table);
        }
        return temp;
    }

    public static List<Game_Table> get_tables_with_type(Table_Type tt) {

        return get_tables_with_type(table_list, tt);
    }

    public static List<Game_Table> get_tables_with_class(List<Game_Table> list, Table_Class tc) {

        List <Game_Table> temp = new ArrayList<Game_Table>();
        for (Game_Table table: list) {
            if (table.getTable_class().equals(tc))
                temp.add(table);
        }
        return temp;
    }

    public static List<Game_Table> get_tables_with_class(Table_Class tc) {

        return get_tables_with_class(table_list, tc);
    }

    public static Game_Console get_console_by_code(List<Game_Console> list, String code) throws EquipmentCodeNotFoundException {

        for (Game_Console console: list) {
            if (console.getCode().equals(code))
                return console;
        }
        throw new EquipmentCodeNotFoundException();
    }

    public static Game_Console get_console_by_code(String code) throws EquipmentCodeNotFoundException {

        return get_console_by_code(console_list, code);
    }

    public static List<Game_Console> get_consoles_with_price_less(List<Game_Console> list, long price) {

        List<Game_Console> temp = new ArrayList<Game_Console>();
        for (Game_Console console: list) {
            if (console.getPrice() < price)
                temp.add(console);
        }
        return temp;
    }

    public static List<Game_Console> get_consoles_with_price_less(long price) {

        return get_consoles_with_price_less(console_list, price);
    }

    public static List<Game_Console> get_consoles_with_price_more(List<Game_Console> list, long price) {

        List<Game_Console> temp = new ArrayList<Game_Console>();
        for (Game_Console console: list) {
            if (console.getPrice() > price)
                temp.add(console);
        }
        return temp;
    }

    public static List<Game_Console> get_consoles_with_price_more(long price) {

        return get_consoles_with_price_more(console_list, price);
    }

    public static List<Game_Console> get_consoles_with_price_equal(List<Game_Console> list, long price) {

        List<Game_Console> temp = new ArrayList<Game_Console>();
        for (Game_Console console: list) {
            if (console.getPrice() == price)
                temp.add(console);
        }
        return temp;
    }

    public static List<Game_Console> get_consoles_with_price_equal(long price) {

        return get_consoles_with_price_equal(console_list, price);
    }

    public static List<Game_Console> get_consoles_with_type(List<Game_Console> list, Console_Type ct) {

        List<Game_Console> temp = new ArrayList<Game_Console>();
        for (Game_Console console: list) {
            if (console.getConsole_type().equals(ct))
                temp.add(console);
        }
        return temp;
    }

    public static List<Game_Console> get_consoles_with_type(Console_Type ct) {

        return get_consoles_with_type(console_list, ct);
    }

    public static List<Game_Console> get_vip_consoles(List<Game_Console> list) {

        List<Game_Console> temp = new ArrayList<Game_Console>();
        for (Game_Console console: list) {
            if (console.is_vip())
                temp.add(console);
        }
        return temp;
    }

    public static List<Game_Console> get_vip_consoles() {

        return get_vip_consoles(console_list);
    }

    public static List<Game_Console> get_not_vip_consoles(List<Game_Console> list) {

        List<Game_Console> temp = new ArrayList<Game_Console>();
        for (Game_Console console: list) {
            if (!console.is_vip())
                temp.add(console);
        }
        return temp;
    }

    public static List<Game_Console> get_not_vip_consoles() {

        return get_not_vip_consoles(console_list);
    }

    public static Reservation get_reservation_by_id(List<Reservation> list, String id) throws ReservationIdNotFoundException {

        for (Reservation reservation: list) {
            if (reservation.getId().equals(id))
                return reservation;
        }
        throw new ReservationIdNotFoundException();
    }

    public static Reservation get_reservation_by_id(String id) throws ReservationIdNotFoundException {

        return get_reservation_by_id(reservation_list, id);
    }

    public static List<Reservation> get_reservations_with_user(List<Reservation> list, User user) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            if (reservation.getUser().getId().equals(user.getId()))
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_reservations_with_user(User user) {

        return get_reservations_with_user(reservation_list, user);
    }

    public static List<Reservation> get_reservations_with_equipment(List<Reservation> list, Equipment equipment) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            if (reservation.getEquipment().getCode().equals(equipment.getCode()))
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_reservations_with_equipment(Equipment equipment) {

        return get_reservations_with_equipment(reservation_list, equipment);
    }

    public static List<Reservation> get_reservations_with_reserve_date(List<Reservation> list, Date reserve_date) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            GregorianCalendar g = new GregorianCalendar();
            GregorianCalendar g2 = new GregorianCalendar();
            g.setTime(reserve_date);
            g2.setTime(reservation.getReserve_date());
            boolean year = g.get(Calendar.YEAR) == g2.get(Calendar.YEAR);
            boolean month = g.get(Calendar.MONTH) == g2.get(Calendar.MONTH);
            boolean day = g.get(Calendar.DAY_OF_MONTH) == g2.get(Calendar.DAY_OF_MONTH);
            boolean hour = g.get(Calendar.HOUR) == g2.get(Calendar.HOUR);
            boolean minute = g.get(Calendar.MINUTE) == g2.get(Calendar.MINUTE);
            if (year && month && day && hour && minute)
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_reservations_with_reserve_date(Date reserve_date) {

        return get_reservations_with_reserve_date(reservation_list, reserve_date);
    }

    public static List<Reservation> get_reservations_with_reserve_duration(List<Reservation> list, Date reserve_duration) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            GregorianCalendar g = new GregorianCalendar();
            GregorianCalendar g2 = new GregorianCalendar();
            g.setTime(reserve_duration);
            g2.setTime(reservation.getReserve_duration());
            boolean hour = g.get(Calendar.HOUR) == g2.get(Calendar.HOUR);
            boolean minute = g.get(Calendar.MINUTE) == g2.get(Calendar.MINUTE);
            if (hour && minute)
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_reservations_with_reserve_duration(Date reserve_duration) {

        return get_reservations_with_reserve_duration(reservation_list, reserve_duration);
    }

    public static List<Reservation> get_reservations_with_total_price_less(List<Reservation> list, long price) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            if (reservation.getTotal_price() < price)
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_reservations_with_total_price_less(long price) {

        return get_reservations_with_total_price_less(reservation_list, price);
    }

    public static List<Reservation> get_reservations_with_total_price_more(List<Reservation> list, long price) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            if (reservation.getTotal_price() > price)
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_reservations_with_total_price_more(long price) {

        return get_reservations_with_total_price_more(reservation_list, price);
    }

    public static List<Reservation> get_reservations_with_total_price_equal(List<Reservation> list, long price) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            if (reservation.getTotal_price() == price)
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_reservations_with_total_price_equal(long price) {

        return get_reservations_with_total_price_equal(reservation_list, price);
    }

    public static List<Reservation> get_reservations_with_submit_date(List<Reservation> list, Date submit_date) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            GregorianCalendar g = new GregorianCalendar();
            GregorianCalendar g2 = new GregorianCalendar();
            g.setTime(submit_date);
            g2.setTime(reservation.getSubmit_date());
            boolean year = g.get(Calendar.YEAR) == g2.get(Calendar.YEAR);
            boolean month = g.get(Calendar.MONTH) == g2.get(Calendar.MONTH);
            boolean day = g.get(Calendar.DAY_OF_MONTH) == g2.get(Calendar.DAY_OF_MONTH);
            boolean hour = g.get(Calendar.HOUR) == g2.get(Calendar.HOUR);
            boolean minute = g.get(Calendar.MINUTE) == g2.get(Calendar.MINUTE);
            if (year && month && day && hour && minute)
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_reservations_with_submit_date(Date submit_date) {

        return get_reservations_with_submit_date(reservation_list, submit_date);
    }

    public static List<Reservation> get_paid_reservations(List<Reservation> list) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            if (reservation.isPaid())
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_paid_reservations() {

        return get_paid_reservations(reservation_list);
    }

    public static List<Reservation> get_not_paid_reservations(List<Reservation> list) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            if (!reservation.isPaid())
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_not_paid_reservations() {

        return get_not_paid_reservations(reservation_list);
    }

    public static List<Reservation> get_past_reservations(List<Reservation> list) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            if (reservation.has_passed())
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_past_reservations() {

        return get_past_reservations(reservation_list);
    }

    public static List<Reservation> get_next_reservations(List<Reservation> list) {

        List<Reservation> temp = new ArrayList<Reservation>();
        for (Reservation reservation: list) {
            if (!reservation.has_passed())
                temp.add(reservation);
        }
        return temp;
    }

    public static List<Reservation> get_next_reservations() {

        return get_next_reservations(reservation_list);
    }

}
