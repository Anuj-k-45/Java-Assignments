import java.util.Scanner;

class StoreData {
    protected int[] data;
    protected int srt, ed;

    public StoreData(int size) {
        data = new int[size];
        srt = -1;
        ed = -1;
    }

    public void insert(int value) {
        System.out.println("Insert method not implemented");
    }

    public void delete() {
        System.out.println("Delete method not implemented");
    }

    public void display() {
        if (srt == -1) {
            System.out.println("No elements to display.");
            return;
        }
        System.out.print("Elements: ");
        for (int i = srt; i <= ed; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}

class Stack extends StoreData {

    public Stack(int size) {
        super(size);
    }

    public void insert(int value) {
        if (ed == data.length - 1) {
            System.out.println("Stack Overflow. Cannot insert " + value);
            return;
        }
        if (srt == -1) {
            srt = 0;
        }
        data[++ed] = value;
        System.out.println(value + " pushed to stack.");
    }

    public void delete() {
        if (srt == -1 || ed == -1) {
            System.out.println("Stack Underflow. Cannot delete.");
            return;
        }
        System.out.println(data[ed] + " popped from stack.");
        ed--;
        if (ed < srt) {
            srt = ed = -1;
        }
    }
}

class Queue extends StoreData {

    public Queue(int size) {
        super(size);
    }

    public void insert(int value) {
        if (ed == data.length - 1) {
            System.out.println("Queue Overflow. Cannot insert " + value);
            return;
        }
        if (srt == -1) {
            srt = 0;
        }
        data[++ed] = value;
        System.out.println(value + " enqueued to queue.");
    }

    public void delete() {
        if (srt == -1 || srt > ed) {
            System.out.println("Queue Underflow. Cannot delete.");
            return;
        }
        System.out.println(data[srt] + " dequeued from queue.");
        srt++;
        if (srt > ed) {
            srt = ed = -1;
        }
    }
}

public class StoreDataTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of stack and queue:");
        int size = scanner.nextInt();

        Stack stack = new Stack(size);
        Queue queue = new Queue(size);

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Push to Stack");
            System.out.println("2. Pop from Stack");
            System.out.println("3. Enqueue to Queue");
            System.out.println("4. Dequeue from Queue");
            System.out.println("5. Display Stack");
            System.out.println("6. Display Queue");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push to stack: ");
                    int stackValue = scanner.nextInt();
                    stack.insert(stackValue);
                    break;

                case 2:
                    stack.delete();
                    break;

                case 3:
                    System.out.print("Enter value to enqueue to queue: ");
                    int queueValue = scanner.nextInt();
                    queue.insert(queueValue);
                    break;

                case 4:
                    queue.delete();
                    break;

                case 5:
                    System.out.println("Stack:");
                    stack.display();
                    break;

                case 6:
                    System.out.println("Queue:");
                    queue.display();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}