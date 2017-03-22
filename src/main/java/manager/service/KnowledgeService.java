package manager.service;

import core.service.serviceImpl.BaseServiceImpl;
import manager.dao.KnowledgeDao;
import manager.entity.Knowledge;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangheng on 2017/3/4.
 */
@Service
public class KnowledgeService extends BaseServiceImpl<Knowledge>{
    KnowledgeDao knowledgeDao;

    @Resource
    public void setKnowledgeDao(KnowledgeDao knowledgeDao) {
        this.knowledgeDao = knowledgeDao;
        this.dao = knowledgeDao;
    }


    public Knowledge getOneKnowledge(String propName, Object propValue) throws Exception {
        List<Knowledge> list =get(propName, propValue);
        if (list.isEmpty())
            return null;
        return list.get(0);
    }
}
