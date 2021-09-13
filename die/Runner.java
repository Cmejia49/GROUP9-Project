import java.util.ArrayList; //Import to use ArraList
import java.util.List;// Import to use List
import java.util.Scanner;// Import to use Scanner 

public class Runner {

private static Scanner sc = new Scanner(System.in);  //Global Variable for Scanner;

     public static void main(String[] args) {
      ArrayList<FaceValue> faceValuesList = new ArrayList<>(); //Creating ArrayList of FaceValue to Put in the Parameter of the Contructor 
      Die die = new Die(faceValuesList); // Die class object
      CostumDie costumDie = new CostumDie(faceValuesList); // CostumDie class Object
      UnfairDie unfairDie = new UnfairDie(faceValuesList); // UnfairDie class object
      /* User will Choose what Type of Die they will play */
      System.out.println("What type of Die Will you want to play ");
      System.out.println("1. Normal Die");
      System.out.println("2. Custom Die");
      System.out.println("3. Unfair Die");
      System.out.print("Choice: ");
      int choice = sc.nextInt();
      int numFaces;// Number of Faces 
      String userAns;// User answer for Continuing the loop
      String faceValue;// Variable to Get the Value of the Face want the User to Add or Remove
      switch(choice)
      {
         case 1:
              drawNormalDie(faceValuesList);//Method do draw default Normal Die
               die.print();//Calling the Print Method from the Die class
               /* The Normal Die Behavior is Roll Only */
                  System.out.println("You Choose normal Die");
                  System.out.println("Action You can do");
                  System.out.println("1. Roll the die ");
                  int normalDieChoice = sc.nextInt();
                  switch(normalDieChoice)
                  {
                     case 1: 
                           die.Roll();//Calling the Method Roll in the class die
                           break;
                     default:
                           System.out.println("wrong choice");
                  }
              break;    
         case 2: //This case is for custom die
               System.out.println("You choose Custom Die ");
               System.out.print("How Many face you will input? ");
               numFaces = sc.nextInt();
               drawCostomDie(numFaces,costumDie);//Calling the method to draw the custom die
               unfairDie.setEqualChance();//set equal Chances
               System.out.print("The Values You input are  ");
               costumDie.print(); // Calling the method print from Die class which is parents class 
               /* The Behavior of the Custom Die is Roll, add Face and Remove Face */
               do{
               System.out.println("What operation you want to Choose? ");
               System.out.println("1. Roll the Die ");
               System.out.println("2. Add another Face");
               System.out.println("3. Remove Face");
               int costumdDieChoice = sc.nextInt();
                  switch(costumdDieChoice)
                  {
                     case 1:        
                           do
                           {
                              costumDie.Roll(); // Calling the method Roll from Die class which is parents class 
                              System.out.println("Roll Again? Y/N");
                              userAns = sc.next();
                           }while(userAns.toUpperCase().equals("Y"));
                           break;
                     case 2:
                           do
                           {
                              System.out.println("add another face please enter Face Value");
                              faceValue = sc.next();
                              numFaces++;
                              /*costumDie.addFace(String s , double d) */
                              costumDie.addFace(faceValue);//This method is Created in CustomDie Class
                              System.out.println("Add face value Again? Y/N");
                              userAns = sc.next();
                          }while(userAns.toUpperCase().equals("Y"));
                          unfairDie.setEqualChance();//To set equal Chances when adding Face value
                          costumDie.print();
                          break;
                     case 3:
                          do
                          {
                              System.out.println("Enter the Face Value you want to Delete");
                              faceValue = sc.next();
                              /* costumDie.Remove(String s) */ 
                              costumDie.Remove(faceValue); // This Method Created in CustomDie Class
                              System.out.println("Remove face Value again? Y/N");
                              userAns = sc.next();
                           }while(userAns.toUpperCase().equals("Y"));
                           unfairDie.setEqualChance();//To set equal Chances when removing Face value
                           costumDie.print();
                           break;
                     default:
                           System.out.println("wrong choice");
                           break;
                  }
                  System.out.println("Want to choose again in Action of CustomDie? Y|N ");
                  userAns = sc.next();
               }while(userAns.toUpperCase().equals("Y"));
               break;
         case 3:
           
                System.out.print("how many face you will input? ");
                numFaces = sc.nextInt();
                drawUnfairDie(numFaces,unfairDie);//Calling the method to Draw unfairDie
                //when chance values are invalid, assign equal chances
                if(!unfairDie.isValidchances())//Validation for input Chances if equal to 100% 
                {                                                   
                      unfairDie.setEqualChance();//set the chances to equal
                }
                unfairDie.print();//Print the Die
                /* The Unfair Die have the behaviors of Roll, Add, Remove and Set Chances */
             do{
                System.out.println("What operation you want to Choose? ");
                System.out.println("1. Roll the Die ");
                System.out.println("2. Add another Face");
                System.out.println("3. Remove Face");
                System.out.println("4. Set Chances");
                int unfairDieChoice = sc.nextInt();
                switch(unfairDieChoice)
                  {
                     case 1:    //Roll the Die    
                           do
                           {
                              unfairDie.Roll();
                              System.out.println("Roll Again? Y/N");
                              userAns = sc.next();
                           }while(userAns.toUpperCase().equals("Y"));
                           break;
                     case 2:// Add face value to Unfair Die
                           do
                           {
                              System.out.println("add another face please enter Face Value");
                              faceValue = sc.next();
                              unfairDie.addFace(faceValue);
                              System.out.println("Add face value Again? Y/N");
                              userAns = sc.next();
                          }while(userAns.toUpperCase().equals("Y"));
                           /* When adding and Removing the face value of the Die set equalChance */
                          if(!unfairDie.isValidchances())
                          {
                             unfairDie.setEqualChance();
                          }

                          unfairDie.print();
                          break;
                     case 3: // Remove face value to die
                          do
                          {
                              System.out.println("Enter the Face Value you want to Delete");
                              faceValue = sc.next();
                              unfairDie.Remove(faceValue);
                              System.out.println("Remove face Value again? Y/N");
                              userAns = sc.next();
                           }while(userAns.toUpperCase().equals("Y"));
                            /* When adding and Removing the face value of the Die set equalChance */
                           if(!unfairDie.isValidchances())
                           {
                              unfairDie.setEqualChance();
                           }

                           unfairDie.print();
                           break;
                     case 4:// Set Chances to die
      
                           do
                           {
                              int index = 0;
                              for (FaceValue faceValue2 : faceValuesList) {
                                 unfairDie.storeChances(faceValue2.getChance());
                                 System.out.println("Set Chances for the face value of " + faceValue2.getValue());
                                 double chances = sc.nextDouble();
                                 unfairDie.setChances(index, chances);
                                 index++;
                              }
                              if(!unfairDie.isValidchances())//Validation for input Chances if equal to 100% 
                              {                                 
                                 if(unfairDie.totalChances()<100)//Validation for input chances if less than to 100% 
                                 {
                                    unfairDie.setChanceLastFace(100.0-unfairDie.totalChances());//Add the short chances to the last Face
                                 }
                                 else //Validation for input chances if greater than 100%
                                 {
                                    unfairDie.setEqualChance();//set the chances to equal
                                 }
                              }
                                 unfairDie.print();
                              System.out.println("Set Chances again? Y/N");
                              userAns = sc.next();
                            }while(userAns.toUpperCase().equals("Y"));
                            break;
                     default:
                            System.out.println("wrong choice");
                            break;
                  }
             System.out.println("Want to choose again in Action of Unfair Die? Y|N ");
             userAns = sc.next();
            }while(userAns.toUpperCase().equals("Y"));
                break;           
      }

    }
    // Method to Creat Normal Die
    public static void drawNormalDie(List<FaceValue> faceValueList)
    {    /* A normal Die consist of 6 faces and have equal chances */
       //add to FaceValue to faceValueList  
       faceValueList.add(new FaceValue("1",16.7));
       faceValueList.add(new FaceValue("2",16.7));
       faceValueList.add(new FaceValue("3",16.7));
       faceValueList.add(new FaceValue("4",16.7));
       faceValueList.add(new FaceValue("5",16.7));
       faceValueList.add(new FaceValue("6",16.7));
    }
    //Method to Create CostomDie
    public static void drawCostomDie(int numFaces, CostumDie costumDie)
    {  
      for(int i = 0;i<numFaces;i++)
      {

         String faceValue = sc.next();
         if(costumDie.isFaceValueExist(faceValue))
         {
           System.out.println("Your Face Value input already exist try again ");
           return;
         }
         costumDie.addFace(faceValue);//Call the CostumDie add face method to add faces
      }
     
    }
    //Method to Create UnfairDie
    public static void drawUnfairDie(int numFaces, UnfairDie unfairDie)
    {
       //providing the custom faces and chances
      for(int i = 0;i<numFaces;i++)
         {
            System.out.println("The Value you will input");
            String faceValue = sc.next();
            if(unfairDie.isFaceValueExist(faceValue))
            {
              System.out.println("Your Face Value input already exist try again ");
              return;
            }
            System.out.println("The Chances of face value will show");
            double unfairChances = sc.nextDouble();
            
            unfairDie.addFace(faceValue, unfairChances);
         }
    }
    
}
