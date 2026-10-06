class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int back = numbers.length - 1;

        int[] sol = new int[2];

        while(front < back){
            int val = numbers[front] + numbers[back];
            if(val == target){
                sol[0] = front+1;
                sol[1] = back+1;
                break;
            }
            if(val < target){
                front++;
            }
            if(val > target){
                back--;
            }
        }

        return sol;
    }
}
