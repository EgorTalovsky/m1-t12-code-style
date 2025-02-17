import java.util.Scanner;

public class DepositCalculator {

   double сalculateComplexPercent(double amount, double yearRate,int depositPeriod ) {

       double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
       return round(pay, 2);
    }

   double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
       return round(amount + amount * yearRate * depositPeriod, 2);
    }

   double round(double value, int index) {
       double result = Math.pow(10, index);
       return Math.round(value * result) / result;
    }

   void calculate() {
       int period;
       int action ;

       Scanner scanner = new Scanner(System.in);

       System.out.println("Введите сумму вклада в рублях:") ;
       int amount = scanner.nextInt();

       System.out.println("Введите срок вклада в годах:") ;
       period = scanner.nextInt();

       System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией: ");
       action = scanner.nextInt();

       double out = 0;

       if (action == 1) {
           out = calculateSimplePercent(amount, 0.06, period);
       } else if (action == 2) {
           out = сalculateComplexPercent(amount, 0.06, period);
       }
       System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
   }

   public static void main(String[] args) {
       new DepositCalculator().calculate();
   }
}
