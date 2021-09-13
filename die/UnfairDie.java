import java.util.ArrayList;
import java.util.List;

public class UnfairDie extends CostumDie 
{
    private ArrayList<Double> StoredChances = new ArrayList<>(); // to store the previous chances that change 
    private double accChances = 0;// To hold the accumulate Chances
    public UnfairDie(List<FaceValue> faceValuesList) 
    {
        super(faceValuesList);
    }
    //Method to Set Chances 
    public void setChances(int index,double chances)
    {
            FaceValueList.get(index).setChance(chances);//calling the setter method of chance from FaceValue Class to set the chance
    }

    //Method to validate if the Chances is valid 
    public boolean isValidchances()
    {        
       
         for(FaceValue faceValue : FaceValueList) //Adding all the chances if total of 100 return true else false
         {
            accChances += faceValue.getChance();
         }
         System.out.println(accChances);
         if(Math.round(Math.abs(accChances))==100.0)
         {  
             accChances = 0;    
             return true;
         }
        return false;
    }
    //This method is to get the totalChances to use in validation if chances less than 100% in calling this to runner class
    public double totalChances()
    {
         return accChances;
    }
    //Method to set equal Chances if Removing and adding faces  and if the set chances method is greater that 100%
    public void setEqualChance()
    {
        int countFaceValue = FaceValueList.size();
        double equalChances = Math.round(100.0/countFaceValue * 100.0) / 100.0;//Solution to have equal Chances
         for (FaceValue faceValue : FaceValueList)
         {
            faceValue.setChance(equalChances);
         }
         accChances = 0;
    }
    //Method to set chances to the last faces when the chances is less than 100%
    public void setChanceLastFace(double shortChance)
    {
        int index = FaceValueList.size() - 1;
        double holderChance = FaceValueList.get(index).getChance();
        FaceValueList.get(index).setChance(shortChance + holderChance);
        accChances = 0;
    }
    //Method to Store Chances 
    public void storeChances(double chances)
    {
        StoredChances.add(chances);
    }
    //Method to retain chances calling  this when the user set a new chances if the new chances is greater than 100% retain the old chances
    public void retainChances()
    {
        int index = 0;
        for (FaceValue faceValue : FaceValueList)
         {
        
            faceValue.setChance(StoredChances.get(index));
            index++;
         }
    }
  



}
