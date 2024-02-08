public class Stack {
    private int top;
    private char[] stack = new char[50];
    Stack(){
        top = -1;
    }
    void push(char x){
        top++;
        stack[top] = x;
    }
    char pop(){
        char y;
        y = stack[top];
        top--;
        return y;
    }
    boolean isEmpty(){
        return top == -1;
    }
}
