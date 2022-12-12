package GradeMath;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;
import ErrorHandling.InvalidNumber;

public class GradeMath {

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

    public static String roundOff(int roundingPlaces, double number)
        throws InvalidNumber
    {
        if (roundingPlaces == 0 || number == 0) {
            throw new InvalidNumber("Cannot round with incorrect values");
        }
        return String.format("%." + roundingPlaces + "f", number);
    }

    public static double gradeCounter(int args, boolean grade) throws InvalidNumber {
        Scanner userInput = new Scanner(System.in);

        // changes out of 100 logic
        final double CHECKING_GRADE = 50.0;
        final double DEFAULT_GRADE = 100.0;

        double result = 0;
        double currentGrade;

        for (int i = 1; i <= args; i++) {
                if (grade) {
                    // if grade is a minor
                    System.out.print("\nEnter the grade of minor #" + i + " >>> ");
                } else {
                    // if grade is a major1
                    System.out.print("\nEnter the grade of major #" + i + " >>> ");
                }
            /*
             to extrapolate current grade via averages
             TODO: error catching for user input
            */
            currentGrade = userInput.nextDouble();

            if (currentGrade > 1000) {
                throw new InvalidNumber("Input is too large");
            }
            else if (currentGrade > 100) {
                System.out.print("Is this grade correct? >>> ");
                String confirmation = userInput.next();

                if (confirmation.equals("no")) {
                    System.out.println("Please re-enter that grade >>> ");
                    currentGrade = userInput.nextDouble();
                }
            }


            if (currentGrade > CHECKING_GRADE) {
                result += currentGrade;
            }
            else {
                // executes if grade is deemed too low (use CHECKING_GRADE)
                System.out.print("What is that grade calculated out of (default 100) >>> ");
                double gradeFraction = userInput.nextDouble();

                result += currentGrade * (DEFAULT_GRADE / gradeFraction);
            }
        }
        return result;
    }
}
