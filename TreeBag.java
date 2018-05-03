/******************************************************************************
* File: TreeBag.java 
* CSC 103 Data Structures - Project #4
*
* Authors: Donald Craig and Joe Eckstein
* Date: 04/20/2018
******************************************************************************/
// The implementation of most methods in this file is left as a student
// exercise from Section 9.5 of "Data Structures and Other Objects Using Java"


/******************************************************************************
* This class is a homework assignment;
* Note:
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for students.
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
   * @param element
   *   the new element that is being inserted
   * Postcondition:
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new BTNode.
   **/
   public void add(E element)
   {      
      try{
         boolean notdone = true;
         BTNode<E> node = new BTNode<E>(element, null, null);
         
         if ( root == null ) 
         {
            root = node;           
         }         
         else 
         {
            
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
                         
         }//end else      
      } 
      catch (OutOfMemoryError E){
         System.out.println("System is Out of Memory, Exiting...");
      }       
      
   }

   /**
   * Retrieve location of a specified element from this bag.
   * @param target
   *   the element to locate in the bag
   * @return 
   *  the return value is a reference to the found element in the tree
   * Postcondition:
   *   If target was found in the bag, then method returns
   *   a reference to a comparable element. If the target was not found then
   *   the method returns null.
   *   The bag remains unchanged.
   **/
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
   * @param target
   *   the element to remove from the bag
   * @return
   *    true if target found and removed
   *    false if target not found
   * Postcondition:
   *   If target was found in the bag, then one copy of
   *   target has been removed and the method returns true. 
   *   Otherwise the bag remains unchanged and the method returns false. 
   **/
   public boolean remove(E target)
   {
      
      BTNode<E> cursor = root;
      BTNode<E> parentOfCursor = null;
          
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
            
      //case 1 cursor is null
         if ( cursor == null)
         {
            return false;
         }   

      //case 2 cursor is at root of tree, no left child
         if ( cursor == root && cursor.getLeft() == null)
         {
            root = root.getRight();
            return true;
         }   
       
      //case 3 cursor is farther down tree, no left child
         if ( cursor.getLeft() == null)
         {
            if (cursor == parentOfCursor.getLeft())
            {
               parentOfCursor.setLeft( cursor.getRight() );
            }
            else 
            {
               parentOfCursor.setRight( cursor.getRight() );
            }
            return true;
         }
                        
      //case 4 cursor non-null, and has a left child
         if (cursor.getLeft() != null)
         {
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
   * Postcondition:
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
   * Displays the entire tree of Node elements using the BTNode
   * postorderPrint method. 
   * 
   * @param 
   *   none
   * Postcondition:
   *   Outputs all elements in the tree.
   *   Does not change the structure. 
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
   * Postcondition:
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

   //========================================= Beyond this line not implemented in this project
   /**
   * Generate a copy of this bag.
   * @param - none
   * @return
   *   The return value is a copy of this bag. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to an TreeBag before it can be used.
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
   * @param addend
   *   a bag whose contents will be added to this bag
   * Precondition:
   *   The parameter, addend, is not null.
   * Postcondition:
   *   The elements from addend have been added to this bag.
   * @exception IllegalArgumentException
   *   Indicates that addend is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of the bag.
   **/
   public void addAll(TreeBag<E> addend)
   {
      // Not implemented for this project
   }
   
   /**
   * Create a new bag that contains all the elements from two other bags.
   * @param b1
   *   the first of two bags
   * @param b2<
   *   the second of two bags
   * Precondition:
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
   * @param target
   *   the element that needs to be counted
   * @return
   *   the number of times that target occurs in this bag
   **/
   public int countOccurrences(E target)
   {
      // Not implemented for this project
      return 0;
   }
      
} 
           