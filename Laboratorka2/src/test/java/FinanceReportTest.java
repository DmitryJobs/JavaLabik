import org.example.FinanceReport;
import org.example.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinanceReportTest {

    @Test
    public void testConstructorAndGetters() {
        Payment payment1 = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        Payment payment2 = new Payment("Кобейн Курт Дональдович", 9, 10, 2005, 2213);

        FinanceReport financeReport = new FinanceReport(new Payment[]{payment1, payment2}, "Балицкий Дмитрий Сергеевич", "10.10.24");

        Assertions.assertEquals(2, financeReport.getQuantityPayments());
        Assertions.assertEquals(payment1, financeReport.getPayment(0));
        Assertions.assertEquals(payment2, financeReport.getPayment(1));
        Assertions.assertEquals("Балицкий Дмитрий Сергеевич", financeReport.getAuthor());
        Assertions.assertEquals("10.10.24", financeReport.getDate());
    }

    @Test
    public void testSetPayment() {
        Payment payment1 = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        Payment payment2 = new Payment("Кобейн Курт Дональдович", 9, 10, 2005, 2213);

        FinanceReport financeReport = new FinanceReport(new Payment[]{payment1, payment2}, "Балицкий Дмитрий Сергеевич", "10.10.24");

        Payment newPayment = new Payment("Цой Виктор Робертович", 2, 12, 2045, 3394);
        financeReport.setPayment(1, newPayment);

        Assertions.assertEquals(newPayment, financeReport.getPayment(1));
    }

    @Test
    public void testToString() {
        Payment payment1 = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        Payment payment2 = new Payment("Кобейн Курт Дональдович", 9, 10, 2005, 2213);

        FinanceReport financeReport = new FinanceReport(new Payment[]{payment1, payment2}, "Балицкий Дмитрий Сергеевич", "10.10.24");

        String expectedString = "[Автор: Балицкий Дмитрий Сергеевич, дата: 10.10.24 Платежи: [\n" +
                                "Плательщик: Горшенев Михаил Юрьевич, дата: 9.10.2005 сумма: 11 руб. 0 коп.\n" +
                                "Плательщик: Кобейн Курт Дональдович, дата: 9.10.2005 сумма: 22 руб. 13 коп.\n" +
                                "]]";
        Assertions.assertEquals(expectedString, financeReport.toString());
    }

    @Test
    public void testCopyConstructor() {
        Payment payment1 = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        Payment payment2 = new Payment("Кобейн Курт Дональдович", 9, 10, 2005, 2213);

        FinanceReport financeReport = new FinanceReport(new Payment[]{payment1, payment2}, "Балицкий Дмитрий Сергеевич", "10.10.24");
        FinanceReport copiedReport = new FinanceReport(financeReport);

        // Изменим оригинальный отчет
        payment1.setFullName("Новый Плательщик Платежник");

        // что копия не изменена?
        Assertions.assertNotEquals(financeReport.getPayment(0), copiedReport.getPayment(0));
    }




}
