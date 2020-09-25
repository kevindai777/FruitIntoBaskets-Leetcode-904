//Java Solution

class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        
        while (right < tree.length) {
            int curr = tree[right];
            
            if (map.containsKey(curr) || map.size() < 2) {
                ans = Math.max(ans, right - left + 1);
            } else {
                int lastMin = Integer.MAX_VALUE;
                int lastMinKey = 0;
                
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() < lastMin) {
                        lastMin = entry.getValue();
                        lastMinKey = entry.getKey();
                    }
                }
                
                map.remove(lastMinKey);
                left = lastMin + 1;
            }
            
            map.put(curr, right++);
        }
        
        return ans;
    }
}