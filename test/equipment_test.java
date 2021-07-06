package test;

import club.Equipment;
import club.Game_Console;
import club.Game_Field;
import club.Game_Table;
import club.enums.*;

public class equipment_test {

    public static void main(String[] args) {

        Equipment eq;
        try {
            eq = new Equipment(3000);
            System.out.println(eq.getPrice());
            System.out.println(eq.getCode());
            eq.setPrice(3500);
            System.out.println(eq.getPrice());

            System.out.println(eq);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something happened!");
        }
        System.out.println();

        Game_Field a;
        try {
            a = new Game_Field(1000, 100, Field_Type.FOOTBALL, Field_Class.A);
            System.out.println(a.getField_class());
            System.out.println(a.getCapacity());
            System.out.println(a.getField_type());
            System.out.println(a.getPrice());
            System.out.println(a.getCode());
            a.setCapacity(200);
            a.setPrice(2000);
            System.out.println(a.getCapacity());
            System.out.println(a.getPrice());

            System.out.println(a);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something happened!");
        }
        System.out.println();

        Game_Table b;
        try {
            b = new Game_Table(1000, Table_Type.FOOSBALL, Table_Class.A);
            System.out.println(b.getTable_class());
            System.out.println(b.getTable_type());
            System.out.println(b.getPrice());
            System.out.println(b.getCode());
            b.setPrice(2000);
            System.out.println(b.getPrice());

            System.out.println(b);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something happened!");
        }
        System.out.println();

        Game_Console c;
        try {
            c = new Game_Console(1000, Console_Type.PS4, true);
            System.out.println(c.getConsole_type());
            System.out.println(c.getPrice());
            System.out.println(c.getCode());
            c.setPrice(2000);
            System.out.println(c.getPrice());

            System.out.println(c);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something happened!");
        }
        System.out.println();

        Equipment eq2;
        try {
            eq2 = new Equipment("eq2_code", 3000);
            System.out.println(eq2.getPrice());
            System.out.println(eq2.getCode());
            eq2.setPrice(3500);
            System.out.println(eq2.getPrice());

            System.out.println(eq2);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something happened!");
        }
        System.out.println();

        Game_Field a2;
        try {
            a2 = new Game_Field("Game_field_code", 1000, 100, Field_Type.FOOTBALL, Field_Class.A);
            System.out.println(a2.getField_class());
            System.out.println(a2.getCapacity());
            System.out.println(a2.getField_type());
            System.out.println(a2.getPrice());
            System.out.println(a2.getCode());
            a2.setCapacity(200);
            a2.setPrice(2000);
            System.out.println(a2.getCapacity());
            System.out.println(a2.getPrice());

            System.out.println(a2);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something happened!");
        }
        System.out.println();

        Game_Table b2;
        try {
            b2 = new Game_Table("Game_table_code", 1000, Table_Type.FOOSBALL, Table_Class.A);
            System.out.println(b2.getTable_class());
            System.out.println(b2.getTable_type());
            System.out.println(b2.getPrice());
            System.out.println(b2.getCode());
            b2.setPrice(2000);
            System.out.println(b2.getPrice());

            System.out.println(b2);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something happened!");
        }
        System.out.println();

        Game_Console c2;
        try {
            c2 = new Game_Console("Game_console_code", 1000, Console_Type.PS4, true);
            System.out.println(c2.getConsole_type());
            System.out.println(c2.getPrice());
            System.out.println(c2.getCode());
            c2.setPrice(2000);
            System.out.println(c2.getPrice());

            System.out.println(c2);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something happened!");
        }
        System.out.println();

    }
}
