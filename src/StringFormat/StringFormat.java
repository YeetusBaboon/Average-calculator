package StringFormat;

import Constants.ConsoleColors;

public class StringFormat {
    public static void redBold(String text) {
        System.out.print(ConsoleColors.RED_BOLD + text + ConsoleColors.RESET);
    }
    public static void bold(String text) {
        System.out.print(ConsoleColors.WHITE_BOLD + text + ConsoleColors.RESET);
    }
    public static void failing(String text) {
        System.out.print(ConsoleColors.RED + text + ConsoleColors.RESET);
    }
    public static void passing(String text) {
        System.out.print(ConsoleColors.GREEN + text + ConsoleColors.RESET);
    }

}
