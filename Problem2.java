//https://leetcode.com/problems/find-all-anagrams-in-a-string/

// Time Complexity :  O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//created a window of size p, then every time checked the map for putgoing as well as
//incoming character in the window, where ever match was equal to count, added the left
//to the result;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int n=p.length(); int m = s.length();
        int l=0;
        int r =1;
        int match =0;
        for(int i=0; i<n;i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int check = map.size();
        if(map.containsKey(s.charAt(l))) {
            int frq=map.get(s.charAt(l));
            map.put(s.charAt(l), --frq);
            if(frq==0) match +=1;
        }
        while(r<n){
            if(map.containsKey(s.charAt(r))) {
                int frq=map.get(s.charAt(r));
                map.put(s.charAt(r), --frq);
                if(frq==0) match +=1;
            }
            r++;
        }
        if(match==check) result.add(l);
        while(r<m){
            //outgoing
            if(map.containsKey(s.charAt(l))){
                int frq=map.get(s.charAt(l));
                map.put(s.charAt(l), ++frq);
                if(frq==1) match -=1;
            }
            l++;
            //incoming
            if(map.containsKey(s.charAt(r))) {
                int frq=map.get(s.charAt(r));
                map.put(s.charAt(r), --frq);
                if(frq==0) match +=1;
            }
            if(match==check) result.add(l);
            r++;
        }
        return result;
    }
}
