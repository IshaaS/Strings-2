//https://leetcode.com/problems/implement-strstr/

// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//if ith character match first charctaer of needle, check until charcaters keep matching 
//if j reached length of needle, its a match return i 
//else increament i and again check from start of needle.

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        int m =haystack.length();
        int n = needle.length();
        int i=0;
        while(i<=m-n){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=0;
                int k=i;
                while(haystack.charAt(k)==needle.charAt(j)){
                    k++;
                    j++;
                    if(j==n) return i;
                }
            }
            i++;
        }
        return -1;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//we store running hash value until window is created, remove left contribution from hash,
//add right's contribution to the has until we get exact hash of needle.

import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        int m =haystack.length();
        int n = needle.length();
        BigInteger hash = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);
        //get hash of pattern
        for(int i =0;i<n;i++){
            char incoming = needle.charAt(i);
            hash=hash.multiply(k).add(BigInteger.valueOf(incoming-'a'+1));
        }
        BigInteger currentHash = BigInteger.ZERO;
        // go over haystack
        for(int i=0;i<m;i++){
            //outgoing
            if(i>=n){
                char outgoing = haystack.charAt(i-n);
                //remove contribution of outgoing character from hash
                currentHash=currentHash.mod(k.pow(n-1));
            }
            //incoming
            char incoming = haystack.charAt(i);
            currentHash=currentHash.multiply(k).add(BigInteger.valueOf(incoming-'a'+1));
            //check if current window is the needle
            if(hash.equals(currentHash)) return i-n+1;
        }
        return -1;
    }
}