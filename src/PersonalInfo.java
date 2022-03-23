import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonalInfo { //this is one single dude, brah
    private String firstName, lastName, company, ethnicity, affiliation;
    private int age;
    private Address address;
    private Color favColor;
    private ArrayList<String> phonenumbers, emailaddress, website, ip;
    public PersonalInfo(){
        this.firstName = "";
        this.lastName = "";
        this.company = "";
        this.age = 0;
        this.ethnicity = "";
        this.phonenumbers = new ArrayList<>();
        this.emailaddress = new ArrayList<>();
        this.website = new ArrayList<>();
        this.ip = new ArrayList<>();
    }
    public PersonalInfo(String firstName, String lastName, String company, String str, String twn, String state, String zip, String phoneNumber1, String phoneNumber2, String email, String website){
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;

        this.address = new Address(str, twn, state, zip);
        this.phonenumbers = new ArrayList<>(Arrays.asList(phoneNumber1, phoneNumber2));
        this.emailaddress = new ArrayList<>(List.of(email));
        this.website = new ArrayList<>(List.of(website));
        this.ip = new ArrayList<>();
    }
    public PersonalInfo(String firstName, String lastName, String company, String str, String twn, String state, String zip, String phoneNumber, String email, String website){
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = new Address(str, twn, state, zip);
        this.phonenumbers = new ArrayList<>(List.of(phoneNumber));
        this.emailaddress = new ArrayList<>(List.of(email));
        this.website = new ArrayList<>(List.of(website));
        this.ip = new ArrayList<>();
    }
    public void setFavColor(Color color){ this.favColor = color; }
    public void setEthnicity(String ethnicity){ this.ethnicity = ethnicity; }
    public void setIp(String ip){ this.ip.add(ip); }
    public void setVotingAffiliation(String affiliation){ this.affiliation = affiliation; }
    public void setAge(int age){ this.age = age; }

}