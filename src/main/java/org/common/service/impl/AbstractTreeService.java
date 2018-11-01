package org.common.service.impl;

import org.common.domain.DataEntity;
import org.common.service.TreeService;

/**
 * Author: ICL
 * Date:2018/10/26
 * Description:
 * Created by ICL on 2018/10/26.
 */
public abstract  class AbstractTreeService<T extends DataEntity, ID> extends AbstractCurdService<T,ID> implements TreeService<T,ID> {

}
