import java.util.List;
public class CostumDie extends Die{
    public CostumDie(List<FaceValue> faceValuesList) {
       super(faceValuesList);
    }

    public void addFace(String value,double chances)
    {
        faceValuesList.add(new FaceValue(value,chances));
    }
    public void Remove(String value)
    {        int i = 0;
            int index = 0;
        for (FaceValue faceValue : faceValuesList) {
            if(faceValue.getValue().equals(value)){
                index = i;
              
            }
            i+=1;
        }
        faceValuesList.remove(index);
    }
    public void print()
    {
        for (FaceValue faceValue : faceValuesList) {
            System.out.println(faceValue.getValue());
        }
    }
}