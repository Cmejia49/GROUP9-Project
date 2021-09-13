import java.util.List;
import java.util.Random;
public class Die
{
    protected List<FaceValue> FaceValueList;//Creat object of FaceValue for more abstraction and lessen the contructor Parameter for Parent Class
    private Random RandomChances = new Random();//Ceat a object for random library
    //Constructor
    public Die(List<FaceValue> faceValuesList)
    {
       this.FaceValueList = faceValuesList;
    } 
    //Using Final this method can not overidden
    public final void Roll()
    {
        double temp = 0,acc = 0;//A variable hold the chances and accumalate chances    
        double randomChances = RandomChances.nextDouble() * 100; // using random to produce random chances multiple to 100 to get the 2 decimal places
        for (FaceValue faceValue : FaceValueList)//For each loop to loop entire list
        {
            acc += faceValue.getChance();//Calling the getChance Method From FaceValue Class to get the chance that user input
                                        // and accumulate the chances to compare 
            /*
            randomChances > temp && randomChances <= acc
            example:
             20.0 > 16.7 && 20.0 < 33.4
            */ 
            if(Math.abs(randomChances) > temp && Math.abs(randomChances)<= acc)//Comparing the random chances to the user input chances
            {
                System.out.println("The Face of die is " + faceValue.getValue()); // Print the face value; Calling the method getValue From FaceValue class to get the value 
                return;
            }
            temp = acc;       
        }       
    }
    //Print method to print the dice
    public void print()
    {
        for (FaceValue faceValue : FaceValueList) {
            System.out.println("the value of the face is " + faceValue.getValue() + " the chances of face is " + faceValue.getChance());
        }
    }
}