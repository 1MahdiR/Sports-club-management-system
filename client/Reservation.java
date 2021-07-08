package client;

import club.Equipment;
import club.Game_Field;
import custom_exceptions.DurationLimitException;
import custom_exceptions.ReservationDatePassedException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class Reservation {

    private final String id;
    private final User user;
    private final Equipment equipment;
    private Date reserve_date;
    private final Date reserve_duration;
    private final long total_price;
    private final Date submit_date;
    private boolean paid;

    public Reservation(User user, Equipment equipment, Date reserve_date, Date reserve_duration) throws DurationLimitException, ReservationDatePassedException {
        if (!check_duration(reserve_duration)) {
            throw new DurationLimitException();
        }
        
        this.id = "R-" + UUID.randomUUID().toString();
        this.user = user;
        this.equipment = equipment;
        if (equipment instanceof Game_Field) {
            Date d = new Date();
            if (d.after(reserve_date)) {
                throw new ReservationDatePassedException();
            }
            this.reserve_date = reserve_date;
        } else {
            this.reserve_date = new Date();
        }
        this.reserve_duration = reserve_duration;

        GregorianCalendar g = new GregorianCalendar();
        g.setTime(reserve_duration);
        int hours = g.get(Calendar.HOUR);
        float minutes = (float)(g.get(Calendar.MINUTE)) / 60;
        long price = (long) ((hours + minutes) * equipment.getPrice());
        price -= price % 100;
        this.total_price = price;

        this.submit_date = new Date();
        this.paid = false;
    }

    public Reservation(String id, User user, Equipment equipment, Date reserve_date, Date reserve_duration) throws DurationLimitException, ReservationDatePassedException {

        if (!check_duration(reserve_duration)) {
            throw new DurationLimitException();
        }

        this.id = id;
        this.user = user;
        this.equipment = equipment;
        if (equipment instanceof Game_Field) {
            Date d = new Date();
            if (d.after(reserve_date)) {
                throw new ReservationDatePassedException();
            }
            this.reserve_date = reserve_date;
        } else {
            this.reserve_date = new Date();
        }
        this.reserve_duration = reserve_duration;

        GregorianCalendar g = new GregorianCalendar();
        g.setTime(reserve_duration);
        int hours = g.get(Calendar.HOUR);
        float minutes = (float)(g.get(Calendar.MINUTE)) / 60;
        long price = (long) ((hours + minutes) * equipment.getPrice());
        price -= price % 100;
        this.total_price = price;

        this.submit_date = new Date();
        this.paid = false;
    }

    public String getId() { return this.id; }

    public User getUser() { return this.user; }

    public Equipment getEquipment() { return this.equipment; }

    public Date getReserve_date() { return this.reserve_date; }

    public Date getReserve_duration() { return this.reserve_duration; }

    public long getTotal_price() { return this.total_price; }

    public Date getSubmit_date() { return this.submit_date; }

    public boolean isPaid() { return this.paid; }

    public void pay() {
        if (!isPaid()) {
            User user = getUser();
            user.increase_debt(getTotal_price());
            this.paid = true;
        }
    }

    private boolean check_duration(Date duration) {
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(duration);
        int hours = g.get(Calendar.HOUR);
        int minutes = g.get(Calendar.MINUTE) + hours * 60;
        return minutes <= (6 * 60);
    }

    public boolean has_passed() {
        Date now = new Date();
        Date reserve_date = getReserve_date();
        return now.after(reserve_date);
    }

    public void change_reserve_date(Date d) {
        if (getEquipment() instanceof Game_Field && !has_passed()) {
            Date now = new Date();
            if (now.before(d)) {
                long temp = d.getTime();
                this.reserve_date.setTime(temp);
            }
        }
    }

    public String toString() {
        String id = getId();
        String user = getUser().toString();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat date2_format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = date_format.format(getSubmit_date());
        String r_date = date2_format.format(getReserve_date());
        return String.format("<Reservation [id:%s]-[user:%s]-[reservation date:%s]-[submit date:%s]-[total price:%d]-[paid:%s]>", id, user, r_date, date, getTotal_price(), isPaid());
    }

}
