package org.example;

public class StringProcessor {
    public static String copyOfTheString (String s, int N) {
        if (N == 0) return "";
        if (N < 0) throw new IllegalArgumentException("Индекс превышает длину списка");
        return String.valueOf(s).repeat(N);
    }
    public static int countEntry(String s1, String s2) {
        int count = 0;
        if (s2.isEmpty()) {
            throw new IllegalArgumentException("Пустая строка");
        }
        for(int i = 0; i <= s1.length() - s2.length(); i++){
            if (s1.startsWith(s2, i)){
                count++;
            }
        }
        return count;
    }
    public static String replaceNumbers(String s) {
        String sOut;
        sOut = s.replace("1", "один")
                .replace("2", "два")
                .replace("3", "три");
        return sOut;
    }

    public static StringBuilder stringDel(StringBuilder stringBuilder) {
        for(int i = 1; i < stringBuilder.length(); i++) {
            stringBuilder.deleteCharAt(i);
        }
        return stringBuilder;
    }
}


