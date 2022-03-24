public class Address {
    private String str, twn, county, state, zip;
    public Address(String str, String twn, String county, String state, String zip){
        this.str = str;             //set fields to params' values
        this.twn = twn;
        this.county = county;
        this.state = state;
        this.zip = zip;
    }
    @Override
    /** @return address **/
    public String toString(){ return (str + ", " + twn + ", " + county + ", " + state + ", " + zip); }
    /** @return street **/
    public String getStr(){ return this.str; }
    /** @return town **/
    public String getTwn(){ return this.twn; }
    /** @return county **/
    public String getCounty(){ return this.county; }
    /** @return state **/
    public String getState(){ return this.state; }
    /** @return zip code **/
    public String getZip(){ return this.zip; }
}
