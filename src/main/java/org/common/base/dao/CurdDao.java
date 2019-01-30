package org.common.base.dao;


import org.apache.ibatis.annotations.Param;
import org.common.base.domain.DataEntity;

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
    int deleteByPrimaryKey(ID id);

    /**
     * 插入数据
     * @param record 实体类
     * @return
     */
    ID insert(T record);

    /**
     * 插入
     * @param record 实体类
     * @return
     */
    ID insertSelective(T record);

    /**
     * 根据id查询
     * @param id 主键id
     * @return
     */
    T selectByPrimaryKey(ID id);

    /**
     * 更新
     * @param record 实体类
     * @return
     */
    ID updateByPrimaryKeySelective(T record);

    /**
     * 更新
     * @param record 实体类
     * @return
     */
    ID updateByPrimaryKey(T record);


    /**
     *  查询所有数据
     * @return  获取所有的数据
     */
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
    List<T> findByCondition(T record);//根据条件查找


    /**
     *
     * @param property
     * @param value
     * @return
     */
    T findByCondition(@Param("property") String property, @Param("value") Object value);//根据条件查找


}
