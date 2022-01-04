package json;

import java.io.Serializable;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 19:02
 * @Classname: User
 * @Description: TODO
 */
public class User implements Serializable {
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static final long serialVersionUID = 1L;
    public String username;
    public String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + this.username + '\'' +
                ", password='" + this.password + '\'' +
                '}';
    }
}
