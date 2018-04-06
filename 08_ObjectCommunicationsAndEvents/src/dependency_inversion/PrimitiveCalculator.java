package dependency_inversion;


import dependency_inversion.interfaces.Strategy;
import dependency_inversion.strategies.AdditionStrategy;
import dependency_inversion.strategies.DivisionStrategy;
import dependency_inversion.strategies.MultiplicationStrategy;
import dependency_inversion.strategies.SubtractionStrategy;

public class PrimitiveCalculator {

    private Strategy strategy;

    public PrimitiveCalculator(Strategy strategy){
        this.strategy = strategy;
    }

    public void changeStrategy(char operator){
        switch (operator){
            case '+':
                this.strategy = new AdditionStrategy();
                break;
            case '-':
                this.strategy = new SubtractionStrategy();
                break;
            case '*':
                this.strategy = new MultiplicationStrategy();
                break;
            case '/':
                this.strategy = new DivisionStrategy();
                break;
        }
    }

    public int performCalculation(int firstOperand,int secondOperand){
        return this.strategy.calculate(firstOperand, secondOperand);
    }
}
