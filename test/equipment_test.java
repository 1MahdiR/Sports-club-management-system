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
    }
}
