package manager.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zhangheng on 2017/3/4.
 */
@Entity
@Table(name = "knowledgetype")
public class KnowledgeType {
    @Id
    @GenericGenerator(name = "hello" , strategy = "uuid")
    @GeneratedValue(generator = "hello")
    @Column(columnDefinition = "CHAR(32)")
    private String id;
    //类型代码
    private int code;
    //类型名称
    private String typename;
    //父类型id
    private String parentid;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
