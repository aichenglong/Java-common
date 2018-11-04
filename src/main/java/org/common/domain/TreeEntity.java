package org.common.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: ICL
 * Date:2018/11/4
 * Description:
 * Created by ICL on 2018/11/4.
 */
public abstract class TreeEntity<T, ID extends Serializable> extends DataEntity<T, ID>{

    /**
     * 父级编号
     */
    private ID parentId;

    /**
     * 排序
     */
    private Long treeSort;

    /**
     * 是否最末级
     */
    private String treeLeaf;

    /**
     * 层次级别
     */
    private Short  treeLevel;


    private List<T> children=new ArrayList<>();

    public ID getParentId() {
        return parentId;
    }

    public void setParentId(ID parentId) {
        this.parentId = parentId;
    }

    public Long getTreeSort() {
        return treeSort;
    }

    public void setTreeSort(Long treeSort) {
        this.treeSort = treeSort;
    }

    public String getTreeLeaf() {
        return treeLeaf;
    }

    public void setTreeLeaf(String treeLeaf) {
        this.treeLeaf = treeLeaf;
    }

    public Short getTreeLevel() {
        return treeLevel;
    }

    public void setTreeLevel(Short treeLevel) {
        this.treeLevel = treeLevel;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
