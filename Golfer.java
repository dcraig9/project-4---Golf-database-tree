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
   * @param 
   * 
   **/
   public Golfer()
   {
      //default constructor
   }

   /**
   * Initialize a Golfer 
   * @param 
   * 
   * @param 
   *    
   * @param 
   *    
   * @param 
   *    
   * @postcondition 
   *    
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
   * @param 
   * 
   **/   
   public Golfer(String name)
   {
      this(name,0,0,0);
   }
   
   /**
   * Accessor method    
   * @param - none
   * @return
   *   
   **/
   public String getName()
   {
      return lastName;
   }
   
   /**
   * Modification method 
   * @param - 
   * @postcondition
   *   
   *   
   **/   
   public void setName(String name)
   {
      lastName = name;
   }
   
   /**
   * Accessor method    
   * @param - none
   * @return
   *   
   **/   
   public int getRounds()
   {
      return numberOfRounds;
   }
   
   /**
   * Modification method 
   * @param - 
   * @postcondition
   *   
   *   
   **/   
   public void setRounds(int rounds)
   {
      numberOfRounds = rounds;
   }
   
   /**
   * Accessor method    
   * @param - none
   * @return
   *   
   **/   
   public double getAverage()
   {
      return averageScore;
   }
   
   /**
   * Modification method 
   * @param - 
   * @postcondition
   *   
   *   
   **/   
   public void setAverage(double average)
   {
      averageScore = average;
   }
   
   /**
   * Modification method 
   * @param - 
   * @postcondition
   *   
   *   
   **/   
   public void setHandicap(int num)
   {
      handicap = num;
   }
   
   /**
   * Accessor method    
   * @param - none
   * @return
   *   
   **/   
   public int getHandicap()
   {
      return handicap;
   }
   
   /**
   *     
   * @param 
   * 
   *   
   **/  
   public void addNewScore(int newScore)
   {
      double newAvg=((numberOfRounds*averageScore)+newScore)/(numberOfRounds+1);
      numberOfRounds++;
      averageScore=newAvg;
   }
   
   /**
   * Compareto method    
   * @param - 
   * @return
   *   
   **/     
   public int compareTo (Golfer obj)
   {
      int answer;
      
      answer = lastName.compareTo(obj.getName());
   
      return answer;
   }
   
   /**
   *     
   * @param - 
   * @return
   *   
   **/     
   public String toString()
   {
      StringBuilder sbuf = new StringBuilder();
      Formatter fmt = new Formatter(sbuf);
      //fmt.format("PI = %f%n", Math.PI);
      //System.out.print(sbuf.toString());
      
      //String output = lastName + "\t\t" + numberOfRounds + "\t\t" + handicap + "\t\t" + averageScore;;
      fmt.format("%-12s",lastName);
      fmt.format("%5d \t",numberOfRounds);
      fmt.format("%5d \t",handicap);
      fmt.format("  %.2f",averageScore);
      String output = sbuf.toString();
      return output;
   }
   
   

}// end class