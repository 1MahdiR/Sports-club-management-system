package test;

import client.User;

public class user_test {

    public static void main(String[] args) {

        User user = new User("Mahdi");

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getDebt());
        user.increase_debt(1000l);
        System.out.println(user.getDebt());
        user.pay_debt(500l);
        System.out.println(user.getDebt());
        System.out.println(user);
    }
}
