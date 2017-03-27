package com.trows.sso.common.baseDao;

import com.trows.sso.common.utils.GetEntityClassUtil;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by trows on 17-3-22.
 * 持久层mybatis实现方法
 */
@Service
public class BaseDaoImpl<Model, Key extends Serializable> extends SqlSessionDaoSupport implements BaseDao<Model, Key> {

    //mybatis 1.2以上不会自动注入SqlSessionTemplate
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public int insert(String namespace, Object object) {
        return getSqlSession().insert(namespace + ".insert", object);
    }

    public int insert(String namespace, String operate, Object object) {
        return getSqlSession().insert(namespace + "." + operate, object);
    }

    public int update(String namespace, Model model) {
        return getSqlSession().update(namespace + ".update", model);
    }

    public int update(String namespace, String operate, Object object) {
        return getSqlSession().update(namespace + "." + operate, object);
    }

    public int delete(String namespace, Key key) {
        return getSqlSession().delete(namespace + ".delete", key);
    }

    public int delete(String namespace, String operate, Object object) {
        return getSqlSession().delete(namespace + "." + operate, object);
    }

    public <X> List<X> find(String namespace, String operate, Object object) {
        return getSqlSession().selectList(namespace + "." + operate, object);
    }

    public Model get(String namespace, Key key) {
        return getSqlSession().selectOne(namespace + ".get", key);
    }

    public Object get(String namespace, String operate, Object object) {
        return getSqlSession().selectOne(namespace + "." + operate, object);
    }

    public Model getModel(String namespace, String operate, Object object) {
        return getSqlSession().selectOne(namespace + "." + operate, object);
    }


}
