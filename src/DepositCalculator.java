import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().findOutTheAmount();
    }

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return getDegree(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return getDegree(amount + amount * yearRate * period,2);
    }

    double getDegree(double value, int degree) {
        double scale = Math.pow(10, degree);
        return Math.round(value * scale) / scale;
    }

    void findOutTheAmount() {
        int period;
        int type;
        int amount;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        type = scanner.nextInt();
        double totalAmount = 0;
        if (type == 1) {
            totalAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (type == 2) {
            totalAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalAmount);
    }
}
