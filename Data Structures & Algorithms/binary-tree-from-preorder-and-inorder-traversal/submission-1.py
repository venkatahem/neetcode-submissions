# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        self.preorderIndex = 0

        hashmap = {}

        for i in range(len(inorder)):
            hashmap[inorder[i]] = i

        return self.build(preorder, 0, len(inorder) - 1, hashmap)

    def build(
        self, preorder: List[int], left: int, right: int, hashmap: Dict[int, int]
    ) -> Optional[TreeNode]:

        if left > right:
            return None

        rootValue = preorder[self.preorderIndex]
        self.preorderIndex += 1

        root = TreeNode(rootValue)

        inorderIndex = hashmap[rootValue]

        root.left = self.build(preorder, left, inorderIndex - 1, hashmap)

        root.right = self.build(preorder, inorderIndex + 1, right, hashmap)

        return root
