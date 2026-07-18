class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack <>() ;
        for(int num :asteroids){
            if (st.isEmpty() || st.peek() < 0 || num > 0) {
                st.push(num);
            } 
            else {
                boolean destroyed = false;

                while (!st.isEmpty() && st.peek() > 0 && num < 0) {

                    if (st.peek() < -num) {
                        st.pop();              // top dies
                    }

                    else if (st.peek() == -num) {
                        st.pop();              // both die
                        destroyed = true;
                        break;
                    }

                    else {
                        destroyed = true;      // current dies
                        break;
                    }
                }

                if (!destroyed) {
                    st.push(num);
                }
            }
        }
        int [] ans = new int [st.size()];
        for(int i = ans.length-1  ; i>=0 ; i--){
            ans[i]= st.peek() ;
            st.pop();
        }
        return ans;
    }
}