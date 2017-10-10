/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
int[] concat(int[] a, int[] b) {
   int aLen = a.length;
   int bLen = b.length;
   int[] c= new int[aLen+bLen];
   System.arraycopy(a, 0, c, 0, aLen);
   System.arraycopy(b, 0, c, aLen, bLen);
   return c;
}
int[] BST_to_array(Node root) {
  if(root.left == null && root.right == null){
    int arr[] = new int[1];
    arr[0] = root.data;
    return arr;
  }
  else if(root.left == null){
    int arr[]=new int[1];
    arr[0] = root.data;
    return concat(arr, BST_to_array(root.right));
  }
  else if(root.right == null){
    int arr[]=new int[1];
    arr[0] = root.data;
    return concat(BST_to_array(root.left), arr);
  }
  else{
    int arr[]=new int[1];
    arr[0] = root.data;
    return concat(concat(BST_to_array(root.left), arr), BST_to_array(root.right));
  }
}
boolean is_sorted(int arr[]){
  boolean sorted = true;
  int len = arr.length;
  for(int i = 0; i<len-1; i++){
    if(arr[i] >= arr[i+1]) {
      sorted = false;
    }
  }
  return sorted;
}
boolean checkBST(Node root) {
  int a[] = BST_to_array(root);
  return is_sorted(a);
}
