package org.common.model;
import org.mybatis.Table;
import org.common.base.domain.DataEntity;
import org.mybatis.PrimaryKey;

@Table("sys_user")
public class User extends DataEntity<User,Long> {

    @PrimaryKey("id")
    private Long id;
    private String userName;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, account=%s, password=%s}", id, userName, password);
    }
}
