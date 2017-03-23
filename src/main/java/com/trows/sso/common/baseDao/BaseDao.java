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
    int insert(Model model);

    int insert(String operate, Object object);

    int update(Model model);

    int update(String operate, Object object);

    int delete(Key key);

    int delete(String operate, Object object);

    <X> List<X> find(String operate, Object object);

    Model get(Key key);

    Object get(String operate, Object object);

    Model getModel(String operate, Object object);

}
