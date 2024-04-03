package com.triptrace.travel.core.utilities;

public class NullUtilities {
    private NullUtilities() {
    }

    public static boolean isNull(Object obj){
        return null == obj;
    }

    public static boolean isNotNull(Object obj){
        return !isNull(obj);
    }

    public static boolean isNullString(String str){
        return null == str || "null".equalsIgnoreCase(str.trim()) || str.trim().isEmpty();
    }

    public static boolean isNotNullString(String str){
        return !isNullString(str);
    }

    public static <T> T returnFirstNonNullValue(T ...args){
        for (T t: args){
            if (isNotNull(t)){
                return t;
            }
        }
        return null;
    }
}
