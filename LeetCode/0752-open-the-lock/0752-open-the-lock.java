class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }
        if ("0000".equals(target)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String next : getNext(cur)) {
                    if (dead.contains(next) || visited.contains(next)) {
                        continue;
                    }
                    if (next.equals(target)) {
                        return steps;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return -1;
    }
    
    private List<String> getNext(String cur) {
        List<String> res = new ArrayList<>();
        char[] chs = cur.toCharArray();
        for (int i = 0; i < 4; i++) {
            char old = chs[i];
            chs[i] = (char) ((old - '0' + 1) % 10 + '0');
            res.add(new String(chs));
            chs[i] = (char) ((old - '0' + 9) % 10 + '0');
            res.add(new String(chs));
            chs[i] = old;
        }
        return res;
    }
}