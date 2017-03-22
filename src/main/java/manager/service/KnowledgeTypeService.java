package manager.service;

import core.service.serviceImpl.BaseServiceImpl;
import manager.dao.KnowledgeDao;
import manager.dao.KnowledgeTypeDao;
import manager.entity.KnowledgeType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangheng on 2017/3/8.
 */
@Service
public class KnowledgeTypeService extends BaseServiceImpl<KnowledgeType>{
    KnowledgeTypeDao knowledgeTypeDao;

    @Resource
    public void setKnowledgeTypeDao(KnowledgeTypeDao knowledgeTypeDao) {
        this.knowledgeTypeDao = knowledgeTypeDao;
        this.dao = knowledgeTypeDao;
    }
}
