/********************************************************************************************
* File: Golfer.java
* Golfer class simulates a Golfer and his related scores(name, average, rounds played, handicap)
*
* Authors: Donald Craig and Joe Eckstein
* Date: 04/17/2018
*
********************************************************************************************/


class Golfer implements Comparable<Golfer>
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
      
      String output = lastName + "     \t" + numberOfRounds + "\t\t\t" + handicap + "\t\t" + averageScore;;
      
      return output;
   }
   
   

}// end class