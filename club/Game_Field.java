package club;

import club.enums.Field_Class;
import club.enums.Field_Type;

public class Game_Field extends Equipment {

    private int capacity;
    private final Field_Type field_type;
    private final Field_Class field_class;

    public Game_Field(long price, int capacity, Field_Type f_type, Field_Class f_class) {
        super(price);
        this.code = "F-" + this.code;
        this.field_type = f_type;
        this.field_class = f_class;
        this.capacity = capacity;
    }

    public Game_Field(String code, long price, int capacity, Field_Type f_type, Field_Class f_class) {
        super(code, price);
        this.field_type = f_type;
        this.field_class = f_class;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int c) {
        this.capacity = c;
    }

    public Field_Type getField_type() {
        return field_type;
    }

    public Field_Class getField_class() {
        return field_class;
    }

    public String toString() {
        return String.format("<Equipment: Game Field [code:%s]-[type:%s]>", this.code, this.field_type);
    }
}
