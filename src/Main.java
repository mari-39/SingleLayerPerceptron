public class Main {
    public static void main(String[] args) {
        Perceptron p = new Perceptron(Data.trainingData, Data.expectedOutputsAND, Data.TEST3, Data.SOL3);
        p.doAllP();
        System.out.println("The statement 'The predicted output-arr is the same as the expected one' is : " + p.testFun());
    }
}
