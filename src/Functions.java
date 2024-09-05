import java.util.Arrays;
import java.util.Random;

public class Functions {
    static double THRESHOLD = 0;
    static double LEARNING_RATE = 0.01;

    public static int[] heavisideStepFun(double[] weightedSum) {
        int[] output = new int[weightedSum.length];
        for (int i = 0; i < weightedSum.length; i++) {
            output[i] = (weightedSum[i] > THRESHOLD) ? 1 : -1;
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
            int error = expectedOutputs[i] - outputs[i];
            if (error != 0) {
                for (int j = 0; j < inputs[i].length; j++) {
                    weights[j] += LEARNING_RATE * error * inputs[i][j];
                }
            }
        }
        return weights;
    }

    public static double[][] shuffleInputs(double[][] inputs) {
        int numOfIn = inputs.length;
        int numOfFeat = inputs[0].length;
        boolean[] grid = new boolean[numOfIn];
        double[][] shuffled = new double[numOfIn][numOfFeat];
        Random rand = new Random();

        for (int i = 0; i < numOfIn; i++) {
            int partner;
                do {
                    partner = rand.nextInt(i + 1);
                }
                while ((partner == i) || (grid[partner] == true));

            shuffled[i] = inputs[partner];
            shuffled[partner] = inputs[i];
            grid[partner] = true;
            grid[i] = true;
        }
        return shuffled;
    }

    public static boolean testingShuffleFun(double[][] inputs) {
        double[][] shuffled = shuffleInputs(inputs);

        int[] countedIn = countInputsHelper(inputs);
        int[] countedSh = countInputsHelper(shuffled);

        System.out.println(Arrays.toString(countedIn));
        System.out.println(Arrays.toString(countedSh));
        return Arrays.equals(countedIn, countedSh);
    }

    public static int[] countInputsHelper(double[][] d) {
        int doubleZero = 0;
        double[] dZ = {0, 0};

        int zeroOne = 0;
        double[] zO = {0, 1};

        int oneZero = 0;
        double[] oZ = {1, 0};

        int doubleOne = 0;
        double[] dO = {1, 1};

        for (int i = 0; i < d.length; i++) {
            if (Arrays.equals(d[i], dZ)) {
                doubleZero++;
            }
            else if (Arrays.equals(d[i], zO)){
                zeroOne++;
            }
            else if (Arrays.equals(d[i], oZ)){
                oneZero++;
            }
            else if (Arrays.equals(d[i], dO)){
                doubleOne++;
            }
        }
        return new int[]{doubleZero, zeroOne, oneZero, doubleOne};
    }
}
