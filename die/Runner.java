
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Runner {

     public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);  
      ArrayList<FaceValue> FaceValue = new ArrayList<>();
      CostumDie costumDie = new CostumDie(FaceValue);
      UnfairDie unfairDie = new UnfairDie(FaceValue);
   
      System.out.println("What type of Dice Will you want to play ");
      System.out.println("1. Normal Dice");
      System.out.println("2. Custom Dice");
      System.out.println("3. Unfair Dice");
      System.out.print("Choice: ");
      int choice = sc.nextInt();
      switch(choice) {
         case 1:
              drawNormalDice(FaceValue);
              break;    
        case 2: 
               System.out.print("How Many face you will input? ");
                int numFaces = sc.nextInt();
                double chances = Math.round(100.0/numFaces * 100.0) / 100.0;
               for(int i = 0;i<=numFaces;i++)
               {
                  String faceValue = sc.nextLine();
                  //how i will add the number of chances in the parameter
                  costumDie.addFace(faceValue, chances);
               }
               System.out.print("The Values You input are  ");
               costumDie.print(); 
               break;
        case 3:
                System.out.print("how many face you will input? ");
                numFaces = sc.nextInt();
                for(int i = 0;i<numFaces;i++)
                {
                   System.out.println("The Value you will input");
                   String faceValue = sc.next();
                   System.out.println("The Chances of face value will show");
                   Double unfairChances = sc.nextDouble();
                   costumDie.addFace(faceValue, unfairDie.setChances(unfairChances));
                }
                break;           
      }

        
       Die die = new Die(FaceValue);
     
       die.Roll();
       die.print();

      /* FaceValue.clear();
       CostumDie costumDie = new CostumDie(FaceValue);
       costumDie.addFace("as");
       costumDie.addFace("bb");
       costumDie.addFace("cc");
       costumDie.addFace("dd");
       costumDie.addFace("ee");
       costumDie.addFace("ff");
       costumDie.Roll();
       costumDie.Remove("as");
       costumDie.print();*/
     

       //Generate random number 1-100 
       //use if statement for the chances of showing the dice 
       //default value all faces have equal chances
    }

    public static void drawNormalDice(List<FaceValue> FaceValue)
    {    
         FaceValue.add(new FaceValue("1",16.7));
         FaceValue.add(new FaceValue("2",16.7));
         FaceValue.add(new FaceValue("3",16.7));
         FaceValue.add(new FaceValue("4",16.7));
         FaceValue.add(new FaceValue("5",16.7));
         FaceValue.add(new FaceValue("6",16.7));
    }
    
}
