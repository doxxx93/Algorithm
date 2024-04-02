class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            char sVal = sMap.computeIfAbsent(sChar, k -> tChar);
            char tVal = tMap.computeIfAbsent(tChar, k -> sChar);

            if(sVal != tChar || tVal != sChar){
                return false;
            }
        }

        return true;
    }
}
