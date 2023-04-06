import java.util.LinkedList;

class Queue<T> {
    private LinkedList<T> list = new LinkedList<T>();

    // Добавляет элемент в конец очереди
    public void enqueue(T value) {
        list.addLast(value);
    }

    // Возвращает и удаляет первый элемент из очереди
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }

    // Возвращает первый элемент из очереди, не удаляя его
    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    // Возвращает true, если очередь пуста
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Возвращает количество элементов в очереди
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("First element: " + queue.first());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("First element after dequeue: " + queue.first());
    }
}
