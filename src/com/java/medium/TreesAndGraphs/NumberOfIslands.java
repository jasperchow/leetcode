//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//
//
//        Example 1:
//
//        Input: grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//        Output: 1
//        Example 2:
//
//        Input: grid = [
//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//        Output: 3

public class NumberOfIslands{
    public NumberOfIslands(){}

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int nums_of_rows = grid.length;
        int nums_of_columns = grid[0].length;
        int result = 0;

        for(int row = 0; row < nums_of_rows; row++){
            for (int column = 0; column < nums_of_columns; column++){
                if (grid[row][column] == '1'){
                    result += 1;
                    dfs(grid, row, column);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int row, int column){
        int nums_of_rows = grid.length;
        int nums_of_columns = grid[0].length;

        if(row < 0 || column < 0 || row >= nums_of_rows || column >= nums_of_columns || grid[row][column] == '0'){
            return;
        }

        grid[row][column] = '0';
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid,row, column + 1);
    }
}