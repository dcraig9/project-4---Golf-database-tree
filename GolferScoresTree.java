/********************************************************************************************
* File: GolferScoresTree.java
* Golfer class simulates a Golfer and his related scores(name, average, rounds played, handicap)
*
* Authors: Donald Craig and Joe Eckstein
* Date: 04/20/2018
*
********************************************************************************************/

import java.util.*;

class GolferScoresTree { 

   public static void main(String [] args) throws IOException {

      String lastName;
      int numRounds = 0;
      int handicap = 0;
      double average = 0.0;
      
      File text = new File ("golferinfo.txt");
      
      if (text.exists()) {
         System.out.println("File exists already - we can read it");
      }else {
         text.createNewFile();   
      }

      Scanner read = new Scanner(text);
      
      // read in data, assign it to a golfer object, place object in tree?
      while(read.hasNext()){
         lastName = read.next();
         numRounds = read.nextInt();
         handicap = read.nextInt();
         average = read.nextDouble();
         
         Golfer one = new Golfer(lastName, numRounds, average, handicap);
      
         // add this to tree bag, and clear it and repeat until all golfers are in tree.
         
      }
         
         
   
      System.out.println(" Thank you for coming to the tournament!  Here are the things you can do with our statistics: ");
      System.out.println();
      
      System.out.println(" 1. Display listing to screen of all golfers stats(ordered by lastname)");
      System.out.println(" 2. Display the golfers in current tree format(Use displayAsTree )");
      System.out.println(" 3. Find and display one individual golfers stats");
      System.out.println(" 4. Update an individual golfers stats(by adding an additional score)");
      System.out.println(" 5. Remove a golfer from the Database");
      System.out.println(" 6. Add a new golfer to the Database");
      System.out.println(" 7. Quit and update datafile");

   
   
   
   
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
}
     