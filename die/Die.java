import java.util.List;
import java.util.Random;
public class Die{

    protected List<FaceValue> faceValuesList;
    private Random randomIndex = new Random();
    private double[] chances = {0.0,16.7,33.4,50.1,66.8,83.5,100};
    public Die(List<FaceValue> faceValuesList) {
       this.faceValuesList = faceValuesList;
    }
    //Behavior 
    public final void Roll()
    {
        double temp = 0,acc = 0;    
        double index = randomIndex.nextDouble();
        double flag = index * 100;
        System.out.println("index " + index + " flag " + flag);
        for (FaceValue faceValue : faceValuesList)
        {
            acc += faceValue.getChances();  
            if(Math.abs(flag) > temp && Math.abs(flag)<= acc)
            {
                System.out.println("The Face of die is " + faceValue.getValue() + " the value is " +  faceValue.getChances() + "index is " + acc + " flag " +flag);
                return;
            }
            temp = acc;
           
        }       
    }
    //Getter For List FaceValue
    public List<FaceValue> getFaceValues()
    {
        return this.faceValuesList;
    }
    
    public void setFaceValues(List<FaceValue> faceValues)
    {
       this.faceValuesList = faceValues;
    }
    public void print()
    {
        for (FaceValue faceValue : faceValuesList) {
            System.out.println(faceValue.getValue());
        }
    }
}