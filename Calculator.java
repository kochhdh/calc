import com.sun.tools.javac.Main;

import java.util.Scanner;

public class Calculator {
     static int convert_to_int(String romes_value){
        char[] value_char = romes_value.toCharArray();
        int[] values_int = new int[value_char.length];
        for (int i = 0; i < value_char.length; i++) {
            switch (value_char[i]) {
                case 'I':
                    values_int[i] = 1;
                    break;
                case 'V':
                    values_int[i] = 5;
                    break;
                case 'X':
                    values_int[i] = 10;
                    break;
                default:
                    throw new ArithmeticException("throws Exception //т.к. формат математической операции не удовлетворяет заданию (+, -, /, *");
            }
        }
        int result = values_int[0];
        for (int i = 0; i < values_int.length && values_int.length > i + 1; i++) {
            if (values_int[i] >= values_int[i+1]) {
                result += values_int[i+1];
            } else if (values_int[i] < values_int[i+1]) {
                result = result + values_int[i+1] - 2;
            }

        }
        return result;
    }
     static String integerToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int resop, numb1, numb2;
        char oper;
        boolean arabicNumbers;
        while (true) {
            System.out.println("Input: ");
            arabicNumbers = true;
            Scanner inputString_a_value = new Scanner(System.in);
            String inputString = inputString_a_value.nextLine();
            String[] calc_inputString = inputString.split(" ");
            if (calc_inputString.length == 5) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                throw new ArithmeticException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (calc_inputString.length != 3) {
                throw new ArithmeticException("throws Exception //т.к. строка не является математической операцией");
            }
            System.out.println("Output: ");
            oper=calc_inputString[1].charAt(0);
            numb1 = 0;
            numb2 = 0;
            resop = 0;
            try {
                numb1 = Integer.parseInt(calc_inputString[0]);
                numb2 = Integer.parseInt(calc_inputString[2]);
            } catch (NumberFormatException e) {
                arabicNumbers = false;
                numb1=convert_to_int(calc_inputString[0]);
                numb2=convert_to_int(calc_inputString[2]);

            }
            if (((numb1>10) || (numb1<1)) || ((numb2>10) || (numb2<1))) {
                throw new ArithmeticException("throws Exception //т.к. число меньше 1 и более 10");
            }
            switch (oper) {
                case '+':
                    resop = numb1 + numb2;
                    break;
                case '-':
                    resop = numb1 - numb2;
                    break;
                case '*':
                    resop = numb1 * numb2;
                    break;
                case '/':
                    resop = numb1 / numb2;
                    break;
                default:
                    throw new ArithmeticException("throws Exception //т.к. формат математической операции не удовлетворяет заданию (+, -, /, *");
            }

            if (arabicNumbers) {
                System.out.println(resop);
            } else {
                if (resop < 0) {
                    throw new ArithmeticException("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
                System.out.println(integerToRoman(resop));
            }
        }
    }
}