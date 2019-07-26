// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    HashMap<Character, Character[]> map = new HashMap<Character, Character[]>();
    
    public void combine(String digits, int digIndex, String comb, List<String> list) {
		if(digIndex == digits.length()) {
			list.add(comb);
			return;
		}
		
		Character[] alph = map.get(digits.charAt(digIndex));
		for(int i=0; i<alph.length ; i++) {
			combine(digits, digIndex+1, comb+alph[i], list); 
		}
	}
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() ==0) return new ArrayList<String>();
        map.put('1', new Character[] {});
        map.put('2', new Character[] {'a', 'b', 'c'});
        map.put('3', new Character[] {'d', 'e', 'f'});
        map.put('4', new Character[] {'g', 'h', 'i'});
        map.put('5', new Character[] {'j', 'k', 'l'});
        map.put('6', new Character[] {'m', 'n', 'o'});
        map.put('7', new Character[] {'p', 'q', 'r', 's'});
        map.put('8', new Character[] {'t', 'u', 'v'});
        map.put('9', new Character[] {'w', 'x', 'y', 'z'});
        
        List<String> list = new ArrayList<String>();
        combine(digits, 0, "", list);
        return list;
    }
}
