package Week1.HandsOn_DataStructuresAndAlgorimth;

public class ExerciseSeven {
    public class FinancialForecast {

    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue; // Base case: no more years left
        }
        // Recursive case
        return predictFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }
}

    public static void main(String[] args) {
        double presentValue = 10000;     // Starting amount
        double growthRate = 0.05;        // 5% annual growth
        int years = 5;                   // Forecast for 5 years

        double futureValue = FinancialForecast.predictFutureValue(presentValue, growthRate, years);

        System.out.printf("Predicted future value after %d years: %.2f%n", years, futureValue);
    }
}
