package manager.service;

import core.service.serviceImpl.BaseServiceImpl;
import core.unionkey.UpLoadKey;
import manager.dao.KnowledgeUpLoadDao;
import manager.entity.Knowledge;
import manager.entity.KnowledgeUpLoad;
import manager.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by zhangheng on 2017/3/4.
 */
@Service
public class KnowledgeUpLoadService extends BaseServiceImpl<KnowledgeUpLoad>{

    KnowledgeUpLoadDao knowledgeUpLoadDao;

    public KnowledgeUpLoadDao getKnowledgeUpLoadDao() {
        return knowledgeUpLoadDao;
    }
    @Resource
    public void setKnowledgeUpLoadDao(KnowledgeUpLoadDao knowledgeUpLoadDao) {
        this.knowledgeUpLoadDao = knowledgeUpLoadDao;
    }

    //用户上传知识保存
    @Transactional
    public void uploadKnowledge(User user, Knowledge knowledge){
        KnowledgeUpLoad knowledgeUpLoad = new KnowledgeUpLoad();
        knowledgeUpLoad.setDate(new Date());
        knowledgeUpLoad.setUpLoadKey(new UpLoadKey(knowledge.getId(),user.getId()));
        knowledgeUpLoadDao.sava(knowledgeUpLoad);
    }
}
