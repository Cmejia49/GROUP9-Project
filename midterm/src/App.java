
import javax.swing.*;
import java.awt.*;
public class App 
{
  
    public static void main(String[] args) 
	{
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView();
 
		new CalculatorController(model,view);
	}
}
