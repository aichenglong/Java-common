package org.common.base.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.common.idgen.IdGenerate;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * Author: ICL
 * Date:2018/10/22
 * Description:
 * Created by ICL on 2018/10/22.
 */
public abstract class DataEntity<T, ID extends java.io.Serializable > extends BaseEntity {
    /**
//     * 删除标记0：正常
//     */
//    private static final String DEL_FLAG_NORMAL = "0";
//    /**
//     * 删除标记1：删除
//     */
//    private static final String DEL_FLAG_DELETE = "1";

    private static final long serialVersionUID = -4839183827907638164L;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期",hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Date createDate;

    @ApiModelProperty(value = "创建用户",hidden = true)
    private String createBy;
    /**
     * 更新日期
     */
    @ApiModelProperty(value = "更新日期",hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Date updateDate;

    @ApiModelProperty(value = "更新用户",hidden = true)
    private String updateBy;
    /**
     * 删除标记(0:正常;1:删除;)
     */
    @ApiModelProperty(value = "删除标记(0:正常;1:删除;)",hidden = true)
    private String status;

    /**
     * 租户名称
     */
    @ApiModelProperty(value = "租户名称)",hidden = true)
    private String corpName;

    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码)",hidden = true)
    private String corpCode;





    @ApiModelProperty(value = "备注信息")
    private String remarks;


    public DataEntity() {
        super();
//        this.status = DEL_FLAG_NORMAL;
    }

    public DataEntity(ID id) {
//        super(id);
    }


    /**
     * 插入之前执行方法，需要手动调用
     */
//    @Override
//    public void preInsert() {
////        this.setId(IdGenerate.nextId());
//        this.updateDate = new Date();
//        this.createDate = this.updateDate;
////        String userDetails = (String) SecurityContextHolder.getContext()
////                .getAuthentication()
////                .getPrincipal();
////        this.updateBy="admin";
////        this.createBy="admin";
//    }

//    /**
//     * 更新之前执行方法，需要手动调用
//     */
//    @Override
//    public void preUpdate() {
//        this.updateDate = new Date();
//    }


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


    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    @JsonIgnore
    @Length(min = 1, max = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
