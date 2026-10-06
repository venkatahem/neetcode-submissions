class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : tasks) {
            map.merge(ch, 1, Integer::sum);
        }

        class Pair {
            char ch;
            int count;
            int nextCycle;
            public Pair(char ch, int count) {
                this.ch = ch;
                this.count = count;
            }
        }

        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        Queue<Pair> next = new LinkedList<>();

        map.forEach((key, value) -> {
            pq.offer(new Pair(key, value));
        });
        map = null;

        int cycles = 0;

        while (!pq.isEmpty() || !next.isEmpty()) {
            cycles++;
            if (!pq.isEmpty()) {
                Pair temp = pq.poll();
                temp.count--;
                if (temp.count != 0) {
                    next.offer(temp);
                    temp.nextCycle = cycles + n;
                } else {
                    temp = null;
                }
            }

            if (!next.isEmpty()) {
                if (next.peek().nextCycle == cycles) {
                    pq.offer(next.poll());
                }
            }
        }

        return cycles;
    }
}
