package GradeMath;

public class StringFormat {
    public static final String ANSI_RESET = "\u001B[0m";
    // reset ANSI print values after using
    public static final String ANSI_BOLD = "\033[0;1m";

    public static void bold(String text) {
        System.out.print(ANSI_BOLD + text + ANSI_RESET);
    }
}
