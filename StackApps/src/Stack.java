public class Stack<T> {
    private int top;
    private T[] stack = (T[])new Object[50]; //most unsafe thing I've done
    Stack(){
        top = -1;
    }
    void push(T x){
        top++;
        stack[top] = x;
    }
    T pop(){
        T y;
        y = stack[top];
        top--;
        return y;
    }
    boolean isEmpty(){
        return top == -1;
    }
}
