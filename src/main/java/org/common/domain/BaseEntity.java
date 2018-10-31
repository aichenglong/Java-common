package org.common.domain;

//import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import java.io.Serializable;

/**
 * Author: ICL
 * Date:2018/10/22
 * Description:
 * Created by ICL on 2018/10/22.
 */
public abstract class BaseEntity<ID> implements Serializable {

    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public BaseEntity(){

    }
    public BaseEntity(ID id) {
        this();
        this.id = id;
    }


    /**
     * 插入之前执行方法，子类实现
     */
    public abstract void preInsert();

    /**
     * 更新之前执行方法，子类实现
     */
    public abstract void preUpdate();

//    @Override
//    public String toString() {
//        return ReflectionToStringBuilder.toString(this);
//    }

}
