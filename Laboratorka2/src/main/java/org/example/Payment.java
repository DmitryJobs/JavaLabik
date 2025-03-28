package org.example;

import java.util.Objects;

public class Payment {
    private String fullName;
    private int day;
    private int month;
    private int year;
    private int amount; // сумма в копейках

    // Конструктор
    public Payment (String fullName, int day, int month, int year, int amount) {
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    public Payment(Payment other) {
        this.fullName = other.fullName;
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
        this.amount = other.amount;
    }

    // Геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // Метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Payment payment = (Payment) obj;
        return day == payment.day && month == payment.month && year == payment.year &&
               amount == payment.amount && Objects.equals(fullName, payment.fullName);
    }

    // Метод hashCode
    @Override
    public int hashCode() {
        return Objects.hash(fullName, day, month, year, amount);
    }

    // Метод toString
    @Override
    public String toString() {
        int rubles = amount / 100;
        int kopecks = amount % 100;
        return String.format("Плательщик: %s, дата: %d.%d.%d сумма: %d руб. %d коп.",
                fullName, day, month, year, rubles, kopecks);
    }
}
