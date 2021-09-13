/* This Class hold the Attribute for Die  for more abstraction and lessen the Contructor parameter for Parent Class 
    When using Super keyword */
public class FaceValue{

    private String Value;
    private double Chance;
    public FaceValue(String value, double Chance) {
        this.Value = value;
        this.Chance = Chance;
    }
    //Getter and Setter for Value
    public String getValue()
    {
        return this.Value;
    }
    public void setValue(String value)
    {
         this.Value = value;
    }
    //Getter and Setter for Chances
    public double getChance()
    {
        return this.Chance;
    }
    public void setChance(double chance)
    {
         this.Chance = chance;
    }

}