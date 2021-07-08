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

    private static void clear_screen() {
        System.out.print("\033[H\033[2J");
    }

    private static void add_equipment() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            clear_screen();
            show_equipments_menu();
            String menu_reply = scan.nextLine();
            if (menu_reply.equals("5"))
                return;

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
