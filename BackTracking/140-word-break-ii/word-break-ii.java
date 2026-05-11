class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> ans=new ArrayList<>();
        solve(s,wordDict,"",0,ans);
        return ans;
    }

    public void solve(String s,List<String> wordDict,String curr,int index,List<String> ans){
        
        if(index>=s.length())
        {
            ans.add(curr.trim());
            return;
        }
        for(int i=index;i<s.length();i++){
            String word=s.substring(index,i+1);

            if(wordDict.contains(word))
            {
                solve(s,wordDict,curr+word+" ",i+1,ans);
            }
        }
    }

}