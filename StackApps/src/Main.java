import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main{
    public static void main(String[] args){
        String[] problems = new String[23];
        int i = 0;
        try {
            File file = new File("C:\\Coding headaches\\CMPS 390\\CMPS390-StackApps\\buff.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                problems[i] = reader.nextLine();
                i++;
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Filepath does not exits");
            e.fillInStackTrace();
        }

        System.out.println("Parentheses Check");
        for(i = 3; i < 6; i++){
            System.out.println(validate(problems[i]));
        }

        System.out.println("\nPostfix Evaluation");
        for(i = 7; i < 10; i++){
            System.out.println(evaluate(problems[i]));
        }

        System.out.println("\nInfix to Postfix");
        for(i = 11; i < 16; i++){
            System.out.println(translate(problems[i]));
        }

        System.out.println("\nFull System Check");
        for(i = 17; i < 23; i++){
            System.out.println(fullSend(problems[i]));
        }
    }
    public static boolean validate(String eq){
        int i;
        char c;
        boolean valid = true;
        Stack<Character> stack = new Stack();

        for(i = 0; i < eq.length(); i++){
            c = eq.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.isEmpty()){
                    valid = false;
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            valid = false;
        }
        return valid;
    }
    public static String translate(String eq){
        Stack<Character> stack = new Stack();
        Queue queue = new Queue();
        int i;
        char c, operator;
        String postfixEquation = "";

        for(i = 0; i < eq.length(); i++){
            c = eq.charAt(i);
            if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')){
                queue.push(c);
            }
            else if(c == '+'||c=='-'||c=='/'||c=='*'){
                stack.push(c);
            }
            else if(c == ')' && !stack.isEmpty()){
                operator = stack.pop();
                queue.push(operator);
            }
        }
        while(!stack.isEmpty()){
            queue.push(stack.pop());
        }
        while(!queue.isEmpty()){
            postfixEquation = postfixEquation + queue.pop();
        }
        return postfixEquation;
    }
    public static int evaluate(String eq){
        int i;
        int x,y,z,num;
        char c;
        Stack<Integer> stack = new Stack();

        for(i = 0; i < eq.length(); i++){
            c = eq.charAt(i);
            if(c >= '0' && c <= '9'){
                num = c - '0';
                stack.push(num);
            }
            else if(c == '+'){
                y = stack.pop();
                x =stack.pop();
                z = x+y;
                stack.push(z);
            }
            else if(c == '-'){
                y = stack.pop();
                x =stack.pop();
                z = x-y;
                stack.push(z);
            }
            else if(c == '/'){
                y = stack.pop();
                x =stack.pop();
                z = x/y;
                stack.push(z);
            }
            else if(c == '*'){
                y = stack.pop();
                x =stack.pop();
                z = x*y;
                stack.push(z);
            }
        }
        return stack.pop();
    }
    public static String fullSend(String eq){
        int ans;
        if(!validate(eq)) {
            return "Invalid Equation";
        }
        ans = evaluate(translate(eq));
        return Integer.toString(ans);
    }
}