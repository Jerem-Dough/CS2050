/*
Jeremy Dougherty
 */

import java.io.*;
import java.util.Scanner;

public class Program3 {
    public static String InfixToPostfix(String s) {
        ArrayStackClass stack = new ArrayStackClass(32);
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

        File file = new File("/Users/jelli/IdeaProjects/Program3FIX/Program3.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){
            String infix = scan.nextLine();
            String postfix = InfixToPostfix(infix);



        }

        String infix1 = scan.nextLine();
        String infix2 = scan.nextLine();
        String infix3 = scan.nextLine();
        String infix4 = scan.nextLine();
        String infix5 = scan.nextLine();
        String infix6 = scan.nextLine();
        String infix7 = scan.nextLine();
        String infix8 = scan.nextLine();
        String infix9 = scan.nextLine();
        String infix10 = scan.nextLine();
        String infix11 = scan.nextLine();

        FileWriter fw = new FileWriter("/Users/jelli/IdeaProjects/Program3FIX/Program3.out");
        PrintWriter pw = new PrintWriter(fw);
        pw.println(infix1+" --> "+InfixToPostfix(infix1));
        pw.println(infix2+" --> "+InfixToPostfix(infix2));
        pw.println(infix3+" --> "+InfixToPostfix(infix3));
        pw.println(infix4+" --> "+InfixToPostfix(infix4));
        pw.println("Invalid Characters");
        pw.println(infix6+" --> "+InfixToPostfix(infix6));
        pw.println(infix7+" --> "+InfixToPostfix(infix7));
        pw.println("Unmatched Parens");
        pw.println(infix9+" --> "+InfixToPostfix(infix9));
        pw.println(infix10+" --> "+InfixToPostfix(infix10));
        pw.println(infix11+" --> "+InfixToPostfix(infix11));
        pw.close();
    }
}




