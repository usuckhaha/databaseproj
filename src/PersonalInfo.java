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
    public PersonalInfo(String firstName, String lastName, String company, String str, String twn, String county, String state, String zip, String phoneNumber1, String phoneNumber2, String email, String website){
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.age = 0;
        this.ethnicity = "";
        this.address = new Address(str, twn, county, state, zip);
        this.phonenumbers = new ArrayList<>(Arrays.asList(phoneNumber1, phoneNumber2));
        this.emailaddress = new ArrayList<>(List.of(email));
        this.website = new ArrayList<>(List.of(website));
        this.ip = new ArrayList<>();
    }
    public PersonalInfo(String firstName, String lastName, String company, String str, String twn, String county, String state, String zip, String phoneNumber, String email, String website){
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.age = 0;
        this.ethnicity = "";
        this.address = new Address(str, twn, county, state, zip);
        this.phonenumbers = new ArrayList<>(List.of(phoneNumber));
        this.emailaddress = new ArrayList<>(List.of(email));
        this.website = new ArrayList<>(List.of(website));
        this.ip = new ArrayList<>();
    }
    public PersonalInfo(String firstName, String lastName, String company, String str, String twn, String county, String state, String zip, String phoneNumber1, String phoneNumber2, String email, String website, String ethnicity, String affiliation, int age, Color favColor, String ip){
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.age = age;
        this.ethnicity = ethnicity;
        this.affiliation = affiliation;
        this.address = new Address(str, twn, county, state, zip);
        this.favColor = favColor;
        this.phonenumbers = new ArrayList<>(Arrays.asList(phoneNumber1, phoneNumber2));
        this.emailaddress = new ArrayList<>(List.of(email));
        this.website = new ArrayList<>(List.of(website));
        this.ip = new ArrayList<>(List.of(ip));
    }
    public String getFirstName(){ return this.firstName; }
    public String getLastName(){ return this.lastName; }
    public String getEthnicity(){ return this.ethnicity; }
    public String getAffiliation(){ return this.affiliation; }
    public int getAge(){ return this.age; }
    public String getState(){ return this.address.getState(); }
    public ArrayList<String> getPhoneNumbers(){ return this.phonenumbers; }
    public ArrayList<String> getEmail(){ return this.emailaddress; }
    public ArrayList<String> getWebsite(){ return this.website; }
    public ArrayList<String> getIp(){ return this.ip; }

    public void setFirstName(String firstName){ this.firstName = firstName; }
    public void setLastName(String lastName){ this.lastName = lastName; }
    public void setCompany(String lastName){ this.lastName = lastName; }
    public void setAddress(String str, String twn, String county, String state, String zip){ this.address = new Address(str, twn, county, state, zip); }
    public void setFavColor(Color color){ this.favColor = color; }
    public void setEthnicity(String ethnicity){ this.ethnicity = ethnicity; }
    public void setIp(String ip){ this.ip.add(ip); }
    public void setVotingAffiliation(String affiliation){ this.affiliation = affiliation; }
    public void setAge(int age){ this.age = age; }

    public void addPhoneNumber(String phoneNumber){ this.phonenumbers.add(phoneNumber); }
    public void addEmailAddress(String email){ this.emailaddress.add(email); }
    public void addWebsite(String website){ this.website.add(website); }
    public void addIp(String ip){ this.ip.add(ip); }

    public void removePhoneNumber(int index){ this.phonenumbers.remove(index); }
    public void removeEmail(int index){ this.emailaddress.remove(index); }
    public void removeWebsite(int index){ this.website.remove(index); }
    public void removeIp(int index){ this.ip.remove(index); }

    public String toString(){
        return (this.firstName + " " + this.lastName + " | " + this.age + "yo | " + this.company + " | " + this.ethnicity + " | " + this.affiliation + " | " + this.address.toString() + " | " + this.favColor.toString() + " | " + this.phonenumbers.toString().replaceAll("[\\[\\]]", "") + " | " + this.emailaddress.toString() + " | " + this.website.toString() + " | " + this.ip.toString());
    }

}