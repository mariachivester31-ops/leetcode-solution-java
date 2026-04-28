class Solution {
    class pair{
        int row;
        int col;
        int dist;
        pair(int r, int c, int d){
            row = r;
            col = c;
            dist = d;
        }
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(distance[i], (int)1e9);
        }
        int[] delr = {0, 1};
        int[] delc = {1, 0};
        PriorityQueue<pair> q = new PriorityQueue<>((pair x, pair y)-> Integer.compare(x.dist, y.dist));
        q.offer(new pair(0, 0, grid[0][0]));
        distance[0][0] = grid[0][0];
        while(!q.isEmpty()){
            pair temp = q.poll();
            if(temp.dist > distance[temp.row][temp.col])continue;
            if(temp.row == m-1 && temp.col == n-1)return temp.dist;
            for(int i = 0 ; i < 2 ; i++){
                int nrow = temp.row+delr[i];
                int ncol = temp.col+delc[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n){
                    int sum = temp.dist+grid[nrow][ncol];
                    if(sum < distance[nrow][ncol]){
                        q.offer(new pair(nrow, ncol, sum));
                        distance[nrow][ncol] = sum;
                    }
                }
            }
        }
        return distance[m-1][n-1];
    }
}
