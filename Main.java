import java.util.Scanner;
import java.lang.Exception;


public class Main {
    static String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };
    static String[] oper = {"+", "-", "*", "/"};

    public static void main(String[] args) throws Exception {
        Scanner example = new Scanner(System.in);
        System.out.print("Input example: ");
        String exam = example.nextLine();
        System.out.println(calc(exam));
    }

    public static String calc(String ex) throws Exception {
        String[] m = null;
        m = ex.split(" ");
        if (m.length>3) throw new Exception("Не более 2х операндов!");
        String op = correctSign(m[1]);
        if (op == null) throw new Exception("Не верный знак");
        int number1 = 0;
        int number2 = 0;
        boolean isRoman = false;
        if ((isRoman(m[0]) && !isRoman(m[2])) || (!isRoman(m[0]) && isRoman(m[2])))
            throw new Exception("Должны быть одинаковые системы исчесления!");
        if (isRoman(m[0]) && isRoman(m[2])) {
            number1 = romanToNumber(m[0]);
            number2 = romanToNumber(m[2]);
            isRoman = true;
        } else if (!isRoman(m[0]) && !isRoman(m[2])) {
            number1 = Integer.parseInt(m[0]);
            number2 = Integer.parseInt(m[2]);
            isRoman = false;
        }
        if ((0 > number1 || number1 > 10) || (0 > number2 || number2 > 10)) throw new Exception("Принимает от 1 до 10");
        if (isRoman == true) {
            String result;
            if (calculation(number1, number2, op) < 1) throw new Exception("Не верный формат");
            result = convertNumToRoman(calculation(number1, number2, op));
            return result;
        } else {
            String result = Integer.toString(calculation(number1, number2, op));
            return result;
        }

    }

    public static String correctSign(String op) {
        for (int i = 0; i < oper.length; i++) {
            if (op.equals(oper[i])) {
                return op;
            }
        }
        return null;
    }

    public static int calculation(int num1, int num2, String sign) {
        int result = 0;
        switch (sign) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }

    private static boolean isRoman(String rom) {
        for (int i = 0; i < roman.length; i++) {
            if (rom.equals(roman[i])) {
                return true;
            }
        }
        return false;
    }

    private static String convertNumToRoman(int numArabian) {

        String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }
        return -1;
    }
}
