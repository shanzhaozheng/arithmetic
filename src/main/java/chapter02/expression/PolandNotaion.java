package chapter02.expression;

import chapter02.stack.LinkedStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolandNotaion {

    public static void main(String[] args) {

        List<String> strings = parseSuffixExpreesionList(Arrays.asList("1", "+", "(", "(", "2", "+", "5", ")", "*", "6", ")", "-", "5"));
        for (String string : strings) {
            System.out.print(string);
        }
    }



    public static List<String> parseSuffixExpreesionList(List<String> ls){
        LinkedStack<String> s1 = new LinkedStack<>();
        List<String> s2 = new ArrayList<>();
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).matches("\\d+")){
                s2.add(ls.get(i));
            }else if (ls.get(i).equals("(")){
                s1.push(ls.get(i));
            }else if (ls.get(i).equals(")")){
                // 将符号栈(之前的符号全部入到s2
                while (!"(".equals(s1.peek())){
                    s2.add(s1.pop());
                }
                // 将(删除
                s1.pop();
            }else {
                // 如果栈顶优先级高则先如栈定符号
                while (s1.size() != 0 && isPriority(s1.peek().charAt(0)) >= isPriority(ls.get(i).charAt(0))){
                    s2.add(s1.pop());
                }
                // 将最后入当前符号
                s1.push(ls.get(i));
            }
        }
        // 将剩余符号存入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 是否拥有优先级高低
     * @param symbol 操作符
     * @return
     */
    public static int isPriority(char symbol){
        return symbol == '*' || symbol == '/' || symbol == '%' ? 2 :
                symbol == '+' || symbol == '-' ? 1 : 0;
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
