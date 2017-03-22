import core.dao.daoImpl.DaoImpl;
import core.util.SpringUtil;
import manager.dao.KnowledgeDao;
import manager.entity.Knowledge;
import manager.entity.KnowledgeType;
import manager.entity.Think;
import manager.entity.User;
import manager.service.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhangheng on 2017/3/3.
 */

public class TestDao {
    private static UserService userService;
    private static KnowledgeService knowledgeService;
    private static KnowledgeUpLoadService knowledgeUpLoadService;
    private static KnowledgeTypeService knowledgeTypeService;
    private static ThinkService thinkService;
    @Before
    public void before(){
        SpringUtil.ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        knowledgeTypeService = SpringUtil.getBean("knowledgeTypeService");
        knowledgeService = SpringUtil.getBean("knowledgeService");
        thinkService = SpringUtil.getBean("thinkService");
        userService = SpringUtil.getBean("userService");

    }
    @Test
    public void testGet() throws Exception {
        Knowledge knowledge = knowledgeService.getOneKnowledge("title","1111");
        List<Think> list = thinkService.get("knowledgeid","8a8aa1295aacaa55015aacaa5d050000");
        List<Knowledge> knowledges = knowledgeService.listEntity();
        Knowledge knowledge2 = knowledges.get(0);
        List<User> users = userService.listEntity();
        User user = users.get(0);
        thinkService.uploadThink(user,knowledge,"我觉得这个知识很傻比22222");

        System.out.println(knowledge.getContent());
        User user2 = new User();
        user.setId("0298304cda9044189e4dc446c6c23aef");
        user.setUsername("zhangheng");
        user.setPhone("1111");
        user.setEmail("111@q.com");
        user.setPassword("123456");

        Knowledge knowledge3 = new Knowledge();
        knowledge.setId(UUID.randomUUID().toString());
        knowledge.setContent("test3");
        knowledge.setSource("user");
        knowledge.setTitle("test3");
        knowledge.setType("艺术");
        knowledgeService.sava(knowledge);
        knowledgeUpLoadService.uploadKnowledge(user,knowledge);
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
        System.out.print("sss");
    }
}
