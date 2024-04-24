public class DirectedOrUndirected {
    public static boolean isDirected(int[][] matrix) {

        int n = matrix.length;

        if(n != matrix[0].length){
            return false;
        }
        // Check for symmetry
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;

    }

}
