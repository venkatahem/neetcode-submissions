class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[rows-1].length;

        int front = 0;
        int back = rows-1;
        int mid = 0;
        while(front<=back){
            mid = ((back - front)/2) + front;

            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] < target){
                if(matrix[mid][columns-1] >= target){
                    break;
                }
                front = mid + 1;
            }else{
                back = mid-1;
            }
        }

        int row = mid;

        System.out.println(row);

        front = 0;
        back = columns-1;

        while(front<=back){
            mid = ((back - front)/2) + front;

            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] < target){
                front = mid + 1;
            }else{
                back = mid-1;
            }
        }

        return false;
    }
}
