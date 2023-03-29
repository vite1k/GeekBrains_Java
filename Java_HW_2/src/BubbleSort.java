import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 4, 1, 9, 5, 7};
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {
            fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info("Original array: " + Arrays.toString(arr));

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                logger.info("Array after iteration " + (i + 1) + ": " + Arrays.toString(arr));
            }

            logger.info("Sorted array: " + Arrays.toString(arr));

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}
