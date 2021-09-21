import java.io.Serializable;
public class Seller implements IEmployee, Serializable{
    
    private double totalSales;
    private static final long serialVersionUID = 1234L;
    public Seller(double totalSales) {
        setTotalSales(totalSales);
    }

    //setter
    public void setTotalSales(double totalSales)
    {
        this.totalSales = totalSales;
    }

    //getter
    public double getTotalSales()
    {
        return this.totalSales;
    }
    public double getSalary()
    {
        return totalSales*0.2;
    }

    public void clear()
    {
        totalSales = 0;
    }

    public void recordSale(double price, int qty)
    {
        totalSales += price*qty;
    }

    
    @Override
    public String toString(){
        String conv = "Seller Total Sales " + totalSales;
        return conv;
    }
}
