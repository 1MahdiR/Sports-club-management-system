import club.Equipment;
import club.Game_Console;
import club.Game_Table;
import club.enums.Console_Type;
import club.enums.Table_Class;
import club.enums.Table_Type;
import utility.Database;

import java.util.Scanner;

public class Main {

    private static void show_menu() {
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("| Sports club management |");
        System.out.println("|                        |");
        System.out.println("| 1.Make a reservation   |");
        System.out.println("| 2.Add a new equipment  |");
        System.out.println("| 3.Add a new client     |");
        System.out.println("| 4.Edit equipments      |");
        System.out.println("| 5.Edit reservations    |");
        System.out.println("| 6.Exit                 |");
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

    private static void clear_screen() {
        System.out.print("\033[H\033[2J");
    }

    private static void show_message(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        scanner.nextLine();
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
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            show_menu();
            String menu_reply = scan.nextLine();

            if (menu_reply.equals("2"))
                add_equipment();
            else if (menu_reply.equals("6"))
                break;

            clear_screen();
        }
    }
}
