package org.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.common.annotation.ReadDataSource;
import org.common.annotation.WriteDataSource;
import org.common.dao.CurdDao;
import org.common.domain.DataEntity;
import org.common.service.CurdService;

import javax.print.Doc;
import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * Author: ICL
 * Date:2018/10/26
 * Description:
 * Created by ICL on 2018/10/26.
 */
public abstract class AbstractCurdService<T extends DataEntity, ID> implements CurdService<T, ID> {

    public abstract CurdDao<T, ID> getCurdDao();

    @WriteDataSource
    @Override
    public int deleteByPrimaryKey(ID id) {
        return getCurdDao().deleteByPrimaryKey(id);
    }

    @WriteDataSource
    @Override
    public int insert(T record) {
        record.preInsert();
        return getCurdDao().insert(record);
    }

    @WriteDataSource
    @Override
    public int insertSelective(T record) {
        record.preInsert();
        return getCurdDao().insertSelective(record);
    }


    @ReadDataSource
    @Override
    public T selectByPrimaryKey(ID id) {
        return getCurdDao().selectByPrimaryKey(id);
    }

    @WriteDataSource
    @Override
    public int updateByPrimaryKeySelective(T record) {
        record.preUpdate();
        return getCurdDao().updateByPrimaryKeySelective(record);
    }

    @WriteDataSource
    @Override
    public int updateByPrimaryKey(T record) {
        record.preUpdate();
        return getCurdDao().updateByPrimaryKey(record);
    }


    @WriteDataSource
    @Override
    public void deleteById(ID id) {
        getCurdDao().deleteByPrimaryKey(id);
    }


    @ReadDataSource
    @Override
    public List<T> findAll() {
        return getCurdDao().findAll();
    }


    @ReadDataSource
    @Override
    public T findBy(String property, Object value) throws TooManyResultsException {
        return null;
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
