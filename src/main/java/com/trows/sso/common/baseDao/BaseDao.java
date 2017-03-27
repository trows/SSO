package com.trows.sso.common.baseDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by trows on 17-3-22.
 * 持久层接口
 */
public interface BaseDao<Model, Key extends Serializable> {

    /**
     * 增删改方法
     */
    int insert(String namespace, Model model);

    int insert(String namespace, String operate, Object object);

    int update(String namespace, Model model);

    int update(String namespace, String operate, Object object);

    int delete(String namespace, Key key);

    int delete(String namespace, String operate, Object object);

    <X> List<X> find(String namespace, String operate, Object object);

    Model get(String namespace, Key key);

    Object get(String namespace, String operate, Object object);

    Model getModel(String namespace, String operate, Object object);

}
