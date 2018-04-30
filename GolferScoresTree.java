/********************************************************************************************
* File: GolferScoresTree.java
* Golfer class simulates a Golfer and his related scores(name, average, rounds played, handicap)
*
* Authors: Donald Craig and Joe Eckstein
* Date: 04/20/2018
*
********************************************************************************************/

import java.util.*;
import java.io.*;

class GolferScoresTree { 

   public static void main(String [] args) throws IOException 
   {

      String lastName;
      int menu=0;
      int numRounds = 0;
      int handicap = 0;
      double average = 0.0;
      boolean done=false;
      Golfer dGolfer;
      
      TreeBag<Golfer> golferTree = new TreeBag();  //treebag to hold all of the golfers
      
      
      File text = new File ("golferinfo.txt");
      
      if (text.exists()) {
         System.out.println("File exists already - we can read it");
      }else {
         text.createNewFile();   
      }

      Scanner read = new Scanner(text);
      
      int counter=0;
      // read in data, assign it to a golfer object, place object in tree?
      while(read.hasNext())
      {
         lastName = read.next();
         numRounds = read.nextInt();
         handicap = read.nextInt();
         average = read.nextDouble();
         
         Golfer one = new Golfer(lastName, numRounds, average, handicap);
         
         golferTree.add(one);
         counter++;
         System.out.println("Added golfer #" + counter + " from data file");  // ===========================test print for tracking adds.
                                                                              // =========================== remove before submitting project
         // add this to tree bag, and clear it and repeat until all golfers are in tree.
         
      }
      read.close();  //close file stream after done reading   - DC
         
   
      System.out.println(" Thank you for coming to the tournament!  Here are the things you can do with our statistics: ");
      System.out.println();
      
      while (!done)
      {
         System.out.println();
         System.out.println(" 1. Display listing to screen of all golfers stats(ordered by lastname)");
         System.out.println(" 2. Display the golfers in current tree format(Use displayAsTree )");
         System.out.println(" 3. Find and display one individual golfers stats");
         System.out.println(" 4. Update an individual golfers stats(by adding an additional score)");
         System.out.println(" 5. Remove a golfer from the Database");
         System.out.println(" 6. Add a new golfer to the Database");
         System.out.println(" 7. Quit and update datafile");
      
         menu=getMenu();
               
         switch(menu)
         {
            case 1:  if (golferTree.size()>0)
                     {
                        System.out.println("Name         Rounds  Handicap  Average");
                        System.out.println("======================================");
                        golferTree.display();
                     }
                     else
                        System.out.println("There are currently no golfers to display.");
                     break;
            case 2:  //
                     break;
            case 3:  displayGolfer(golferTree);
                     break;
            case 4:  updateGolfer(golferTree);
                     break;
            case 5:  removeGolfer(golferTree);
                     break;
            case 6:  Golfer newGolfer = new Golfer();
                     newGolfer = addNewGolfer(newGolfer);
                     golferTree.add(newGolfer);
                     break;
            case 7:  //stuff
                     //call routine to write all golfer info to txt file
                     done=true;
                     break; 
         }//end switch 
      }//end while                            
   
   }//end main
   
   public static int getMenu() // gets valid menu choice
   {
      int choice=0;
      boolean valid=false;
      while (!valid)
      {
         System.out.print("Choice (1-7) :");
         choice=getInt();
         System.out.println();
         if (choice>=1 && choice<=7)
            valid=true;
         else
            System.out.println("Choice must be from 1 to 7");
      }
      return choice;
   }
   
   public static int getInt( )           //dedicated method to get an integer as input
   {
      Scanner numScan = new Scanner(System.in);
      int input=0;
      boolean valid=false;
      while(!valid)
      {
         try
         {         
            input=numScan.nextInt();
            if (input<=0) 
            {
               valid = false;
               throw new Exception("Value must be positive.");
            }
            else
            {
               valid = true;
            }  
         }
         catch (InputMismatchException e) 
         {
            System.out.println("Invalid entry, must be an integer.");
            numScan.next();
         }
         catch (Exception e) {
            System.out.println(e.getMessage() );
         }
      }
      return input; 
   }//end getInt
   
   public static double getDbl( )           //dedicated method to get a double as input
   {
      Scanner numScan = new Scanner(System.in);
      double input=0;
      boolean valid=false;
      while(!valid)
      {
         try
         {         
            input=numScan.nextDouble();
            if (input<=0) 
            {
               valid = false;
               throw new Exception("Value must be positive.");
            }
            else
            {
               valid = true;
            }  
         }
         catch (InputMismatchException e) 
         {
            System.out.println("Invalid entry, must be a double.");
            numScan.next();
         }
         catch (Exception e) {
            System.out.println(e.getMessage() );
         }
      }
      return input; 
   }//end getDbl
   
   public static void displayGolfer(TreeBag golferTree)     //========== method to find an individual golfer and display his stats
   {
      //get desired name to look for
      //retrieve from treebag (if it exists)
      //print Golfer and stats to screen is retrieve worked
      //otherwise let user know golfer wasn't found
      Golfer dGolfer;
      Scanner scan = new Scanner(System.in);
      String name;
      System.out.print("Last name of golfer to retrieve : ");
      name = scan.next();
      dGolfer = (Golfer)golferTree.retrieve(new Golfer(name));
		if (dGolfer != null)
      {
         System.out.println();
			System.out.println("Name         Rounds  Handicap  Average");
         System.out.println("======================================");
         System.out.println(dGolfer.toString());
		}
      else 
      {
         System.out.println("\nNo golfer with the name " + name + " could be found!");
      }
   
   }//end displayGolfer
   
   public static void updateGolfer(TreeBag golferTree) //update # of rounds and average score for target golfer
   {
      int newScore=0;
      Golfer dGolfer;
      Scanner scan = new Scanner(System.in);
      String name;
      System.out.print("Last name of golfer to update : ");
      name = scan.next();
      dGolfer = (Golfer)golferTree.retrieve(new Golfer(name));
		if (dGolfer != null)
      {
			System.out.print("\nEnter new score to add for this player : ");
         newScore=getInt();
         dGolfer.addNewScore(newScore);
         System.out.print("\nPlayer updated.");
		}
      else 
      {
         System.out.println("\nNo golfer with the name " + name + " could be found!");
      }
   
   
   }//end updateGolfer
   
   
   public static Golfer addNewGolfer(Golfer newGolfer)
   {
      Scanner scan = new Scanner(System.in);
      String name;
      int numRounds = 0;
      int handicap = 0;
      double average = 0.0;
      System.out.println();
      System.out.println("Enter information for the new player.");
      System.out.println("=====================================");
      System.out.print("Last name of new golfer : ");
      name = scan.next();
      System.out.println();
      System.out.print("Number of rounds they have played : ");
      numRounds=getInt();
      System.out.println();
      System.out.print("Player Handicap : ");
      handicap=getInt();
      System.out.println();
      System.out.print("Player Average : ");
      average=getDbl();
      newGolfer.setName(name);
      newGolfer.setRounds(numRounds);
      newGolfer.setAverage(average);
      newGolfer.setHandicap(handicap);
      return newGolfer;
   }//end addNewGolfer
   
   public static void removeGolfer(TreeBag golferTree) //remove found Golfer entry from tree
   {
      boolean removed = false;
      Golfer dGolfer;
      Scanner scan = new Scanner(System.in);
      String name;
      System.out.print("Last name of golfer to remove : ");
      name = scan.next();
      dGolfer = (Golfer)golferTree.retrieve(new Golfer(name));
		if (dGolfer != null) //retrieve works
      {
         removed = golferTree.remove(new Golfer(name));
         if ( removed )
         {
            System.out.print("\nGolfer " + name + " found and removed. ");
         }                         
		}
      else 
      {
         System.out.println("\nNo golfer with the name " + name + " could be found!");
      }
   
   
   }//end removeGolfer
   
   
}
     