class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
          Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Find Next Greater Element for every element in nums2
        for (int i = nums2.length - 1; i >= 0; i--) {

            // Remove all smaller or equal elements
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            // Store answer in HashMap
            if (st.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], st.peek());
            }

            // Current element becomes a candidate
            st.push(nums2[i]);
        }

        // Step 2: Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}