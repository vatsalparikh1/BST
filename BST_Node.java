package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  BST_Node parent;
  
  BST_Node(String data){ this.data=data; }



  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  

  
  	public boolean containsNode(String s){
  		
  		if(this.data == null){
  			return false;
  		}else if(s.compareTo(this.data) == 0){
  			return true;
  		} else if(s.compareTo(this.data) < 0 && this.left != null){
  			return this.left.containsNode(s);
  		}else if(s.compareTo(this.data) > 0 && this.right != null){
  			return this.right.containsNode(s);
  		}else{
  			return false;
  		}
  	
  	}
  public boolean insertNode(String s){ 
	  
	  BST_Node temp = this;
	 
		 
		 if(s.compareTo(temp.data) < 0.0 && temp.left != null){
			 return temp.left.insertNode(s);
		 } else if (s.compareTo(temp.data) > 0.0 && temp.right != null){
			 return temp.right.insertNode(s);
		 }else {
				if (s.compareTo(temp.data) < 0.0) {
					BST_Node newNode = new BST_Node(s);
					temp.left = newNode;
					newNode.parent = temp;
					
					return true;
				} else if (s.compareTo(temp.data) > 0.0) {
					BST_Node newNode = new BST_Node(s);
					temp.right = newNode;
					newNode.parent = temp;
					return true;
				} else {
					return false;
				}
			}
			 
		  
  }
  public boolean removeNode(String s, BST_Node n){ //in progress
	  

	  
	  if(!n.containsNode(s)){
		  return false;
	  }else{
		 
			 if((s.compareTo(n.data) < 0.0) && (n.left != null)){
			  return removeNode(s,n.left); 
			  
		 }else if ((s.compareTo(n.data) > 0.0) && (n.right != null)){
			 return removeNode(s,n.right);
			 
			 
		 } else {
			 
			 if ((n.left == null) && (n.right == null)){ //no children (leaf)
				 
				 if(n.parent == null){ 
					 n.data = null;
				 }else if(n == n.parent.left){
					 n.parent.left = null;
				 }else if(n == n.parent.right){
					 n.parent.right = null;
				 }
				 
				 System.out.println("no children case");
				 return true;
				 
			 }else if((n.left != null) && (n.right == null)){//one child, left of n
				 
				 if(n.parent == null){//at root
					 
					 BST_Node leftNode = n.left;
					 n.data = leftNode.data;
					 n.left = leftNode.left;
					 n.right = leftNode.right;
					 
					 if(leftNode.left != null){
						 leftNode.left.parent = n;
					 }
					 if(leftNode.right != null){
						 leftNode.right.parent = n;
					 }
				 
					 
					 
				 }else if(n.parent.left == n){//left of parent
					 n.parent.left = n.left;
					 n.left.parent = n.parent;
				 }else if(n.parent.right == n){//right of parent
					 n.parent.right = n.left;
					 n.left.parent = n.parent;
				 }
				 
				 System.out.println("one child (left)");
				 return true;
				 
			 }else if((n.left == null) && (n.right != null)){//one child, right of n
				 
				 if(n.parent == null){//at root
					 BST_Node rightNode = n.right;
					 
					 n.data = rightNode.data;
					 n.left = rightNode.left;
					 n.right = rightNode.right;
					 
					 if(rightNode.right != null){//check to see if child has a right
					 rightNode.right.parent = n; 
					 }
					 if(rightNode.left != null){//check to see if child has a left
					 rightNode.left.parent = n;
					 }
					  
				 }else if(n.parent.left == n){//left of parent
					 n.parent.left = n.right;
					 n.right.parent = n.parent;
				 }else if(n.parent.right == n){//right of parent
					 n.parent.right = n.right;
					 n.right.parent = n.parent;
				 }
				 
				 System.out.println("one child (right)");
				 return true;
				 
			 }else{//two children
				 
				 if(n.parent == null){//n is root node
				
					 BST_Node temp = n.right;
				 	
					 while(temp.left != null){
				 		temp = temp.left;
				 	 }
					 
					 //temp has now reached min value right of n
					 
					 
					 if(temp.parent == n){//if min after deletion(n) is n.right
						 n.data = temp.data;
						 n.right = temp.right;
						 temp.right.parent = n;
						 
						 
					 }else{//min after deletion(n) is a left node
					 
						 if(temp.right != null){//min.right != null
							 temp.parent.left = temp.right;
							 temp.right.parent = temp.parent; 
						 }else{					//min.right == null
							 temp.parent.left = null;
						 }
					 
						 n.data = temp.data;
						 
					 
					 }
					 		 
					 
					 
				 }else if(n.parent.left == n){ // n left of parent
					 
					 BST_Node temp = n.right;
					 
					 while(temp.left != null){
						 temp = temp.left;
					 }
					 //temp has now reached min value right of n
					 
					 if(temp.parent == n){ //if min after deletion(n) is n.right
						 temp.parent = n.parent;
						 temp.left = n.left;
						 n.parent.left = temp;
						 n.left.parent = temp;
						 
						 
					 }else{//min after deletion(n) is a left node
						 
						 if(temp.right != null){//min.right != null
							 temp.parent.left = temp.right;
							 temp.right.parent = temp.parent; 
						 }else{					//min.right == null
							 temp.parent.left = null;
						 }
					 
						 temp.parent = n.parent;
						 temp.left = n.left;
						 temp.right = n.right;
						 n.left.parent = temp;
						 n.right.parent = temp;
					 
						 n.parent.left = temp;
						 //n = null;
					 }
					 
				 } else if(n.parent.right == n){//n right of parent
					 
					 BST_Node temp = n.right;
					 
					 while(temp.left != null){
						 temp = temp.left;
					 }
					 //temp has now reached min value right of n
					 
					 
					 if(temp.parent == n){//if min after deletion(n) is n.right
						 
						 temp.parent = n.parent;
						 temp.left = n.left;
						 n.parent.right = temp;
						 n.left.parent = temp;
						 
					 }else{//min after deletion(n) is a left node
					 
						 if(temp.right != null){//min.right != null
							 temp.parent.left = temp.right;
							 temp.right.parent = temp.parent; 
						 }else{					//min.right == null
							 temp.parent.left = null;
						 }
					 
						 temp.parent = n.parent;
						 temp.left = n.left;
						 temp.right = n.right;
						 n.left.parent = temp;
						 n.right.parent = temp;
					 
						 n.parent.right = temp;
						 //n = null;
					 
					 }
					  
				 }
				 
				 System.out.println("two children case");
				 return true;
				 	 
				 
			 }
			 		 
			 
		 }	  
	  
	  }
	  
	  
  }
  public BST_Node findMin(){ 
	  
	  BST_Node temp = this;
	  
	  while(temp.left != null){
		  temp = temp.left;
	  }
	  
	  return temp;
	  
  }
 public BST_Node findMax(){ 
	 
	 BST_Node temp = this;
	 
	 while (temp.right != null){
		 temp = temp.right;
	 }
	 return temp;
}
 public int getHeight(){ 
	 
	 int divideLeft = 0;
	 int divideRight = 0;
	 
	 if(right != null){
		 divideRight = right.getHeight() + 1;
	 }
	 if(left != null){
		 divideLeft = left.getHeight() + 1;
	 }
	  
	 if(divideLeft >= divideRight){
		 return divideLeft;
	 }else{
		 return divideRight;
	 }
	 
}
  
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}
