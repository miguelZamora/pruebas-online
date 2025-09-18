package cl.cachoza.web001.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sefwp_users")
public class WpUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "user_login", nullable = false, length = 60)
    private String userLogin;

    @Column(name = "user_pass", nullable = false, length = 255)
    private String userPass;

    @Column(name = "user_nicename", nullable = false, length = 50)
    private String userNicename;

    @Column(name = "user_email", nullable = false, length = 100)
    private String userEmail;

    @Column(name = "user_url", nullable = false, length = 100)
    private String userUrl;

    @Column(name = "user_registered", nullable = false)
    private LocalDateTime userRegistered;

    @Column(name = "user_activation_key", nullable = false, length = 255)
    private String userActivationKey;

    @Column(name = "user_status", nullable = false)
    private Integer userStatus;

    @Column(name = "display_name", nullable = false, length = 250)
    private String displayName;

    // Constructores
    public WpUserEntity() {}

    public WpUserEntity(String userLogin, String userPass, String userNicename, 
                       String userEmail, String userUrl, LocalDateTime userRegistered, 
                       String userActivationKey, Integer userStatus, String displayName) {
        this.userLogin = userLogin;
        this.userPass = userPass;
        this.userNicename = userNicename;
        this.userEmail = userEmail;
        this.userUrl = userUrl;
        this.userRegistered = userRegistered;
        this.userActivationKey = userActivationKey;
        this.userStatus = userStatus;
        this.displayName = displayName;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserNicename() {
        return userNicename;
    }

    public void setUserNicename(String userNicename) {
        this.userNicename = userNicename;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public LocalDateTime getUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(LocalDateTime userRegistered) {
        this.userRegistered = userRegistered;
    }

    public String getUserActivationKey() {
        return userActivationKey;
    }

    public void setUserActivationKey(String userActivationKey) {
        this.userActivationKey = userActivationKey;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}