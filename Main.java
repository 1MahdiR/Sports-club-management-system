import client.Reservation;
import client.User;
import club.Equipment;
import club.Game_Console;
import club.Game_Field;
import club.Game_Table;
import club.enums.*;
import custom_exceptions.*;
import utility.Database;

import java.util.*;

public class Main {

    private static void show_menu() {
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("| Sports club management |");
        System.out.println("|                        |");
        System.out.println("| 1.Make a reservation   |");
        System.out.println("| 2.Add a new equipment  |");
        System.out.println("| 3.Add a new client     |");
        System.out.println("| 4.Show all equipments  |");
        System.out.println("| 5.Show all reservations|");
        System.out.println("| 6.Show all clients     |");
        System.out.println("| 7.Manage reservations  |");
        System.out.println("| 8.Manage clients       |");
        System.out.println("| 9.Exit                 |");
        System.out.println("|                        |");
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.print("\n>");
    }

    private static void show_equipments_menu() {
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("| Add a new equipment    |");
        System.out.println("|                        |");
        System.out.println("| 1.Game field           |");
        System.out.println("| 2.Game table           |");
        System.out.println("| 3.Game console         |");
        System.out.println("| 4.Other equipments     |");
        System.out.println("| 5.Return               |");
        System.out.println("|                        |");
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.print("\n>");
    }

    private static void show_game_field_types() {
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("| Choose a type          |");
        System.out.println("|                        |");
        System.out.println("| 1.FOOTBALL             |");
        System.out.println("| 2.FUTSAL               |");
        System.out.println("| 3.VOLLEYBALL           |");
        System.out.println("| 4.HANDBALL             |");
        System.out.println("| 5.TENNIS               |");
        System.out.println("| 6.HOCKEY               |");
        System.out.println("| 7.BASKETBALL           |");
        System.out.println("| 8.BASEBALL             |");
        System.out.println("| 9.SOCCER               |");
        System.out.println("|                        |");
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.print("\n>");
    }

    private static void show_game_field_classes() {
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("| Choose a class         |");
        System.out.println("|                        |");
        System.out.println("| 1.A                    |");
        System.out.println("| 2.B                    |");
        System.out.println("| 3.C                    |");
        System.out.println("| 4.D                    |");
        System.out.println("|                        |");
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.print("\n>");
    }

    private static void show_game_table_types() {
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("| Choose a type          |");
        System.out.println("|                        |");
        System.out.println("| 1.FOOSBALL             |");
        System.out.println("| 2.PINGPONG             |");
        System.out.println("| 3.SNOOKER              |");
        System.out.println("| 4.POOL                 |");
        System.out.println("|                        |");
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.print("\n>");
    }

    private static void show_game_table_classes() {
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("| Choose a class         |");
        System.out.println("|                        |");
        System.out.println("| 1.A                    |");
        System.out.println("| 2.B                    |");
        System.out.println("| 3.C                    |");
        System.out.println("|                        |");
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.print("\n>");
    }

    private static void show_game_console_types() {
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("| Choose a type          |");
        System.out.println("|                        |");
        System.out.println("| 1.PS3                  |");
        System.out.println("| 2.PS4                  |");
        System.out.println("| 3.PS5                  |");
        System.out.println("| 4.XBOX_ONE             |");
        System.out.println("| 5.XBOX_ONE_S           |");
        System.out.println("| 6.XBOX_ONE_X           |");
        System.out.println("|                        |");
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.print("\n>");
    }

    private static void show_reservation_edit_options() {
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("| Choose an option       |");
        System.out.println("|                        |");
        System.out.println("| 1.Change reservation   |");
        System.out.println("| 2.Pay reservation      |");
        System.out.println("| 3.Return               |");
        System.out.println("|                        |");
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.print("\n>");
    }

    private static void show_user_edit_options() {
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("| Choose an option       |");
        System.out.println("|                        |");
        System.out.println("| 1.Pay debt             |");
        System.out.println("| 2.Return               |");
        System.out.println("|                        |");
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.print("\n>");
    }

    private static void clear_screen() {
        System.out.print("\033[H\033[2J");
    }

    private static void show_message(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        scanner.nextLine();
    }

    private static void make_reservation() {
        Scanner scan = new Scanner(System.in);
        String reply;

        clear_screen();
        System.out.println("Enter a unique id for reservation (Enter nothing to generate a unique id):");
        System.out.print(">");
        boolean id_empty;
        String id = scan.nextLine();
        clear_screen();
        if (id.contains(" ")) {
            show_message("Reservation id must not contain space character.\nAborted!");
            return;
        }
        id_empty = id.isEmpty();
        System.out.println("Enter the user id of client:");
        System.out.print(">");
        String userId = scan.nextLine().trim();

        User user;
        try {
            user = Database.get_user_by_id(userId);
        } catch (UserIdNotFoundException e) {
            show_message("This user does not exist.\nAborted!");
            return;
        }

        clear_screen();
        System.out.println("Enter the equipment code:");
        System.out.print(">");
        String equipmentCode = scan.nextLine().trim();

        Equipment equipment;
        try {
            equipment = Database.get_equipment_by_code(equipmentCode);
        } catch (EquipmentCodeNotFoundException e) {
            show_message("This equipment does not exist.\nAborted!");
            return;
        }

        clear_screen();
        Date reservation_date;
        if (equipment instanceof Game_Field) {

            System.out.println("Enter the reservation date:");
            int year, month, day, hour, minute;
            try {
                System.out.print("Year>");
                year = Integer.parseInt(scan.nextLine());
                if (year < 0)
                    throw new Exception();
                System.out.print("Month>");
                month = Integer.parseInt(scan.nextLine());
                if (month < 1 || month > 12)
                    throw new Exception();
                System.out.print("Day>");
                day = Integer.parseInt(scan.nextLine());
                if (day < 1 || day > 31)
                    throw new Exception();
                System.out.print("Hour>");
                hour = Integer.parseInt(scan.nextLine());
                if (hour < 0 || hour > 23)
                    throw new Exception();
                System.out.print("Minute>");
                minute = Integer.parseInt(scan.nextLine());
                if (minute < 0 || minute > 59)
                    throw new Exception();

                GregorianCalendar g = new GregorianCalendar(year, month-1, day, hour, minute);
                reservation_date = g.getTime();

            } catch (Exception e) {
                show_message("Invalid input!\nAborted!");
                return;
            }
        } else {
            reservation_date = new Date();
        }
        clear_screen();
        Date duration;
        System.out.println("Enter the duration of reservation (max: 5h 59m):");
        int hour, minute;
        try {
            System.out.print("Hour>");
            hour = Integer.parseInt(scan.nextLine());
            if (hour < 0 || hour > 5)
                throw new Exception();
            System.out.print("Minute>");
            minute = Integer.parseInt(scan.nextLine());
            if (minute < 0 || minute > 59)
                throw new Exception();

            GregorianCalendar g = new GregorianCalendar(0, 0, 0, hour, minute);
            duration = g.getTime();

        } catch (Exception e) {
            show_message("Invalid input!\nAborted!");
            return;
        }
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(duration);

        clear_screen();
        System.out.printf("Reservation id: %s\nReservation user: %s\nReservation equipment: %s\nReservation reserve date: %s\nReservation duration: %d:%d\n\n", id, user.getId(), equipment.getCode(), reservation_date, g.get(Calendar.HOUR), g.get(Calendar.MINUTE));
        System.out.println("Are you sure? [Y/n]");
        System.out.print(">");
        reply = scan.nextLine();

        if (reply.trim().equalsIgnoreCase("n")){
            clear_screen();
            show_message("Aborted!");
            return;
        }

        clear_screen();
        Reservation reservation;
        try {
            if (id_empty)
                reservation = new Reservation(user, equipment, reservation_date, duration);
            else
                reservation = new Reservation(id, user, equipment, reservation_date, duration);
        } catch (ReservationDatePassedException | DurationLimitException e) {
            show_message("Reservation date has passed\nAborted!");
            return;
        }

        Database.insert_reservation(reservation);
        System.out.println("Reservation has been successfully added to database.");
        scan.nextLine();

    }

    private static void add_equipment() {
        Scanner scan = new Scanner(System.in);
        String reply;
        while (true) {
            clear_screen();
            show_equipments_menu();
            String menu_reply = scan.nextLine();
            if (menu_reply.equals("5"))
                return;
            if (menu_reply.equals("4")) {
                clear_screen();
                System.out.println("Enter a unique code for equipment (Enter nothing to generate a unique code): ");
                System.out.print(">");
                boolean id_empty;
                String id = scan.nextLine();
                clear_screen();
                if (id.contains(" ")) {
                    show_message("Equipment code must not contain space character.\nAborted!");
                    return;
                }
                id_empty = id.isEmpty();
                System.out.println("Enter a price for using the equipment:");
                System.out.print(">");

                long price;
                try {
                    price = Long.parseLong(scan.nextLine());
                } catch (NumberFormatException e) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                clear_screen();
                System.out.printf("Equipment code: %s\nEquipment price: %d\n\n", id, price);
                System.out.println("Are you sure? [Y/n]");
                System.out.print(">");
                reply = scan.nextLine();

                if (reply.trim().equalsIgnoreCase("n")){
                    clear_screen();
                    show_message("Aborted!");
                    return;
                }

                Equipment equipment;
                if (id_empty)
                    equipment = new Equipment(price);
                else
                    equipment = new Equipment(id, price);
                Database.insert_equipment(equipment);
                clear_screen();
                System.out.println("Equipment has been successfully added to database.");
                scan.nextLine();
                return;
            }
            if (menu_reply.equals("3")) {
                clear_screen();
                System.out.println("Enter a unique code for game console (Enter nothing to generate a unique code): ");
                System.out.print(">");
                boolean id_empty;
                String id = scan.nextLine();
                clear_screen();
                if (id.contains(" ")) {
                    show_message("Game console code must not contain space character.\nAborted!");
                    return;
                }
                id_empty = id.isEmpty();

                System.out.println("Enter a price for using the game console:");
                System.out.print(">");

                long price;
                try {
                    price = Long.parseLong(scan.nextLine());
                } catch (NumberFormatException e) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                clear_screen();
                show_game_console_types();
                int ct;
                try {
                    ct = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                if (ct < 1 || ct > 6) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                Console_Type console_type = Console_Type.values()[ct-1];
                boolean vip;

                clear_screen();
                System.out.println("vip game console? [N/y]");
                System.out.print(">");
                reply = scan.nextLine();

                vip = reply.trim().equalsIgnoreCase("y");

                clear_screen();
                System.out.printf("Game console code: %s\nGame console price: %d\nGame console type: %s\nvip: %s\n", id, price, console_type, vip);
                System.out.println("Are you sure? [Y/n]");
                System.out.print(">");
                reply = scan.nextLine();

                if (reply.trim().equalsIgnoreCase("n")){
                    clear_screen();
                    show_message("Aborted!");
                    return;
                }

                Game_Console game_console;
                if (id_empty)
                    game_console = new Game_Console(price, console_type, vip);
                else
                    game_console = new Game_Console(id, price, console_type, vip);

                Database.insert_equipment(game_console);
                clear_screen();
                System.out.println("Game console has been successfully added to database.");
                scan.nextLine();
                return;
            }
            if (menu_reply.equals("2")) {
                clear_screen();
                System.out.println("Enter a unique code for game table (Enter nothing to generate a unique code): ");
                System.out.print(">");
                boolean id_empty;
                String id = scan.nextLine();
                clear_screen();
                if (id.contains(" ")) {
                    show_message("Game table code must not contain space character.\nAborted!");
                    return;
                }
                id_empty = id.isEmpty();

                System.out.println("Enter a price for using the game table:");
                System.out.print(">");

                long price;
                try {
                    price = Long.parseLong(scan.nextLine());
                } catch (NumberFormatException e) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                clear_screen();
                show_game_table_types();
                int tt;
                try {
                    tt = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                if (tt < 1 || tt > 4) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                Table_Type table_type = Table_Type.values()[tt-1];

                clear_screen();
                show_game_table_classes();
                int tc;
                try {
                    tc = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                if (tc < 1 || tc > 3) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                Table_Class table_class = Table_Class.values()[tc-1];

                clear_screen();
                System.out.printf("Game table code: %s\nGame table price: %d\nGame table type: %s\nGame table class: %s\n", id, price, table_type, table_class);
                System.out.println("Are you sure? [Y/n]");
                System.out.print(">");
                reply = scan.nextLine();

                if (reply.trim().equalsIgnoreCase("n")){
                    clear_screen();
                    show_message("Aborted!");
                    return;
                }

                Game_Table game_table;
                if (id_empty)
                    game_table = new Game_Table(price, table_type, table_class);
                else
                    game_table = new Game_Table(id, price, table_type, table_class);

                Database.insert_equipment(game_table);
                clear_screen();
                System.out.println("Game table has been successfully added to database.");
                scan.nextLine();
                return;
            }
            if (menu_reply.equals("1")) {
                clear_screen();
                System.out.println("Enter a unique code for game field (Enter nothing to generate a unique code): ");
                System.out.print(">");
                boolean id_empty;
                String id = scan.nextLine();
                clear_screen();
                if (id.contains(" ")) {
                    show_message("Game field code must not contain space character.\nAborted!");
                    return;
                }
                id_empty = id.isEmpty();

                System.out.println("Enter a price for using the game field:");
                System.out.print(">");

                long price;
                try {
                    price = Long.parseLong(scan.nextLine());
                } catch (NumberFormatException e) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                if (price < 0) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                clear_screen();
                System.out.println("Enter limit for capacity of game field:");
                System.out.print(">");
                int capacity;
                try {
                    capacity = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                if (capacity < 0) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                clear_screen();
                show_game_field_types();
                int ft;
                try {
                    ft = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                if (ft < 1 || ft > 9) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                Field_Type field_type = Field_Type.values()[ft-1];

                clear_screen();
                show_game_field_classes();
                int fc;
                try {
                    fc = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                if (fc < 1 || fc > 4) {
                    clear_screen();
                    show_message("Invalid input!\nAborted!");
                    return;
                }

                Field_Class field_class = Field_Class.values()[fc-1];

                clear_screen();
                System.out.printf("Game field code: %s\nGame field price: %d\nGame field capacity: %d\nGame field type: %s\nGame field class: %s\n", id, price, capacity, field_type, field_class);
                System.out.println("Are you sure? [Y/n]");
                System.out.print(">");
                reply = scan.nextLine();

                if (reply.trim().equalsIgnoreCase("n")){
                    clear_screen();
                    show_message("Aborted!");
                    return;
                }

                Game_Field game_field;
                if (id_empty)
                    game_field = new Game_Field(price, capacity, field_type, field_class);
                else
                    game_field = new Game_Field(id, price, capacity, field_type, field_class);

                Database.insert_equipment(game_field);
                clear_screen();
                System.out.println("Game field has been successfully added to database.");
                scan.nextLine();
                return;
            }
        }
    }

    private static void add_client() {
        Scanner scan = new Scanner(System.in);
        String reply;
        clear_screen();
        System.out.println("Enter a unique id for client (Enter nothing to generate a unique code): ");
        System.out.print(">");
        boolean id_empty;
        String id = scan.nextLine();
        clear_screen();
        if (id.contains(" ")) {
            show_message("client id must not contain space character.\nAborted!");
            return;
        }
        id_empty = id.isEmpty();
        System.out.println("Enter a name for client:");
        System.out.print(">");
        String name = scan.nextLine();
        clear_screen();
        if (name.trim().isEmpty()) {
            show_message("Name must be at least one character.\nAborted!");
            return;
        }

        System.out.printf("User id: %s\nUser name: %s\n\n", id, name);
        System.out.println("Are you sure? [Y/n]");
        System.out.print(">");
        reply = scan.nextLine();

        if (reply.trim().equalsIgnoreCase("n")){
            clear_screen();
            show_message("Aborted!");
            return;
        }

        User user;
        if (id_empty)
            user = new User(name);
        else
            user = new User(id, name);
        Database.insert_user(user);
        clear_screen();
        System.out.println("User has been successfully added to database.");
        scan.nextLine();

    }

    private static void show_all_equipments() {
        clear_screen();
        System.out.println();
        List<Equipment> list = Database.getEquipment_list();
        for (Equipment equipment: list) {
            System.out.println(equipment);
        }
        System.out.println();
    }

    private static void show_all_reservations() {
        clear_screen();
        System.out.println();
        List<Reservation> list = Database.getReservation_list();
        for (Reservation reservation: list) {
            System.out.println(reservation);
        }
        System.out.println();
    }

    private static void show_all_clients() {
        clear_screen();
        System.out.println();
        List<User> list = Database.getUser_list();
        for (User user: list) {
            System.out.println(user);
        }
        System.out.println();
    }

    private static void edit_reservations() {
        Scanner scan = new Scanner(System.in);
        String reply;
        clear_screen();
        System.out.println("Enter the id of reservation you want to edit:");
        System.out.print(">");
        String reservationId = scan.nextLine().trim();

        Reservation reservation;
        try {
            reservation = Database.get_reservation_by_id(reservationId);
        } catch (ReservationIdNotFoundException e) {
            show_message("This reservation does not exist.\nAborted!");
            return;
        }

        while (true) {
            clear_screen();
            System.out.println(reservation);
            System.out.println();
            show_reservation_edit_options();
            String menu_reply = scan.nextLine();
            if (menu_reply.equals("1")) {
                clear_screen();
                Date reservation_date;
                System.out.println("Enter the reservation date:");
                int year, month, day, hour, minute;
                try {
                    System.out.print("Year>");
                    year = Integer.parseInt(scan.nextLine());
                    if (year < 0)
                        throw new Exception();
                    System.out.print("Month>");
                    month = Integer.parseInt(scan.nextLine());
                    if (month < 1 || month > 12)
                        throw new Exception();
                    System.out.print("Day>");
                    day = Integer.parseInt(scan.nextLine());
                    if (day < 1 || day > 31)
                        throw new Exception();
                    System.out.print("Hour>");
                    hour = Integer.parseInt(scan.nextLine());
                    if (hour < 0 || hour > 23)
                        throw new Exception();
                    System.out.print("Minute>");
                    minute = Integer.parseInt(scan.nextLine());
                    if (minute < 0 || minute > 59)
                        throw new Exception();

                    GregorianCalendar g = new GregorianCalendar(year, month-1, day, hour, minute);
                    reservation_date = g.getTime();

                } catch (Exception e) {
                    show_message("Invalid input!\nAborted!");
                    return;
                }
                Database.change_reservation_reserve_date(reservation.getId(), reservation_date);
                clear_screen();
                show_message("Reservation date has been successfully updated!");
                return;
            }
            if (menu_reply.equals("2")) {
                reservation.pay();
                clear_screen();
                show_message("Reservation is paid. check user's info for final checkout.");
                return;
            }
            if (menu_reply.equals("3"))
                return;
        }

    }

    private static void edit_clients() {
        Scanner scan = new Scanner(System.in);
        String reply;
        clear_screen();
        System.out.println("Enter the id of user you want to manage:");
        System.out.print(">");
        String userId = scan.nextLine().trim();

        User user;
        try {
            user = Database.get_user_by_id(userId);
        } catch (UserIdNotFoundException e) {
            clear_screen();
            show_message("This user does not exist.\nAborted!");
            return;
        }

        while (true) {
            clear_screen();
            System.out.println(user);
            System.out.println();
            show_user_edit_options();
            String menu_reply = scan.nextLine();
            if (menu_reply.equals("1")) {
                clear_screen();
                long debt;
                System.out.println("How much do you want to pay? :");
                System.out.print(">");
                try {
                    debt = Long.parseLong(scan.nextLine());
                    if (debt < 0)
                        throw new Exception();

                    if (debt > user.getDebt()) {
                        clear_screen();
                        show_message("This cash is more than client's debt!\nAborted!");
                        return;
                    }

                } catch (Exception e) {
                    show_message("Invalid input!\nAborted!");
                    return;
                }
                user.pay_debt(debt);
                clear_screen();
                show_message("Paid successfully!");
                return;
            }
            if (menu_reply.equals("2"))
                return;
        }
    }

    public static void main(String[] args) {
        clear_screen();
        Scanner scan = new Scanner(System.in);
        label:
        while (true) {
            show_menu();
            String menu_reply = scan.nextLine();

            switch (menu_reply) {
                case "1":
                    make_reservation();
                    break;
                case "2":
                    add_equipment();
                    break;
                case "3":
                    add_client();
                    break;
                case "4":
                    show_all_equipments();
                    scan.nextLine();
                    break;
                case "5":
                    show_all_reservations();
                    scan.nextLine();
                    break;
                case "6":
                    show_all_clients();
                    scan.nextLine();
                    break;
                case "7":
                    edit_reservations();
                    break;
                case "8":
                    edit_clients();
                    break;
                case "9":
                    break label;
            }

            clear_screen();
        }
    }
}
