package GradeMath;

import java.util.Scanner;

public class GradeMath {
    public static double average(int args, double weight, double ... total) {
        // varargs is used for parsing flexibility
        double result = 0.0;

        // varargs returns an array
        for (double i : total) {
            result += i;
        }
        // weighted average
        return (result/args) * weight;
    }
    public static double gradeCounter(int args, boolean grade) {
        Scanner userInput = new Scanner(System.in);
        double result = 0;

        for (int i = 1; i <= args; i++) {
            if (grade) {
                // if grade is a minor
                System.out.print("\nEnter the grade of minor #" + i + " >>> ");
            }
            else {
                // if grade is a major
                System.out.print("\nEnter the grade of major #" + i + " >>> ");
            }
            result += userInput.nextDouble();
        }
        return result;
    }
    public static void main(String[] args) {}

}
