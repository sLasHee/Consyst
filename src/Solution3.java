import java.util.TreeMap;

public class Solution3 {

    static String toRoman(int number) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        int value = map.floorKey(number);
        if (value == number)
            return map.get(number);
        return map.get(value) + toRoman(number - value);
    }
}
