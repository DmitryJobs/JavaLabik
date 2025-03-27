package org.example;
import java.util.Arrays;

public class FinanceReport {
    private Payment[] payments;
    private String author;
    private String date;

    // Конструктор
    public FinanceReport(Payment[] payments, String author, String date) {
        this.payments = payments;
        this.author = author;
        this.date = date;
    }

    // Конструктор копирования
    public FinanceReport(FinanceReport other) {
        this.author = other.author;
        this.date = other.date;
        // Глубокое копирование массива Payment
        this.payments = new Payment[other.payments.length];
        for (int i = 0; i < other.payments.length; i++) {
            this.payments[i] = new Payment(other.payments[i]);
        }
    }


    // Геттеры и сеттеры
    public Payment[] getPayments() {
        return payments;
    }

    public void setPayments(Payment[] payments) {
        this.payments = payments;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Метод для получения количества платежей
    public int getQuantityPayments() {
        return payments.length;
    }

    // Метод для получения платежа по индексу
    public Payment getPayment(int index) {
        if (index >= 0 && index < payments.length) {
            return payments[index];
        }
        return null; // Возвращаем null, если индекс вне допустимого диапазона
    }

    // Метод для установки платежа по индексу
    public void setPayment(int index, Payment payment) {
        if (index >= 0 && index < payments.length) {
            payments[index] = payment;
        }
    }

    // Метод toString для вывода отчета
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[Автор: %s, дата: %s Платежи: [\n", author, date));
        for (Payment payment : payments) {
            sb.append(payment.toString()).append("\n");
        }
        sb.append("]]");
        return sb.toString();
    }
}
