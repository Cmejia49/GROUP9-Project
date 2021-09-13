import java.util.List;
public class CostumDie extends Die
{
    private int Index ;//Variable hold the index for faceValueList
    public CostumDie(List<FaceValue> faceValuesList) 
    {
       super(faceValuesList);
    }
    //Method to add Face Value
    public void addFace(String value)
    {
        addFace(value,16.7);
    }
    public void addFace(String value,double chances)
    {

        FaceValueList.add(new FaceValue(value,chances));
    }
    //Method to remove Face Value
    public void Remove(String value)//Input the face value to remove 
    {    
        if(isFaceValueFound(value))//Validation if the face value exist else print invalid
        {
            FaceValueList.remove(Index);//Removing the face value
        }
        else//Print invalid input when face value not found
        {
            System.out.println("Your Face Value input is invalid ");
        }
    
    }
    //Validate if face value Exist
    public boolean isFaceValueExist(String value)
    {
        for (FaceValue faceValue : FaceValueList) 
        {
            if(faceValue.getValue().equals(value))
            {
                return true;
            }
        }
        return false;
    }
    //Helper Method
    //Create to validate the face value if exist
    private boolean isFaceValueFound(String value)
    {
        int index = 0;
        for (FaceValue faceValue : FaceValueList) //Loop to entire list to find the Face value
        {            
            if(faceValue.getValue().equals(value))//if the value found get the index then return true 
            {       
                setIndex(index);//gettin the index to use to remove method of List library
                return true;
            }
            index++;
        }
        return false;
    }

    private void setIndex(int index)//Setting index for private property index 
    {
        this.Index = index;
    }

}