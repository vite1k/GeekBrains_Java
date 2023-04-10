public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        System.out.println("Sorted array is:");
        printArray(arr);
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение максимальной кучи
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение элементов из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещение текущего корня (максимального элемента) в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызов процедуры heapify для уменьшенной кучи
            heapify(arr, i, 0);
        }
    }

    // Функция для преобразования поддерева с корнем в i-й индекс в максимальную кучу
    // n - размер кучи
    static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализация самого большого элемента как корня
        int left = 2 * i + 1; // левый = 2 * i + 1
        int right = 2 * i + 2; // правый = 2 * i + 2

        // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Если правый дочерний элемент больше самого большого элемента на данный момент
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразовать затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    // Вспомогательная функция для вывода массива
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
