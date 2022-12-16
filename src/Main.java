import Helper.Util;
import Constants.Grades;

public class Main {
    public static void main(String[] args)
            throws Exception
    {
        // user instructions
        Util.instructions();

        // minor grade
        int minorNumber = Util.gradeNumber( true);
        double totalMinorPoints = Util.gradeCounter(minorNumber, true);

        // major grade
        int majorNumber = Util.gradeNumber(false);
        double totalMajorPoints = Util.gradeCounter(majorNumber, false);

        double finalGrade = Util.average(minorNumber, Grades.MINOR_WEIGHT, totalMinorPoints) +
            Util.average(majorNumber, Grades.MAJOR_WEIGHT, totalMajorPoints);

        Util.finalResult(finalGrade, Grades.PASSING_GRADE);

    }

}