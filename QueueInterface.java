//Adharsh Thiagarjan


package com.company;

public interface QueueInterface<T> {
    T dequeue();

    void enqueue(T item);

    T peek();

    boolean isEmpty();

    int size();
}
