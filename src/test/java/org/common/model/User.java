package org.common.model;

import org.common.base.domain.DataEntity;
import org.mybatis.PrimaryKey;

public class User extends DataEntity<User,Long> {

    @PrimaryKey("id")
    private Long id;
    private String account;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, account=%s, password=%s}", id, account, password);
    }
}
