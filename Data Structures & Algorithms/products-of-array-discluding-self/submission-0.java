class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1,1,2,8]
        // [48,24,6,1]

        int front = 0;
        int back = nums.length;

        int[] prefix = new int[back];
        int[] suffix = new int[back];

        back--;

        int a = 1;
        int b = 1;

        while(front < nums.length && back >= 0){
            prefix[front] = a;
            suffix[back] = b;

            a = a*nums[front];
            b = b*nums[back];

            front++;
            back--;
        }

        int[] sol = new int[nums.length];

        for(int i=0; i < nums.length; i++){
            sol[i] = prefix[i] * suffix[i];
        }

        return sol;
    }
}  
