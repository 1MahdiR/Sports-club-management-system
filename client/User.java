package client;

import java.util.UUID;

public class User {

    private String id;
    private String name;
    private long debt;

    public User(String name) {

        this.id = "U-" + UUID.randomUUID().toString();
        this.name = name;
        this.debt = 0l;
    }

    public String getId() { return this.id; }

    public String getName() { return this.name; }

    public long getDebt() { return this.debt; }
    public void pay_debt(long p) { this.debt -= p; }
    public void increase_debt(long p) { this.debt += p; }

}
