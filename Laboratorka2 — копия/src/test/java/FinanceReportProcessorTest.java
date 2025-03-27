import org.example.FinanceReport;
import org.example.FinanceReportProcessor;
import org.example.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinanceReportProcessorTest {

    @Test
    public void getPaymentsSecondName1() {
        // Создаем платежки
        Payment payment1 = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        Payment payment2 = new Payment("Кобейн Курт Дональдович", 9, 10, 2005, 2213);
        Payment payment3 = new Payment("Цой Виктор Робертович", 2, 12, 2045, 3394);
        Payment payment4 = new Payment("Цой Виктор Робертович", 2, 12, 2045, 3394);

        // Создаем отчет
        FinanceReport financeReport = new FinanceReport(new Payment[]{payment1, payment2, payment3, payment4},
                "Балицкий Дмитрий Сергеевич", "09.10.05");

        // Мы ищем все платежи, фамилия которых начинается на 'Ц'
        FinanceReport result = FinanceReportProcessor.getPaymentsSecondName(financeReport, 'Ц');

        //  два платежа от Цоя?
        Assertions.assertEquals("""
            [Автор: Балицкий Дмитрий Сергеевич, дата: 09.10.05 Платежи: [
            Плательщик: Цой Виктор Робертович, дата: 2.12.2045 сумма: 33 руб. 94 коп.
            Плательщик: Цой Виктор Робертович, дата: 2.12.2045 сумма: 33 руб. 94 коп.
            ]]""", result.toString());
    }


    @Test
    public void getPaymentsSecondName2() {
        Payment payment1 = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        Payment payment2 = new Payment("Кобейн Курт Дональдович", 9, 10, 2005, 2213);
        Payment payment3 = new Payment("Цой Виктор Робертович", 2, 12, 2045, 3394);
        Payment payment4 = new Payment("Цой Виктор Робертович", 2, 12, 2045, 3394);

        FinanceReport financeReport = new FinanceReport(new Payment[]{payment1, payment2, payment3, payment4},
                "Балицкий Дмитрий Сергеевич", "09.10.05");

        // Платежи с фамилией на 'J' такого нет
        FinanceReport result = FinanceReportProcessor.getPaymentsSecondName(financeReport, 'J');

        //  не будет ни одного платежа?
        Assertions.assertEquals("""
                [Автор: Балицкий Дмитрий Сергеевич, дата: 09.10.05 Платежи: [
                ]]""", result.toString());
    }

    @Test
    public void getPaymentsUnderValue1() {
        Payment payment1 = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        Payment payment2 = new Payment("Кобейн Курт Дональдович", 9, 10, 2005, 2213);
        Payment payment3 = new Payment("Цой Виктор Робертович", 2, 12, 2045, 3394);
        Payment payment4 = new Payment("Цой Виктор Робертович", 2, 12, 2045, 3394);

        FinanceReport financeReport = new FinanceReport(new Payment[]{payment1, payment2, payment3, payment4},
                "Балицкий Дмитрий Сергеевич", "10.10.24");

        // Платежи с суммой меньше 30000
        FinanceReport result = FinanceReportProcessor.getPaymentsUnderValue(financeReport, 30000);

        // Проверка все платежи в отчете меньше заданной суммы
        Assertions.assertEquals("""
                [Автор: Балицкий Дмитрий Сергеевич, дата: 10.10.24 Платежи: [
                Плательщик: Горшенев Михаил Юрьевич, дата: 9.10.2005 сумма: 11 руб. 0 коп.
                Плательщик: Кобейн Курт Дональдович, дата: 9.10.2005 сумма: 22 руб. 13 коп.
                Плательщик: Цой Виктор Робертович, дата: 2.12.2045 сумма: 33 руб. 94 коп.
                Плательщик: Цой Виктор Робертович, дата: 2.12.2045 сумма: 33 руб. 94 коп.
                ]]""", result.toString());
    }

    @Test
    public void getPaymentsUnderValue2() {
        Payment payment1 = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        Payment payment2 = new Payment("Кобейн Курт Дональдович", 9, 10, 2005, 2213);
        Payment payment3 = new Payment("Цой Виктор Робертович", 2, 12, 2045, 3394);
        Payment payment4 = new Payment("Цой Виктор Робертович", 2, 12, 2045, 3394);

        FinanceReport financeReport = new FinanceReport(new Payment[]{payment1, payment2, payment3, payment4},
                "Балицкий Дмитрий Сергеевич", "10.10.24");

        // Платежи с суммой меньше 300
        FinanceReport result = FinanceReportProcessor.getPaymentsUnderValue(financeReport, 300);

        // не будет ни одного платежа?
        Assertions.assertEquals("""
                [Автор: Балицкий Дмитрий Сергеевич, дата: 10.10.24 Платежи: [
                ]]""", result.toString());
    }
}
