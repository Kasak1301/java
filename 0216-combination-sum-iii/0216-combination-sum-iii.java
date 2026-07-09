class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(1, k, n, new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int start,
                      int k,
                      int target,
                      List<Integer> ds,
                      List<List<Integer>> ans) {

        if(target == 0 && ds.size() == k){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(target < 0 || ds.size() > k)
            return;

        for(int i = start; i <= 9; i++){

            ds.add(i);

            solve(i + 1,
                  k,
                  target - i,
                  ds,
                  ans);

            ds.remove(ds.size() - 1);
        }
    }
}