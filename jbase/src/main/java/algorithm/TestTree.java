package algorithm;

public class TestTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node n0 = new Node("n0"),
		 n1 = new Node("n1"),
		 n2 = new Node("n2"),
		 n3 = new Node("n3"),
		 n4 = new Node("n4"),
		 n5 = new Node("n5"),
		 n6 = new Node("n6");
		 n0.left = n1;
		 n0.right=n2;
		 n1.left=n3;
		 n1.right=n4;
		 n2.left=n5;
		 n2.right=n6;
		 noInRecursive(n0);
	}

	/**
	 * 先序递归
	 * @param node
	 */
	public static void preRecursive(Node node){
		if (node.o!=null) System.out.print(node.o);
		if (node.left!=null) preRecursive(node.left);
		if (node.right!=null) preRecursive(node.right);
	}
	

	/**
	 * 中序递归
	 * @param node
	 */
	public static void inRecursive(Node node){
		if (node.left!=null) inRecursive(node.left);
		if (node.o!=null) System.out.print(node.o);
		if (node.right!=null) inRecursive(node.right);
	}
	

	/**
	 * 后序递归
	 * @param node
	 */
	public static void endRecursive(Node node){
		if (node.left!=null) endRecursive(node.left);
		if (node.right!=null) endRecursive(node.right);
		if (node.o!=null) System.out.print(node.o);
	}

	/**
	 * 非递归先序 节点数不超过32
	 */
	public static void noPreRecursive(Node node){
		Node[] nodes = new Node[32];
		Node parent = node;
		int index =0;
		while(parent!=null||index>0){
			while(parent!=null){
		          System.out.print(parent.o);
		          nodes[index++] = parent;
		          parent = parent.left;
			}
			parent =nodes[--index];
			parent = parent.right;
		}
	}
	
	/**
	 * 非递归中序 节点数不超过32
	 */
	public static void noInRecursive(Node node){
		Node[] nodes = new Node[32];
		Node parent = node;
		int index =0;
		while(parent!=null||index>0){
			while(parent!=null){
		          nodes[index++] = parent;
		          parent = parent.left;
			}
			parent =nodes[--index];
	        System.out.print(parent.o);
			parent = parent.right;
		}
	}
	
	
	/**
	 * 非递归后序 节点数不超过32
	 */
	public static void noEndRecursive(Node node){
		Node[] nodes = new Node[32];
		Node parent = node;
		Node lastVisit = null;
		int index =0;
		while(parent!=null||index>0){
			while(parent!=null){
		          nodes[index++] = parent;
		          parent = parent.left;
			}
			parent=nodes[index-1];
			if(parent.right==null||parent.right==lastVisit){
				System.out.print(parent.o);
				lastVisit = parent;
				index--;
				parent = null;
			}
			else
			{
				parent = parent.right;
			}
		}
	}
}