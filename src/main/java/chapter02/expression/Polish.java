package chapter02.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 波兰表达式
 * 前缀表达式解析
 */
public class Polish {
    public static void main(String[] args) {
        //30-5*6-1 => - - 30 * 5 6 1 => -1;
        String express="- - 30 * 5 6 1";

        List<String> strings = Arrays.asList(express.split(" "));
        //List<String> reversal = reversal(strings);
        System.out.println(expression(strings));
    }

    public static Integer expression(List<String> strings){
        Stack<String> number=new Stack();
        for (int i = strings.size()-1; i >= 0; i--) {
            if (strings.get(i).matches("\\d+"))
            {
                number.push(strings.get(i));
            }else {
                Integer num1 = Integer.valueOf(number.pop());
                Integer num2 = Integer.valueOf(number.pop());
                number.push(calculate(num1,num2,strings.get(i)).toString());
            }
        }
        return Integer.valueOf(number.pop());
    }


    /**
     * 集合反转头插
     * @param strings
     * @return
     */
    public static List<String> reversal(List<String> strings){
        ArrayList<String> objects = new ArrayList<>(strings.size());
        objects.addAll(strings);
        for (int i = 0; i < strings.size(); i++) {
            objects.set(strings.size()-1-i,strings.get(i));
        }
        return objects;
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
