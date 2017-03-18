/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreedemo;

/**
 *
 * @author cody
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
   This class implements a binary search tree.
*/

public class BinarySearchTree
{    
     private class Node
    {
        String  value;          // Value stored in node
        Node left, right;    // Left and right child      
        
        /**
           Constructor for leaf nodes.
           @param val The value to store in the node.
        */
        
        Node(String val)
        {
            value = val;
            left = null;
            right = null;
        }   
        
        /** 
           Constructor for non-leaf nodes.
           @param val The value to initialize the node.
           @param leftChild The link to the left child.
           @param rightChild The link to the right child.
        */

        Node(String val, Node leftChild, Node rightChild)
        {
            value = val;
            left = leftChild;
            right = rightChild;
        }
    }
    
    /**
       The BTreeDisplay class graphically displays trees
       in a JPanel. The JPanel is recursively partitioned
       Stringo a top part dislaying the root, and two lower 
       parts displaying the left and right subtrees.
    */
    
    private class BTreeDisplay extends JPanel
    {
        /**
           Constructor.
           @param tree The root of the binary 
			  tree to display.
        */
        
        BTreeDisplay(Node tree)
        {           
           setBorder(BorderFactory.createEtchedBorder());
           setLayout(new BorderLayout());
           if (tree != null) 
           {          
               String value = (tree.value);  
               int pos = SwingConstants.CENTER;
               JLabel rootLabel = new JLabel(value, pos);                         
               add(rootLabel, BorderLayout.NORTH);
               JPanel panel = new JPanel(new GridLayout(1, 2));
               panel.add(new BTreeDisplay(tree.left));
               panel.add(new BTreeDisplay(tree.right));    
               add(panel);
           }       
        }   
    }
   

    private Node root = null;   // Root of binary tree    
    private Node vw = null;
   /**
      The getView method creates and returns a 
      a graphical view of the binary tree.
      @return A panel that displays a view of the tree.
    */

    public JPanel getView()
    {
       return new BTreeDisplay(root);       
    }    
    
    
    /**
       The add method adds a value to the search tree.
     * @param x
     * @param y
       @x the value to add.
       @return The root of the resulting 
		 binary search tree.
    */  
    
    public boolean left(String x,String y)
    {
        root =  left(x, y, root);
        return true;
    }
    
    private Node left(String x,String y, Node bstree)
    {
        if (bstree.value.equals(x))
        {
            if(bstree.left == null)
            {bstree.left = new Node(y);}
            else {return bstree;}
        }
        // bstree is not null. 
        else
        {
            if(bstree.left != null)
            bstree.left = left(x,y,bstree.left);
            if(bstree.right != null)
            bstree.right = left(x,y,bstree.right);
        }
        return bstree;
    }
    
    public boolean right(String x,String y)
    {
        root =  right(x, y, root);
        return true;
    }
    
    private Node right(String x,String y, Node bstree)
    {
        if (bstree.value.equals(x))
        {
            if(bstree.right == null)
            {bstree.right = new Node(y);}
            else {return bstree;}
        }
        // bstree is not null. 
        else
        {
            if(bstree.left != null)
            bstree.left = right(x,y,bstree.left);
            if(bstree.right != null)
            bstree.right = right(x,y,bstree.right);
        }
        return bstree;
    }
    
    
    
    
    public boolean root(String x)
    {
        root =  root(x, root);
        vw = root;
        return true;
    }
   
    
    private Node root(String x, Node bstree)
    {
        if (bstree == null)
            return new Node(x);
        // bstree is not null. 
        
        return bstree;
    }
    
}