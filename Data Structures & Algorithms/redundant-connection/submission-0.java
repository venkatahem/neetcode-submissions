class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if (this.parent[node] == node) {
                return node;
            }

            return this.parent[node] = find(this.parent[node]);
        }

        public boolean union(int a, int b) {
            int parent_a = this.find(a);
            int parent_b = this.find(b);

            if (parent_a != parent_b) {
                if (this.rank[parent_a] < this.rank[parent_b]) {
                    this.parent[parent_a] = parent_b;
                    this.rank[parent_b] = this.rank[parent_a] + this.rank[parent_b];
                } else {
                    this.parent[parent_b] = parent_a;
                    this.rank[parent_a] = this.rank[parent_a] + this.rank[parent_b];
                }

                return true;
            }

            return false;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int sol = 0;
        int n = edges.length;

        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            if (!dsu.union(edges[i][0], edges[i][1])) {
                sol = i;
            }
        }

        return edges[sol];
    }
}
