package berich.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "user")
public class UserDTO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usercode;
    private String name;
    private String userId;
    private String password;
    private String like;

    public int getUsercode() {
        return usercode;
    }

    public void setUsercode(int usercode) {
        this.usercode = usercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return userId;
    }

    public void setId(String id) {
        this.userId = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
