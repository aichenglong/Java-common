package org.mybatis;


import org.common.base.dao.CurdDao;
import org.common.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MybatisReflectUtil {

    public static Class<?>[] getMapperGenerics(Class<?> mapperClass) {
        Type[] types = mapperClass.getGenericInterfaces();
        for (Type type : types) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (CurdDao.class != (Class<?>) parameterizedType.getRawType())
                continue;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            Class<?>[] generics = new Class[typeArguments.length];
            for (int i = 0; i < typeArguments.length; i++)
                generics[i] = (Class<?>) typeArguments[i];
            return generics;
        }
        return null;
    }

    public static Field[] getModelField(Class<?> modelClass) {
        List<Field> fields = new ArrayList<>();
        Field[] declaredFields = modelClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if ("serialVersionUID".equals(field.getName()))
                continue;
            fields.add(field);
        }
        return fields.toArray(new Field[0]);
    }

    public static String getPrimaryKeyField(Class<?> modelClass) {
        Field[] declaredFields = modelClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if ("serialVersionUID".equals(field.getName()))
                continue;
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class); //获取指定类型注解
            if (null != primaryKey) {
                if (StringUtils.isNotBlank(primaryKey.value())) {
                    return primaryKey.value();
                } else {
                    return field.getName();
                }
            }
//            fields.add(field);
        }

        return null;
    }


}
