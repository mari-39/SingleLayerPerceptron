public class Data {
    static int BIAS = 1;

    // Training-Data :
    static int[][] trainingData = {{BIAS, 0, 0}, {BIAS, 0, 1}, {BIAS, 1, 0}, {BIAS, 1, 1}};

    // expectedOut AND - Gate :
    static int[] expectedOutputsAND = {-1, -1, -1, 1};

    // expectedOut OR - Gate :
    static int[] expectedOutputsOR = {-1, 1, 1, 1};


    // Test-Data to ensure the weights have been adjusted correctly :
    static int[][] TEST = {{BIAS, 1, 1}, {BIAS, 0, 1}, {BIAS, 0, 1}, {BIAS, 0, 0}, {BIAS, 1, 1}};
    // AND => 1, -1, -1, -1, 1
    // OR => 1, 1, 1, -1, 1

    static int[][] TEST2 = {{BIAS, 0, 0}, {BIAS, 1, 0}, {BIAS, 1, 1}};
    // AND => -1, -1, 1
    // OR => 0, 1, 1

    static int[][] TEST3 = {{BIAS, 0, 1}, {BIAS, 1, 1}, {BIAS, 1, 0}, {BIAS, 1, 1}, {BIAS, 0, 1},
            {BIAS, 0, 0}, {BIAS, 1, 1}, {BIAS, 1, 0}, {BIAS, 0, 1}, {BIAS, 1, 1},
            {BIAS, 1, 1}, {BIAS, 0, 1}, {BIAS, 1, 1}, {BIAS, 1, 0}, {BIAS, 0, 0},
            {BIAS, 1, 1}, {BIAS, 1, 1}, {BIAS, 0, 1}, {BIAS, 1, 1}, {BIAS, 0, 0},
            {BIAS, 1, 0}, {BIAS, 0, 1}, {BIAS, 1, 1}, {BIAS, 1, 0}, {BIAS, 0, 1},
            {BIAS, 1, 1}, {BIAS, 0, 0}, {BIAS, 1, 1}, {BIAS, 1, 0}, {BIAS, 0, 0},
            {BIAS, 1, 1}, {BIAS, 0, 1}, {BIAS, 1, 0}, {BIAS, 1, 1}, {BIAS, 1, 1}};
    // AND - solution :
    static int[] SOL3 = {-1, 1, -1, 1, -1, -1, 1, -1, -1, 1, 1, -1, 1, -1, -1, 1, 1, -1, 1, -1, -1, -1, 1, -1, -1, 1,
            -1, 1, -1, -1, 1, -1, -1, 1, 1};

}
