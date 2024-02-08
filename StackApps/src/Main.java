import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main{
    public static void main(String[] args){
        String[] parenthesesTest = new String[23];
        int i = 0;
        try {
            File file = new File("C:\\Coding headaches\\CMPS 390\\CMPS390-StackApps\\buff.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                parenthesesTest[i] = reader.nextLine();
                i++;
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Filepath does not exits");
            e.fillInStackTrace();
        }
        for(i = 0; i < 23; i++){
            System.out.println(parenthesesTest[i]);
        }
        System.out.println(validate(parenthesesTest[3]));
        System.out.println(validate(parenthesesTest[4]));
        System.out.println(validate(parenthesesTest[5]));
    }
    public static boolean validate(String eq){
        int i;
        char c;
        boolean valid = true;
        Stack stack = new Stack();

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
}