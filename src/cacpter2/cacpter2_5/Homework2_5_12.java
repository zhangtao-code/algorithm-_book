package cacpter2.cacpter2_5;

import cacpter1.cacpter1_3.common.queue.LinkedQueue;
import cacpter1.cacpter1_3.common.queue.Queue;

import java.util.ArrayList;
import java.util.List;

public class Homework2_5_12 {
    public static void main(String[] args) {
        List<Task> list = new ArrayList<>();
        list.add(new Task("任务1", 12));
        list.add(new Task("任务2", 14));
        list.add(new Task("任务3", 15));
        list.add(new Task("任务4", 16));
        list.add(new Task("任务6", 1));
        list.add(new Task("任务7", 21));
        List<Cpu> cpus = new ArrayList<>();
        cpus.add(new Cpu());
        cpus.add(new Cpu());
        cpus.add(new Cpu());

        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(100);
        queue.enqueue(231);
        queue.enqueue(877);
        queue.enqueue(673);
        queue.enqueue(75);
        queue.enqueue(2431);
        queue.enqueue(8754);
        queue.enqueue(87);
        queue.enqueue(2314);
        while (true) {
            Integer value = queue.dequeue();
            if (value == null) {
                break;
            }
            System.out.print(value + "\t");
        }
    }
}

class PriorityQueue {
    protected Object[] array = new Object[100];
    protected int size;

    /**
     * 不考虑数组越界
     *
     * @param value
     */
    public void enqueue(int value) {
        int n = size;
        while (n > 0) {
            int parent = n >> 1;
            int parentValue = (int) array[parent];
            if (value >= parentValue) {
                break;
            }
            array[n] = array[parent];
            n = parent;
        }
        array[n] = value;
        size++;
    }

    public Integer dequeue() {
        if (size == 0) {
            return null;
        }
        Integer min = (Integer) array[0];
        if (size == 1) {
            array[0] = null;
            size--;
            return min;
        }
        int max = size - 1;
        array[0] = array[max];
        array[max] = null;
        int maxValue = (int) array[0];
        int k = 0;
        while (2 * k + 1 < max) {
            int j = 2 * k + 1;
            if (j + 1 < max && ((int) array[j + 1]) < ((int) array[j])) {
                j++;
            }
            int temp = (int) array[j];
            if (temp < maxValue) {
                array[k] = array[j];
                k = j;
            } else {
                break;
            }
        }
        array[k] = maxValue;
        size--;
        return min;
    }
}


class Task {
    public String name;
    public int time;

    public Task(String name, int time) {
        this.name = name;
        this.time = time;
    }
}

class Cpu {
    public int time;
    public Queue<Task> task;

    public Cpu() {
        this.task = new LinkedQueue<>();
    }

    public void addTask(Task task) {
        time += task.time;
        this.task.enqueue(task);
    }
}