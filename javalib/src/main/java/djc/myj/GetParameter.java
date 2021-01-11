package djc.myj;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import djc.myj.bean.Payee;

/**
 * Author: Zeus
 * Date: 2020/11/17 9:56
 * Description: 利用反射遍历属性
 * History:
 */
class GetParameter {
    public static void main(String[] args) {
//        getMethodInfo("djc.myj.bean.Payee");
        Payee payee = new Payee();
        String aPackage = payee.getClass().getName();
//                +payee.getClass().getSimpleName();

        System.out.println("****class-" + aPackage);
        System.out.println("*****************************");
        getFileds(aPackage);
        String packageName = "";
//        getMethodInfo("djc.myj.bean.DestinationBean");
    }

    private static void getMethodInfo(String pkgName) {
        try {
            Class clazz = Class.forName(pkgName);
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                System.out.println("method-:" + methodName);
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> clas : parameterTypes) {
                    String parameterName = clas.getName();
                    System.out.println("type-:" + parameterName);
                }
                System.out.println("*****************************");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void getFileds(String pkgName) {
        try {
            Class clazz = Class.forName(pkgName);
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                String fieldName = field.getName();
//                Object o = field.get(field);
                System.out.println("name-:" + fieldName);
                Type parameterTypes = field.getGenericType();
                String typeName = parameterTypes.getTypeName();
                System.out.println("type-:" + typeName);
//                Object o = field.get(fieldName);
//                Field clazzField = clazz.getField(fieldName);
//                System.out.println("class-value-:" + clazzField);
/*
                for (Class<?> clas : parameterTypes) {

                }
*/
                System.out.println("*****************************");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
