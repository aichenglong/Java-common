package org.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * Author: ICL
 * Date:2018/10/22
 * Description:
 * Created by ICL on 2018/10/22.
 */
public abstract class DataEntity<T, ID> extends BaseEntity {
    /**
     * 删除标记0：正常
     */
    public static final String DEL_FLAG_NORMAL = "0";
    /**
     * 删除标记1：删除
     */
    public static final String DEL_FLAG_DELETE = "1";

    private static final long serialVersionUID = -4839183827907638164L;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    /**
     * 更新日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    /**
     * 删除标记(0:正常;1:删除;)
     */
    private String delFlag;


    public DataEntity() {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public DataEntity(ID id) {
        super(id);
    }


    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert() {
//        this.setId(IdGenerate.nextId());
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate() {
        this.updateDate = new Date();
    }


    public Date getCreateDate() {
        return createDate == null ? null : (Date) createDate.clone();
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate == null ? null : (Date) createDate.clone();
    }

    public Date getUpdateDate() {
        return updateDate == null ? null : (Date) updateDate.clone();
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate == null ? null : (Date) updateDate.clone();
    }

    @JsonIgnore
    @Length(min = 1, max = 1)
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
