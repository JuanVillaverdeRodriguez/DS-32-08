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

    public static void main(String[] args) {
        char a = 'm';
        String cadena1 = "Two words";
        String cadena2 = "Mm";
        String cadena3 = "aAaaa3aa#aa";
        String cadena4 = "aAaaa3aa#aa";

        //System.out.println(countWords(cadena1));
        //System.out.println(countChar(cadena2, a));
        System.out.println(countCharIgnoringCase(cadena2, a));
        //System.out.println(isPasswordSafe(cadena4));


    }
}
