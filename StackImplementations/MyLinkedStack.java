/*
Jeremy Dougherty
 */

public class MyLinkedStack{

    int size;
    Node top;
    private class Node{
        private char value;
        private Node next;

        public Node(char value){
            this.value = value;
            this.next = null;
        }
    }

    public void push(char value){
        Node temp = new Node(value);
        temp.next = top;
        top = temp;
        size++;
    }

    public char pop(){
        char val = top.value;
        top = top.next;
        size--;
        return val;
    }

    public char peek(){
        return top.value;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
