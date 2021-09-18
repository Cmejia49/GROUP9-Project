public class Main {
 
    public static void main(String[] args) {
        
        OnlineStore data = new OnlineStore();

        data.add(new Seller(10));
        data.add(new Ride(10));

        System.out.println(data);
        data.resetEmployeesSalary();
        System.out.println(data);
    }
}
