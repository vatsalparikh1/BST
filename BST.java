package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

@Override
public boolean insert(String s) {
	if (root == null || root.data == null){
		root = new BST_Node(s);
		root.parent = null;
		size ++;
		return true;
	}else{
		if(root.insertNode(s)){
			size++;
			return true;
		}else{
			return false;
		}
	}
	
}

@Override
public boolean remove(String s) {
	if(root == null){
		return false;
	}else{
		if(root.removeNode(s, root)){
			size --;
			return true;
		}else{
			return false;
		}
	}
	
	//return false;
}

@Override
public String findMin() {
	if(root == null){
		return null;
	}else{
	return root.findMin().data;
	}
}

@Override
public String findMax() {
	if(root == null){
		return null;
	}else{
	return root.findMax().data;
	}
}

@Override
public boolean empty() {
	if(size == 0){
		return true;
	}else{
		return false;
	}
}

@Override
public boolean contains(String s) {
	if(root == null){
		return false;
	}else{
	return root.containsNode(s);
	}
}

@Override
public int size() {
	if(root == null){
		return 0;
	}else{
	return size;
	}
}

@Override
public int height() {
	if(size == 0 || root == null){
		return -1;
	}else{
		
	return root.getHeight();
	
	}
}

}
