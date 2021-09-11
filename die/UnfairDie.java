import java.util.List;
public class UnfairDie extends Die {
    public UnfairDie(List<FaceValue> faceValuesList) {
        super(faceValuesList);
    }

    public double setChances(double chances)
    {
    
            return chances;
    }

    //Helper method
    private boolean isValidchances()
    {
        double temp = 0;
      for (FaceValue faceValue : faceValuesList) {
            temp += faceValue.getChances();
      }
        if( Math.abs(temp)> 100)
        {
            return false;
        }
        return true;
    }
}
