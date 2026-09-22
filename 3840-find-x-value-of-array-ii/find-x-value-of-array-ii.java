class Solution {

    class Node {
        int product;
        int[] prefix;

        Node(int k) {
            prefix = new int[k];
        }
    }

    int k;
    int[] nums;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.nums = nums;
        this.k = k;

        int n = nums.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Persistent update
            nums[index] = value;
            update(1, 0, n - 1, index, value);

            // Get information for [start, n-1]
            Node res = query(1, 0, n - 1, start, n - 1);

            ans[q] = res.prefix[x];
        }

        return ans;
    }

    // Build segment tree
    void build(int node, int left, int right) {

        if (left == right) {
            tree[node] = new Node(k);

            int rem = nums[left] % k;

            tree[node].product = rem;
            tree[node].prefix[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Update one position
    void update(int node, int left, int right, int index, int value) {

        if (left == right) {

            int rem = value % k;

            tree[node] = new Node(k);
            tree[node].product = rem;
            tree[node].prefix[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Merge two nodes
    Node merge(Node a, Node b) {

        Node res = new Node(k);

        // Product of complete segment
        res.product = (int) ((long) a.product * b.product % k);

        // Prefixes completely inside left segment
        for (int r = 0; r < k; r++) {
            res.prefix[r] += a.prefix[r];
        }

        // Prefixes that cross from left into right
        for (int r = 0; r < k; r++) {

            if (b.prefix[r] == 0)
                continue;

            int newRemainder =
                    (int) ((long) a.product * r % k);

            res.prefix[newRemainder] += b.prefix[r];
        }

        return res;
    }

    // Query range [ql, qr]
    Node query(int node, int left, int right, int ql, int qr) {

        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (qr <= mid) {
            return query(node * 2, left, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, right, ql, qr);
        }

        Node a = query(node * 2, left, mid, ql, qr);
        Node b = query(node * 2 + 1, mid + 1, right, ql, qr);

        return merge(a, b);
    }
}