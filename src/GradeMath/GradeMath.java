package GradeMath;

import ErrorHandling.InvalidString;

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
        double currentGrade = 0;

        for (int i = 1; i <= args; i++) {
            if (grade) {
                // if grade is a minor
                System.out.print("\nEnter the grade of minor #" + i + " >>> ");
            }
            else {
                // if grade is a major
                System.out.print("\nEnter the grade of major #" + i + " >>> ");
            }
            // to extrapolate current grade
            currentGrade = userInput.nextDouble();

            System.out.print("\nIs that grade calculated out of 100? (yes or no) >>> ");
            String userChoice = userInput.next();

            if (userChoice.equals("no")) {
                System.out.print("What is that grade calculated out of? >>> ");
                double gradeFraction = userInput.nextDouble();

                result += currentGrade * (100.0 / gradeFraction);
            }
            else {
                result += currentGrade;
            }
        }
        return result;
    }
}
