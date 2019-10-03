import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NumbersHelper {

    private static final Map<Character, Integer> romanToInt = new HashMap<>(7);
    static {
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int len = s.length() - 1;
        for (int i = 0; i < len; i++) {
            if (romanToInt.get(s.charAt(i)) < romanToInt.get(s.charAt(i + 1))) {
                sum -= romanToInt.get(s.charAt(i));
            } else {
                sum += romanToInt.get(s.charAt(i));
            }
        }
        return sum += romanToInt.get(s.charAt(len));
    }


    private static final TreeMap<Integer, String> intToRoman = new TreeMap<>(Collections.reverseOrder());
    static {
        intToRoman.put(1000, "M");
        intToRoman.put(900, "CM");
        intToRoman.put(500, "D");
        intToRoman.put(400, "CD");
        intToRoman.put(100, "C");
        intToRoman.put(90, "XC");
        intToRoman.put(50, "L");
        intToRoman.put(40, "XL");
        intToRoman.put(10, "X");
        intToRoman.put(9, "IX");
        intToRoman.put(5, "V");
        intToRoman.put(4, "IV");
        intToRoman.put(1, "I");
    }
    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder("");
        for (Integer i: intToRoman.keySet()) {
            for (int j = 1; j <= num / i; j++) {
                roman.append(intToRoman.get(i));
            }
            num %= i;
        }
        return roman.toString();
    }
}
