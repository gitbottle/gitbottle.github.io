package project2_files;

public class TreeTest1 {
    public static void main(String[] args)
    {
        //create and fill up our tree
        LinkedBinaryTree<String> binaryTree = BinaryExpressionTree2.constructExpressionTree ("(((3.4/3)*9.7)+(2.1-1.5))");
        
   
       
      System.out.println(BinaryExpressionTree2.infixExpressionFromTree(binaryTree));
      System.out.println (BinaryExpressionTree2.valueOfExpressionTree(binaryTree));
        
        
    }
    
   
}
