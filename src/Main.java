import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final String YOU_HAVE_PUTED_NOT_A_NUMBER = "You have pured not a number";


    private static int val1;
    private static int val2;
    private static int result;

    public static void main(String[] args) {
        boolean calculate = true;

        boolean isRome = false;
        System.out.printf("Welcome to simple calculator");
        while (calculate) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("What numbers do you use? '1 - rome' or '2 - arab'");
                try {
                    int i = Integer.parseInt(reader.readLine().trim());
                    if (i == 1) {
                        isRome = true;
                        break;
                    } else if (i == 2) {
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Print 1 or 2");
                }
            }

            System.out.println("Write two numbers divided by *, +, - or /");

            result = execute(isRome, reader, "write expression");


            System.out.format("The result of computation is %s", result);

        }
    }

    private static int execute(boolean isRome, BufferedReader reader, String instruction) {
        String operation;

        System.out.println(instruction);
        while (true) {
            System.out.println("Input");
            try {
                String expression = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(expression);

                val1 = parse(isRome, tokenizer.nextToken());

                operation = tokenizer.nextToken();

                val2 = parse(isRome, tokenizer.nextToken());

                result = compute(val1, val2, operation);

                System.out.println();

                System.out.println("Output:");

                if (isRome) {
                    System.out.println(convertToRome(result));
                } else {
                    System.out.println(result);
                }

            } catch (Exception e) {
                System.out.println("You have typed a wrong expression! Try again please!");
                continue;
            }
            try {
                boolean exitAsk = true;
                while (exitAsk) {
                    System.out.println("Compute again? Type 'yes' or 'no'");
                    String exit = reader.readLine().toLowerCase().trim();

                    if ("no".equals(exit)) {
                        System.exit(0);
                    }

                    if ("yes".equals(exit)) {
                        exitAsk = false;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int parse(boolean isRome, String strVal1) throws Exception {
        if (isRome) {
            return parseRome(strVal1);
        } else {
            return parseArab(strVal1);
        }
    }

    private static int compute(int val1, int val2, String operation) throws Exception {
        switch (operation) {
            case "*":
                return val1 * val2;
            case "/":
                return val1 / val2;
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
        }
        throw new Exception("Unsupported operation exception");
    }


    private static int parseArab(String str) throws Exception {
        if (str == null || str.isEmpty()) throw new Exception(YOU_HAVE_PUTED_NOT_A_NUMBER);
        return Integer.parseInt(str.trim());
    }

    private static int parseRome(String str) throws Exception {
        if (str == null || str.isEmpty()) throw new Exception(YOU_HAVE_PUTED_NOT_A_NUMBER);
        return convertToArabe(str.trim());
    }

    private static String convertToRome(int val) {
        return NumbersHelper.intToRoman(val);
    }

    private static int convertToArabe(String val) {
        return NumbersHelper.romanToInt(val);
    }
}
