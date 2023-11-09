/*
Jeremy Dougherty
 */

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Program5
{
        public static String InfixToPostfix(String s) {
            Stack<Character> stack = new Stack<Character>();
            String output = "";
            char[] a = s.toCharArray();

            for (char c : a) {
                if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
                    output = output + c;
                } else if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty()) {
                        char t = stack.pop();
                        if (t != '(') {
                            output = output + t;
                        } else {
                            break;
                        }
                    }
                } else {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        while (!stack.isEmpty()) {
                            char t = stack.pop();
                            if (t == '(') {
                                stack.push(t);
                                break;
                            } else if (t == '+' || t == '-' || t == '*' || t == '/') {
                                if (getPriority(t) < getPriority(c)) {
                                    stack.push(t);
                                    break;
                                } else {
                                    output = output + t;
                                }
                            }
                        }
                        stack.push(c);
                    }
                }
            }
            while(!stack.isEmpty()){
                output = output + stack.pop();
            }
            return output;
        }

        public static int getPriority(char c) {
            if (c == '+' || c == '-') {
                return 1;
            } else {
                return 2;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader reader = new BufferedReader(new FileReader("/Users/jelli/IdeaProjects/Program5/Program3.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/jelli/IdeaProjects/Program5/Program5.out"));
            String infix;

            while((infix = reader.readLine()) != null){
                writer.write('\n'+infix +" ---> "+InfixToPostfix(infix));
            }
            reader.close();
            writer.close();
        }
}
