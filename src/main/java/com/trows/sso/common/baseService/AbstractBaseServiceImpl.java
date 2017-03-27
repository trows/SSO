package com.trows.sso.common.baseService;

import com.trows.sso.common.baseDao.BaseDao;
import com.trows.sso.common.utils.GetEntityClassUtil;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by trows on 17-3-27.
 * 实现service方法的抽象类
 */
public abstract class AbstractBaseServiceImpl<Model, Key extends Serializable>
        implements BaseService<Model, Key> {

    private final String namespace = GetEntityClassUtil.getEntityClass(this.getClass()).getName();

    @Resource
    private BaseDao<Model, Key> baseDao;

    public int insert(Model model) {
        return baseDao.insert(namespace, model);
    }

    public int insert(String operate, Object object) {
        return baseDao.insert(namespace, operate, object);
    }

    public int update(Model model) {
        return baseDao.update(namespace, model);
    }

    public int update(String operate, Object object) {
        return baseDao.update(namespace, operate, object);
    }

    public int delete(Key key) {
        return baseDao.delete(namespace, key);
    }

    public int delete(String operate, Object object) {
        return baseDao.delete(namespace, operate, object);
    }

    public <X> List<X> find(String operate, Object object) {
        return baseDao.find(namespace, operate, object);
    }

    public Model get(Key key) {
        return baseDao.get(namespace, key);
    }

    public Object get(String operate, Object object) {
        return baseDao.get(namespace, operate, object);
    }

    public Model getModel(String operate, Object object) {
        return baseDao.getModel(namespace, operate, object);
    }
}
