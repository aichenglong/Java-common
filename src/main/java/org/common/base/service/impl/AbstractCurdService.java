package org.common.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.common.annotation.ReadDataSource;
import org.common.annotation.WriteDataSource;
import org.common.base.dao.CurdDao;
import org.common.base.service.CurdService;
import org.common.base.domain.DataEntity;
import org.common.lang.StringUtils;

import java.util.List;

/**
 * Author: ICL
 * Date:2018/10/26
 * Description:
 * Created by ICL on 2018/10/26.
 */
public abstract class AbstractCurdService<T extends DataEntity, ID extends java.io.Serializable> extends AbstractBaseService<T,
        ID> implements CurdService<T, ID> {

    public abstract CurdDao<T, ID> getCurdDao();

    @WriteDataSource
    @Override
    public int deleteByPrimaryKey(ID id) {
        return getCurdDao().deleteByPrimaryKey(id);
    }

    @WriteDataSource
    @Override
    public T  insert(T record) {
//        record.preInsert();
//        record.setId(getCurdDao().insert(record));
        return record;
    }

    @WriteDataSource
    @Override
    public T insertSelective(T record) {
//        record.preInsert();
//        record.setId(getCurdDao().insertSelective(record));
        return record;
    }


    @ReadDataSource
    @Override
    public T selectByPrimaryKey(ID id) {
        return getCurdDao().selectByPrimaryKey(id);
    }

    @WriteDataSource
    @Override
    public T updateByPrimaryKeySelective(T record) {
//        record.preUpdate();
//        record.setId(getCurdDao().updateByPrimaryKeySelective(record));
        return record;
    }

    @WriteDataSource
    @Override
    public T updateByPrimaryKey(T record) {
//        record.preUpdate();
//        record.setId(getCurdDao().updateByPrimaryKey(record));
        return record;
    }




    @ReadDataSource
    @Override
    public List<T> findAll() {

        return getCurdDao().findAll();
    }


    @ReadDataSource
    @Override
    public T findByCondition(String property, Object value) throws TooManyResultsException {

        return getCurdDao().findByCondition(StringUtils.uncamelCase(property),value);
    }
    @ReadDataSource
    @Override
    public PageInfo<T> queryPage(T t, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<T> records = getCurdDao().findByCondition(t);
        PageInfo<T> pageInfo = new PageInfo<>(records);
        return pageInfo;
    }
}
