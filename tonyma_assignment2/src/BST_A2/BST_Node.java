package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations


  public boolean containsNode(String s){
	  int cmp = data.compareTo(s);
	  if(cmp == 0) {
		  return true;
	  }
	  if(cmp > 0 && left != null && left.containsNode(s)) {
		  return true;
	  }
	  if(cmp < 0 && right != null && right.containsNode(s)) {
		  return true;
	  }
	  return false;
	  
  }
  public boolean insertNode(String s){
	  BST_Node insert = new BST_Node(s);
	  if(s.compareTo(data) == 0) {
			return false;
	  } else if (s.compareTo(data) < 0) {
		  if (left == null) {
			  left = insert;
			  return true;
		  } else {
			  return left.insertNode(s);
		  }
	  } else {
		  if (this.right == null) {
			  this.right = insert;
			  return true;
		  } else {
			  return right.insertNode(s);
		  }
	  }
  }
  public boolean removeNode(String s, BST_Node parent){
	  if (containsNode(s)==false) {
			return false;
	  }
	  if (s.compareTo(data) < 0) { //one child removal
          if (left != null) {
        	  return left.removeNode(s, this);
          } else {
                return false;
          } 
	  } else if (s.compareTo(data) > 0) { //one child removal
          if (right != null) {
                return right.removeNode(s, this);
          } else {
                return false;
          }
     } else { //two child removal
          if (left != null && right != null) {
                data = right.findMin().data; //creating a duplicate node
                right.removeNode(data, this); //removing the duplicate node
          } else if (parent.left == this) {
                if (left != null) {
                	parent.left = left; //directly linking the parent's left to the left grandchild
                } else {
                	parent.left = right; //directly linking the parent's left to the right grandchild
                }
          } else if (parent.right == this) {
        	    if (left != null) {
              	    parent.right = left; //directly linking the parent's right to the left grandchild
                } else {
              	    parent.right = right; //directly linking the parent's right to the right grandchild
                }
          }
          return true;
    }
  }
  public BST_Node findMin(){ //done
	  BST_Node min = this;
		while (min.left != null) {
			min = min.left;
		}
		return min;
  }
  public BST_Node findMax(){ //done
	  BST_Node max = this;
		while (max.right != null) {
			max = max.right;
		}
		return max;
  }
  public int getHeight(BST_Node a){ //hard
	  
	  if (a == null) {
		  return -1;
	  } else {
		  int leftHeight = getHeight(a.left);
		  int rightHeight = getHeight(a.right);
		  
		  if (leftHeight > rightHeight) {
			  return leftHeight + 1;
		  } else {
			  return rightHeight + 1;
		  }
	  }
  }


  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}