package GradeMath;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;
import ErrorHandling.InvalidNumber;

public class GradeMath {
    private static final double DEFAULT_GRADE = 100.0;

    public static double average(int args, double weight, double @NotNull ... total) {
        // varargs is used for parsing flexibility
        double result = 0.0;

        // varargs returns an array
        for (double i : total) {
            result += i;
        }
        // weighted average
        return (result / args) * weight;
    }

    public static String roundOff(int places, double number)
        throws InvalidNumber
    {
        if (places == 0 || number == 0) {
            throw new InvalidNumber("Cannot round a nonexistent number");
        }
        return String.format("%." + places + "f", number);
    }

    public static double gradeCounter(int args, boolean grade) {
        Scanner userInput = new Scanner(System.in);
        double result = 0;
        double currentGrade;

        for (int i = 1; i <= args; i++) {
            if (grade) {
                // if grade is a minor
                System.out.print("\nEnter the grade of minor #" + i + " >>> ");
            }
            else {
                // if grade is a major1
                System.out.print("\nEnter the grade of major #" + i + " >>> ");
            }
            // to extrapolate current grade
            currentGrade = userInput.nextDouble();

            if (currentGrade > 50) {
                result += currentGrade;
            }
            else {
                try {
                    System.out.print("What is that grade calculated out of (default 100) >>> ");
                    double gradeFraction = userInput.nextDouble();

                    // multiply fraction to magic number of DEFAULT_GRADE
                    result += currentGrade * (DEFAULT_GRADE / gradeFraction);
                }
                catch (ArithmeticException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
