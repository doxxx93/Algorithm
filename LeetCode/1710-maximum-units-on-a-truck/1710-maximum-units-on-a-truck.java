class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(box -> -box[1]));
        int answer = 0;
        int currentSize = 0;
        for (int[] box : boxTypes) {
            if (currentSize + box[0] <= truckSize) {
                currentSize += box[0];
                answer += box[1]*box[0];
            } else {
                answer += (truckSize-currentSize)*box[1];
                currentSize += (truckSize-currentSize);
            }
        }
        return answer;
    }
}