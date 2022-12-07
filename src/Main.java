import ErrorHandling.*;
import GradeMath.GradeMath;
import StringFormat.StringFormat;
import java.util.Scanner;

public class Main {
    // TODO: Write a GPA Calculator using this code
    public static void main(String[] args)
        throws InvalidNumber, LargeInput
    {
        Scanner userInput = new Scanner(System.in);

        final double MINOR_WEIGHT = 0.4;
        final double MAJOR_WEIGHT = 0.6;
        final double FAILING_GRADE = 70;
        // FIXME: constant declaration

        // instructions for user
        StringFormat.bold("-".repeat(50));
        System.out.println("\nThis program calculates the average for any given class");
        System.out.println("When prompted, please enter the number of minors and majors");
        System.out.println("that are graded in that class. enter only integer values");
        StringFormat.bold("-".repeat(50));
        System.out.println();

        StringFormat.redBold("How many minors are being calculated? >>> ");
        int minorNumber = userInput.nextInt();
        if (minorNumber > 25) {
            throw new LargeInput("Input is too large, try again with smaller numbers.");
        }

        // minor grade
        double totalMinorPoints = GradeMath.gradeCounter(minorNumber, true);

        StringFormat.redBold("\nHow many majors are being calculated? >>> ");
        int majorNumber = userInput.nextInt();
        if (majorNumber > 25) {
            throw new LargeInput("Input is too large, try again with smaller numbers.");
        }

        if (minorNumber == 0 && majorNumber == 0) {
            throw new InvalidNumber("Cannot calculate average with no grades.");
        }

        double totalMajorPoints = GradeMath.gradeCounter(majorNumber, false);

        // avg of all grades multiplied by their weight
        double finalGrade = GradeMath.average(minorNumber, MINOR_WEIGHT, totalMinorPoints) +
                            GradeMath.average(majorNumber, MAJOR_WEIGHT, totalMajorPoints);
        if (finalGrade > FAILING_GRADE) {
            StringFormat.passing("\nYour grade for that class is >>> " + GradeMath.roundOff(2, finalGrade));
        }
        else {
            StringFormat.failing("\nYour grade for that class is >>> " + GradeMath.roundOff(2, finalGrade));
        }

    }

}