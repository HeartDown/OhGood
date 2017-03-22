package manager.entity;

import core.unionkey.ThinkKey;
import core.unionkey.UpLoadKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangheng on 2017/3/16.
 */
@Entity
@Table(name = "think")
public class Think implements Serializable {
    //上传联合主键
    @Id
    private ThinkKey thinkKey;

    private String word;

    public ThinkKey getThinkKey() {
        return thinkKey;
    }

    public void setThinkKey(ThinkKey thinkKey) {
        this.thinkKey = thinkKey;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
