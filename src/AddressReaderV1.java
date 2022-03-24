import java.awt.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AddressReaderV1
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    // Open input file:
    if (args.length > 0)
      fileName = args[0];
    else
    {
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim();
    }

    BufferedReader inputFile = new BufferedReader(new FileReader(fileName), 1024);
    PersonalDatabase database = new PersonalDatabase();

    String line;
    
    while ((line = inputFile.readLine()) != null)
    {
      String[] s = line.split("\"");
         PersonalInfo info = new PersonalInfo(s[1], s[3], s[5], s[7], s[9], s[11], s[13], s[14].substring(1, s[14].length()-1), s[15], s[17], s[19], s[21]);
      if(!database.contains(info))
    	   database.add(info);
    }
    inputFile.close();
   
    
    System.out.println("Done loading addresses " + database.size() + " entries");
    
    //randomly set ages and voting affiliations
    for(int i=0; i<database.size(); i++)
    {
        String[] ethnicities = {"Hispanic","White","Black or African American", "American Indian and Alaska Native", "Asian", "Native Hawaiian and Other Pacific Islander", "Multiracial"};
        String[] voting = {"Democrat", "Republican", "Independent"};
    	database.get(i).setAge((int)(Math.random()*80)+18);
    	database.get(i).setVotingAffiliation(voting[(int)(Math.random()*voting.length)]);
        database.get(i).setFavColor(new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256)));
        database.get(i).setEthnicity(ethnicities[(int)(Math.random()*ethnicities.length)]);
        database.get(i).setIp((int)(Math.random()*999) + "." + (int)(Math.random()*999) + "." + (int)(Math.random()*999) + "." + (int)(Math.random()*999));
    }
    
    while(true)
    {
    
    	System.out.println("Search Database:");
    	System.out.println("1. Find People from State");
    	System.out.println("2. Find Senior Citizens");
      System.out.println("3. Find Voting populations");
    	System.out.println("4. Some other search");
    	System.out.println("5. Quit");
    		
    	int choice = keyboard.nextInt();
    	keyboard.nextLine();
    	
    	switch(choice)
    		{
    	
    	     case 1:
    	     	  System.out.println("Which state");
    	     	  String state = keyboard.nextLine();
    	     	  System.out.println(database.findPeopleFromState(state).toString());
    				  break;
    			
    			 case 2: 
    			 	  System.out.println(database.findAgeRange(70,90).toString());
    			 	  break;
    			 case 3:
               System.out.println("Which state");
   	     	   state = keyboard.nextLine();
    	     	   System.out.println("Which party? Republican(R), Democrat(D), Independent(I)");
               String vote = keyboard.nextLine();
              System.out.println(database.findPeopleFromState(state).findVoting(vote).toString());
    				  break;

    			 case 4: 
    			 //	  something else to search for
                     System.out.println("Which ethnicity?");
                     state = keyboard.nextLine();
                     System.out.println(database.findEthnicity(state).toString());
    			 	  break;
    			 case 5:
    			 	  return;
    				  
    		}
    		
    	
    	}
    
  }
}
