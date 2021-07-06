package club;

import java.util.UUID;

public class Equipment {

    String code;
    long price;

    public Equipment(long price) {

        this.price = price;
        this.code = UUID.randomUUID().toString();
    }

    public Equipment(String code, long price) {

        this.price = price;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public long getPrice() {
        return price;
    }
    public void setPrice(long p) {
        this.price = p;
    }

    public String toString() {
        return String.format("<Equipment [code:%s]>", this.code);
    }
}
