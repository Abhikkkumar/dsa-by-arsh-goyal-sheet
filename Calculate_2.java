import java.util.ArrayList;
import java.util.Scanner;
// question Link: https://leetcode.com/problems/basic-calculator-ii/
import static java.lang.Integer.parseInt;

public class Calculate_2 {

        private static ArrayList<String> overhead1(String s){
//            System.out.println("overhead1");
            ArrayList<String> help = new ArrayList<>();
            int top = -1;
            String curr = "" ;
            for(int i=0;i<s.length();i++){

                if(s.charAt(i)!= 32){
                    switch(s.charAt(i)){
                        case '+':
                        case '-':
                        case '*':
                        case '/':
                            help.add(curr);
                            top ++;
                            curr= "" + s.charAt(i);
                            help.add(curr);
                            top ++;
                            curr="";
                            break;
                        default:
                            curr+=s.charAt(i);
                    }
                }
            }
            help.add(curr);
//            System.out.println(help);
            return help;
        }
        private static Integer priority(String symbol){
//            System.out.println("priority");
            switch(symbol){
                case "*":
                case "/":
                    return 2;
                case "+":
                case "-":
                    return 1;
                default:
                    return Integer.MIN_VALUE;
            }

        }
        private static ArrayList<String> postfix(ArrayList<String> str){

            ArrayList<String> postStr = new ArrayList<>();

            ArrayList<String> oprtStack = new ArrayList<>();
            int top = -1;

            for(int i=0;i<str.size();i++){
                String curr = str.get(i);
                switch(curr){
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        if(top==-1 || priority(curr)>priority(oprtStack.get(top))){
                            oprtStack.add(curr);
                            top++;
                        }else if(priority(curr)<=priority(oprtStack.get(top))){
                            postStr.add(oprtStack.remove(top));
                            top--;
                            i--;
                        }
                        break;
                    default:
                        postStr.add(curr);
                }
            }
            while(top>-1){
                postStr.add(oprtStack.remove(top));
                top--;
            }
//            System.out.println("postfix string");
//            System.out.println(postStr);
            return postStr;

        }
        private static int calculate(String s) {
//            System.out.println("calculate");
            ArrayList<String> help = overhead1(s);
            ArrayList<String> postfixStr = postfix(help);

            ArrayList<Integer> operand = new ArrayList<>();
            int top=-1;

            for(int i=0;i<postfixStr.size();i++){
                String curr = postfixStr.get(i);
                switch(curr){
                    case "+":
                    {
                        int operand1 = operand.remove(top--);
                        int operand2 = operand.remove(top--);

                        int value = operand1 + operand2;
//                        System.out.println("operation: +, "+"operand1: "+operand1+" ,operand2: "+operand2+"value: "+value);
                        operand.add(value);
                        top++;
                        break;
                    }
                    case "-":
                    {
                        int operand1 = operand.remove(top--);
                        int operand2 = operand.remove(top--);
                        int value = operand2 - operand1;
//                        System.out.println("operation: -, "+"operand1: "+operand1+" ,operand2: "+operand2+"value: "+value);
                        operand.add(value);
                        top++;
                        break;
                    }
                    case "*":
                    {
                        int operand1 = operand.remove(top--);
                        int operand2 = operand.remove(top--);
                        int value = operand1 * operand2;
//                        System.out.println("operation: *, "+"operand1: "+operand1+" ,operand2: "+operand2+"value: "+value);
                        operand.add(value);
                        top++;
                        break;
                    }
                    case "/":
                    {
                        int operand1 = operand.remove(top--);
                        int operand2 = operand.remove(top--);
                        int value = operand2 / operand1;
//                        System.out.println("operation: /, "+"operand1: "+operand1+" ,operand2: "+operand2+"value: "+value);
                        operand.add(value);
                        top++;
                        break;
                    }
                    default:
                        int a = parseInt(curr);
//                        System.out.println("default. a value is "+ a);
                        operand.add(a);
                        top++;
                }
            }
            return operand.remove(top);

        }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println("Input: "+input);
        int result = calculate(input);
        System.out.println(result);

    }
}
