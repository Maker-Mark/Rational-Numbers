public class Rational //Means I can compare myself(Object) to another rational number
  
  implements Comparable <Rational>{
   //Rational numbers are a numbers that can be represented in a p/q way ie .1 is not rational??
    private int numer;
    private int denom;

  public Rational(int numer, int denom) throws Exception {
      if(denom == 0)
          throw new Exception();
    this.numer = numer;
    this.denom = denom;
       simplify(); //simplify the fraction
  }
  
  private void simplify(){
  int divisor = gcd(numer, denom);
    numer /= divisor; // the "/=" operator does --> numer = numer /devisor
    denom /= divisor;   
  }
  //Implemeting a recursive Euclidean algorithm
  //Assumes bigger number comes first
  private static int gcd (int a, int b){
    if (b == 0) // the gcd of 0 and anything is anything
        return a;
      return gcd(b, a%b); 
    }
  
  public double convertToDecimal(){
      
      return (double)numer/denom; // I need to cast one fo them to a double so that we avoid int                                       division
      }
  
  public Rational(int numer) throws Exception {
    // If you are calling a constructor in a constructor it needs tyo be the first thing you do.
          this(numer, 1); // this is a failsafe. Ie if you gave me 10, and my cons is for a 2 param                             well if I have just one number, we know that the denom must be 1, so we                            just send it to the og cons with a 1 as the denominator
  }
  //Make sure they have a common denom ( we do this with simplify)
  public Rational add(Rational another) throws Exception{
  // 1/2 + 1/3 I need to multiply 2 by 3(numerator and denom, and  to get 6 and 3 by 2 to get 6 so   i can add
      int newNumer = numer*another.denom + another.numer * denom;
      //mult opp numer by opp denom
      int newDenom = denom * another.denom; 
    return new Rational (newNumer, newDenom);
  }
  
  //Method simply multiplies across
  public Rational mult( Rational another){
    return new Rational(numer * another.numer, denom * another.denom);
  }
  
  public String toString(){
    //Turnary operator, shortahnd for an if else that evals to an expression witht eh same datatype      Is the denom !=1? then do / + the denom OTHERwise just do what's after :. Boolean answer if        true, answer if false
    // Only works for expressions not operations
  return numer + (denom!=1? "/" + denom : ""); 
  }
  // Just integer divison, we want to avoid converting things to a decimal
  // The nature of "equaling" doubles requires 
  //Use math.abs(x-y) is it less than 0.000001(or something)
  public int floor(){
    return numer/ denom;
  }
  
  // The param here can be ANYTHING at all...due to the java Object hierarchy 
    public boolean equals(Object obj){
      // Use instanceof (boolean)
      if(!(obj instanceof Rational))
        return false;
      //Compile-time type: type it thinks it is versus the runtime type: what it actually is
      // I need to cast object to Rational so it knows it has a compareTo
      Rational rat = (Rational)obj;
     return rat.compareTo(this) == 0 ; // dot takes highest precidence, so youd need to use                                             parethisis
    }

  // We can cross multiply then subtract
  public int compareTo(Rational another){
    // Will return a postibve number neg or int
    return (numer*another.denom)
        - (another.numer *denom);
      }  
}
