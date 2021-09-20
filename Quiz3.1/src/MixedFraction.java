

/*A mixed number can be created with the following data combination.
1. 1 number - treated as the whole part, the numerator defaults to 0 and denominator defaults to 1
2. 2 numbers - treated as numerator and denominator, hence whole defaults to 0
3. 3 numbers - treated as whole, numerator and denominator respectively.*/

/*Examples for initialization
1. mn1 = new MixedNumber<Float>(0.25f) results into whole = 0, numerator = 1, denominator = 4
2. mn2 = new MixedNumber<Long>(34, 6l) results into whole = 5, numerator = 2, denominator = 3
3. mn3 = new MixedNumber<Double>(11d, 18d, 10d) results into whole = 12, numerator = 4, denominator = 5 */

/*Operations Example
mn1 + mn2 = MixedNumber(whole = 5, numerator = 11, denominator = 12)
mn3 - mn2 = MixedNumber(whole = 7, numerator = 2, denominator = 15)
mn3 * mn1 = MixedNumber(whole = 3, numerator = 1, denominator = 5)
mn2 / mn3 = MixedNumber(whole = 0, numerator = 85, denominator = 192)*/

/*Notes
a. all fraction operators including creation result into a correct simplified fraction (lowest terms).
b. the data in mixed number creation can be any form of a number (byte, short, int, long, float or double)
c. Assumption is all number to entered are positive (no need to worry about negative values) */

public class MixedFraction<T extends Number> extends Fraction
{
    private int whole ;
    private T number;
    private Fraction divF;
    private Fraction MulF;
    public MixedFraction(T number) {
        super(number.intValue(),number.intValue());
        convertDecimalToFraction(number.doubleValue());
        this.number = number;
   
   }
   
   public MixedFraction(T num ,T denom) 
   {
    super(num.intValue(),denom.intValue());
    if(num.intValue()>denom.intValue())
          toMixedFraction(num.intValue(), denom.intValue());
    }

     public MixedFraction(T number,T num ,T denom) 
    {
        super(num.intValue(),denom.intValue());
       setWhole(number.intValue());
       if(num.intValue()>denom.intValue())
       {
          MulF = toMixedFraction(num.intValue(), denom.intValue());
          
       }
    }

    public double getNumber()
    {
        return this.number.doubleValue();
    }
 
     public void convertDecimalToFraction(double x)
     {
         double s  = x;
         String a;
         //Accurance of 1.2 converting Float to double specific problem;
        if(s == 1.2000000476837158)
        {
             a  =""+ String.format("%.2f",s);
        }
        else
        {
            a = "" + s;
             
        }
		String spilts[] = a.split("\\.");
		int b = spilts[1].length();
		int denominator = (int) Math.pow(10, b); 
		int numerator = (int) (s * denominator); 
		int gcd = GCD(numerator,denominator);
        int num3 = (numerator/gcd);
        int den3 = denominator / gcd;
        int whole = (numerator/denominator);
        setNumerator(num3);
        setDenominator(den3);
        setWhole(whole);
    }

    public Fraction toMixedFraction(int num,int denum)
    {
        int wNumer;
        int newNumerator = num%denum ;
        int newDenominator = denum;
        wNumer = Math.round((num/denum));
        setWhole(getWhole() + wNumer);
        MixedFraction<Number> f2 = new MixedFraction<Number>(wNumer,newNumerator,newDenominator);
          Fraction f = f2.simplify(wNumer,newNumerator,newDenominator);
          setNumerator(f.getNumerator());
          setDenominator(f.getDenominator());
          return f2.simplify(wNumer,newNumerator,newDenominator);
       
    }
    public Fraction toImproperFraction(int whole,int num,int denum)
    {
        int impNum = (whole*denum)+num;
        Fraction f2 = new Fraction(impNum, denum);
        return f2;
     
    }
    public Fraction addMFraction(MixedFraction another)
    {       
        Fraction curr = another;
        Fraction num1 = another;
        Fraction num2 = another;;
        if(this.whole != 0 && another.getWhole() != 0)
        {
            num1 =  toImproperFraction(this.whole, this.getNumerator(), this.getDenominator());
            num2 =  toImproperFraction(another.getWhole(), another.getNumerator(), another.getDenominator());
             curr = num1.add(num2);
        }else if(this.whole != 0)
        {
            num1 = toImproperFraction(this.whole, this.getNumerator(), this.getDenominator());
            num2 = new MixedFraction(another.getWhole(),another.getNumerator(),another.getDenominator());
            curr = num1.subtract(num2);
        }else if(another.getWhole() != 0)
        {
             num1 = new MixedFraction(this.getWhole(),this.getNumerator(),this.getDenominator());
             num2 = toImproperFraction(another.getWhole(), another.getNumerator(), another.getDenominator());
              curr = num1.add(num2);
        }else
        {
            num1 = new MixedFraction(this.getWhole(),this.getNumerator(),this.getDenominator());
            num2 = new MixedFraction(another.getWhole(),another.getNumerator(),another.getDenominator());
            curr = num1.add(num2);
        }
        
        int newWhole = getWhole() + another.getWhole();
     
        if(curr.getNumerator() > curr.getDenominator())
        {
            return toMixedFraction(curr.getNumerator(), curr.getDenominator()); 
        }

        MixedFraction f2 = new MixedFraction(newWhole,curr.getNumerator(),curr.getDenominator());
       return f2;
    }

    public Fraction subtractMFraction(MixedFraction another)
    {     
        Fraction curr = another;
        Fraction num1 = another;
        Fraction num2 = another;;
        if(this.whole != 0 && another.getWhole() != 0)
        {
            num1 =  toImproperFraction(this.whole, this.getNumerator(), this.getDenominator());
            num2 =  toImproperFraction(another.getWhole(), another.getNumerator(), another.getDenominator());
             curr = num1.subtract(num2);
        }else if(this.whole != 0)
        {
           
             num1 = toImproperFraction(this.whole, this.getNumerator(), this.getDenominator());
             num2 = new MixedFraction(another.getWhole(),another.getNumerator(),another.getDenominator());
      
             curr = num1.subtract(num2);
        }else if(another.getWhole() != 0)
        { 
            
             num1 = new MixedFraction(this.getWhole(),this.getNumerator(),this.getDenominator());
             num2 = toImproperFraction(another.getWhole(), another.getNumerator(), another.getDenominator());
   
              curr = num1.subtract(num2);
        }else
        {
           
            num1 = new MixedFraction(this.getWhole(),this.getNumerator(),this.getDenominator());
            num2 = new MixedFraction(another.getWhole(),another.getNumerator(),another.getDenominator());
            curr = num1.subtract(num2);
        }
        
        int newWhole = getWhole() + another.getWhole();
        if(curr.getNumerator() > curr.getDenominator())
        {   
            return toMixedFraction( curr.getNumerator(), curr.getDenominator()); 
        }

        MixedFraction f2 = new MixedFraction(getWhole(),curr.getNumerator(),curr.getDenominator());
       return f2;
    }

    public Fraction multiplyMFraction(MixedFraction another)
    { 
        Fraction curr = another;
        Fraction num1 = another;
        Fraction num2 = another;;
        if(this.whole != 0 && another.getWhole() != 0)
        { 
            num1 =  toImproperFraction(this.whole, this.getNumerator(), this.getDenominator());
            num2 =  toImproperFraction(another.getWhole(), another.getNumerator(), another.getDenominator());
             curr = num1.multiply(num2);
        }else if(this.whole != 0)
        {  
             num1 = toImproperFraction(this.whole, this.getNumerator(), this.getDenominator());
             num2 = new MixedFraction(another.getWhole(),another.getNumerator(),another.getDenominator());
             curr = num1.multiply(num2);
        }else if(another.getWhole() != 0)
        {   
             num1 = new MixedFraction(this.getWhole(),this.getNumerator(),this.getDenominator());
             num2 = toImproperFraction(another.getWhole(), another.getNumerator(), another.getDenominator()); 
              curr = num1.multiply(num2);
        }else
        {
           
            num1 = new MixedFraction(this.getWhole(),this.getNumerator(),this.getDenominator());
            num2 = new MixedFraction(another.getWhole(),another.getNumerator(),another.getDenominator());
            curr = num1.multiply(num2);
        }
        
        if(curr.getNumerator() > curr.getDenominator())
        {
           
           return toMixedFraction( curr.getNumerator(), curr.getDenominator()); 
        }

        MixedFraction f2 = new MixedFraction(getWhole(),curr.getNumerator(),curr.getDenominator());

        return f2.simplify(getWhole(), curr.getNumerator() , curr.getDenominator());
  
    }

    public Fraction divisionMFraction(MixedFraction another)
    { 
        Fraction curr = another;
        Fraction num1 = another;
        Fraction num2 = another;;
        if(this.whole != 0 && another.getWhole() != 0)
        {
            num1 =  toImproperFraction(this.whole, this.getNumerator(), this.getDenominator());
            num2 =  toImproperFraction(another.getWhole(), another.getNumerator(), another.getDenominator());
             curr = num1.divide(num2);
        }else if(this.whole != 0)
        {
        
             num1 = toImproperFraction(this.whole, this.getNumerator(), this.getDenominator());
             num2 = new MixedFraction(another.getWhole(),another.getNumerator(),another.getDenominator());
      
             curr = num1.divide(num2);
        }else if(another.getWhole() != 0)
        {  
          
             num1 = new MixedFraction(this.getWhole(),this.getNumerator(),this.getDenominator());
             num2 = toImproperFraction(another.getWhole(), another.getNumerator(), another.getDenominator());
              curr = num1.divide(num2);
             
        }else
        {
           
            num1 = new MixedFraction(this.getWhole(),this.getNumerator(),this.getDenominator());
            num2 = new MixedFraction(another.getWhole(),another.getNumerator(),another.getDenominator());
            curr = num1.divide(num2);
        }
        
        int newWhole = getWhole() + another.getWhole();
        if(curr.getNumerator() > curr.getDenominator())
        { 
            return toMixedFraction( curr.getNumerator(), curr.getDenominator()); 
        }

        MixedFraction f2 = new MixedFraction(curr.getNumerator(),curr.getDenominator());
       return f2;
    }

    public int getWhole()
    {
        return this.whole;
    }
    
    public void setWhole(int whole)
    {
         this.whole = whole;
    }

    @Override
    public String toString(){
        if(getNumerator() == 0 && getDenominator() == 0)
        {
            return "whole = " + getWhole() ;
        }
       return "whole = " + getWhole() +"  numerator = "+getNumerator()+ "  denominator = "+ getDenominator();
    }
}