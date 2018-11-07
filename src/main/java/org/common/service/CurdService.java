package org.common.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.common.domain.DataEntity;

import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * Author: ICL
 * Date:2018/10/26
 * Description:
 * Created by ICL on 2018/10/26.
 */
public interface CurdService<T extends DataEntity, ID> extends BaseService {


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_T
     *
     *  Fri Oct 26 20:51:19 CST 2018
     */
    int deleteByPrimaryKey(ID id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_T
     *
     *  Fri Oct 26 20:51:19 CST 2018
     */
    int insert(T record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_T
     *
     *  Fri Oct 26 20:51:19 CST 2018
     */
    int insertSelective(T record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_T
     *
     *  Fri Oct 26 20:51:19 CST 2018
     */
    T selectByPrimaryKey(ID id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_T
     *
     *  Fri Oct 26 20:51:19 CST 2018
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_T
     *
     *  Fri Oct 26 20:51:19 CST 2018
     */
    int updateByPrimaryKey(T record);


    void deleteById(ID id);//通过主鍵刪除



    List<T> findAll();//获取所有





    T findBy(String property, Object value) throws TooManyResultsException; //通过某个成员属性查找,value需符合unique约束

    PageInfo<T> queryPage(T user, int currentPage, int pageSize);
}
