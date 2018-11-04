package org.common.service;


import org.common.domain.TreeEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Author: ICL
 * Date:2018/10/26
 * Description:树形结构服务类
 * Created by ICL on 2018/10/26.
 */
public interface TreeService<T extends TreeEntity, ID> extends CurdService<T,ID>  {

    /**
     * 获得指定节点下所有归档
     * @param list
     * @param parentId
     * @return
     */
    public List<T> getChildTreeObjects(List<T> list, String parentId);


    /**
     * 递归列表
     * @param list
     * @param t
     */
    public void recursionFn(List<T> list,T t);

    /**
     * 获得指定节点下的所有子节点
     * @param list
     * @param t
     * @return
     */
    public List<T> getChildList(List<T> list,T t);

    /**
     * 判断是否还有下一个子节点
     * @param list
     * @param t
     * @return
     */
    public boolean hasChild(List<T> list, T t);
}
