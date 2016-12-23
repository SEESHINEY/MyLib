//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yezhangxin.utils;


import java.util.ArrayList;
import java.util.List;

public class MySort<T extends Comparable<? super T>> implements QSort<T> {
    private int i;
    private int j;
    private T key;
    private T temp;
    private static MySort mySort;

    private MySort() {
    }

    public static <T extends Comparable<? super T>> MySort getInstance() {
        if(mySort != null) {
            return mySort;
        } else {
            mySort = new MySort();
            return mySort;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void swap(T[] arr, int i, int j) {
        this.temp = arr[i];
        arr[i] = arr[j];
        arr[j] = this.temp;
    }

    private void swap(List<T> arr, int i, int j) {
        this.temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, this.temp);
    }

    public void qSort(T[] arr, int start, int end) {
        this.i = start;
        this.j = end;
        this.swap(arr, start, (start + end) / 2);
        this.key = arr[start];

        while(this.i < this.j) {
            while(this.i < this.j && arr[this.j].compareTo(this.key) >= 0) {
                --this.j;
            }

            if(this.i < this.j) {
                arr[this.i] = arr[this.j];
                ++this.i;
            }

            while(this.i < this.j && arr[this.i].compareTo(this.key) <= 0) {
                ++this.i;
            }

            if(this.i < this.j) {
                arr[this.j] = arr[this.i];
                --this.j;
            }
        }

        arr[this.i] = this.key;
        if(this.i > start) {
            this.qSort(arr, start, this.i - 1);
        }

        if(this.j < end) {
            this.qSort(arr, this.i + 1, end);
        }

    }

    public void qSort(T[][] arr, int rowsNum, int columnsNum) {
        ArrayList list = new ArrayList();

        int k;
        int i;
        for(k = 0; k < rowsNum; ++k) {
            for(i = 0; i < columnsNum; ++i) {
                list.add(arr[k][i]);
            }
        }

        this.qSort((List)list);
        k = 0;

        for(i = 0; i < rowsNum; ++i) {
            for(int j = 0; j < columnsNum; ++j) {
                arr[i][j] = (T) list.get(k++);
            }
        }

    }

    public void qSort(int[] arr, int start, int end) {
        if(start >= 0 && end >= 0 && start <= end) {
            this.i = start;
            this.j = end;
            this.swap(arr, start, (start + end) / 2);
            int key = arr[start];

            while(this.i < this.j) {
                while(this.i < this.j && arr[this.j] >= key) {
                    --this.j;
                }

                if(this.i < this.j) {
                    arr[this.i] = arr[this.j];
                    ++this.i;
                }

                while(this.i < this.j && arr[this.i] <= key) {
                    ++this.i;
                }

                if(this.i < this.j) {
                    arr[this.j] = arr[this.i];
                    --this.j;
                }
            }

            arr[this.i] = key;
            if(this.i > start) {
                this.qSort(arr, start, this.i - 1);
            }

            if(this.j < end) {
                this.qSort(arr, this.i + 1, end);
            }

        }
    }

    public void qSort(T[] arr) {
        this.qSort(arr, 0, arr.length - 1);
    }

    public void qSort(T[][] arr) {
        this.qSort(arr, arr.length, arr[0].length);
    }

    public void qSort(int[] arr) {
        this.qSort((int[])arr, 0, arr.length - 1);
    }

    public void qSort(int[][] arr) {
        this.qSort(arr, arr.length, arr[0].length);
    }

    public void qSort(int[][][] arr) {
        this.qSort(arr, arr.length, arr[0].length, arr[0][0].length);
    }

    public void qSort(int[][] arr, int rowsNum, int columnsNum) {
        int[] a = new int[rowsNum * columnsNum];
        int k = 0;

        int i;
        int j;
        for(i = 0; i < rowsNum; ++i) {
            for(j = 0; j < columnsNum; ++j) {
                a[k++] = arr[i][j];
            }
        }

        this.qSort(a);
        k = 0;

        for(i = 0; i < rowsNum; ++i) {
            for(j = 0; j < columnsNum; ++j) {
                arr[i][j] = a[k++];
            }
        }

    }

    public void qSort(int[][][] arr, int xNum, int yNum, int zNum) {
        int[] a = new int[xNum * yNum * zNum];
        int i = 0;

        int x;
        int y;
        int z;
        for(x = 0; x < xNum; ++x) {
            for(y = 0; y < yNum; ++y) {
                for(z = 0; z < zNum; ++z) {
                    a[i++] = arr[x][y][z];
                }
            }
        }

        this.qSort(a);
        i = 0;

        for(x = 0; x < xNum; ++x) {
            for(y = 0; y < yNum; ++y) {
                for(z = 0; z < zNum; ++z) {
                    arr[x][y][z] = a[i++];
                }
            }
        }

    }

    public void qSort(double[] arr, int start, int end) {
        this.i = start;
        this.j = end;
        this.swap(arr, start, (start + end) / 2);
        double key = arr[start];

        while(this.i < this.j) {
            while(this.i < this.j && arr[this.j] >= key) {
                --this.j;
            }

            if(this.i < this.j) {
                arr[this.i] = arr[this.j];
                ++this.i;
            }

            while(this.i < this.j && arr[this.i] <= key) {
                ++this.i;
            }

            if(this.i < this.j) {
                arr[this.j] = arr[this.i];
                --this.j;
            }
        }

        arr[this.i] = key;
        if(this.i > start) {
            this.qSort(arr, start, this.i - 1);
        }

        if(this.j < end) {
            this.qSort(arr, this.i + 1, end);
        }

    }

    private void swap(double[] arr, int i, int j) {
        double temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public void qSort(double[] arr) {
        this.qSort((double[])arr, 0, arr.length - 1);
    }

    public void qSort(List<T> arr, int start, int end) {
        this.i = start;
        this.j = end;
        this.swap(arr, start, (start + end) / 2);
        this.key =arr.get(start);

        while(this.i < this.j) {
            while(this.i < this.j && ((Comparable)arr.get(this.j)).compareTo(this.key) >= 0) {
                --this.j;
            }

            if(this.i < this.j) {
                arr.set(this.i, arr.get(this.j));
                ++this.i;
            }

            while(this.i < this.j && ((Comparable)arr.get(this.i)).compareTo(this.key) <= 0) {
                ++this.i;
            }

            if(this.i < this.j) {
                arr.set(this.j, arr.get(this.i));
                --this.j;
            }
        }

        arr.set(this.i, this.key);
        if(this.i > start) {
            this.qSort(arr, start, this.i - 1);
        }

        if(this.j < end) {
            this.qSort(arr, this.i + 1, end);
        }

    }

    public void qSort(List<T> arr) {
        this.qSort((List)arr, 0, arr.size() - 1);
    }
}
