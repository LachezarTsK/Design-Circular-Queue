
/*
Design of a Circular Queue without applying any of the built-in queue data structures.
 */
public class MyCircularQueue {

    int[] circularQueue;
    int maxCapacity;
    int front;
    int rear;

    // By this design, empty Circular Queue is always with rear = -1 and front = 0.
    public MyCircularQueue(int k) {
        circularQueue = new int[k];
        maxCapacity = k;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = rear < maxCapacity - 1 ? ++rear : 0;
        circularQueue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (front != rear) {
            front = front < maxCapacity - 1 ? ++front : 0;
        } else {
            // dequeuing the only remaining element.
            front = 0;
            rear = -1;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return circularQueue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return circularQueue[rear];
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear >= 0 && (rear + 1) % maxCapacity == front % maxCapacity;
    }
}
