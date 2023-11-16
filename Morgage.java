import java.util.Scanner;
import java.io.InputStream;
import java.text.NumberFormat;

class Morgage{
    public static void main(String[] args) {
        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;

       Scanner loanInfo = new Scanner(System.in);
        System.out.print("Principal ($1K - $M): ");
        double principal = loanInfo.nextDouble();
        while (principal < 1_000 || principal > 1_000_000)
          {
           System.out.println("Enter an amount that is between $1,000 and $1,000,000.");
           System.out.print("Principal ($1K - $M): ");
           principal = loanInfo.nextDouble();
          }

        System.out.print("Annual Interest rate: ");
        float annualInterest = loanInfo.nextFloat();
        while (annualInterest <= 0 || annualInterest > 30){
            System.out.println("Enter a value that is greater than 0 and less than or equal to 30.");
            System.out.print("Annual Interest rate: ");
            annualInterest = loanInfo.nextFloat();
        }

        System.out.print("Period (Years): ");
        byte period = loanInfo.nextByte();
        while(period <= 0 || period > 30){
            System.out.println("Enter a value that is greater than 0 and less than or equal to 30.");
            System.out.print("Period (Years): ");
            period = loanInfo.nextByte();
        }

        double monthlyInterest = annualInterest / (MONTHS_IN_YEAR * PERCENT); 
        int months = period * MONTHS_IN_YEAR;
        double t = Math.pow((1 + monthlyInterest), months);

        double r = monthlyInterest * t;
        double j = t - 1;
         
         NumberFormat morgage = NumberFormat.getCurrencyInstance();
         String morgageCalc = morgage.format((principal * r) / j);

        System.out.println("Morgage: " + morgageCalc);


    }
}
