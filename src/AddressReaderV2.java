import java.awt.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AddressReaderV2 {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String fileName;
        String[] ethnicities = {"Hispanic","White","Black or African American", "American Indian and Alaska Native", "Asian", "Native Hawaiian and Other Pacific Islander", "Multiracial"};
        String[] voting = {"D", "R", "I"};
        // Open input file:
        if (args.length > 0)
            fileName = args[0];
        else{
            System.out.print("\nEnter input file name: ");
            fileName = keyboard.nextLine().trim();
        }
        BufferedReader inputFile = new BufferedReader(new FileReader(fileName), 1024);
        PersonalDatabase database = new PersonalDatabase();

        String line;
        while ((line = inputFile.readLine()) != null) {
            String[] s = line.split("\"");
            PersonalInfo info = new PersonalInfo(s[1], s[3], s[5], s[7], s[9], s[11], s[13], s[14].substring(1, s[14].length()-1), s[15], s[17], s[19], s[21], ethnicities[(int)(Math.random()*ethnicities.length)], voting[(int)(Math.random()*voting.length)], (int)(Math.random()*80)+18, new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256)), ((int)(Math.random()*999) + "." + (int)(Math.random()*999) + "." + (int)(Math.random()*999) + "." + (int)(Math.random()*999)));
            if(!database.contains(info))
                database.add(info);
        }
        inputFile.close();


        System.out.println("Done loading addresses " + database.size() + " entries");

        while(true){

            System.out.println("Find people:");
            System.out.println("1. by state");
            System.out.println("2. by age range");
            System.out.println("3. by voting affiliation");
            System.out.println("4. by ethnicity");
            System.out.println("5. Multi-search");
            System.out.println("6. Manage people");
            System.out.println("7. Show person");
            System.out.println("0. Quit");

            int choice = keyboard.nextInt();
            keyboard.nextLine();

            switch(choice){

                case 1:
                    System.out.print("Which state? ");
                    String opt = keyboard.nextLine();
                    System.out.println(database.findPeopleFromState(opt).toString());
                    break;
                case 2:
                    System.out.print("Set lower limit: ");
                    int loLimit = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.print("Set higher limit: ");
                    int hiLimit = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println(database.findAgeRange(loLimit, hiLimit));
                    break;
                case 3:
                    System.out.print("Which party? Republican(R), Democrat(D), Independent(I): ");
                    opt = keyboard.nextLine();
                    System.out.println(database.findVoting(opt).toString());
                    break;
                case 4:
                    System.out.print("Which ethnicity? ");
                    opt = keyboard.nextLine();
                    System.out.println(database.findEthnicity(opt).toString());
                    break;
                case 5:
                    PersonalDatabase subdatabase = database;
                    while (true) {
                        System.out.println("Multi-search:");
                        System.out.println("1. by state");
                        System.out.println("2. by age range");
                        System.out.println("3. by voting affiliation");
                        System.out.println("4. by ethnicity");
                        System.out.println("0. go back");
                        int subchoice = keyboard.nextInt();
                        keyboard.nextLine();
                        switch (subchoice){
                            case 1:
                                System.out.print("Which state? ");
                                String op = keyboard.nextLine();
                                subdatabase = subdatabase.findPeopleFromState(op);
                                System.out.println(subdatabase.toString());
                                break;
                            case 2:
                                System.out.print("Set lower limit: ");
                                loLimit = keyboard.nextInt();
                                keyboard.nextLine();
                                System.out.print("Set higher limit: ");
                                hiLimit = keyboard.nextInt();
                                keyboard.nextLine();
                                subdatabase = subdatabase.findAgeRange(loLimit, hiLimit);
                                System.out.println(subdatabase.toString());
                                break;
                            case 3:
                                System.out.print("Which party? Republican(R), Democrat(D), Independent(I): ");
                                op = keyboard.nextLine();
                                subdatabase = subdatabase.findVoting(op);
                                System.out.println(subdatabase);
                                break;
                            case 4:
                                System.out.print("Which ethnicity? Hispanic(Hi), White(Wh), Black or African American(Bl), American Indian and Alaska Native(Am), Asian(As), Native Hawaiian and Other Pacific Islander(Na), Multiracial(Mu): ");
                                op = keyboard.nextLine();
                                subdatabase = subdatabase.findEthnicity(op);
                                System.out.println(subdatabase.toString());
                                break;
                            case 0:
                                break;

                        }
                        if(subchoice==0)
                            break;
                        System.out.println("Select a sub-filter:");
                    }
                    break;
                case 6:
                    while(true) {
                        System.out.print("Manage: Enter the person's name (enter 0 to go back): ");
                        String person = keyboard.nextLine();
                        if(person.equals("0"))
                            break;
                        if (database.containsPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))) {
                            while (true) {
                                System.out.println("Add:");
                                System.out.println("1. phone number");
                                System.out.println("2. email address");
                                System.out.println("3. website");
                                System.out.println("4. ip address");
                                System.out.println("Set:");
                                System.out.println("5. first name");
                                System.out.println("6. last name");
                                System.out.println("7. age");
                                System.out.println("8. address");
                                System.out.println("9. company");
                                System.out.println("10. voting affiliation");
                                System.out.println("11. favourite colour");
                                System.out.println("Remove: ");
                                System.out.println("12. phone number");
                                System.out.println("13. email address");
                                System.out.println("14. website");
                                System.out.println("15. ip address");
                                System.out.println("0. select someone else");
                                int ch = keyboard.nextInt();
                                keyboard.nextLine();
                                switch (ch) {
                                    case 1:
                                        System.out.print("Enter new phone number (include dashes): ");
                                        String newInfo = keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).addPhoneNumber(newInfo);
                                        break;
                                    case 2:
                                        System.out.print("Enter new email address: ");
                                        newInfo = keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).addEmailAddress(newInfo);
                                        break;
                                    case 3:
                                        System.out.print("Enter new website: ");
                                        newInfo = keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).addWebsite(newInfo);
                                        break;
                                    case 4:
                                        System.out.print("Enter new ip address: ");
                                        newInfo = keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).addIp(newInfo);
                                        break;
                                    case 5:
                                        System.out.print("Enter new first name: ");
                                        newInfo = keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).setFirstName(newInfo);
                                        break;
                                    case 6:
                                        System.out.print("Enter new last name: ");
                                        newInfo = keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).setLastName(newInfo);
                                        break;
                                    case 7:
                                        System.out.print("Enter current age: ");
                                        int newInt = keyboard.nextInt();
                                        keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).setAge(newInt);
                                        break;
                                    case 8:
                                        System.out.print("Enter new street: ");
                                        String str = keyboard.nextLine();
                                        System.out.print("Enter new town: ");
                                        String twn = keyboard.nextLine();
                                        System.out.print("Enter new county: ");
                                        String county = keyboard.nextLine();
                                        System.out.print("Enter new state: ");
                                        String state = keyboard.nextLine();
                                        System.out.print("Enter new zip code: ");
                                        String zip = keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).setAddress(str, twn, county, state, zip);
                                        break;
                                    case 9:
                                        System.out.print("Enter new company: ");
                                        newInfo = keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).setCompany(newInfo);
                                        break;
                                    case 10:
                                        System.out.print("Enter new voting affiliation: Republican(R), Democrat(D), Independent(I): ");
                                        newInfo = keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).setVotingAffiliation(newInfo);
                                        break;
                                    case 11:
                                        System.out.print("Enter new favourite colour in RGB (255 255 255): ");
                                        newInfo = keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).setFavColor(new Color(Integer.parseInt(newInfo.substring(0, newInfo.indexOf(" "))), Integer.parseInt(newInfo.substring(newInfo.indexOf(" ")+1).substring(0, newInfo.indexOf(" "))), Integer.parseInt(newInfo.substring(newInfo.indexOf(" ")+1).substring(newInfo.indexOf(" ")))));
                                        break;
                                    case 12:
                                        System.out.print("Select the phone number (0-" + (database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).getPhoneNumbers().size()-1) + ") you wish to delete\n" + database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).getPhoneNumbers().toString() + ": ");
                                        newInt = keyboard.nextInt();
                                        keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).removePhoneNumber(newInt);
                                        break;
                                    case 13:
                                        System.out.print("Select the email address (0-" + (database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).getEmail().size()-1) + ") you wish to delete\n" + database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).getEmail().toString() + ": ");
                                        newInt = keyboard.nextInt();
                                        keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).removeEmail(newInt);
                                        break;
                                    case 14:
                                        System.out.print("Select the website (0-" + (database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).getWebsite().size()-1) + ") you wish to delete\n" + database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).getWebsite().toString() + ": ");
                                        newInt = keyboard.nextInt();
                                        keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).removeWebsite(newInt);
                                        break;
                                    case 15:
                                        System.out.print("Select the ip address (0-" + (database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).getIp().size()-1 + ") you wish to delete\n" + database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).getIp().toString() + ": "));
                                        newInt = keyboard.nextInt();
                                        keyboard.nextLine();
                                        database.get(database.findPerson(person.substring(0, person.indexOf(" ")), person.substring(person.indexOf(" ") + 1))).removeIp(newInt);
                                        break;
                                    case 0:
                                        break;
                                }
                                if(ch==0) break;
                            }
                        }
                        else {
                            System.out.println("Person does not exist in this database");
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.print("Show: Enter the person's name (enter 0 to go back): ");
                    opt = keyboard.nextLine();
                    if(!database.containsPerson(opt.substring(0, opt.indexOf(" ")), opt.substring(opt.indexOf(" ") + 1))) {
                        System.out.println("Person does not exist in this database");
                        break;
                    }
                    else
                        System.out.println(database.get(database.findPerson(opt.substring(0, opt.indexOf(" ")), opt.substring(opt.indexOf(" ") + 1))).toString());
                    break;
                case 0:
                    return;
            }
        }
    }
}
