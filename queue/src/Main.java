public class Main {

    public static void main(String[] args) throws InterruptedException {
        Queue<String> queue = new Queue();
        queue.offer("first");
        queue.offer("second");
        queue.offer("third");
        System.out.println(queue.size() + "\n");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }}