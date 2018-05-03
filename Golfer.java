/********************************************************************************************
* File: Golfer.java
* Golfer class simulates a Golfer and his related scores(name, average, rounds played, handicap)
*
* Authors: Donald Craig and Joe Eckstein
* Date: 04/17/2018
*
********************************************************************************************/

import java.util.Formatter;

class Golfer implements Comparable<Golfer>
{


   private String lastName;
   private int numberOfRounds;
   private double averageScore;
   private int handicap;

   /**
   * Initialize a Golfer with empty name and stats
   * @param - none
   * @postcondition - new Golfer with null values is created.
   * 
   **/
   public Golfer()
   {
      //default constructor
   }

   /**
   * Initialize a Golfer with name, rounds played, average score, and handicap
   * @param name
   *     Golfer's last name (String)
   * 
   * @param rounds
   *     Number of rounds played (integer)    
   *    
   * @param avg
   *     Average score for all of the rounds played (double)
   *    
   * @param cap
   *     Golfer's Handicap (integer)
   **/
   public Golfer(String name, int rounds, double avg, int cap)
   {
      lastName = name;
      numberOfRounds = rounds;
      averageScore = avg;
      handicap = cap;  
   }

   /**
   * Initialize a Golfer with only a last name. All stats set to zero.
   * Used for compareTo operations where a target is required.
   * @param name
   *     Last name entered as a String.
   * 
   **/   
   public Golfer(String name)
   {
      this(name,0,0,0);
   }
   
   /**
   * Accessor method getName()   
   * @param - none
   * @return lastName (String)
   *   
   **/
   public String getName()
   {
      return lastName;
   }
   
   /**
   * Modification method setName(
   * @param - name (String)
   * @postcondition - last name of golfer is changed
   **/   
   public void setName(String name)
   {
      lastName = name;
   }
   
   /**
   * Accessor method getRounds()  
   * @param - none
   * @return - integer
   *   
   **/   
   public int getRounds()
   {
      return numberOfRounds;
   }
   
   /**
   * Modification method setRounds( int )
   * @param - rounds (integer)
   * @postcondition - number of rounds played is changed
   **/   
   public void setRounds(int rounds)
   {
      numberOfRounds = rounds;
   }
   
   /**
   * Accessor method getAverage()  
   * @param - none
   * @return - average score (double) 
   *   
   **/   
   public double getAverage()
   {
      return averageScore;
   }
   
   /**
   * Modification method setAverage( double)
   * @param - average (double)
   * @postcondition - player average is updated
   *   
   **/   
   public void setAverage(double average)
   {
      averageScore = average;
   }
   
   /**
   * Modification method setHandicap( int )
   * @param - num  (integer)
   * @postcondition - player handicap score is updated
   *  
   **/   
   public void setHandicap(int num)
   {
      handicap = num;
   }
   
   /**
   * Accessor method getHandicap
   * @param - none
   * @return - handicap (integer) of a player is returned
   *   
   **/   
   public int getHandicap()
   {
      return handicap;
   }
   
   /**
   * addNewScore updates golfer info based on the results of playing one round of golf    
   * @param - newScore (integer)
   * @postcondition - 
   *     numberOfRounds increases by one
   *     averageScore is updated by averaging in the newScore, calculating the new averageScore         
   *
   **/  
   public void addNewScore(int newScore)
   {
      double newAvg=((numberOfRounds*averageScore)+newScore)/(numberOfRounds+1);
      numberOfRounds++;
      averageScore=newAvg;
   }
   
   /**
   * Compareto method to compare lastName of Golfer objects   
   * @param - a Golfer obj
   * @return - integer -1, 0, or 1 returned
   *     -1  =  Golfer obj last name is less than this.lastname,
   *            comes sooner alphabetically
   *     0   =  Golfer object last name is the same as this.lastname
   *     1   =  Golfer object last name is greater than this.lastname
   *            comes after it, alphabetically
   **/     
   public int compareTo (Golfer obj)
   {
      int answer;
      
      answer = lastName.compareTo(obj.getName());
   
      return answer;
   }
   
   /**
   * toString method to present data from a Golfer Object in String format    
   * @param - none
   * @return - a String formatted to output lastName, numberOfRounds, handicap, averageScore   
   *   
   **/     
   public String toString()
   {
      StringBuilder sbuf = new StringBuilder();
      Formatter fmt = new Formatter(sbuf);
      fmt.format("%-12s",lastName);
      fmt.format("%5d \t",numberOfRounds);
      fmt.format("%5d \t",handicap);
      fmt.format("  %.2f",averageScore);
      String output = sbuf.toString();
      return output;
   }
   
   

}// end class