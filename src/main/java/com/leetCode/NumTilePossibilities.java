package com.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1079. 活字印刷
 * <p>
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * <p>
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 */
public class NumTilePossibilities {

    public int numTilePossibilities(String tiles) {

        boolean[] visited = new boolean[tiles.length()];
        Set<String> set = new HashSet<>();
        dfs(visited, set, tiles, new StringBuilder());
        return set.size() - 1;
    }

    public void dfs(boolean[] visited, Set<String> set, String tiles, StringBuilder sb) {

        set.add(sb.toString());

        for (int i = 0; i < tiles.length(); i++) {

            if (!visited[i]) {
                visited[i] = true;
                sb.append(tiles.charAt(i));
                dfs(visited, set, tiles, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new NumTilePossibilities().numTilePossibilities("AAB"));
    }
}
