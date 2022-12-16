package Helper;

import ErrorHandling.LargeInput;
import StringFormat.StringFormat;
import org.jetbrains.annotations.NotNull;
import java.util.Scanner;
import ErrorHandling.InvalidNumber;
import Constants.Grades;

public class Util {

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

    public static void instructions() {
        StringFormat.bold("-".repeat(50));

        System.out.println("\nThis program calculates the average for any given class");
        System.out.println("When prompted, please enter the number of minors and majors");
        System.out.println("that are graded in that class. enter only integer values");

        StringFormat.bold("-".repeat(50));
        System.out.println();
    }

    public static void finalResult(double finalGrade, double failingGrade) throws InvalidNumber {
        if (finalGrade > failingGrade) {
            StringFormat.passing("\nYour grade for that class is >>> " + Util.roundOff(2, finalGrade));
        }
        else {
            StringFormat.failing("\nYour grade for that class is >>> " + Util.roundOff(2, finalGrade));
        }
    }

    public static String roundOff(int roundingPlaces, double number)
        throws InvalidNumber
    {
        if (roundingPlaces == 0 || number == 0) {
            throw new InvalidNumber("Cannot round with incorrect values");
        }
        return String.format("%." + roundingPlaces + "f", number);
    }

    public static int gradeNumber(boolean gradeType) throws LargeInput, InvalidNumber {
        Scanner userInput = new Scanner(System.in);

        // minor grade
        if (gradeType) {
            StringFormat.redBold("How many minors are being calculated? >>> ");
            int minorNumber = userInput.nextInt();
            if (minorNumber > 25) {
                throw new LargeInput("Input is too large, try again with smaller numbers.");
            }
            else if (minorNumber == 0) {
                throw new InvalidNumber("Cannot calculate grades with nil values");
            }

            return minorNumber;

        }
        else {
            StringFormat.redBold("\nHow many majors are being calculated? >>> ");
            int majorNumber = userInput.nextInt();
            if (majorNumber > 25) {
                throw new LargeInput("Input is too large, try again with smaller numbers.");
            }
            else if (majorNumber == 0) {
                throw new InvalidNumber("Cannot calculate grades with nil values");
            }
            return majorNumber;
        }
    }

    public static double gradeCounter(int args, boolean grade) throws InvalidNumber {
        Scanner userInput = new Scanner(System.in);

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
             TODO: store data in arrays
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

            if (currentGrade > Grades.CHECKING_GRADE) {
                result += currentGrade;
            }
            else {
                // executes if grade is deemed too low (use CHECKING_GRADE)
                System.out.print("What is that grade calculated out of (default 100) >>> ");
                double gradeFraction = userInput.nextDouble();

                result += currentGrade * (Grades.DEFAULT_GRADE / gradeFraction);
            }
        }
        return result;
    }
}
