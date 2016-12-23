//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yezhangxin.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MyUtil {
    public static String QSORT = "QSORT";
    private static final int CPUTIME = 500;
    private static final int PERCENT = 100;
    private static final int FAULTLENGTH = 10;
    private static ArrayList arrayList;
    private static ArrayList<ArrayList> arrayLists;

    public MyUtil() {
    }

    public static <T> void p(T t) {
        Class tClass = t.getClass();
        if(!tClass.isArray()) {
            System.out.println(t);
        }

    }

    public static <T> void p(List<T> t) {
        Iterator var1 = t.iterator();

        while(var1.hasNext()) {
            Object temp = var1.next();
            p(temp);
        }

    }

    public static void p(int[] arr) {
        System.out.print(arr[0]);

        for(int i = 1; i < arr.length; ++i) {
            System.out.printf("%20d", new Object[]{Integer.valueOf(arr[i])});
        }

        System.out.println();
    }

    public static void p(int[][] arr) {
        for(int i = 0; i < arr.length; ++i) {
            p(arr[i]);
        }

    }

    public static void p(double[] arr) {
        System.out.print(arr[0]);

        for(int i = 1; i < arr.length; ++i) {
            System.out.printf("%20f", new Object[]{Double.valueOf(arr[i])});
        }

        System.out.println();
    }

    public static void p(double[][] arr) {
        for(int i = 0; i < arr.length; ++i) {
            p(arr[i]);
        }

    }

    public static <T> void p(T[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }

    }

    public static <T> void p(T[][] arr) {
        for(int i = 0; i < arr.length; ++i) {
            p(arr[i]);
        }

    }

    public static void die() {
        System.exit(0);
    }

    public static void die(int i) {
        System.exit(i);
    }

    public static boolean isPrime(int num) {
        if(num != 2 && num != 3 && num != 5) {
            if(num % 2 != 0 && num % 3 != 0 && num % 5 != 0 && num != 1) {
                int max = (int)Math.sqrt((double)num);

                for(int c = 7; c < max; c += 2) {
                    if(num % c == 0) {
                        return false;
                    }
                }

                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public static int containIndex(String source, String s) {
        if(s != "" && source != "") {
            boolean i_source = false;
            int i_s = 0;
            int index = 0;

            for(int i = 0; i < source.length(); ++i) {
                if(i_s == s.length()) {
                    if(!String.valueOf(source.charAt(i)).equals("\'")) {
                        break;
                    }

                    i_s = 0;
                }

                if(source.charAt(i) == s.charAt(i_s)) {
                    index = i;
                    ++i_s;
                } else {
                    i_s = 0;
                    index = i_s;
                    if(source.charAt(i) == s.charAt(i_s)) {
                        index = i;
                        ++i_s;
                    }
                }
            }

            return index == 0 && s.charAt(0) != source.charAt(0)?-1:index - s.length() + 1;
        } else {
            return -1;
        }
    }

    public static ArrayList<String> delRepeat(ArrayList<String> s) {
        ArrayList re = new ArrayList();
        Iterator var2 = s.iterator();

        while(var2.hasNext()) {
            String ss = (String)var2.next();
            if(!re.contains(ss)) {
                re.add(ss);
            }
        }

        return re;
    }

    public static <T extends Comparable<? super T>> ArrayList LCS(T[] x, T[] y) {
        int[][] c = new int[x.length + 1][y.length + 1];
        int[][] t = new int[x.length + 1][y.length + 1];

        int max;
        for(max = 0; max <= x.length; ++max) {
            c[max][0] = 0;
        }

        max = 0;

        for(int i = 1; i <= x.length; ++i) {
            for(int j = 1; j <= y.length; ++j) {
                if(x[i - 1].compareTo(y[j - 1]) == 0) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    t[i][j] = 0;
                    if(c[i][j] > max) {
                        max = c[i][j];
                    }
                } else if(c[i][j - 1] > c[i - 1][j]) {
                    c[i][j] = c[i][j - 1];
                    t[i][j] = 1;
                } else {
                    c[i][j] = c[i - 1][j];
                    t[i][j] = -1;
                }
            }
        }

        BackTrack(x, t, x.length, y.length);
        return (ArrayList)arrayLists.get(0);
    }

    public static <T extends Comparable<? super T>> int LCSLength(T[] x, T[] y) {
        int[][] c = new int[x.length + 1][y.length + 1];
        int[][] t = new int[x.length + 1][y.length + 1];

        int max;
        for(max = 0; max <= x.length; ++max) {
            c[max][0] = 0;
        }

        for(max = 0; max <= y.length; ++max) {
            c[0][max] = 0;
        }

        max = 0;

        for(int i = 1; i <= x.length; ++i) {
            for(int j = 1; j <= y.length; ++j) {
                if(x[i - 1].compareTo(y[j - 1]) == 0) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    t[i][j] = 0;
                    if(c[i][j] > max) {
                        max = c[i][j];
                    }
                } else if(c[i][j - 1] > c[i - 1][j]) {
                    c[i][j] = c[i][j - 1];
                    t[i][j] = 1;
                } else {
                    c[i][j] = c[i - 1][j];
                    t[i][j] = -1;
                }
            }
        }

        return max;
    }

    private static <T> void BackTrack(T[] x, int[][] t, int i, int j) {
        arrayLists = new ArrayList();
        arrayList = new ArrayList();
        BackTrackUp(x, t, i, j);
        arrayLists.add(arrayList);
    }

    private static <T> void BackTrackUp(T[] x, int[][] t, int i, int j) {
        if(i != 0 && j != 0) {
            if(t[i][j] == 0) {
                arrayList.add(x[i - 1]);
                BackTrackUp(x, t, i - 1, j - 1);
            } else if(t[i][j] == 1) {
                BackTrackUp(x, t, i, j - 1);
            } else {
                BackTrackUp(x, t, i - 1, j);
            }

        }
    }

    private static <T> void BackTrackLeft(T[] x, int[][] t, int i, int j) {
        if(i != 0 && j != 0) {
            if(t[i][j] == 0) {
                arrayList.add(x[i - 1]);
                BackTrackLeft(x, t, i - 1, j - 1);
            } else if(t[i][j] == 1) {
                BackTrackLeft(x, t, i, j - 1);
            } else {
                BackTrackLeft(x, t, i - 1, j);
            }

        }
    }

    public static String readFile(String filePath) {
        String tempString = "";
        String str = "";

        try {
            File e = new File(filePath);
            FileReader fr = new FileReader(e);

            for(BufferedReader br = new BufferedReader(fr); (tempString = br.readLine()) != null; str = str + tempString) {
                ;
            }
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return str;
    }

    public static String[] convertToArrayBySpace(String str) {
        String[] s = str.split(" ");
        return s;
    }

    private static QSort getQSort() {
        Object qSort = (QSort)Register.get(QSORT);
        if(qSort == null) {
            qSort = MySort.getInstance();
            Register.set(QSORT, qSort);
        }

        return (QSort)qSort;
    }

    public static <T extends Comparable<? super T>> void qSort(T[] arr, int start, int end) {
        getQSort().qSort(arr, start, end);
    }

    public static <T extends Comparable<? super T>> void qSort(T[][] arr, int rowsNum, int columnsNum) {
        getQSort().qSort(arr, rowsNum, columnsNum);
    }

    public static void qSort(int[] arr, int start, int end) {
        getQSort().qSort(arr, start, end);
    }

    public static <T extends Comparable<? super T>> void qSort(T[] arr) {
        getQSort().qSort(arr);
    }

    public static <T extends Comparable<? super T>> void qSort(T[][] arr) {
        getQSort().qSort(arr);
    }

    public static void qSort(int[] arr) {
        getQSort().qSort(arr);
    }

    public static void qSort(int[][] arr) {
        getQSort().qSort(arr);
    }

    public static void qSort(int[][][] arr) {
        getQSort().qSort(arr);
    }

    public static void qSort(int[][] arr, int rowsNum, int columnsNum) {
        getQSort().qSort(arr, rowsNum, columnsNum);
    }

    public static void qSort(int[][][] arr, int xNum, int yNum, int zNum) {
        getQSort().qSort(arr, xNum, yNum, zNum);
    }

    public static void qSort(double[] arr, int start, int end) {
        getQSort().qSort(arr, start, end);
    }

    public static void qSort(double[] arr) {
        getQSort().qSort(arr);
    }

    public <T extends Comparable<? super T>> void qSort(List<T> arr, int start, int end) {
        getQSort().qSort(arr, start, end);
    }

    public <T extends Comparable<? super T>> void qSort(List<T> arr) {
        getQSort().qSort(arr);
    }

    

    public static List<String> getDisk() {
        ArrayList list = new ArrayList();

        for(char c = 65; c <= 90; ++c) {
            String dirName = c + ":/";
            File win = new File(dirName);
            if(win.exists()) {
                long total = win.getTotalSpace();
                long free = win.getFreeSpace();
                Double compare = Double.valueOf(Double.valueOf(1.0D - (double)free * 1.0D / (double)total).doubleValue() * 100.0D);
                String str = c + ":鐩�  宸蹭娇鐢� " + compare.intValue() + "%";
                list.add(str);
            }
        }

        return list;
    }

    public static String getCpuRatioForWindows() {
        try {
            String ex = System.getenv("windir") + "//system32//wbem//wmic.exe process get Caption,CommandLine,KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount";
            long[] c0 = readCpu(Runtime.getRuntime().exec(ex));
            Thread.sleep(500L);
            long[] c1 = readCpu(Runtime.getRuntime().exec(ex));
            if(c0 != null && c1 != null) {
                long idletime = c1[0] - c0[0];
                long busytime = c1[1] - c0[1];
                return "CPU浣跨敤鐜�:" + Double.valueOf((double)(100L * busytime) * 1.0D / (double)(busytime + idletime)).intValue() + "%";
            } else {
                return "CPU浣跨敤鐜�:0%";
            }
        } catch (Exception var7) {
            var7.printStackTrace();
            return "CPU浣跨敤鐜�:0%";
        }
    }

    private static long[] readCpu(Process proc) {
        long[] retn = new long[2];

        try {
            proc.getOutputStream().close();
            InputStreamReader e = new InputStreamReader(proc.getInputStream());
            LineNumberReader input = new LineNumberReader(e);
            String line = input.readLine();
            if(line != null && line.length() >= 10) {
                int capidx1 = line.indexOf("Caption");
                int cmdidx = line.indexOf("CommandLine");
                int rocidx = line.indexOf("ReadOperationCount");
                int umtidx = line.indexOf("UserModeTime");
                int kmtidx = line.indexOf("KernelModeTime");
                int wocidx = line.indexOf("WriteOperationCount");
                long idletime = 0L;
                long kneltime = 0L;
                long usertime = 0L;

                while((line = input.readLine()) != null) {
                    if(line.length() >= wocidx) {
                        String caption = substring(line, capidx1, cmdidx - 1).trim();
                        String e1 = substring(line, cmdidx, kmtidx - 1).trim();
                        if(e1.indexOf("wmic.exe") < 0) {
                            String s1 = substring(line, kmtidx, rocidx - 1).trim();
                            String s2 = substring(line, umtidx, wocidx - 1).trim();
                            if(!caption.equals("System Idle Process") && !caption.equals("System")) {
                                if(s1.length() > 0) {
                                    kneltime += Long.valueOf(s1).longValue();
                                }

                                if(s2.length() > 0) {
                                    usertime += Long.valueOf(s2).longValue();
                                }
                            } else {
                                if(s1.length() > 0) {
                                    idletime += Long.valueOf(s1).longValue();
                                }

                                if(s2.length() > 0) {
                                    idletime += Long.valueOf(s2).longValue();
                                }
                            }
                        }
                    }
                }

                retn[0] = idletime;
                retn[1] = kneltime + usertime;
                long[] caption1 = retn;
                return caption1;
            }

            Object capidx = null;
            return (long[])capidx;
        } catch (Exception var30) {
            var30.printStackTrace();
        } finally {
            try {
                proc.getInputStream().close();
            } catch (Exception var29) {
                var29.printStackTrace();
            }

        }

        return null;
    }

    private static String substring(String src, int start_idx, int end_idx) {
        byte[] b = src.getBytes();
        String tgt = "";

        for(int i = start_idx; i <= end_idx; ++i) {
            tgt = tgt + (char)b[i];
        }

        return tgt;
    }
}
