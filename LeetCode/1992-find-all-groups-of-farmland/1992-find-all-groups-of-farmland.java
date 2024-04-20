class Solution {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i< land.length; i++){
            for (int j = 0; j < land[0].length; j++){
                if (land[i][j] == 1) {
                    int[] lect = {i, j, i, j};
                    dfs(land, i, j, lect);
                    res.add(lect);
                }
            }
        }

        return res.toArray(new int[0][]);
    }

    private void dfs(int[][] land, int i, int j, int[] lect){
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] == 0){
            return;
        }
        land[i][j] = 0;
        lect[0] = Math.min(lect[0], i);
        lect[1] = Math.min(lect[1], j);
        lect[2] = Math.max(lect[2], i);
        lect[3] = Math.max(lect[3], j);
        for (int k = 0; k < 4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(land, x, y, lect);
        }
    }
}
