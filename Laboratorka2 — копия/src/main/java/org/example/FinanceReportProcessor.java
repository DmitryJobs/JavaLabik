package org.example;

import org.example.FinanceReport;
import org.example.Payment;

import java.util.ArrayList;
import java.util.List;

public class FinanceReportProcessor {

    // Метод для получения всех платежей, фамилия которых начинается с указанного символа
    public static FinanceReport getPaymentsSecondName(FinanceReport report, char firstLetter) {
        List<Payment> filteredPayments = new ArrayList<>();
        for (Payment payment : report.getPayments()) {
            if (payment.getFullName().charAt(0) == firstLetter) {
                filteredPayments.add(payment);
            }
        }
        return new FinanceReport(filteredPayments.toArray(new Payment[0]), report.getAuthor(), report.getDate());
    }

    // Метод для получения всех платежей, сумма которых меньше заданной величины
    public static FinanceReport getPaymentsUnderValue(FinanceReport report, int value) {
        List<Payment> filteredPayments = new ArrayList<>();
        for (Payment payment : report.getPayments()) {
            if (payment.getAmount() < value) {
                filteredPayments.add(payment);
            }
        }
        return new FinanceReport(filteredPayments.toArray(new Payment[0]), report.getAuthor(), report.getDate());
    }
}

