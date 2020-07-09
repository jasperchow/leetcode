//Given an array of strings, group anagrams together.
//
//        Example:
//
//        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Output:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        Note:
//
//        All inputs will be in lowercase.
//        The order of your output does not matter.

public class GroupAnagrams{
    public GroupAnagrams(){}

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();

        Map<String, List> result = HashMap<String, list>();

        for(s : strs){
            char[] ca = s.toCharArray();

            Arrays.sort(ca);
            String key = String.valueOf(ca);
        }
    }
}