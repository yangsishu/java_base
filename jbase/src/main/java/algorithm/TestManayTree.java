package algorithm;

public class TestManayTree {
	
	class ManayNode{
		int nodeId;
		int parentId;
		ManayNode[] nodes;
		Object obj;
		
		ManayNode(){
			
		}
		
        ManayNode(int nodeId,int parentId,Object obj,ManayNode[] nodes){
        	this.nodeId=nodeId;
        	this.parentId = parentId;
        	this.nodes = nodes;
        	this.obj = obj;
		}
	}

	public static void noRecursiv(ManayNode manayNode){
		
		
	}
	
	public static void recursiv(ManayNode manayNode){
		System.out.print(manayNode.obj);
		ManayNode[] nns  = manayNode.nodes;
		if(nns!=null){
			for(ManayNode node:nns){
				recursiv(node);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
