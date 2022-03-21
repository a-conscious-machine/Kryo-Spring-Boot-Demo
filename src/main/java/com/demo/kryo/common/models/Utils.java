package com.demo.kryo.common.models;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static final Map inpMap = new HashMap<>() {{
        put("Hello", "World");
        put("Key", "Val");
    }};

    public static Object getObject(String someValue) {
//        return getSomeClassObjInp(someValue);
        return getMapObjInput(someValue);
    }

    public static Object getSomeClassObjInp(String someValue) {
        SomeClass someClassObject = new SomeClass();
        someClassObject.value = someValue;
        return someClassObject;
    }

    public static Object getMapObjInput(String someValue) {
        inpMap.put("Custom", someValue);
        return inpMap;
    }

//    public static Object getOutObj(String someValue) {
//        SomeClass someClassObject = new SomeClass();
//        someClassObject.value = someValue;
//        return someClassObject;
//    }
}
