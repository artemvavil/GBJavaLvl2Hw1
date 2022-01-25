package homework5;

import java.util.Arrays;

public class ThreadApp {

    static float[] createArray(int size) {

        float[] arr = new float[size];

        Arrays.fill(arr, 1.0f);

        return arr;
    }

    static long fillArray(float[] arr) {

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        return (System.currentTimeMillis() - a);
    }

    static long createArrayWithFillArray(float[] sourceArray) {

        int cellsQuantity = (sourceArray.length / 2);
        long a = System.currentTimeMillis();

        float[][] assignArray = new float[2][cellsQuantity];
        Thread[] thread = new Thread[2];


        for (int i = 0; i < 2; i++) {

            System.arraycopy(sourceArray, cellsQuantity * i, assignArray[i], 0, cellsQuantity);

            final int index = i;

            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {

                    int x = index * cellsQuantity;

                    for (int j = 0; j < cellsQuantity; j++) {
                        assignArray[index][j] = (float) (assignArray[index][j] * Math.sin(0.2f + x / 5) *
                                Math.cos(0.2f + x / 5) * Math.cos(0.4f + x / 2));
                        x++;
                    }
                }
            });

            thread[i].start();
        }

        for (int i = 0; i < 2; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 2; i++) {
            System.arraycopy(assignArray[i], 0, sourceArray, i * cellsQuantity, cellsQuantity);
        }

        return System.currentTimeMillis() - a;
    }

}

