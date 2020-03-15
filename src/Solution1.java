import java.util.*;

//Требуется доработать вывод результата.
public class Solution1 {

    static String format(int timeInSeconds) {
        if (timeInSeconds < 0)
            return "Error: This is a negative value";
        if (timeInSeconds == 0)
            return "now";
        else {
            int year = timeInSeconds / 31536000;
            int day = (timeInSeconds % 31536000) / 86400;
            int hour = (timeInSeconds % 86400) / 3600;
            int minute = (timeInSeconds % 3600) / 60;
            int second = timeInSeconds % 60;

            String sYear = "year";
            String sDay = "day";
            String sHour = "hour";
            String sMinute = "minute";
            String sSecond = "second";

            String plural = "s";

            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            map.put(sYear, year);
            map.put(sDay, day);
            map.put(sHour, hour);
            map.put(sMinute, minute);
            map.put(sSecond, second);

            map.entrySet().removeIf(entry -> entry.getValue() == 0);

            StringBuilder result = new StringBuilder();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1)
                    result.append(entry.getValue()).append(" ").append(entry.getKey()).append(plural).append(",").append(" ");
                else
                    result.append(entry.getValue()).append(" ").append(entry.getKey()).append(",").append(" ");
            }
            return result.toString();
        }
    }
}


