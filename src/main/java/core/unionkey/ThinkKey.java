package core.unionkey;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangheng on 2017/3/18.
 */
@Embeddable
public class ThinkKey implements Serializable{
    private static final long serialVersionUID = -3304319243957832225L;
    private String userid ;
    private String knowledgeid ;
    private Date date;

    public ThinkKey() {
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


    public ThinkKey(String knowledgeid, String userid, Date date) {
        this.knowledgeid = knowledgeid;
        this.userid = userid;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override

    public boolean equals(Object o) {
        if(o instanceof ThinkKey){
            ThinkKey key = (ThinkKey)o ;
            if(this.userid == key.getUserid() && this.knowledgeid.equals(key.getKnowledgeid())
                    && this.date == key.getDate()){
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
