package org.common.base.dao;


import org.apache.ibatis.annotations.*;
import org.common.base.domain.DataEntity;
import org.mybatis.BaseMapperDriver;

import java.util.List;

/**
 * Author: ICL
 * Date:2018/10/22
 * Description:
 * Created by ICL on 2018/10/22.
 */
public interface CurdDao<T extends DataEntity, ID extends java.io.Serializable> extends BaseDao {

    /**
     * 删除数据
     * @param id 主键ID
     * @return
     */
    @Lang(BaseMapperDriver.class)
    @Delete("DELETE FROM ${table} WHERE ${id}=#{id}")
    int deleteByPrimaryKey(ID id);

    /**
     * 插入数据
     * @param record 实体类
     * @return
     */
    @Lang(BaseMapperDriver.class)
    @Insert({"<script>", "INSERT INTO ${table} ${values}", "</script>"})
    ID insert(T record);

    /**
     * 插入
     * @param record 实体类
     * @return
     */
    @Lang(BaseMapperDriver.class)
    @Insert({"<script>", "INSERT INTO ${table} ${values}", "</script>"})
    ID insertSelective(T record);

    /**
     * 根据id查询
     * @param id 主键id
     * @return
     */
    @Lang(BaseMapperDriver.class)
    @Select("SELECT * FROM ${table} WHERE ${id}=#{id} and ${status}=#{status}")
    T selectByPrimaryKey(ID id);

    /**
     * 更新
     * @param record 实体类
     * @return
     */
    @Lang(BaseMapperDriver.class)
    @Update({"<script>", "UPDATE ${table} ${sets} WHERE ${id}=#{id}", "</script>"})
    ID updateByPrimaryKeySelective(T record);

    /**
     * 更新
     * @param record 实体类
     * @return
     */
    @Update({"<script>", "UPDATE ${table} ${sets} WHERE ${id}=#{id}", "</script>"})
    ID updateByPrimaryKey(T record);


    /**
     *  查询所有数据
     * @return  获取所有的数据
     */
    @Lang(BaseMapperDriver.class)
    @Select("SELECT * FROM ${table}")
    List<T> findAll();//获取所有

    /**
     * 分页查询
     * @param record 实体类
     * @return
     */
    List<T> pageInfo(T record);

    /**
     * 根据条件查询
     * @param record
     * @return
     */
    @Lang(BaseMapperDriver.class)
    @Select({"<script>","SELECT * FROM ${table} ${condition}", "</script>"})
    List<T> findByCondition(T record);//根据条件查找


    /**
     *
     * @param property
     * @param value
     * @return
     */
    T findByCondition(@Param("property") String property, @Param("value") Object value);//根据条件查找


}
