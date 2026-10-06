class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int back = numbers.length - 1;

        while (front < back) {
            while (front < back && numbers[front] + numbers[back] > target) {
                back--;
            }
            while (front < back && numbers[front] + numbers[back] < target) {
                front++;
            }

            if(numbers[front] + numbers[back] == target){
                break;
            }
        }

        return new int[] {front+1, back+1};
    }
}
