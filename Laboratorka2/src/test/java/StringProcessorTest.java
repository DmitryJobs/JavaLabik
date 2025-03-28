
import org.example.StringProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringProcessorTest {
    @Test
    public void copyOfTheString1(){
        Assertions.assertEquals("abcabcabc", StringProcessor.copyOfTheString("abc", 3));
    }

    @Test
    public void copyOfTheString2(){
        Assertions.assertEquals("", StringProcessor.copyOfTheString("", 3));
    }

    @Test()
    public void copyOfTheString3(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringProcessor.copyOfTheString("abc", -1));
    }

    @Test
    public void countEntryTest(){
        Assertions.assertEquals(2, StringProcessor.countEntry("aa", "a"));
        Assertions.assertEquals(3, StringProcessor.countEntry("aaa", "a"));
        Assertions.assertEquals(2, StringProcessor.countEntry("aaa", "aa"));
    }

    @Test
    public void replaceNumbers(){
        Assertions.assertEquals("Я живу один только два рубля и три микрухи", StringProcessor.replaceNumbers("Я живу 1 только 2 рубля и 3 микрухи"));
        Assertions.assertEquals("одиндватри", StringProcessor.replaceNumbers("123"));
        Assertions.assertEquals("двадвадва", StringProcessor.replaceNumbers("222"));
    }

    @Test
    public void stringDel(){
        Assertions.assertEquals("1111", StringProcessor.stringDel(new StringBuilder("12121212")).toString());
    }

}
