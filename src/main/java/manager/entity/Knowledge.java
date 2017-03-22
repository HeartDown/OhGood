package manager.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhangheng on 2017/3/4.
 */
@Entity
@Table(name = "knowledge")
public class Knowledge implements Serializable{
    @Id
    @GenericGenerator(name = "hello" , strategy = "uuid")
    @GeneratedValue(generator = "hello")
    @Column(columnDefinition = "CHAR(32)")
    private String id;

    private String imgpath;

    public String getImgpath() {
        return imgpath;
    }
    public Knowledge(String id, String title, String content, String source, String type,String imgpath) {
        this.id = id;
        this.content = content;
        this.source = source;
        this.title = title;
        this.type = type;
        this.imgpath = imgpath;
    }
    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public Knowledge(String id, String title, String content, String source, String type) {
        this.id = id;
        this.content = content;
        this.source = source;
        this.title = title;
        this.type = type;
    }

    private String title;

    public Knowledge() {
    }

    private String source;

    private String content;

    private String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
