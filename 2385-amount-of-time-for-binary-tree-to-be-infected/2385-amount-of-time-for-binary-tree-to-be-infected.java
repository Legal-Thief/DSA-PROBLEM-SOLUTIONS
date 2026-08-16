class Solution {
    public int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }

        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        parentNode(root, null, map);

        TreeNode target = findTarget(root, start);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode num = q.remove();

                if (num.left != null && !visited.contains(num.left)) {
                    visited.add(num.left);
                    q.add(num.left);
                }


                if (num.right != null && !visited.contains(num.right)) {
                    visited.add(num.right);
                    q.add(num.right);
                }


                TreeNode p = map.get(num);

                if (p != null && !visited.contains(p)) {
                    visited.add(p);
                    q.add(p);
                }
            }

            if (!q.isEmpty()) {
                time++;
            }
        }

        return time;
    }

    public void parentNode(
        TreeNode root,
        TreeNode temp,
        HashMap<TreeNode, TreeNode> map
    ) {
        if (root == null) {
            return;
        }

        map.put(root, temp);

        parentNode(root.left, root, map);
        parentNode(root.right, root, map);
    }

    public TreeNode findTarget(TreeNode root, int start) {
        if (root == null) {
            return null;
        }

        if (root.val == start) {
            return root;
        }

        TreeNode left = findTarget(root.left, start);

        if (left != null) {
            return left;
        }

        return findTarget(root.right, start);
    }
}