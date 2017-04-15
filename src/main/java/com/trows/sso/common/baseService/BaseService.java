package com.trows.sso.common.baseService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pengruoying on 2017/3/23.
 * service Interface
 */
public interface BaseService<Model, Key extends Serializable> {


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
