class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long mod = 1000000007;

        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Next Smaller or Equal
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nextSmaller[i] = n;
            } else {
                nextSmaller[i] = st.peek();
            }

            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;

            ans = (ans + (left * right * arr[i]) % mod) % mod;
        }

        return (int) ans;
    }
}