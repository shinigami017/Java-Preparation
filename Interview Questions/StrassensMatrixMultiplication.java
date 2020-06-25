import java.util.Scanner;

class StrassensMatrixMultiplication
{
    // Function to multiply matrices
    public static int[][] multiply(int[][] A, int[][] B)
    {        
        int n = A.length;
        int[][] C = new int[n][n];
        // base case
        if (n == 1)
            C[0][0] = A[0][0] * B[0][0];
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            // Dividing matrix A into 4 halves
            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);

            // Dividing matrix B into 4 halves
            split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);
 
            /** 
                Strassens 7 formulae
                M1 = (A11 + A22)(B11 + B22)
                M2 = (A21 + A22) B11
                M3 = A11 (B12 - B22)
                M4 = A22 (B21 - B11)
                M5 = (A11 + A12) B22
                M6 = (A21 - A11) (B11 + B12)
                M7 = (A12 - A22) (B21 + B22)
            **/
 
            int [][] M1 = multiply(add(A11, A22), add(B11, B22));
            int [][] M2 = multiply(add(A21, A22), B11);
            int [][] M3 = multiply(A11, sub(B12, B22));
            int [][] M4 = multiply(A22, sub(B21, B11));
            int [][] M5 = multiply(add(A11, A12), B22);
            int [][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int [][] M7 = multiply(sub(A12, A22), add(B21, B22));
 
            /**
                Strassens 4 generic formulae
                C11 = M1 + M4 - M5 + M7
                C12 = M3 + M5
                C21 = M2 + M4
                C22 = M1 - M2 + M3 + M6
            **/

            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);
 
            // join 4 halves into one result matrix
            join(C11, C, 0 , 0);
            join(C12, C, 0 , n/2);
            join(C21, C, n/2, 0);
            join(C22, C, n/2, n/2);
        }    
        return C;
    }
    // Funtion to sub two matrices
    public static int[][] sub(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
    // Funtion to add two matrices
    public static int[][] add(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
    // Funtion to split parent matrix into child matrices 
    public static void split(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
    // Funtion to join child matrices intp parent matrix 
    public static void join(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }    
    // Main function
    public static void main (String[] args)throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order n of the matrices : ");
        int N = sc.nextInt();

        // Accept two 2D matrices
        System.out.println("\nEnter N order matrix 1");
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = sc.nextInt();
 
        System.out.println("\nEnter N order matrix 2");
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                B[i][j] = sc.nextInt();
 
        int[][] C = multiply(A, B);
 
        System.out.println("\nProduct of matrices A and  B : ");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(C[i][j] +"\t");
            System.out.println();
        }
        sc.close();
    }
}