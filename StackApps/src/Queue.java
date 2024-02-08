public class Queue {
    private int top, bottom;
    private char[] queue = new char[50];
    Queue(){
        bottom = 0;
        top = 0;
    }
    void push(char x){
        queue[top] = x;
        top++;
    }
    char pop(){
        char y;
        y = queue[bottom];
        bottom++;
        return y;
    }
    boolean isEmpty(){
        return bottom == top;
    }
}
