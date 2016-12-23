//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yezhangxin.utils;

import java.util.HashMap;

public class Register {
    public static HashMap<String, Object> objects = new HashMap();

    public Register() {
    }

    public static void set(String alias, Object o, boolean lower) {
        alias = lower?alias.toLowerCase():alias;
        objects.put(alias, o);
    }

    public static void set(String alias, Object o) {
        set(alias, o, true);
    }

    public static Object get(String alias, boolean lower) {
        alias = lower?alias.toLowerCase():alias;
        return objects.containsKey(alias)?objects.get(alias):null;
    }

    public static Object get(String alias) {
        return get(alias, true);
    }

    public static boolean unset(String alias, boolean lower) {
        alias = lower?alias.toLowerCase():alias;
        if(objects.containsKey(alias)) {
            objects.remove(alias);
            return true;
        } else {
            return false;
        }
    }

    public static boolean unset(String alias) {
        return unset(alias, true);
    }
}
