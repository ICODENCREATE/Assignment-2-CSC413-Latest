//Adharsh Thiagarjan


package com.company;

import java.util.LinkedList;

public class MyPriorityQueue<T extends Comparable<T>> implements QueueInterface<T>{

    private LinkedList<T> list;


    public MyPriorityQueue() {
        list = new LinkedList<>();
    }

    @Override
    public void enqueue(T element) {
        if (isEmpty()) {
            list.add(element);
        } else {
            int index = 0;
            for (T item : list) {
                if (item.compareTo(element) > 0) {
                    list.add(index, item);
                    return;
                }
                index++;
            }
            list.addLast(element);
        }
    }
    @Override
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public T peek(){
        if (isEmpty()){
            return null;
        }
        return list.getFirst();

    }

    public int size() {
        return list.size();
    }

    public void clear(){
        list.clear();
    }

    public boolean contains(T element){
        return list.contains(element);
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
