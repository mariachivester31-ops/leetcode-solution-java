class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> currentStack = new Stack<>();
        currentStack.add(root);
        
        boolean goRight = false;
        while (!currentStack.empty()) {
            List<Integer> nodeVals = new ArrayList<>();
            Stack<TreeNode> childrenStack = new Stack<>();
            
            while (!currentStack.empty()) {
                TreeNode node = currentStack.pop();
                if (goRight) {
                    if (node.right != null) childrenStack.add(node.right);
                    if (node.left != null) childrenStack.add(node.left);
                } else {
                    if (node.left != null) childrenStack.add(node.left);
                    if (node.right != null) childrenStack.add(node.right);
                }
                nodeVals.add(node.val);
            }
           
            result.add(nodeVals);
            goRight = !goRight;
            currentStack = childrenStack;
        }
        
        return result;
    }
}
