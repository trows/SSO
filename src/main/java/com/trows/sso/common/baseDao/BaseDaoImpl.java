package com.trows.sso.common.baseDao;

import com.trows.sso.common.utils.GetEntityClassUtil;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by trows on 17-3-22.
 * 持久层mybatis实现方法
 */
public class BaseDaoImpl<Model, Key extends Serializable> extends SqlSessionDaoSupport implements BaseDao<Model, Key> {

    private final String namespace = GetEntityClassUtil.getEntityClass(this.getClass()).getName();

    public int insert(Object object) {
        return getSqlSession().insert(namespace + ".insert", object);
    }

    public int insert(String operate, Object object) {
        return getSqlSession().insert(namespace + "." + operate, object);
    }

    public int update(Model model) {
        return getSqlSession().update(namespace + ".update", model);
    }

    public int update(String operate, Object object) {
        return getSqlSession().update(namespace + "." + operate, object);
    }

    public int delete(Key key) {
        return getSqlSession().delete(namespace + ".delete", key);
    }

    public int delete(String operate, Object object) {
        return getSqlSession().delete(namespace + "." + operate, object);
    }

    public <X> List<X> find(String operate, Object object) {
        return getSqlSession().selectList(namespace + "." + operate, object);
    }

    public Model get(Key key) {
        return getSqlSession().selectOne(namespace + ".get", key);
    }

    public Object get(String operate, Object object) {
        return getSqlSession().selectOne(namespace + "." + operate, object);
    }

    public Model getModel(String operate, Object object) {
        return getSqlSession().selectOne(namespace + "." + operate, object);
    }


}
