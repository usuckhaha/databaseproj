import java.util.ArrayList;

public class PersonalDatabase extends ArrayList<PersonalInfo> {
    public PersonalDatabase(){ super(); }

    public PersonalDatabase findAgeRange(int startAge, int endAge){
        PersonalDatabase flamingo = new PersonalDatabase();
        for(PersonalInfo cow : this){
            if(cow.getAge()>= startAge && cow.getAge() <= endAge){
                flamingo.add(cow);
            }
        }
        return flamingo;
    }
    public PersonalDatabase findPeopleFromState(String state){
        PersonalDatabase flamingo = new PersonalDatabase();
        for(PersonalInfo cow : this){
            if(cow.getState().equals(state)){
                flamingo.add(cow);
            }
        }
        return flamingo;
    }
    public PersonalDatabase findVoting(String affiliation){
        PersonalDatabase flamingo = new PersonalDatabase();
        for(PersonalInfo cow : this){
            if(cow.getAffiliation().equals(affiliation)){
                flamingo.add(cow);
            }
        }
        return flamingo;
    }
    public PersonalDatabase findEthnicity(String ethnicity){
        PersonalDatabase flamingo = new PersonalDatabase();
        for(PersonalInfo cow : this){
            if(cow.getEthnicity().substring(0,2).equals(ethnicity)){
                flamingo.add(cow);
            }
        }
        return flamingo;
    }
    public int findPerson(String firstName, String lastName){
        for(int i=0; i<this.size(); i++){
            if(this.get(i).getFirstName().equals(firstName) && this.get(i).getLastName().equals(lastName)){
                return i;
            }
        }
        return -1;
    }
    public boolean containsPerson(String firstName, String lastName){
        for(PersonalInfo cow : this){
            if(cow.getFirstName().equals(firstName) && cow.getLastName().equals(lastName))
                return true;
        }
        return false;
    }
    public String toString(){
        String ret = "";
        for(PersonalInfo cow : this){
            ret = ret.concat(cow.toString() + "\n");
        }
        ret = ret.concat("\n\n");
        return ret;
    }
}
