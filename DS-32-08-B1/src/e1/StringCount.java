package e1;

import java.util.Objects;

public class StringCount {
    public static int countWords(String text) {
        if (text == null) return 0;
        String[] array = text.trim().split("\\s+");

        return array.length;
    }

    public static int countChar(String text, char c) {
        int contador = 0;
        if (text == null) return 0;
        char[] array = text.toCharArray();
        for (char s : array) {
            if (Objects.equals(s, c)) {
                contador++;
            }
        }
        return contador;
    }

    public static int countCharIgnoringCase(String text, char c) {
        if (text == null) return 0;
        int contador = 0;
        char[] array = text.toCharArray();
        for (char s : array) {
            if (Objects.equals(Character.toLowerCase(s), Character.toLowerCase(c))) {
                contador++;
            }
        }
        return contador;
    }

    public static boolean isPasswordSafe(String password) {
        char[] array = password.toCharArray();

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (password.length() < 8) return false;
        for (char s : array) {
            if (Character.isUpperCase(s)) {
                hasUppercase = true;
            }
            if (Character.isLowerCase(s)) {
                hasLowercase = true;
            }
            if (Character.isDigit(s)) {
                hasDigit = true;
            }
            if (s == '?' || s == '@' || s == '#' || s == '$' || s == '.' || s == ',') {
                hasSpecialChar = true;
            }
            if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar) return true;

        }
        return false;
    }
}
