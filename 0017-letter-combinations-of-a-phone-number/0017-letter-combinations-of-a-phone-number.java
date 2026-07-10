class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {
            "", "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        List <String> ans =  new ArrayList<>() ;
        StringBuilder current = new StringBuilder ();
        solve(0, digits, map, current, ans);
        return ans ;
    }
    public void solve (int index ,String  digits , String [] map , StringBuilder  current , List<String> ans ){
        if(index==digits.length()){
            ans.add(current.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String str  = map[digit] ; 
        for(char s : str.toCharArray()){
            current.append(s);
            solve(index+1 , digits , map , current , ans) ; 
            current.deleteCharAt(current.length()-1);
        }
    }
}