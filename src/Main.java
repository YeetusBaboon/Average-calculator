import GradeMath.GradeMath;
import GradeMath.StringFormat;
import java.util.Scanner;

public class Main {
    // TODO: Write a GPA Calculator using this code
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        final double MINOR_WEIGHT = 0.4;
        final double MAJOR_WEIGHT = 0.6;
        // FIXME: constant declaration

        StringFormat.bold("How many minors are being calculated? >>> ");
        int minorNumber = userInput.nextInt();
        double totalMinorPoints = GradeMath.gradeCounter(minorNumber, true);

        StringFormat.bold("\nHow many majors are being calculated? >>> ");
        int majorNumber = userInput.nextInt();
        double totalMajorPoints = GradeMath.gradeCounter(majorNumber, false);

        // avg of all grades multiplied by their weight
        double minorTotal = GradeMath.average(minorNumber, MINOR_WEIGHT, totalMinorPoints);
        double majorTotal = GradeMath.average(majorNumber, MAJOR_WEIGHT, totalMajorPoints);

        StringFormat.bold("\nYour grade for that class is >>> ");
        // round to two decimal places
        System.out.format("%.2f", minorTotal + majorTotal);

    }
}