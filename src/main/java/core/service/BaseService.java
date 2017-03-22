package core.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangheng on 2017/2/27.
 */
public interface BaseService<E> {

    /**
     * 保存实体
     * @param entity
     * @return ID
     */
    public Serializable sava(E entity);

    /**
     * 删除实体
     * @param entity
     */
    public void delete(E entity);

    /**
     * 通过ID删除
     * @param id
     * @return
     */
    public boolean deleteById(Serializable... id);

    /**
     * 更新实体
     * @param entity
     */
    public void update(E entity);

    /**
     * 根据ID查询实体
     * @param id
     * @return 实体对象
     */
    public E getEntity(Serializable id);

    /**
     * 查询所有实体
     * @return
     */
    public List<E> listEntity();

}
