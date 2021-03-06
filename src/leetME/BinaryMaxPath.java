public class BinaryMaxPath{
	public int maxPathSum(TreeNode root){
		int []res=new int[1];
		res[0]=Integer.MIN_VALUE;
		maxPath(root,res);
		return res[0];
		
	}
	public int maxPath(TreeNode root,int []res){
		if(root==null)return 0;
		int lval=maxPath(root.lchild,res);
		int rval=maxPath(root.rchild,res);
		int val=lval+rval+root.val;
		int valSingle=root.val+Math.max(rval,lval);
		res[0]=Math.max(res[0],Math.max(val,valSingle));
		return res[0];
		
	}
	
	
}
/* Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *
 *      1
 *     / \
 *    2   3
 * Return 6.
 */
/* For each node like following, there should be four ways existing for max path:
 * 1. Node only
 * 2. L-sub + Node
 * 3. R-sub + Node
 * 4. L-sub + Node + R-sub
 * Keep trace the four path and pick up the max one in the end.
 * 表示通过root节点能走到root的parent的最大和，这个值作为返回对象返给调用父函数  
 * 只有3中情况: 1 从左子树到root再到parent  
 * 2 从右子树到root再到parent  
 * 3 直接从root到parent  
 * 注意arch那条路是不可能走到parent，因为那条路已经经过root了，除非折回来重复走！但这是不允许的  
 * 返回以Node的终点的路径的和，但最大值可能是穿过Node的和 
 */