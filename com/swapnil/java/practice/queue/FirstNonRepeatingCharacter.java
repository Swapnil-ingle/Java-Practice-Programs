package com.swapnil.java.practice.queue;

import java.util.*;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(solve("xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr"));
    }

    private static String solve(String A) {
        char[] CA = A.toCharArray();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> freq = new HashMap<>();
        MyDequeue<String> queue = new MyDequeue<>();

        for (int i = 0; i < CA.length; i++) {
            String e = String.valueOf(CA[i]);

            if (freq.get(e) == null) {
                freq.put(e, 1);
            } else {
                freq.put(e, freq.get(e) + 1);
            }

            queue.enqueue(e);

            while (!queue.isEmpty() && freq.get(queue.head()) > 1) {
                queue.dequeue();
            }

            if (queue.isEmpty()) {
                sb.append("#");
            } else {
                sb.append(queue.head());
            }
        }

        return sb.toString();
    }

    public static class MyDequeue<T> extends AbstractQueue<T> {
        private LinkedList<T> elements;

        public MyDequeue() {
            this.elements = new LinkedList<T>();
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public Iterator<T> iterator() {
            return elements.iterator();
        }

        @Override
        public int size() {
            return elements.size();
        }

        public boolean enqueue(T t) {
            return offer(t);
        }

        public boolean enqueueHead(T t) {
            elements.add(0, t);
            return true;
        }

        @Override
        public boolean offer(T t) {
            if (t == null) {
                return false;
            }
            elements.add(t);
            return true;
        }

        public T dequeue() {
            return poll();
        }

        public T dequeueTail() {
            if (isEmpty()) {
                return null;
            }

            return elements.remove(size() - 1);
        }

        @Override
        public T poll() {
            if (isEmpty()) {
                return null;
            }

            Iterator<T> iter = elements.iterator();
            T t = iter.next();
            if(t != null){
                iter.remove();
                return t;
            }
            return null;
        }

        public T head() {
            return peek();
        }

        public T tail() {
            if (isEmpty()) {
                return null;
            }

            return elements.getLast();
        }

        @Override
        public T peek() {
            if (isEmpty()) {
                return null;
            }

            return elements.getFirst();
        }
    }
}
