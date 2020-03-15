import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {

    static String find(String input) {
        List<Integer> list = new ArrayList<>();
        for (String s : input.split(" ")) {
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);
        return list.get(list.size()-1)+" "+list.get(0);
    }
}
