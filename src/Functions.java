import java.util.ArrayList;

public class Functions {
    static double THRESHHOLD = 0;
    static double LEARNING_RATE = 0.1;

    public static int[] heavisideStepFun(double[] weightedSum) {
        int[] output = new int[weightedSum.length];

        for (int i = 0; i < weightedSum.length; i++) {
            if (weightedSum[i] > THRESHHOLD) {
                output[i] = 1;
            }
            else {
                output[i] = -1;
            }
        }
         return output;
    }

    public static double[] summationFun(double[] weights, double[][] inputs) {
        double weightedSum[] = new double[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs[i].length; j++) {
                weightedSum[i] += weights[j] * inputs[i][j];
            }
        }
        return weightedSum;
    }


    public static double[] perceptronLearningAlgo(int[] outputs, int[] expectedOutputs, double[] weights, double[][] inputs) {
        for (int i = 0; i < outputs.length; i++) {
            if (outputs[i] != expectedOutputs[i]) {
                for (int j = 0; j < inputs[i].length; j++) {
                    // just expectedoutpur[i] is also used
                    int error = expectedOutputs[i] - outputs[i];
                    System.out.println(error);
                    weights[j] += LEARNING_RATE * error * inputs[i][j];
                }
            }
            else {
                System.out.println(0);
            }
        }
        return weights;
    }
}
