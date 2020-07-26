package practice.week1;

public class Day7_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {

        for (int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return getPerimeter(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int getPerimeter(int [][]grid, int i, int j) {

        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length) return 1;
        if (grid[i][j] == 0) return 1;
        if(grid[i][j] == -1) return 0;
        grid[i][j] = -1; // marking node as visited

        int perimeter = 0;
        perimeter += getPerimeter(grid, i + 0, j + 1);
        perimeter += getPerimeter(grid, i + 0, j - 1);
        perimeter += getPerimeter(grid, i + 1, j + 0);
        perimeter += getPerimeter(grid, i - 1, j + 0);

        return perimeter;
    }

    public static void main(String[] args) {
        int grid[][] = {{1}};
//                {{0,1,0,0},
//                {1,1,1,0},
//                {0,1,0,0},
//                {1,1,0,0}};
        System.out.println(new Day7_IslandPerimeter().islandPerimeter(grid));
    }
}
