package ru.geekbrains.java.homeworks;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {

        doMethod1();
        doMethod2();
    }

    public static void doMethod1() {
        System.out.println("Method 1");
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        /*for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
      */
        fillArray(arr);

    }

    public static void doMethod2() {
        System.out.println("Method 2");
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        long start = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        long split = System.currentTimeMillis();
        System.out.println(String.format("Array is splited. Run time is %d", split - start));

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                fillArray(arr1);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                fillArray(arr2);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long connection = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Array connection run time is %d", (end - connection)));

    }

    private static void fillArray(float[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finish = System.currentTimeMillis();
        System.out.println(String.format("Run Time is: %d ", (finish - start)));
    }
}
