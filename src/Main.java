import java.util.Arrays;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        int epochs = 1000;

        // AND - Gate

        // inputs has features : posn1, posn2, speed at posn1
        // outputs should predict whether car is accelerating
        double[][] inputs = {{0, 1, 1}, {0, 1, 0}, {0, 2, 2}, {0, 3, 3},
                {0, 4, 5}, {0, 2, 3}, {0, 6, 6}, {1, 3, 2}, {6, 7, 3}, {8, 11.2, 3.2}};
        double[] weights = {random(), random(), random()};
//        System.out.println("Initial weights : " + Arrays.toString(weights));
        int[] expectesOutputs = {-1, 1, 1, -1, 1, 1, -1, -1, 1, 1, -1};

        for (int i = 0; i < epochs; i++) {
            int[] outputs = Functions.heavisideStepFun(Functions.summationFun(weights, inputs));
//            System.out.println(Arrays.toString(weights));
            weights = Functions.perceptronLearningAlgo(outputs, expectesOutputs, weights, inputs);
//            System.out.println(Arrays.toString(weights));
        }

        System.out.println("Updated weights : " + Arrays.toString(weights));

    }

}
