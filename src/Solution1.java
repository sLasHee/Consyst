import java.util.*;

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

            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            map.put(sYear, year);
            map.put(sDay, day);
            map.put(sHour, hour);
            map.put(sMinute, minute);
            map.put(sSecond, second);
            String result = "";
            List<String> list = new ArrayList<>();
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