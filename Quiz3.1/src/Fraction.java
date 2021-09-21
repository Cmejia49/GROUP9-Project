public class Fraction 
{
        private int num, denom;
        public Fraction(int num, int denom) 
        { 
            this.num = num;
            this.denom = denom;
        }
        /**
         * Simplify the fraction 
         * @param w1
         * @param n1
         * @param n2
         * @return Fraction
         */
        public Fraction simplify(int w1,int n1, int n2)
        {     
            int common_factor = GCD(n1,n2);
            int den3 = this.denom/common_factor;
            int  num3 = this.num/common_factor;
            if(den3 == 1)
            {
            MixedFraction f = new MixedFraction(w1,0, 0);
            return f;
            }
            MixedFraction f = new MixedFraction(w1,num3, den3);
           return f;
        }
        /**
         * Find The Gcd
         * @param n1
         * @param n2
         * @return int
         */
        public static int GCD(int n1, int n2)
        {
            if (n2 == 0) {
                return n1;
            }
            return GCD(n2, n1 % n2);
        }
    
  
        public Fraction add(Fraction another)
        { 
            int num1 =(this.num*another.denom) + (another.num * this.denom);
            int denom1=(this.denom*another.denom);

            Fraction f2 = new Fraction(num1, denom1);
           return f2;
        }
        public Fraction subtract(Fraction another)
        { 
            int num1 =(this.num*another.getDenominator()) - (another.getNumerator() * this.denom);
            int denom1=(this.denom*another.getDenominator());

            Fraction f2 = new Fraction(num1, denom1);
           return f2;
        }
        public Fraction multiply(Fraction another)
        { 
            int num1 =(this.num*another.num);
            int denom1=(this.denom*another.denom);

            Fraction f2 = new Fraction(num1, denom1);
           return f2;
        }
        public Fraction divide(Fraction another)
        { 
            int num1 = this.num * another.denom;
            int denom1 = this.denom * another.num;
            Fraction f2 = new Fraction(num1, denom1); 
            return f2;
        }
        //Getter
        public int getNumerator()
        { 
            return this.num;
        }
        public int getDenominator()
        {
            return this.denom;
        }
        //Setter
        public void setNumerator(int numerator)
        {
            this.num = numerator;
        }
        public void setDenominator(int denominator)
        {
            this.denom = denominator;
        }
     @Override
     public String toString(){
        return "<Funtion f value="+getNumerator()+"/"+getDenominator()+">";
    }
}
