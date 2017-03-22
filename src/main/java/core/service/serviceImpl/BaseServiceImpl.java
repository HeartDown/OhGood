package core.service.serviceImpl;

import core.dao.Dao;
import core.service.BaseService;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangheng on 2017/2/27.
 */
@Service
public class BaseServiceImpl<E> implements BaseService<E>{

    protected Dao<E> dao;

    @Override
    @Transactional
    public Serializable sava(E entity) {
        return this.dao.sava(entity);
    }

    @Override
    @Transactional
    public void delete(E entity) {
        this.dao.delete(entity);
    }

    @Override
    @Transactional
    public boolean deleteById(Serializable... id) {
        return this.dao.deleteById(id);
    }

    @Override
    @Transactional
    public void update(E entity) {
        this.dao.update(entity);
    }

    @Override
    @Transactional
    public E getEntity(Serializable id) {
        return this.dao.getEntity(id);
    }

    @Override
    @Transactional
    public List<E> listEntity() {
        return this.dao.listEntity();
    }

    @Transactional
    public List<E> get(String propName, Object propValue) throws Exception {
        return this.dao.getEntityByPropName(propName,propValue);
    }
}
