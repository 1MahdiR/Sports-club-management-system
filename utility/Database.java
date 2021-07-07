package utility;

import client.Reservation;
import client.User;
import club.Equipment;
import club.Game_Console;
import club.Game_Field;
import club.Game_Table;
import custom_exceptions.EquipmentCodeNotFoundException;
import custom_exceptions.UserIdNotFoundException;

import java.util.ArrayList;
import java.util.List;

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
}
