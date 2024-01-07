import java.util.Scanner;

public class Calculator {
    public static String result = "";
    public static char oper;
    public static String[] string;
    public static int number, number1;



    public static  void main(String[] args) throws Exception{
        Scanner scr = new Scanner(System.in);
        String str = scr.nextLine();

        if (str.contains(" + ")){
            string = str.split(" \\+ ");
            if (string[0].contains("\"") && string[1].contains("\"")) {
                string[0] = string[0].replace("\"", "");
                string[1] = string[1].replace("\"", "");
            }else throw new Exception("Строка должна содержать кавычки");
            if (string[0].length() > 10 || string[1].length() > 10) throw new Exception("длинна строки не может превышать 10 символов");
            oper = '+';
        } else if (str.contains(" - ")){
            string = str.split(" - ");
            if (string[0].contains("\"") && string[1].contains("\"")) {
                string[0] = string[0].replace("\"", "");
                string[1] = string[1].replace("\"", "");
            }else throw new Exception("Строка должна содержать кавычки");
            if (string[0].length() > 10 || string[1].length() > 10) throw new Exception("длинна строки не может превышать 10 символов");
            oper = '-';
        } else if (str.contains(" * ")){
            string = str.split(" \\* ");
            if (string[0].contains("\""))
                string[0] = string[0].replace("\"", "");
            else throw new Exception("Строка должна содержать кавычки");
            if (string[0].length() > 10) throw new Exception("длинна строки не может превышать 10 символов");
            if (string[1].contains("\"")) throw new Exception("число не должно быть с кавычками");
            number = Integer.parseInt(string[1]);
            if (number < 1 || number > 10) throw new Exception("число должно быть от 1 до 10");
            oper = '*';
        }else if (str.contains(" / ")) {
            string = str.split(" / ");
            if (string[0].contains("\""))
                string[0] = string[0].replace("\"", "");
            else throw new Exception("Строка должна содержать кавычки");
            if (string[0].length() > 10) throw new Exception("длинна строки не может превышать 10 символов");
            if (!string[1].matches("\\d")) throw new Exception("делить можно только на число");
            number = Integer.parseInt(string[1]);
            if (number < 1 || number > 10) throw new Exception("число должно быть от 1 до 10");
            oper = '/';
        } else
            throw new Exception("введен не корректный знак");

        if (oper == '+'){
            result = string[0] + string[1];
        }
        if (oper == '-') {
            number = string[0].indexOf(string[1]);
            if (number == -1) {
                result = string[0];
            } else {
                result = string[0].substring(0, number);
                result += string[0].substring(number + string[1].length());
            }
        }
        if (oper == '*'){
            for (int i = 0; i < number; i++) {
                result += string[0];
            }
        }
        if (oper == '/'){
            number1 = string[0].length() / number;
            result = string[0].substring(0,number1);
        }
        if (result.length() > 40)
            print(result.substring(0, 40) + "(...)");
        else
            print(result);
    }
    public static void print(String text){
        System.out.println("\"" + text + "\"");
    }
}
