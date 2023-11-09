/*
Jeremy Dougherty
 */
public class ArrayStackClass {

    int capacity;
    int top;
    int[] array;

    public ArrayStackClass(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = 0;
    }

    public void push(char value) {
        array[++top] = value;
    }

    public char pop() {
        char val = (char) array[top];
        top--;
        return val;
    }

    public char peek() {
        return (char) array[top];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top<=0;
    }

}
