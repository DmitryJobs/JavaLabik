import org.example.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Test
    public void testConstructorAndGetters() {
        Payment payment = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);

        Assertions.assertEquals("Горшенев Михаил Юрьевич", payment.getFullName());
        Assertions.assertEquals(9, payment.getDay());
        Assertions.assertEquals(10, payment.getMonth());
        Assertions.assertEquals(2005, payment.getYear());
        Assertions.assertEquals(1100, payment.getAmount());
    }

    @Test
    public void testSetters() {
        Payment payment = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);

        payment.setFullName("Кобейн Курт Дональдович");
        payment.setDay(10);
        payment.setMonth(11);
        payment.setYear(2006);
        payment.setAmount(2000);

        Assertions.assertEquals("Кобейн Курт Дональдович", payment.getFullName());
        Assertions.assertEquals(10, payment.getDay());
        Assertions.assertEquals(11, payment.getMonth());
        Assertions.assertEquals(2006, payment.getYear());
        Assertions.assertEquals(2000, payment.getAmount());
    }

    @Test
    public void testEqualsAndHashCode() {
        Payment payment1 = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        Payment payment2 = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        Payment payment3 = new Payment("Кобейн Курт Дональдович", 9, 10, 2005, 1100);

        Assertions.assertEquals(payment1, payment2);
        Assertions.assertNotEquals(payment1, payment3);
        Assertions.assertEquals(payment1.hashCode(), payment2.hashCode());
        Assertions.assertNotEquals(payment1.hashCode(), payment3.hashCode());
    }

    @Test
    public void testToString() {
        Payment payment = new Payment("Горшенев Михаил Юрьевич", 9, 10, 2005, 1100);
        String expectedString = "Плательщик: Горшенев Михаил Юрьевич, дата: 9.10.2005 сумма: 11 руб. 0 коп.";
        Assertions.assertEquals(expectedString, payment.toString());
    }
}
