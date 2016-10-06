/*
 * This program is part of my learning Java series
 * This one looks at arrays and lists
 * 
 * Find the blog here,
 * http://testsheepnz.blogspot.co.nz/2016/08/java-10-arrays.html
 * 
 * For more information - please reread.
 * 
 * Mike Talks, Aug 2016
 */

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class RandomWinner {
 
       private int numEntrants;
      
       public void setNumEntrants (int num)
       {
              numEntrants = num;
       }
      
       public int winnerIs ()
       {
              return ((int)(Math.random() * numEntrants));
       }
      
      
       @Test
       public void randomNumberSpread()
       {
              System.out.println("============================");
              System.out.println("Confirming even distribution");
              RandomWinner randWinner = new RandomWinner();
              int numEntrants = 8;
              int[] countArray = new int[numEntrants];
              int counter, index;
              int totalRolls = 800000;
              int minVal, maxVal;
             
              //Set number of entrants
              randWinner.setNumEntrants(numEntrants);
             
              //Roll the dice totalRolls times, count the results
              for(counter = 0; counter < totalRolls; counter++)
              {
                     index = randWinner.winnerIs();
                     countArray[index]++;
              }
             
              //Rolling done, show us the numbers
              for(counter = 0; counter < numEntrants; counter++)
              {
                     System.out.println("Number of " + (counter) 
                    		 + " selections = " + countArray[counter]);
              }
             
              //Work out min/max threshold as +/- 1%
              minVal = (int) (0.99 * totalRolls / numEntrants);
              maxVal = (int) (1.01 * totalRolls / numEntrants);
             
              //Confirm each number rolled 1/6 of the time
              for(counter = 0; counter < numEntrants; counter++)
              {
                     assertTrue("Dice rolls for " + (counter+1)
                                  + " below threshold of " + minVal,
                                  (countArray[counter]
                                                > minVal ) );
                     assertTrue("Dice rolls for " + (counter+1)
                                  + " above threshold of " + maxVal,
                                  (countArray[counter]
                                                < maxVal ) );             
              }
       }
      
       @Test
       public void TheArrayWinnerIs ()
       {
             
              System.out.println("============================");
              System.out.println("Selecting a winner");
             
              RandomWinner randWinner = new RandomWinner();
             
              String[] entrants = {
                           "@neilstudd",
                           "@erikhun",
                           "@miller_alaine",
                           "@testanalystat",
                           "@theGuttedTester",
                           "@Shicky4",
                           "@srinivasskc",
                           "@techgirl1908" };
             
             
              System.out.println("Num entrants: " + entrants.length);
              randWinner.setNumEntrants (entrants.length);
             
              int winnerNum = randWinner.winnerIs();
              String winner = entrants[winnerNum];
              System.out.println("Winning num " + winnerNum);
              System.out.println("Winner is " + winner);
             
       }
      
       @Test
       public void TheListedWinnersAre ()
       {
              RandomWinner randWinner = new RandomWinner();
              
              List<String> entrants = new ArrayList<String>();

              entrants.add("@neilstudd");
              entrants.add("@erikhun");
              //entrants.add("@miller_alaine");
              entrants.add("@testanalystat");
              entrants.add("@theGuttedTester");
              entrants.add("@Shicky4");
              entrants.add("@srinivasskc");
              entrants.add("@techgirl1908");

             
              System.out.println("Num entrants: " + entrants.size());
              randWinner.setNumEntrants (entrants.size());
             
              int winnerNum = randWinner.winnerIs();
              String winner = entrants.get(winnerNum);
              System.out.println("Winning num " + winnerNum);
              System.out.println("Winner is " + winner);
             
              // Now show those who didn't win
              // Remove winner
              entrants.remove(winnerNum);
             
              System.out.println("The following didn't win");
              
              for(String twitterHandle :entrants)
              {
            	  System.out.println(twitterHandle);
              }      
             
       }
}
 
