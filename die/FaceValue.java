
public class FaceValue{

    private String value;
    private double chances;
    public FaceValue(String value, double chances) {
        this.value = value;
        this.chances = chances;
    }
    public String getValue()
    {
        return this.value;
    }
    public void setValue(String value)
    {
         this.value = value;
    }
    public double getChances()
    {
        return this.chances;
    }
    public void setChances(double chances)
    {
         this.chances = chances;
    }

}