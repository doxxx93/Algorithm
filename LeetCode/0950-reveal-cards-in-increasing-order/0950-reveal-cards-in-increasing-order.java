class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[queue.poll()] = deck[i];
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }
        return res;
    }
}