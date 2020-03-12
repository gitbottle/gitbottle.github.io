package project2_files;

import java.util.ArrayList;
import java.util.List;

public class BinaryExpressionTree2 {
    private static final String DIGITS = "0123456789.";//added period 
    private static final String OPERATORS = "+-/*";
    private BinaryExpressionTree2() {} //to prevent initialization

    /**
     * Transforms a fully parenthesized infix expression into a postfix expression.
     * Only integers, whitespace, and the operators *, /, +, - are permitted.
     * May not detect that some inputs are invalid (and return equivalent nonsense).
     * @param infix a fully parenthesized arithmetic expression in infix notation
     * @return postfix expression
     */
    //infix to postfix
    public static String postfixFromInfix(String infix) throws IllegalArgumentException {
        String postfix = "";
        Stack<Character> charStack = new LinkedStack<>();
        for (int i = 0; i < infix.length(); i++) {
            if (infix.charAt(i) == '(') charStack.push('(');
            else if (infix.charAt(i) == ')')
            {
                while(charStack.top() != '(')
                    postfix = postfix + charStack.pop() + ' ';
                charStack.pop(); //pop off the '('
            }
            //checks to see if ___ is an operator
            else if(OPERATORS.indexOf(infix.charAt(i)) != -1)//if __ does not exist, it will be -1. Any number other than -1 shows that ___ does exist
            {
                charStack.push(infix.charAt(i));
            }
            //checks to see if ___ is digits
            else if(DIGITS.indexOf(infix.charAt(i)) != -1)
            {
                postfix = postfix + infix.charAt(i);
                //if character that comes right after this digit is NOT a number OR PERIOD, put white space in postfix
                if(DIGITS.indexOf(infix.charAt(i+1)) == -1)
                    postfix = postfix + " "; //add a space to separate integers
            }
            else if(infix.charAt(i)==' ') { } //allow and ignore whitespace in our expression
            else throw new IllegalArgumentException("Invalid character in infix expression");
        }
        if(!charStack.isEmpty()) throw new IllegalArgumentException("Invalid infix expression");
        return postfix;
    }

    /**
     * Constructs a LinkedBinaryTree from a postfix expression
     * @param postfix a valid postfix expression
     * @return a LinkedBinaryTree representing the expression
     * 
    Create a Stack
    Read next input symbol
    If the symbol is a numeric value or a variable, create a new expression tree with a single node representing the value/variable and push it into the stack.
    If the symbol is an operator, pop out two trees (T1 and T2) from the stack. Create a new tree with the operator as the root and T1 and T2 as two children. Push this new tree back into the stack.
    Repeat this procedure until the whole input is read.
    At the end, the stack will contain a single tree which would be the output. 
     */
    
    public static LinkedBinaryTree<String> constructExpressionTreeFromPostfix(String postfix)
            throws IllegalArgumentException
    {
        //master tree
    	Stack<LinkedBinaryTree<String>> treeStack = new LinkedStack<>();
        for(int i=0; i<postfix.length(); i++)
        {	//if it is a digit
            if(DIGITS.indexOf(postfix.charAt(i)) != -1) {
                String temp = "";
                		//while it is a digit OR A PERIOD - for numbers that are more than 1 digit. Like 45. Put 45 together in "temp"
                while (DIGITS.indexOf(postfix.charAt(i)) != -1) {
                    temp = temp + postfix.charAt(i);
                    i++;
                }
                //make a subree then add this number as the root
                LinkedBinaryTree<String> curr = new LinkedBinaryTree<>();
                
                curr.addRoot(temp);
                //then add to the master tree
                treeStack.push(curr);
            }
            else if(postfix.charAt(i) == ' ') {} //do nothing for whitespace
            //if it is an operator
            else if(OPERATORS.indexOf(postfix.charAt(i)) != -1)
            {
                //static method valueOf()returns a single character as a string
            	String operator = String.valueOf(postfix.charAt(i));
                //create a tree with the operator as a root
            	LinkedBinaryTree<String> curr = new LinkedBinaryTree<>();
                curr.addRoot(operator);
                //pop off the digit and make it a left subtree
                LinkedBinaryTree<String> treeRight = treeStack.pop(); 
                //pop off the next digit and make it a right subtree
                LinkedBinaryTree<String> treeLeft = treeStack.pop();
                //now attach these two digits to the operator root tree, curr
                curr.attach(curr.root(), treeLeft, treeRight);
                treeStack.push(curr);
            }
            else throw new IllegalArgumentException("Invalid postfix expression");
        }
        return treeStack.pop();
    }

    /**
     * Constructs a LinkedBinaryTree from a infix expression
     * @param infix a valid infix expression
     * @return a LinkedBinaryTree representing the expression
     */
    public static LinkedBinaryTree<String> constructExpressionTree(String infix)
        throws IllegalArgumentException
    {
        String postfix = postfixFromInfix(infix);
        return constructExpressionTreeFromPostfix(postfix);
    }

  


  
    /**
     * Returns a fully parenthesized infix expression
     * represented by the binary expression tree.
     * The binary expression tree is expected to contain only
     * integers (positive or negative) and the operators: +, -, /, *
     * @param tree a binary expression tree
     * @return infix expression represented by the tree
     */
    //tree to infix with parenthesis
    public static String infixExpressionFromTree(LinkedBinaryTree<String> tree)
    {
        //TODO for students
    	  StringBuilder sb= new StringBuilder();
    	sb.append(infixExpressionFromTreeHelper (tree.root(), tree));
             
        return sb.toString();  
    }
    
    
    public static StringBuilder infixExpressionFromTreeHelper (Position <String> p, LinkedBinaryTree<String> tree) {
    	StringBuilder infix= new StringBuilder();
    	if(tree.isInternal(p)) infix.append( "(");    	
    	if (tree.left(p)!=null)
    		infix.append(infixExpressionFromTreeHelper (tree.left(p), tree));
    	
    		infix.append (p.getElement());
    	
    	if (tree.right(p)!=null)
    		infix.append(infixExpressionFromTreeHelper (tree.right(p), tree));
    	
    	if (tree.isInternal(p)) infix.append( ")");
    	
    	return infix;
    	  	
    }
    
    /**
     * Evaluates and returns the value associated with a binary expression tree.
     * @param tree a binary expression tree
     * @return the value associated with the root
     */
    public static double valueOfExpressionTree(LinkedBinaryTree<String> tree)
    {
        //TODO for students
    	double value;
    	value = valueOfExpressionTreeHelper (tree.root (),tree);
    	
       
        return value;
    }

    public static double valueOfExpressionTreeHelper (Position <String> p, LinkedBinaryTree<String> tree) {
    	//if the node is the operator/internal. Operators are typically internal
    	if (tree.isInternal(p)) {
    		double value = 0;
    		double left = 0;
    		double right =0;
    		
    		if (tree.left(p)!=null)
    			left = valueOfExpressionTreeHelper (tree.left(p), tree);
    		if (tree.right(p)!=null)
    			right = valueOfExpressionTreeHelper (tree.right(p), tree);
    		
    		if (p.getElement().equals("+"))
    			value = value + left + right;
    		if (p.getElement().equals ("/"))
    			value = value + left/right;
    		if (p.getElement().equals ("*"))
    			value = value + left*right;
    		if (p.getElement().equals ("-"))
    			value = value + left-right;
    		
    		return value;
    	}else {
    		//if the node is a number. This will return numerical value for left or right nodes
    		return Double.parseDouble(p.getElement());
    	}
    }
    
    
}