package manager.entity;

import core.unionkey.UpLoadKey;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangheng on 2017/3/4.
 */
@Entity
@Table(name = "knowledgeupload")
public class KnowledgeUpLoad implements Serializable{

    //上传日期
    private Date date;
    //上传联合主键
    @Id
    private UpLoadKey upLoadKey;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UpLoadKey getUpLoadKey() {
        return upLoadKey;
    }

    public void setUpLoadKey(UpLoadKey upLoadKey) {
        this.upLoadKey = upLoadKey;
    }
}
