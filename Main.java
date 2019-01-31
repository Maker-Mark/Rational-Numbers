public class Main{
  
public static void main(String[] args) throws Exception {

  System.out.println("Hi: Java cant do math! Tell me what .1 \"times\" 10 is (adding .1 ten times): " + (.1 + .1 + .1 + .1 + .1+ .1 + .1 + .1 + .1 + .1));
  // .1 in bnary is a repeating value.That's why we want to do math in a rational number space
   
  Rational rn = new Rational(10, 1);
 //Uses the toString of Rational object 
  System.out.println("Hi I am a rational number: " + rn);
  }


}

