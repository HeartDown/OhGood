package core.dao.daoImpl;

import core.constant.MainConstant;
import core.dao.Dao;
import core.util.ReflectUtil;
import org.hibernate.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhangheng on 2017/2/27.
 */

public class DaoImpl<E> implements Dao<E>{

    private SessionFactory sessionFactory;
    //使用反射工具得到参数类型
    public Class<E> eClass = ReflectUtil.findParameterizedType(getClass());

    //初始化泛型实体
    public DaoImpl() {
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }

    public Session getSession(){
        return this.getSessionFactory().getCurrentSession();
    }

    @Override
    public Serializable sava(E entity) {
        return getSession().save(entity);
    }

    @Override
    public void delete(E entity) {
        getSession().delete(entity);
    }

    @Override
    public boolean deleteById(Serializable... id) {
        boolean result = false;
        if (id != null && id.length>0){
            for (int i = 0; i < id.length; i++) {
                if (getEntity(id[i]) != null) {
                    getSession().delete(getEntity(id[i]));
                    result = true;
                }
                }
            }
        return result;
    }

    /**
     * 根据属性名和值查询结果集
     * @param propName
     * @param propValue
     * @return
     * @throws Exception
     */
    public List<E> get(String[] propName, Object[] propValue) throws Exception {
        if (Objects.equals(null,propName) || Objects.equals(null , propValue)
            || Objects.equals(0,propName.length) || Objects.equals(0,propValue.length)
                || !Objects.equals(propName.length,propValue.length)){
            throw new Exception(MainConstant.CONDITION_TIP);
        }
        //此处使用getCurrentSession()事务管理器为空报错。
        Session session = getSessionFactory().openSession();
        List<E> list = null;

        StringBuilder stringBuilder = new StringBuilder(" from "+this.eClass.getSimpleName() + " where ");

        for (int i = 0; i < propName.length; i++) {
            stringBuilder.append(propName[i]+"= :"
                    +propName[i]+" and ");
        }
        stringBuilder.append(MainConstant.SQL_TRUE);
        Query query = session.createQuery(stringBuilder.toString());
        //hql设置参数（此处未对Data等特殊多值映射做反应）
        for (int i = 0; i < propName.length; i++) {
            query.setParameter(propName[i],propValue[i]);
        }
        list = query.list();
        session.close();
        return list;
    }

    /**
     * 根据属性名称和值得到实体
     * @param propName
     * @param propValue
     * @return
     */
    public List<E> getEntityByPropName(String propName,Object propValue) throws Exception {
        String[] propNames = {propName};
        Object[] propValues = {propValue};
        List<E> list = get(propNames,propValues);
        return list;
    }
    @Override
    public void update(E entity) {
        getSession().update(entity);
    }

    @Override
    public E getEntity(Serializable id) {
        return  getSession().get(this.eClass,id);
    }

    @Override
    public List<E> listEntity() {
        Criteria cri = getSession().createCriteria(this.eClass);
        return cri.list();
    }
}
