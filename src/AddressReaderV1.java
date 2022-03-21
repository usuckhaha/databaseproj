import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;

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

    BufferedReader inputFile =
                 new BufferedReader(new FileReader(fileName), 1024);

    

    myDatabase database = new myDatabase();

    String line="";
    String input="";
    int lineNum = 0;
    
    while ((line = inputFile.readLine()) != null)
    {
    	    
      String[] s = line.split("\",");
      for(int i=0; i<s.length; i++)            
      	s[i] = s[i].replaceAll("\"","");
      	
      String[] zip_phone = s[7].split(",");
     
      PersonalInfo info = new PersonalInfo(s[0], s[1], s[3], s[4], s[5], s[6], zip_phone[0], zip_phone[1], s[8], s[9], s[10]);
      
      if(!database.contains(info))
    	   database.add(info);
    
      
    }
   
    inputFile.close();
   
    
    System.out.println("Done loading addresses " + database.size() + " entries");
    
    //randomly set ages and voting affiliations
    for(int i=0; i<database.size(); i++)
    {
    	int age = (int)(Math.random()*80)+18;
    	database.get(i).setAge(age);
    	database.get(i).setVotingAffiliation((int)(Math.random()*3));
    
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
    	     	  System.out.println(database.findPeopleFromState(state));
    				  break;
    			
    			 case 2: 
    			 	  System.out.println(database.findAgeRange(70,90));  			 	  
    			 	  break;
    			 case 3:
               System.out.println("Which state");
   	     	   state = keyboard.nextLine();
    	     	   System.out.println("Which party? Republican(R), Democrat(D), Independent(I)");
               String vote = keyboard.nextLine();
              System.out.println(database.findPeopleFromStateVoting(state, vote));
    				  break;

    			 case 4: 
    			 //	  something else to search for
    			 	  break;
    			 case 5:
    			 	  return;
    				  
    		}
    		
    	
    	}
    
  }
}
