package BST_A2;

public class BST_Playground {

  
  public static void main(String[]args){

	  
	  BST a = new BST();
	  	  

	 //Empty Test 1
	  
	  a.insert("B");
	  a.insert("A");
	  a.insert("D");
	  a.insert("C");
	  a.insert("E");
	  a.remove("B");
	  a.remove("A");
	  a.remove("D");
	  a.remove("C");
	  a.remove("E");
	  System.out.println("Empty: " + a.empty());
	  
	  
	  	  
	  
	  
	  System.out.println("Max: " + a.findMax());
	  System.out.println("Min: " + a.findMin());
	  System.out.println("Empty: " + a.empty());
	  System.out.println("size: " + a.size());
	  System.out.println("height: " + a.height());
	  System.out.println("Contains 'hat': " + a.contains("hat"));
	  
	  
	  System.out.print("Order: ");
	  printLevelOrder(a);
	  
	  
	  
 
  }

  
  static void printLevelOrder(BST tree){ 

    int h=tree.getRoot().getHeight();
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data + " ");
    //if(level==0)System.out.print("(" + root + ")");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
}
