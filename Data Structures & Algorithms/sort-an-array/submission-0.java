class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums,nums.length-1);

        return nums;
    }

    public void sort(int[] arr,int index){
        if(index<=0){
            return;
        }


        sort(arr,index-1);
        insert(arr,index);

    }

    public void insert(int arr[],int pos){
        if(pos <= 0){
            return;
        }

        if(arr[pos-1]>=arr[pos]){
            int a = arr[pos];
            int b = arr[pos-1];

            arr[pos] = b;
            arr[pos-1] = a;
            insert(arr,pos-1);
        }else{
            return;
        }
    }
}