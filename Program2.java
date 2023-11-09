/*
 * Jeremy Dougherty
 * Program 2
 */

public class Program2 {

    public static double add(double a, double b) {
        return (a + b);
    }

    public static double subtract(double a, double b) {
        return (a - b);
    }

    public static double multiply(double a, double b) {
        if(a * b == -0) {
            return (0);
        }
        else {
            return (a * b);
        }
    }

    public static double divide(double a, double b) {
        return (a / b);
    }

    public static double sinOfAngle(double oppSide, double hyp) {
        double sinOfAngle = (oppSide / hyp);
        double val1 = sinOfAngle * 100;
        double val2 = Math.round(val1);
        return val2 / 100;
    }

    public static double hypOfTriangle(double sideA, double sideB) {
        double sqrt = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
        double value1 = sqrt * 100;
        double value2 = Math.round(value1);
        return value2 / 100;
    }


    public static void main(String[] args) {

        double add = Program2.add(5, 0);
            System.out.println(add);

        double divide = Program2.divide(5, -2);
            System.out.println(divide);

        double sinOfAngle = Program2.sinOfAngle(3.0, 4.1);
            System.out.println(sinOfAngle);
    }
}
