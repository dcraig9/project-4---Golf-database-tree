// File: TreeBag.java 

// The implementation of most methods in this file is left as a student
// exercise from Section 9.5 of "Data Structures and Other Objects Using Java"


/******************************************************************************
* This class is a homework assignment;
* An <CODE>TreeBag</CODE> is a collection of int numbers.
*
* <dl><dt><b>Limitations:</b> <dd>
*   Beyond <CODE>Integer.MAX_VALUE</CODE> elements, <CODE>countOccurrences</CODE>,
*   and <CODE>size</CODE> are wrong. 
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @version
*   Jan 24, 2016
******************************************************************************/
public class TreeBag<E extends Comparable> implements Cloneable
{
   // The Term E extends Comparable is letting the compiler know that any type
   // used to instantiate E must implement Comparable. i. e. that means that whatever
   // type E is must have a compareTo method so that elements can be compared against one another
   // This is required becuase we are doing comparisons in our methods


   // Invariant of the TreeBag class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   private BTNode<E> root;   


   /**
   * Insert a new element into this bag.
   * @param <CODE>element</CODE>
   *   the new element that is being inserted
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new BTNode.
   **/
   public void add(E element)
   {      
      try{
         boolean notdone = true;
         //BTNode<E> cursor = new BTNode(root, null, null);
         BTNode<E> node = new BTNode<E>(element, null, null);
         
         if ( root == null ) 
         {
            root = node;
            //cursor.setData(element);
         }         
         else 
         {
            //cursor = root;
            BTNode<E> cursor = root;
            while (cursor!=null)
            {
               
               if(cursor.getData().compareTo(element) > 0)              
               {
                  if(cursor.getLeft() == null)
                  {
                     cursor.setLeft(node);;
                     cursor = null;
                  }
                  else
                  {
                     cursor = cursor.getLeft();
                  } 
               }
               else if(cursor.getData().compareTo(element) < 0)
               {
                  if(cursor.getRight() == null)
                  {
                     cursor.setRight(node);
                     cursor = null;
                  }
                  else
                  {
                     cursor = cursor.getRight();
                  }
               }  
            }//end while     
               
               //cursor.setData(element);
            
         }//end else      
      } 
      catch (OutOfMemoryError E){
         System.out.println("System is Out of Memory, Exiting...");
      }       
      
   }

   /**
   * Retrieve location of a specified element from this bag.
   * @param <CODE>target</CODE>
   *   the element to locate in the bag
   * @return 
   *  the return value is a reference to the found element in the tree
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then method returns
   *   a reference to a comparable element. If the target was not found then
   *   the method returns null.
   *   The bag remains unchanged.
   **/
   @SuppressWarnings("unchecked")
   public E retrieve(E target)
   {
      if (root != null)
      {
         boolean found= false;
         BTNode<E> cursor = root;
         while (!found && cursor!=null)
         {
            if (target.compareTo(cursor.getData()) < 0)
            {
				   cursor = cursor.getLeft();
            }
            else if (target.compareTo(cursor.getData()) > 0)
            {
               cursor = cursor.getRight();
            }
            else if (target.compareTo(cursor.getData()) == 0)
            {
               found = true;
               return cursor.getData();
            }
         }
         return null;
      }
      else
      {  
      return null;
      }
   }

   
   /**
   * Remove one copy of a specified element from this bag.
   * @param <CODE>target</CODE>
   *   the element to remove from the bag
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then one copy of
   *   <CODE>target</CODE> has been removed and the method returns true. 
   *   Otherwise the bag remains unchanged and the method returns false. 
   **/
   public boolean remove(E target)
   {
      // Student will replace this return statement with their own code:
      BTNode<E> cursor = root;
      BTNode<E> parentOfCursor = null;
      
      //parent is supposed to stay one behind cursor - how to do this while using retrieve?
      // does retrieve have to be redone?  retrieve seems to be for data only, doesn't return whole
      // BTNode.
      
      //following code from retrieve positions cursor at match 
      // needs a null situation where match is not found
     
         boolean found= false;
         
         while (!found && cursor!=null)
         {
            if (target.compareTo(cursor.getData()) < 0)
            {
				   parentOfCursor = cursor;
               cursor = cursor.getLeft();
            }
            else if (target.compareTo(cursor.getData()) > 0)
            {
               parentOfCursor = cursor;
               cursor = cursor.getRight();
            }
            else if (target.compareTo(cursor.getData()) == 0)
            {
               found = true;
            }
         }

      
      //cursor = cursor.retrieve(target);
            
      //case 1 cursor is null
      if ( cursor == null){
         return false;
      }   

      //case 2 cursor is at root of tree, no left child
      if ( cursor == root && cursor.getLeft() == null){
      
         root = root.getRight();
         return true;
      }   
       
      //case 3 cursor is farther down tree, no left child
      if ( cursor.getLeft() == null){
         
         if (cursor == parentOfCursor.getLeft()){
            
            parentOfCursor.setLeft( cursor.getRight() );
         }
         else {
            
            parentOfCursor.setRight( cursor.getRight() );
         }
         
         return true;
      }
                        
      //case 4 cursor non-null, and has a left child
      if (cursor.getLeft() != null){
      
         cursor.setData( cursor.getLeft().getRightmostData() );
         
         //remove extra rightmost copy
         
         cursor.setLeft( cursor.getLeft().removeRightmost() );
         
         return true;
      }    
      
      
            return false;
   }
   
   /**
   * Displays the entire tree of Node elements in a order specified
   * by the elements compareTo method
   * 
   * @param 
   *   none
   * <dt><b>Postcondition:</b><dd>
   *   Outputs all elements in the tree to Screen.
   *   Does not change the structure 
   **/
   public void display()
   {
      if (root == null)
      {
			System.out.println("There are no elements to display.");
		} 
      else
      {
         root.inorderPrint();
      }     
   } 
   
   /**
   * Displays the entire tree of Node elements in a order specified
   * by the elements compareTo method. 
   * 
   * @param 
   *   none
   * <dt><b>Postcondition:</b><dd>
   *   Outputs all elements in the tree to Screen.
   *   Does not change the structure 
   **/
   public void sendToFile()
   {
      if (root == null)
      {
			System.out.println("There are no elements to display.");
		} 
      else
      {
         root.postorderPrint();
      }     
   } 
     
   /**
   * Displays the entire tree of Node elements using the
   * built in print method of BTNode
   * which displays the entire tree in tree format
   * 
   * @param 
   *   none
   * <dt><b>Postcondition:</b><dd>
   *   Outputs all elements in the tree to Screen.
   *   Does not change the structure 
   **/   
   public void displayAsTree() {
      root.print(0);
   }
             
   /**
   * Count the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/                           
   public int size( )
   {
      return BTNode.treeSize(root);
   }

   //========================================= beyond this line not implemented in this project
   /**
   * Generate a copy of this bag.
   * @param - none
   * @return
   *   The return value is a copy of this bag. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to an <CODE>TreeBag</CODE> before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public TreeBag<E> clone( )
   {  // Clone an IntTreeBag object.
      // Not implemented for this project
      return null; 
   } 

   /**
   * Add the contents of another bag to this bag.
   * @param <CODE>addend</CODE>
   *   a bag whose contents will be added to this bag
   * <dt><b>Precondition:</b><dd>
   *   The parameter, <CODE>addend</CODE>, is not null.
   * <dt><b>Postcondition:</b><dd>
   *   The elements from <CODE>addend</CODE> have been added to this bag.
   * @exception IllegalArgumentException
   *   Indicates that <CODE>addend</CODE> is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of the bag.
   **/
   public void addAll(TreeBag<E> addend)
   {
      // Not implemented for this project
   }
   
   /**
   * Create a new bag that contains all the elements from two other bags.
   * @param <CODE>b1</CODE>
   *   the first of two bags
   * @param <CODE>b2</CODE>
   *   the second of two bags
   * <dt><b>Precondition:</b><dd>
   *   Neither b1 nor b2 is null.
   * @return
   *   the union of b1 and b2
   * @exception IllegalArgumentException
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new bag.
   **/   
   public static TreeBag union(TreeBag b1, TreeBag b2)
   {
      // Not implemented for this project
      return null;
   }
   
   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   * @param <CODE>target</CODE>
   *   the element that needs to be counted
   * @return
   *   the number of times that <CODE>target</CODE> occurs in this bag
   **/
   public int countOccurrences(E target)
   {
      // Not implemented for this project
      return 0;
   }
      
} 
           