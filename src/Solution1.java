import java.util.*;

public class Solution1 {

    static String format(int timeInSeconds) {
        if (timeInSeconds < 0)
            return "Error. This is a negative value";
        if (timeInSeconds == 0)
            return "now";
        else {
            int year = timeInSeconds / 31536000;
            int day = (timeInSeconds % 31536000) / 86400;
            int hour = (timeInSeconds % 86400) / 3600;
            int minute = (timeInSeconds % 3600) / 60;
            int second = timeInSeconds % 60;

            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            map.put("year", year);
            map.put("day", day);
            map.put("hour", hour);
            map.put("minute", minute);
            map.put("second", second);

            List<String> list = new ArrayList<>();

            String result = "";
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue()!=0)
                    list.add(entry.getKey());
            }
            if (list.size()==1)
                result = map.get(list.get(0)).toString()+" "+list.get(0);
            else if (list.size()==2)
                result = map.get(list.get(0)).toString()+" "+list.get(0) + " and " + map.get(list.get(1)).toString()+" "+list.get(1);
            else {
                for (int i = 0; i < list.size(); i++) {
                    result += map.get(list.get(i)).toString()+" "+list.get(i);
                    if (map.get(list.get(i))>1)
                        result += "s";
                    if (i==list.size()-2)
                        result += " and ";
                    else if (i==list.size()-1)
                        break;
                    else
                        result += ", ";
                }
            }
            return result;
        }
    }
}