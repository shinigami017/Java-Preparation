import java.util.*;
class MatrixChainMultiplication{
    static char name = 'A';
    // n -> number of matrices, dimension[] -> storing dimensions of the n matrices
    public static int solveMatrixChainMultiplication(int n, int[] dimensions){
        // we will take one extra row and column for simplicity of program
        // 0th row and 0th column will be 0 and won't be used
        int[][] cost = new int[n + 1][n + 1];
        for(int diff = 1; diff <= n; diff++){
            // i = 1, since we won't use 0th row
            // i < n - diff, since we only need to fill upper triangle of cost
            for(int i = 1; i <= (n - diff); i++){
                // since our diff was supposed to be (diff = i - j) => (j = i + diff)
                int j = i + diff;
                cost[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    // c -> cost/number of scalar multiplications
                    int c = cost[i][k] + cost[k + 1][j] + (dimensions[i - 1] * dimensions[k] * dimensions[j]);
                    if(c < cost[i][j]){
                        cost[i][j] = c;
                        cost[j][i] = k;
                    }
                }
            }
        }
        printMatrixChainMultiplication(1, n, n + 1, cost);
        // since our cost table contains minimum cost at last column of first row
        return cost[1][n];
    }

    public static void printMatrixChainMultiplication(int i, int j, int size, int[][] brackets){
        // if there  is only one matrix left
        if(i == j){
            System.out.print(name++);
            return;
        }
        System.out.print("(");
        // sub-expression from i to brackets[j][i]
        printMatrixChainMultiplication(i, brackets[j][i], size, brackets);
        // sub-expression from brackets[j][i] + 1 to j
        printMatrixChainMultiplication(brackets[j][i] + 1, j, size, brackets);
        System.out.print(")");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nMatrix Chain Multiplication Problem using Dynamic Programming\n");
        System.out.print("Enter number of matrices : ");
        int n = sc.nextInt();
        sc.nextLine();
        // We can take input in this for as well but sticking to main solution of our problem 
        // and we'll let the user do the simplification of dimensions of matrices
        // int[] rows = new int[n];
        // int[] columns = new int[n];
        // System.out.println("In next " + n + " lines, enter number of rows and columns of each matrix separated by a single space (rows columns)");
        // System.out.println("(We assume that the matrices and their rows and columns follow CR rule of matrix multiplication, in their present order\n)");
        // for(int i = 0; i < n; i++){
        //     String[] input = sc.nextLine().split(" ");
        //     rows[i] = Integer.parseInt(input[0]);
        //     columns[i] = Integer.parseInt(input[1]);
        // }

        // We can take rows and colums separately as input for all matrices and check for CR rule 
        // and then generate the dimensions array required but, we will let the user to take care of that for now 
        int[] dimensions = new int[n + 1];
        System.out.println("In next " + (n + 1) + " space separated integers, enter the dimensions of " + n + " matrices");
        System.out.println("(For e.g : matrices A[10x20] B[20x30] C[30x40] D[40x50] : {10, 20, 30, 40, 50})");
        String[] input = sc.nextLine().split(" ");
        for(int i = 0; i < dimensions.length; i++){
            dimensions[i] = Integer.parseInt(input[i]);
        }
        int min_cost = solveMatrixChainMultiplication(n, dimensions);
        System.out.println("\nMinimum number of multiplications required for multiplying above " + n + " matrices : " + min_cost);
        sc.close();
    }
}