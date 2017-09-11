package bodor.com.yourowndb;

/**
 * Created by Administrator on 2017/9/9 0009.
 */

public class Account {
    private String UserName;
    private String Email;

    public Account() {
    }
    public Account(String userName, String email) {
        UserName = userName;
        Email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
