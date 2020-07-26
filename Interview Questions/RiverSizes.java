// River Sizes Problem - Obtain the sizes of different rivers from the given matrix, one river comprises of all adjacent cells with value 1.
// O(m*n) - time | O(m*n)
import java.util.*;
class RiverSizes{

    public static List<Integer> getAllRiversSizes(int[][] matrix){
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(!visited[i][j]){
                    if(matrix[i][j] == 0){
                        visited[i][j] = true;
                    }else{
                        sizes.add(getRiverSize(matrix, visited, i, j));
                    }
                }
            }
        }
        return sizes;
    }

    public static int getRiverSize(int[][] matrix, boolean[][] visited, int i, int j){
        visited[i][j] = true;
        if(matrix[i][j] == 0){
            return 0;
        }
        int current_size = 1;
        // left adjacent
        current_size += (j - 1 >= 0 && !visited[i][j - 1]) ? getRiverSize(matrix, visited, i, j - 1) : 0;
        // right adjacent
        current_size += (j + 1 < visited[i].length && !visited[i][j + 1]) ? getRiverSize(matrix, visited, i, j + 1) : 0;
        // top adjacent
        current_size += (i - 1 >= 0 && !visited[i - 1][j]) ? getRiverSize(matrix, visited, i - 1, j) : 0;
        // right adjacent
        current_size += (i + 1 < visited.length && !visited[i + 1][j]) ? getRiverSize(matrix, visited, i + 1, j) : 0;
        return current_size;
    }

    public static void printMatrix(int[][] matrix){
        for(int[] mat : matrix){
            for(int m : mat){
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nRiver Sizes Problem : Obtain the sizes of different rivers from the given matrix\n");
        System.out.print("Enter number of testcases : ");
        int T = sc.nextInt();
        while(T-->0){
            System.out.print("Enter number of rows : ");
            int M = sc.nextInt();
            System.out.print("Enter number of columns : ");
            int N = sc.nextInt();
            int[][] matrix = new int[M][N];            
            for(int i = 0; i < M; i++){
                System.out.print("Enter " + N + " space separated 1s for water or 0s for land : ");
                for(int j = 0; j < N; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println("\nMatrix : ");
            printMatrix(matrix);
            System.out.println();
            List<Integer> sizes = getAllRiversSizes(matrix);
            System.out.println("River Size : " + sizes);
        }
        sc.close();
    }
}