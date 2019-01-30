package org.common.base.service.impl;



import org.common.base.service.BaseService;

import java.lang.reflect.ParameterizedType;

/**
 * Author: ICL
 * Date:2018/10/26
 * Description:
 * Created by ICL on 2018/10/26.
 */
public abstract  class AbstractBaseService<T,ID> implements BaseService {



    protected Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractBaseService(){

//        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
//        modelClass = (Class<T>) pt.getActualTypeArguments()[0];

    }


}
