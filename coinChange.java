public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[][] maxWays = new int[candidates.length+1][target+1];
        for(int i=0;i<target;i++)
            maxWays[0][i] = 0;
        for(int j=0;j<candidates.length;j++){
            maxWays[j][0] = 1;
        }
        for(int i=1;i<=candidates.length;i++){
            for(int j=1;j<=target;j++){
                if(j<candidates[i-1]){
                    maxWays[i][j] = maxWays[i-1][j];
                }else{
                    maxWays[i][j] = maxWays[i-1][j] + maxWays[i][j-candidates[i-1]];
                }
            }
        }
        System.out.println(maxWays[candidates.length][target]);
        return null;
    }
}
