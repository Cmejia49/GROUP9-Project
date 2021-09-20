public class Runner {
    
    public static void main (String[] args)  
    {
 
         /*1. mn1 = new MixedNumber<Float>(0.25f) results into whole = 0, numerator = 1, denominator = 4
          2. mn2 = new MixedNumber<Long>(34l, 6l) results into whole = 5, numerator = 2, denominator = 3
          3. mn3 = new MixedNumber<Double>(11d, 18d, 10d) results into whole = 12, numerator = 4, denominator = 5*/

        MixedFraction<Float> mn1 = new MixedFraction<Float>(0.25f);
        System.out.println(mn1);
        MixedFraction<Long> mn2= new MixedFraction<Long>(34l,6l);
        System.out.println(mn2);
        MixedFraction<Double> mn3 = new MixedFraction<Double>(11d,18d,10d);
        System.out.println(mn3);

        /*mn1 + mn2 = MixedNumber(whole = 5, numerator = 11, denominator = 12)
        mn3 - mn2 = MixedNumber(whole = 7, numerator = 2, denominator = 15)
        mn3 * mn1 = MixedNumber(whole = 3, numerator = 1, denominator = 5)
      mn2 / mn3 = MixedNumber(whole = 0, numerator = 85, denominator = 192)*/
        System.out.println("OPERATION FRACTION");

        System.out.println("Addition:");
        System.out.println(mn1.addMFraction(mn2));
        
        System.out.println("SubTract:");
        System.out.println(mn3.subtractMFraction(mn2));
        mn1 = new MixedFraction<Float>(0.25f);
        System.out.println("Multiply:");
        System.out.println(mn3.multiplyMFraction(mn1));
        mn3 = new MixedFraction<Double>(11d, 18d,10d);
        System.out.println("Divide:");
        System.out.println(mn2.divisionMFraction(mn3));// 

    }
}
