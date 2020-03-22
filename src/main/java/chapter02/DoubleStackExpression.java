package chapter02;

import java.util.Stack;

/**
 * 双栈表达式运算解析
 * 中缀表达式解析
 */
public class DoubleStackExpression {
    public static void main(String[] args) {
        System.out.println(expression("(3+4)*5-6"));
        System.out.println((3+4)*5-6);
    }

    static Stack<Integer> stack1=new Stack();

    static Stack<Character> stack2=new Stack();


    public static int expression(String expression){
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isSymbol(chars[i])){
                if (isPriority(chars[i]) &&  isNumber(chars[i+1])){
                    char symbol=chars[i];
                    int number1 = stack1.pop();
                    StringBuffer number2=new StringBuffer();
                     do {
                        number2.append(chars[i+1]);
                        ++i;
                      }while(isNumber(chars[i+1]));
                    int calculate = calculate(number1, Integer.valueOf(number2.toString()), symbol);
                    stack1.push(calculate);

                }else {
                    stack2.push(chars[i]);
                }
            }else if(chars[i] == ')' ){
                Integer number2 = stack1.pop();
                Integer number1 = stack1.pop();
                Character pop = stack2.pop();
                int calculate = calculate(number1, number2, pop);
                stack1.push(calculate);
            }else if (isNumber(chars[i])){
                StringBuffer number2=new StringBuffer();
                int index = i;
                do {
                    number2.append(chars[index]);
                    if (index == chars.length-1) {
                        index=chars.length+1;
                        break;
                    }
                }while(isNumber(chars[++index]));
                i=index-1;
                stack1.push(Integer.valueOf(number2.toString()));
            }
        }
        while (true){
            if (stack2.isEmpty()){
                break;
            }
            Integer pop1 = stack1.pop();
            Integer pop2 = stack1.pop();
            Character pop = stack2.pop();
            int calculate = calculate(pop2, pop1, pop);
            stack1.push(calculate);
        }
        return stack1.pop();
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
    public static int calculate(int number1 ,int  number2,char symbol){

        switch (symbol){
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                return number1 / number2;
            case '%':
                return number1 % number2;
            default:
                return 0;

        }
    }


}

