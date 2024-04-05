import java.util.HashMap;

class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                int k = map.get(name);
                while (map.containsKey(name + "(" + k + ")")) {
                    k++;
                }
                result[i] = name + "(" + k + ")";
                map.put(name + "(" + k + ")", 1);
                map.put(name, k + 1);
            } else {
                result[i] = name;
                map.put(name, 1);
            }
        }
        return result;
    }
}