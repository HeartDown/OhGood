package core.unionkey;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by zhangheng on 2017/3/4.
 */
@Embeddable
public class UpLoadKey implements Serializable{
    private static final long serialVersionUID = -3304319243957837925L;
    protected String userid ;
    protected String knowledgeid ;

    public UpLoadKey(String knowledgeid, String userid) {
        this.knowledgeid = knowledgeid;
        this.userid = userid;
    }

    public UpLoadKey() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getKnowledgeid() {
        return knowledgeid;
    }

    public void setKnowledgeid(String knowledgeid) {
        this.knowledgeid = knowledgeid;
    }

    @Override

    public boolean equals(Object o) {
        if(o instanceof UpLoadKey){
            UpLoadKey key = (UpLoadKey)o ;
            if(this.userid == key.getUserid() && this.knowledgeid.equals(key.getKnowledgeid())){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public int hashCode() {
        return this.userid.hashCode();
    }
}
