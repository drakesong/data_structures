public class TimingTest {
	//Created by Professor Justin Li

    private static int NUM_TRIALS = 100;

    public static long forwardTest(Map map, long numElements) {
        String formatString = "%0" + String.format("%d", ((long) Math.log10(numElements)) + 2) + "d";
        long start;
        long end;
        long[] data = new long[NUM_TRIALS];
        int trial;
        long i;
        for (trial = 0; trial < NUM_TRIALS; trial++) {
            start = System.nanoTime();
            // add numbers from small to large
            for (i = 0; i < numElements; i++) {
                map.put(String.format(formatString, i), "");
            }
            end = System.nanoTime();
            data[trial] = end - start;
        }
        long total = 0;
        for (trial = 0; trial < NUM_TRIALS; trial++) {
            total += data[trial];
        }
        return (total / NUM_TRIALS) / 1000000;
    }

    public static long backwardTest(Map map, long numElements) {
        String formatString = "%0" + String.format("%d", ((long) Math.log10(numElements)) + 2) + "d";
        long start;
        long end;
        long[] data = new long[NUM_TRIALS];
        int trial;
        long i;
        for (trial = 0; trial < NUM_TRIALS; trial++) {
            start = System.nanoTime();
            // add numbers from large to small
            for (i = numElements; i > 0; i--) {
                map.put(String.format(formatString, i), "");
            }
            end = System.nanoTime();
            data[trial] = end - start;
        }
        long total = 0;
        for (trial = 0; trial < NUM_TRIALS; trial++) {
            total += data[trial];
        }
        return (total / NUM_TRIALS) / 1000000;
    }

    public static void main(String[] args) {
        long result;
        long numElements = 1000;
        Map map;

        map = new AVLTreeMap();
        result = forwardTest(map, numElements); 
        System.out.println(String.format("forward  AVL\t%d milliseconds", result));

        map = new SortedArrayMap();
        result = forwardTest(map, numElements);
        System.out.println(String.format("forward  array\t%d milliseconds", result));

        map = new AVLTreeMap();
        result = backwardTest(map, numElements); 
        System.out.println(String.format("backward AVL\t%d milliseconds", result));

        map = new SortedArrayMap();
        result = backwardTest(map, numElements);
        System.out.println(String.format("backward array\t%d milliseconds", result));
    }
}
