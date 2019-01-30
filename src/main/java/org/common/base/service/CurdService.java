package org.common.base.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.common.base.domain.DataEntity;

import java.util.List;

/**
 * Author: ICL
 * Date:2018/10/26
 * Description:
 * Created by ICL on 2018/10/26.
 */
public interface CurdService<T extends DataEntity, ID> extends BaseService {


    /**
     * 删除记录信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(ID id);

    /**
     * 新增记录信息
     * @param record
     * @return
     */
    T  insert(T record);
    /**
     * 新增记录信息
     * @param record
     * @return
     */
    T insertSelective(T record);

    /**
     * 根据主键查询记录信息
     * @param id
     * @return
     */
    T selectByPrimaryKey(ID id);

    /**
     * 根据实体更新记录信息
     * @param record
     * @return
     */
    T updateByPrimaryKeySelective(T record);


    /**
     * 根据主键更新记录信息
     * @param record
     * @return
     */
    T updateByPrimaryKey(T record);



    /**
     * 查询所有的记录信息
     * @return
     */
    List<T> findAll();


    /**
     * 通过某个成员属性查找,value需符合unique约束
     * @param property
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    T findByCondition(String property, Object value) throws TooManyResultsException;

    /**
     * 分页查询
     * @param user
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<T> queryPage(T user, int currentPage, int pageSize);
}
