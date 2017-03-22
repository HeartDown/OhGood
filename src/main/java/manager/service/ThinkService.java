package manager.service;

import core.service.serviceImpl.BaseServiceImpl;
import core.unionkey.ThinkKey;
import core.unionkey.UpLoadKey;
import manager.dao.ThinkDao;
import manager.entity.Knowledge;
import manager.entity.KnowledgeUpLoad;
import manager.entity.Think;
import manager.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangheng on 2017/3/16.
 */
@Service
public class ThinkService extends BaseServiceImpl<Think>{
    ThinkDao thinkDao;

    public ThinkDao getThinkDao() {
        return thinkDao;
    }
    @Resource
    public void setThinkDao(ThinkDao thinkDao) {
        this.thinkDao = thinkDao;
        dao = thinkDao;
    }
    //用户上传知识保存
    @Transactional
    public void uploadThink(User user, Knowledge knowledge,String word){
        Think think = new Think();
        think.setWord(word);
        think.setThinkKey(new ThinkKey(knowledge.getId(),user.getId(),new Date()));
        thinkDao.sava(think);
    }

    public List<Think> findWithSameKnowledge(Knowledge knowledge) throws Exception {
        return thinkDao.getEntityByPropName("knowledgeid",knowledge.getId());
    }
}
