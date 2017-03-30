package com.demos.reflectioncall;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends Activity {
    String packageName = "com.demos.reflectioncalled";
    String className="com.demos.reflectioncalled.ReflectClass";
    String fieldName="field1";
    String methodName="method1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Context context = this.createPackageContext(packageName,
                    Context.CONTEXT_INCLUDE_CODE | Context.CONTEXT_IGNORE_SECURITY);
            Class clazz = context.getClassLoader().loadClass(className);

            Constructor constructor = clazz.getConstructor();
            Object object = constructor.newInstance();
            Method method = clazz.getDeclaredMethod(methodName,null);
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(false);
            Log.d("minguoCall",""+field.getInt(object));
            method.invoke(object,null);
        } catch(Exception e){
            e.printStackTrace();
            Log.d("minguoCall",""+e);
        }



    }
}
