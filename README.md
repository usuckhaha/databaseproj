# databaseproj
AP Java project

ArrayLists Database assignment

Part 1:
Look at the us-500.csv file and review the personal information stored for each individual. Design a class
around this information called PersonalInfo. The class should have fields so that each piece of data in
the file can be stored.

For example:

    public class PersonalInfo {

        String firstName;

        String lastName;

        Address address; //create an Address class that will be made up of Street, City, State, County (read from file)

        ArrayList<String> phoneNumbers; //by default, two phone numbers are listed for each person in file. Storing these numbers as an ArrayList allows for the possibility that you will find more phone numbers for them.

        ArrayList<String> emailaddress; //one email address was provided with data, possibly you’ll find more.

        ArrayList<String> website;
    }

Companies purchase and maintain lists such as these so that they have a file of potential and/or current
customers. Advertisers and other companies will pay for these lists, particularly if there is other data
included. For example, some people would like all of the addresses of registered republicans in NY, or
all of the people between the ages of 25-35 that live in MA, or all the people that have visited a certain
website. Depending on what you think would be interesting data to collect, add fields to your
PersonalInfo class that you might collect on these people. Create accessor and mutator methods for
above class so that you have access to all fields.

Create a class myDatabase that extends an ArrayList<PersonalInfo>

Add methods: findPeopleFromState(String state) that returns an
ArrayList<PersonalInfo> containing all the individuals that live in ‘state’.
Add methods that use the information that you added to your PersonalInfo, including ways to
modify these fields as information is found. 

For example, if you are storing individuals’ ages, have a
method setAge() and findPeopleInAgeRange() as described below.

    //sets the age of the Person that has the fName and lName listed.
    public void setAge(String fName, String lName, int age)

    //returns a list of PersonalInfo files of people between the ages of startAge and endAge.
    public ArrayList<PersonalInfo> findPeopleInAgeRange(int startAge, int endAge){}
You don’t have to write methods that would update or search every data field available, concentrate on
searches you find interesting and write methods for these.

Part 2: Consider the video we watched at the beginning of class and the propensity for data to be
collected and used for business or other purposes. Work with your partner to consider some other
interesting pieces of information that might be collected. Add into your database a field to represent
this. The field can be a singular piece of information (e.g. age) or it can be a growing list of information
(e.g. social media platforms used)

Update the AddressReader.java file to add in other ways to search for your data.