import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        int epochs = 10000;

        // AND - Gate
        double[][] inputs = {{0, 1}, {1, 1}, {1, 0}, {1, 1}, {0, 1}, {0, 0}, {1, 1}, {1, 0}, {0, 1}, {1, 1}, {1, 1},
                {0, 1}, {1, 1}, {1, 0}, {0, 0}, {1, 1}, {1, 1}, {0, 1}, {1, 1}, {0, 0}, {1, 0}, {0, 1}, {1, 1}, {1, 0}, {0, 1}, {1, 1}, {0, 0}, {1, 1}, {1, 0}, {0, 0}, {1, 1}, {0, 1}, {1, 0}, {1, 1}, {1, 1}};
        int[] expectedOutputs = {-1, 1, -1, 1, -1, -1, 1, -1, -1, 1, 1, -1, 1, -1, -1, 1, 1, -1, 1, -1, -1, -1, 1, -1, -1, 1, -1, 1, -1, -1, 1, -1, -1, 1, 1};

        double[] weights = {random() - 0.5, random() - 0.5};
//        System.out.println("Initial weights : " + Arrays.toString(weights));

        for (int i = 0; i < epochs; i++) {
            int[] outputs = Functions.heavisideStepFun(Functions.summationFun(weights, inputs));
            weights = Functions.perceptronLearningAlgo(outputs, expectedOutputs, weights, inputs);
        }

//        System.out.println("Updated weights : " + Arrays.toString(weights));

        double[][] testingData = {{1, 1}, {0, 1}, {0, 1}, {0, 0}, {1, 1}};
        // predicted : 1, -1, -1, -1, 1 => [0.3066289077856507, -0.02941801409932049] yields this
//        System.out.println(Arrays.toString(Functions.heavisideStepFun(Functions.summationFun(weights, testingData))));

        System.out.println(Arrays.deepToString(Functions.shuffleInputs(inputs)));
//        System.out.println(Functions.testingShuffleFun(inputs));

    }

}
