import javax.swing.JButton;
import javax.swing.JTextField;
 
public class CalculatorModel
{
	private int sum;
	private int number;
	private char opt;
 
	public CalculatorModel()
	{
		sum = 0;
		number = 0;
	}
 
	public void set(JButton idenifier, JTextField number)
	{
		int count = 0;
		int num1,num2;
		//this will receive '+' '-' '/' '*' etc
		opt = idenifier.getText().charAt(0);
 
		//getting value from JTextField and setting it as a integer
		this.number = Integer.parseInt(number.getText());
 
		//for testing
		System.out.println("The char is: "+opt+" and the int is: "+this.number);
 
		count++;
		if(count==1)//getting the first number
		{
		num1 = this.number;
		//System.out.println("num1 is: "+num1);
		}
		if(count==2) //getting the second number
		{
		num2= this.number; 
 
			calculate(opt,num2); //sending the sign and both numbers to method
			//System.out.println("num2 is: "+num2);
 
		count=0;//resetting count back to zero
		}
	}
 
	public void setNumber(int number)
	{
		this.number = number;
	}
 
	public int getSum() {
		return sum;
	}
 
	private void setSum(int sum) 
	{
		this.sum = sum;
	}
 
	void calculate(char sign,int num2)
	{
		switch(sign)
		{
		case '+':
			sum += num2;
			setSum(sum);
			break;
		case '-':
			sum -= number;
			setSum(sum);
			break;
 
		case '/':
			sum/= number;
			setSum(sum);
			break;
 
		case '*':
			sum *= number;
			setSum(sum);
			break;
 
		case '=':
			setSum(sum);
			break;
		case 'C':
			opt = 0;
			number = 0;
			sum = 0;
			setSum(sum);
			break;
			default: 
		}
	}
}
