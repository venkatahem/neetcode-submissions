class Solution {
    class Pair{
        int a;
        int b;

        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        int getKey(){
            return a;
        }

        int getValue(){
            return b;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());


        int front = 0;
        int back = 0;

        List<Integer> sol = new ArrayList<>();

        while(back < nums.length){
            Pair temp = new Pair(nums[back],back);
            pq.offer(temp);
            while(pq.peek().getValue() < front){
                pq.poll();
            }
            if(back-front+1 == k){
                sol.add(pq.peek().getKey());
                front++;
            }
            back++;
        }

        return sol.stream().mapToInt(Integer::intValue).toArray();
    }
}
