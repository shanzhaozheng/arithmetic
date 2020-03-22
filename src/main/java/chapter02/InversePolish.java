package chapter02;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式
 * 后缀表达式解析
 */
public class InversePolish {


    public static void main(String[] args) {
        //30-5*6-1
        String express="30 5 6 * - 1 -";

        List<String> strings = Arrays.asList(express.split(" "));

        System.out.println(expression(strings));
        System.out.println((32+4)*5-6);
    }

    public static Integer expression(List<String> strings){
        Stack<String> number=new Stack();
        for (String string : strings) {
            if (string.matches("\\d+"))
            {
                number.push(string);
            }else {
                Integer num2 = Integer.valueOf(number.pop());
                Integer num1 = Integer.valueOf(number.pop());
                number.push(calculate(num1,num2,string).toString());
            }
        }
        return Integer.valueOf(number.pop());
    }



    /**
     * 是否拥有优先级
     * @param symbol 操作符
     * @return
     */
    public static boolean isPriority(char symbol){
        return symbol == '*' || symbol == '/' || symbol == '%';
    }

    /**
     * 是否时操作符
     * @param str 操作符
     * @return
     */
    public static boolean isSymbol(char str){
        return str == '+' || str == '-' ||  str == '*' || str == '/' || str == '%';
    }

    /**
     * 是否是数字
     * @param str 字符
     * @return
     */
    public static boolean isNumber(char str){
        return !(str == ' ' || str == '+' || str == '-' ||  str == '*' || str == '/' || str == '%' || str == '(' || str == ')');
    }

    /**
     * 计算器
     * @param number1 数字1
     * @param number2 数字2
     * @param symbol 运算符
     * @return
     */
    public static Integer calculate(int number1 ,int  number2,String symbol){

        switch (symbol){
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            case "%":
                return number1 % number2;
            default:
                throw new IllegalArgumentException("运算符错误");

        }
    }

}
