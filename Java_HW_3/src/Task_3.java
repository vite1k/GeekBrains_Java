public class Task_3 {

    public static void main(String[] args) {
        int[] array = {12, 11, 10, 5, 6, 2, 30};
        System.out.println("Исходный массив:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("Отсортированный массив:");
        printArray(array);
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int size1 = middle - left + 1;
        int size2 = right - middle;

        int[] tempLeft = new int[size1];
        int[] tempRight = new int[size2];

        System.arraycopy(array, left, tempLeft, 0, size1);
        System.arraycopy(array, middle + 1, tempRight, 0, size2);

        int i = 0;
        int j = 0;
        int k = left;

        while (i < size1 && j < size2) {
            if (tempLeft[i] <= tempRight[j]) {
                array[k] = tempLeft[i];
                i++;
            } else {
                array[k] = tempRight[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            array[k] = tempLeft[i];
            i++;
            k++;
        }

        while (j < size2) {
            array[k] = tempRight[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
