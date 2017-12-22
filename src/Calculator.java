import java.util.*;

import static java.lang.System.exit;

public class Calculator {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static volatile Queue<Integer> qualifier_to_add = new LinkedList<>();

    public static void main(String[] args) {
        setUp();
    }

    private static void setUp() {
        qualifier_to_add.clear();
        System.out.println("Welcome to the single function calculator");
        System.out.println("Please select the function you need, We got");
        System.out.println("\"+\": for addition function");
        System.out.println("\"-\": for subtraction function");
        System.out.println("\"x\": for multiplication function");
        System.out.println("\"/\": for division function");

        String function_selection = SCANNER.nextLine();

        if (function_selection.equals("+")) {
            System.out.println("The answer is: " + String.valueOf(addition()));
        } else if (function_selection.equals("-")) {
            System.out.println("The answer is: " + String.valueOf(subtraction()));
        } else if (function_selection.equals("x")) {
            System.out.println("The answer is: " + String.valueOf(multiplication()));
        } else if (function_selection.equals("/")) {
            System.out.println("The answer is: " + String.valueOf(division()));
        } else {
            System.out.println("Please check if you entered the right function selection.");
        }

        continue_check();
    }

    private static int addition() {
        String input = null;
        int result = 0;
        System.out.println("please enter \"=\" when all numbers were entered.");
        while (true) {
            input = SCANNER.nextLine();
            if (input.equals("=") && qualifier_check() && !input.equals("")) {
                while (!qualifier_to_add.isEmpty()) {
                    result += qualifier_to_add.poll();
                }
                return result;
            } else if (!input.equals("=") && !input.equals("")) {
                qualifier_to_add.add(Integer.parseInt(input));
            } else {
                calculate_fail();
                continue_check();
            }
        }
    }

    private static int subtraction() {
        String input = null;
        int result = 0;
        System.out.println("please enter \"=\" when all numbers were entered.");
        while (true) {
            input = SCANNER.nextLine();
            if (input.equals("=") && qualifier_check() && !input.equals("")) {
                result += qualifier_to_add.poll();
                while (!qualifier_to_add.isEmpty()) {
                    result -= qualifier_to_add.poll();
                }
                return result;
            } else if (!input.equals("=") && !input.equals("")) {
                qualifier_to_add.add(Integer.parseInt(input));
            } else {
                calculate_fail();
                continue_check();
            }
        }
    }

    private static int multiplication() {
        String input = null;
        int result = 0;
        System.out.println("please enter \"=\" when all numbers were entered.");
        while (true) {
            input = SCANNER.nextLine();
            if (input.equals("=") && qualifier_check() && !input.equals("")) {
                result = qualifier_to_add.poll();
                while (!qualifier_to_add.isEmpty()) {
                    result *= qualifier_to_add.poll();
                }
                return result;
            } else if (!input.equals("=") && !input.equals("")) {
                qualifier_to_add.add(Integer.parseInt(input));
            } else {
                calculate_fail();
                continue_check();
            }
        }
    }

    private static int division() {
        String input = null;
        int result = 0;
        System.out.println("please enter \"=\" when all numbers were entered.");
        while (true) {
            input = SCANNER.nextLine();
            if (input.equals("=") && qualifier_check() && !input.equals("")) {
                result = qualifier_to_add.poll();
                while (!qualifier_to_add.isEmpty()) {
                    result /= qualifier_to_add.poll();
                }
                return result;
            } else if (!input.equals("=") && !input.equals("")) {
                qualifier_to_add.add(Integer.parseInt(input));
            } else {
                calculate_fail();
                continue_check();
            }
        }
    }

    private static boolean qualifier_check() {
        boolean status = false;
        if (qualifier_to_add.isEmpty()) {
            status = false;
        } else {
            status = true;
        }
        return status;
    }

    private static void calculate_fail() {
        System.out.println("please enter at least 1 number to do calculation");
    }

    private static void continue_check() {
        System.out.println("do you want to calculate again? y/n");
        String continue_req = SCANNER.nextLine();
        if (continue_req.equals("y")) {
            setUp();
        } else {
            System.out.println("Thank you for using this product. See you :)");
            exit(0);
        }
    }

}
