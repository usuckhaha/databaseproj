public class Address {
    private String str;
    private String twn;
    private String state;
    private String zip;
    public Address(String str, String twn, String state, String zip){
        this.str = str;             //set fields to params' values
        this.twn = twn;
        this.state = state;
        this.zip = zip;
    }
    @Override
    /** @return address **/
    public String toString(){ return (str + ", " + twn + ", " + state + ", " + zip); }
    /** @return street **/
    public String getStr(){ return this.str; }
    /** @return town **/
    public String getTwn(){ return this.twn; }
    /** @return state **/
    public String getState(){ return this.state; }
    /** @return zip code **/
    public String getZip(){ return this.zip; }
}
