package com.example.android.architecture.blueprints.todoapp;

import android.util.Log;
import kotlin.jvm.functions.Function0;
import io.qameta.allure.android.model.Parameter;


import java.lang.reflect.InvocationTargetException;

import static io.qameta.allure.android.StepKt.step;

public class StepWrapper {

    //note: methods to call should be "public static"
    public static Object stepWrapper(String stepName, String description, Object... parameters) {
        Function0 function0 = new Function0() {
            @Override
            public Object invoke() {
                try {
                    Class[] temp = new Class[parameters.length];
                    for (int i = 0; i < parameters.length; i++) {
                        temp[i] = parameters[i].getClass();
                    }
                    return Steps.class.getMethod(stepName, temp).invoke(Steps.class, parameters);
                } catch (NoSuchMethodException| InvocationTargetException |IllegalAccessException  e) {
                    Log.d("(custom) method invoke (error)", e.getMessage(), e);
                    return null;
                }
            }
        };

        Parameter[] stub = new Parameter[1];
        stub[0] = new Parameter();
        return step(description, stub, function0);
    }
}
