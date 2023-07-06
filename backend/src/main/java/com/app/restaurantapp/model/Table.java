package com.app.restaurantapp.model;

import jakarta.persistence.*;

@Entity(name = "tables")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;

    @Column(name = "table_seats")
    private int seats;
    @Column(name = "table_status")
    private String status;
    @Column(name = "table_reserved_by")
    private String reservedBy;
    @Column(name = "table_booked_date")
    String dateBooked;
    @Column(name = "table_book_start_time")
    String startTime;
    @Column(name = "table_book_end_time")
    String endTime;

    public Table() {
    }

    public Table(int seats, String status, String reservedBy, String dateBooked, String startTime, String endTime) {
        this.seats = seats;
        this.status = status;
        this.reservedBy = reservedBy;
        this.dateBooked = dateBooked;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(String dateBooked) {
        this.dateBooked = dateBooked;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

}
