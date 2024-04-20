import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i< land.length; i++){
            for (int j = 0; j < land[0].length; j++){
                if (land[i][j] == 1) {
                    int[] farm = {i, j, i, j};
                    dfs(land, i, j, farm);
                    res.add(farm);
                }
            }
        }

        return res.toArray(new int[0][]);
    }

    private void dfs(int[][] land, int i, int j, int[] farm){
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] == 0){
            return;
        }
        land[i][j] = 0;
        farm[0] = Math.min(farm[0], i);
        farm[1] = Math.min(farm[1], j);
        farm[2] = Math.max(farm[2], i);
        farm[3] = Math.max(farm[3], j);
        for (int k = 0; k < 4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(land, x, y, farm);
        }
    }
}
