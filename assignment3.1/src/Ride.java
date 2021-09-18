import java.io.Serializable;

public class Ride implements IEmployee,Serializable {
    private int numOfDeliveries;
    private static final long serialVersionUID = 1234L;
    public Ride(int numOfDeliveries) {
        setNumOfDeliveries(numOfDeliveries);
    }

    //Setter
    public void setNumOfDeliveries(int numOfDeliveries)
    {
        this.numOfDeliveries = numOfDeliveries;
    }

    //getter
    public int getNumOfDeliveries()
    {
        return this.numOfDeliveries;
    }

    //Rider Object Method
    public double getSalary()
    {
        return numOfDeliveries*350;
    }

    public void clear()
    {
        numOfDeliveries = 0;
    }

    public void addDelivery(int count)
    {
        numOfDeliveries += count;
    }

    @Override
    public String toString(){
        String conv = "Rider Number Of Deliveries " + numOfDeliveries;
        return conv;
    }
}
