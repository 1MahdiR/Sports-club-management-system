package club;

import club.enums.Console_Type;

public class Game_Console extends Equipment {

    private final Console_Type console_type;
    boolean vip;

    public Game_Console(long price, Console_Type console_type, boolean is_vip) {
        super(price);
        this.code = "C-" + this.code;
        this.console_type = console_type;
        this.vip = is_vip;
    }

    public Game_Console(String code, long price, Console_Type console_type, boolean is_vip) {
        super(code, price);
        this.console_type = console_type;
        this.vip = is_vip;
    }

    public Game_Console(long price, Console_Type console_type) {
        super(price);
        this.code = "C-" + this.code;
        this.console_type = console_type;
        this.vip = false;
    }

    public Game_Console(String code, long price, Console_Type console_type) {
        super(code, price);
        this.console_type = console_type;
        this.vip = false;
    }

    public Console_Type getConsole_type() { return this.console_type; }
    public boolean is_vip() { return this.vip; }

    public String toString() {
        return String.format("<Equipment: Game Console [code:%s]-[type:%s]>", this.code, this.console_type);
    }
}
