package manager.dao;

import core.dao.daoImpl.DaoImpl;
import manager.entity.Knowledge;
import manager.entity.Think;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangheng on 2017/3/16.
 */
@Repository
public class ThinkDao extends DaoImpl<Think>{
    public List<Think> findWithSameKnowledge(Knowledge knowledge) throws Exception {
        return getEntityByPropName("knowledgeid",knowledge.getId());
    }
}
