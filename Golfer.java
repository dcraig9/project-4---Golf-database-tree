/********************************************************************************************
* File: Golfer.java
* Golfer class simulates a Golfer and his related scores(name, average, rounds played, handicap)
*
* Authors: Donald Craig and Joe Eckstein
* Date: 04/17/2018
*
********************************************************************************************/


class Golfer implements Comparable<Object>
{


   private String lastName;
   private int numberOfRounds;
   private double averageScore;
   private int handicap;

   /**
   * Initialize a 
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
   
   }
   /**
   * Compareto method    
   * @param - 
   * @return
   *   
   **/     
   public int compareTo (Object obj)
   {
   
      return 0;
   }
   
   /**
   *     
   * @param - 
   * @return
   *   
   **/     
   public String toString(Object obj)
   {
      String output = "";
      
      return output;
   }
   
   
   
   
   
   
   
   
   
   
   
   

}// end class