import java.util.LinkedList;

import org.w3c.dom.Node;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		TreeNode f =new TreeNode(6,null,null);
		TreeNode e =new TreeNode(5,null,null);
		TreeNode c =new TreeNode(3,null,null);
		TreeNode d= new TreeNode(4,e,f);
		TreeNode b= new TreeNode(2,d,null);
		TreeNode a= new TreeNode(1,b,c);*/
		//System.out.println(isBalanced2(a));
		

	}
	
	//Given a directed graph, find out whether there is a route between two nodes
	public enum State{
		Unvistied, Visited, Visiting;
	}
	
	public static boolean search2(Graph g, Vertex start, Vertex end){
		LinkedList<Vertex> q=new LinkedList<Vertex>();
		for(Vertex v:g.getVertices()){
			v.visited=false;
		}
		if(end==start)return true;
		start.visited=true;
		q.add(start);
		while(!q.isEmpty()){
			Vertex v=q.removeFirst();
			if(v!=null){
				for(Edge e=v.edges;e!=null;e=e.nextEdge){
					Vertex w=e.to;
					if(!w.visited){
						if(w==end)return true;
						w.visited=true;
						q.add(w);
					}
				}
			}
		}
		return false;
	}
	
	public static boolean search(Graph g, Node start, Node end){
		LinkedList<Node> q=new LinkedList<Node>();
		for(Node u: g.getNodes()){
			u.state=State.Unvistied;
		}
		start.state=State.Visiting;
		
		q.add(start);
		Node u;
		while(!q.isEmpty()){
			u=q.removeFirst();
			if(u!=null){
				for(Node v:u.getAdjacent()){
					if(v.state==State.Unvistied){
						if(v==end){
							return true;
						}else{
							v.state=State.Visiting;
							q.add(v);
						}
					}
				}
				u.state=State.Visited;
			}
			
		}
		return false;
				
	}


}
