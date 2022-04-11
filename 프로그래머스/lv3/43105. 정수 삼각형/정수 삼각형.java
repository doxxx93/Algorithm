class Solution {

    private int[][] value;
    private Integer[][] dp;
    //dp[a][b] = 어떤걸 의미하는가

    public int dfs(int x, int y){
        //if(x < 0|| y < 0) return 0;
        if(dp[x][y] == null){

            if(y == 0){
                dp[x][y] = value[x][y] + dfs(x-1, y);
            }else if(y == x){
                dp[x][y] = value[x][y] + dfs(x-1, y-1);
            }else{
                dp[x][y] = value[x][y] +Math.max(dfs(x-1, y-1),dfs(x-1, y));
            }
        }
        return dp[x][y];
    }


    public int solution(int[][] triangle) {
        int answer = 0;
        // 메모이제이션을 사용해서 문제를 해결
        // 각각의 위치에서 최대합은 항상 일정하고 그 정보를 가지고 그다음 최대합을 구하는 식으로 진행
        // top-down
        this.value = triangle;
        dp = new Integer[triangle.length][triangle.length];
        //init setting
        dp[0][0] = value[0][0];
        for(int i = 0; i<value.length; i++){
            dfs(value.length - 1, i);
        }

        int max = -1;
        for(int i = 0;i<value.length; i++){
            max = Math.max(dp[value.length-1][i], max);
        }
        return max;
    }
}