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
	//delegate the "normal" cases to BST_Node class
	 if (size == 0 || root == null) {
		root = new BST_Node(s);
		size++;
		return true;
	} else {
		size++;
		return root.insertNode(s);
	}	
}

@Override
public boolean remove(String s) {
	//delegate the "normal" cases to BST_Node class
	//case for when removing the root
	if(size <= 0 || root == null) {
		return false;
	}
	if (root.getData().compareTo(s) == 0) {
        BST_Node auxRoot = new BST_Node("");
        auxRoot.left = root;
        boolean result = root.removeNode(s, auxRoot);
        root = auxRoot.getLeft();
        size--;
        return result;
    } else {
		size--;
		return root.removeNode(s, null);
	}
}

@Override
public String findMin() {
	if (size <= 0) {
		return null;
	}
	return root.findMin().data;
}

@Override
public String findMax() {
	if (size <= 0) {
		return null;
	}
	return root.findMax().data;
}

@Override
public boolean empty() {
	if (size > 0) {
		return false;
	}
	return true;
}

@Override
public boolean contains(String s) {
	if (size == 0) {
		return false;
	}
	return root.containsNode(s);
}

@Override
public int size() { //works
	return size;
}

@Override
public int height() { //works
	if (size <= 0 || root == null) {
		return -1;
	} else {
		return root.getHeight(root);
	}
}

}