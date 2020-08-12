package com.tedemach.August7;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import com.tedemach.Util.TreeNode;

public class Solution {
    private int leftMost, rightMost;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return null;
        leftMost = 0;
        rightMost = 0;
        calculateWidth(root, 0);
        List<List<NodePosition>> positions = new ArrayList<>();
        createSpace(positions);
        DFS(root, 0, 0, positions);
        return copyResults(positions);
    }

    private void calculateWidth(TreeNode node, int x) {
        if (node == null)
            return;
        leftMost = x < leftMost ? x : leftMost;
        rightMost = x > rightMost ? x : rightMost;
        calculateWidth(node.left, x - 1);
        calculateWidth(node.right, x + 1);
    }

    private void createSpace(List<List<NodePosition>> list) {
        for (int i = 0; i < (rightMost - leftMost + 1); i++) {
            list.add(new ArrayList<NodePosition>());
        }
    }

    private void DFS(TreeNode node, int x, int y, List<List<NodePosition>> positions) {
        if (node == null)
            return;
        positions.get(x - leftMost).add(new NodePosition(node.val, x, y));
        DFS(node.left, x - 1, y - 1, positions);
        DFS(node.right, x + 1, y - 1, positions);
    }

    private List<List<Integer>> copyResults(List<List<NodePosition>> pos) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < pos.size(); i++) {
            List<NodePosition> p = pos.get(i);
            Collections.sort(p);
            List<Integer> res = new ArrayList<>();
            for (NodePosition position : p) {
                res.add(position.val);
            }
            result.add(res);
        }
        return result;
    }

    private class NodePosition implements Comparable<NodePosition> {
        int val;
        int x;
        int y;

        public NodePosition(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(NodePosition pos) {
            if (y != pos.y)
                return pos.y - y;
            return x == pos.x ? val - pos.val : x - pos.x;
        }
    }
}