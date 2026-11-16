import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        int candidates[] = { 2, 3, 6, 7 };

        int target = 7;
        List<List<Integer>> ans = combine(candidates, target);

        for (List<Integer> list : ans) {
            System.out.println(list);
        }

    }

    public static List<List<Integer>> combine(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,candidates,target, ans, new ArrayList<>());

        return ans;
    }

    public static void solve(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        int n = arr.length;

        if (idx == n) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            solve(idx, arr, target - arr[idx], ans, ds);
            ds.remove(ds.size() - 1);
        }
        solve(idx + 1, arr, target, ans, ds);
    }
}