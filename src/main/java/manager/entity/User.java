package manager.entity;

import com.alibaba.fastjson.annotation.JSONType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


/**
 * Created by zhangheng on 2017/2/23.
 */
@Entity
@Table(name = "user")
@JSONType(orders = {"username","email","phone"})
public class User implements Serializable{
    @Id
    @GenericGenerator(name = "hello" , strategy = "uuid")
    @GeneratedValue(generator = "hello")
    @Column(columnDefinition = "CHAR(32)")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
