package org.common.base.service.impl;

import org.common.base.service.TreeService;
import org.common.base.domain.TreeEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author: ICL
 * Date:2018/10/26
 * Description:
 * Created by ICL on 2018/10/26.
 */
public abstract class AbstractTreeService<T extends TreeEntity, ID  extends java.io.Serializable> extends AbstractCurdService<T,
        ID> implements TreeService<T, ID> {

    @Override
    public List<T> getChildTreeObjects(List<T> list, String parentId) {
        List<T> returnList = new ArrayList<T>();
        for (Iterator<T> iterator = list.iterator(); iterator.hasNext(); ) {
            T res = (T) iterator.next();
            //判断第一个对象是否为第一个节点
            if ((res.getParentId().toString()) .equals(parentId)) {
                //等--说明第一个节点为父节点--递归下面的子节点
                recursionFn(list, res);
                returnList.add(res);
            }
        }
        return returnList;
    }


    @Override
    public void recursionFn(List<T> list, T t) {
        List<T> childrenLists = getChildList(list, t);
        //设置他的子集对象集
        t.setChildren(childrenLists);
        //迭代--这些子集的对象--时候还有下一级的子级对象
        for (T nextChild : childrenLists) {
            //下一个对象，与所有的资源集进行判断
            if (hasChild(list, nextChild)) {
                // 有下一个子节点,递归
                Iterator<T> it = childrenLists.iterator();
                while (it.hasNext()) {
                    T node = it.next();
                    //所有的对象--跟当前这个childrenLists 的对象子节点
                    recursionFn(list, node);
                }
            }
        }
    }

    @Override
    public List<T> getChildList(List<T> list, T t) {
        List<T> childrenLists = new ArrayList<T>();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            T child = it.next();
            //判断集合的父ID是否等于上一级的id
            if ((((TreeEntity<T, ID>) child).getParentId().toString()).equals (((TreeEntity<T, ID>) t).getId().toString())) {
                childrenLists.add(child);
            }
        }
        return childrenLists;
    }

    @Override
    public boolean hasChild(List<T> list, T t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
