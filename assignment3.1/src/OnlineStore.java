public class OnlineStore extends List<IEmployee>{
    /**
     * Compute the Salary of Specific Employee Rider
     * @param index
     * @return double
     */
    public double computeEmp1Salary(int index)
    {
        IEmployee curr = get(index);
        return curr.getSalary();
    }
    /**
     * Compute the Salary of Specific Employee Seller
     * @param index
     * @return double
     */
    public double computeEmp2Salary(int index)
    {
        IEmployee curr = get(index);
        return curr.getSalary();
    }
     /**
     * Reset All the salary of Employee
     * @param 
     * @return 
     */
    public void resetEmployeesSalary()
    {
       
        int j=0;
        Object[] v = getList();
        IEmployee[] curr = new IEmployee[v.length];
        for(int i = 0;i<v.length;)
        {
            curr[j++] = (IEmployee) v[i++];
        }
       
        for(int k=0;k<v.length;k++)
        {
            curr[k].clear();
        }
    }
}