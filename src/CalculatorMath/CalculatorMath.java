package CalculatorMath;

public class CalculatorMath {
    public static int average(int ... num) {
        // Uses varargs to parse any number of inputs
        int result = 0;

        for (int i : num) {
            result += i;
        }
        return result/num.length;
    }

    public static void main(String[] args) {
    }
}
