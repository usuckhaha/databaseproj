import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonalInfo { //this is one single dude, brah
    private String firstName, lastName, company;
    private Address address;
    private ArrayList<String> phonenumbers, emailaddress, website;
    public PersonalInfo(){
        this.firstName = "";
        this.lastName = "";
        this.company = "";
        this.phonenumbers = new ArrayList<>();
        this.emailaddress = new ArrayList<>();
        this.website = new ArrayList<>();
    }
    public PersonalInfo(String firstName, String lastName, String company, String str, String twn, String state, String zip, String phoneNumber1, String phoneNumber2, String email, String website){
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = new Address(str, twn, state, zip);
        this.phonenumbers = new ArrayList<>(Arrays.asList(phoneNumber1, phoneNumber2));
        this.emailaddress = new ArrayList<>(List.of(email));
        this.website = new ArrayList<>(List.of(website));
    }
    public PersonalInfo(String firstName, String lastName, String company, String str, String twn, String state, String zip, String phoneNumber, String email, String website){
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = new Address(str, twn, state, zip);
        this.phonenumbers = new ArrayList<>(List.of(phoneNumber));
        this.emailaddress = new ArrayList<>(List.of(email));
        this.website = new ArrayList<>(List.of(website));
    }
}