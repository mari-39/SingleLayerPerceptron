import java.util.Arrays;
import static java.lang.Math.random;

public class Perceptron {
    // The perceptron's defining data :
    int[][] inputs;
    int[] expectedOut;
    double[] weights;
    int[][] testInputs;
    int[] testExpectedOut;

    // Constants for the training process :
    double THRESHOLD = 0;
    double LEARNING_RATE = 0.1;
    int EPOCHS = 1000;

    // Specialized constructor :
    public Perceptron(int[][] inputs, int[] expectedOut, int[][] testInputs, int[] testExpectedOut) {
        this.inputs = inputs;
        this.expectedOut = expectedOut;
        this.weights = new double[] {random() - 0.5, random() - 0.5, random() - 0.5};
        this.testInputs = testInputs;
        this.testExpectedOut = testExpectedOut;
    }

    // calculates the weighted sum (weight0 * input[0][1] + weight1 * ... + weightN * input[i][n])
    public double[] summationFunP() {
        double weightedSum[] = new double[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs[i].length; j++) {
                weightedSum[i] += weights[j] * inputs[i][j];
            }
        }
        return weightedSum;
    }

    // Activation function => either stores 1 or -1 in output-arr,
// depending on each weightedSum-val
    public int[] heavisideStepFunP(double[] weightedSum) {
        int[] output = new int[weightedSum.length];
        for (int i = 0; i < weightedSum.length; i++) {
            output[i] = (weightedSum[i] > THRESHOLD) ? 1 : -1;
        }
        return output;
    }

    // Adjusts weights, depending on distance between desired and actually generated output
    public double[] perceptronLearningAlgoP(int[] outputs) {
        for (int i = 0; i < outputs.length; i++) {
            int error = expectedOut[i] - outputs[i];
            if (error != 0) {
                for (int j = 0; j < inputs[i].length; j++) {
                    weights[j] += LEARNING_RATE * error * inputs[i][j];
                }
            }
        }
        return weights;
    }

    // 1. calculates the weighted sum, plugging it into the activation function
    // compares the generated output with the correct Test-Data output, yielding a boolean
    public boolean testFun() {
        System.out.println("Correct test-output : " +
                Arrays.toString(testExpectedOut));
        double weightedSum[] = new double[testInputs.length];
        for (int i = 0; i < testInputs.length; i++) {
            for (int j = 0; j < testInputs[i].length; j++) {
                weightedSum[i] += weights[j] * testInputs[i][j];
            }
        }
        int[] generatedOut = heavisideStepFunP(weightedSum);
        System.out.println("Actual test-output : " + Arrays.toString(generatedOut));
        return Arrays.equals(testExpectedOut, generatedOut);
    }

// 1. solves the problem EPOCH-times, adjusting the weights each time by also
//    running the perceptronLearningAlgorithm EPOCH-times
// 2. tests the updated weights on the TEST-data

    public void doAllP() {
        System.out.println("Initial weights : " + Arrays.toString(weights));
        for (int i = 0; i < EPOCHS; i++) {
            int[] generatedOut = heavisideStepFunP(summationFunP());
            weights = perceptronLearningAlgoP(generatedOut);
        }
        System.out.println("Updated weights : " + Arrays.toString(weights));
        System.out.println("Correct output : " + Arrays.toString(expectedOut));
        System.out.println("Generated Output : " +
                Arrays.toString(heavisideStepFunP(summationFunP())));
    }
}
