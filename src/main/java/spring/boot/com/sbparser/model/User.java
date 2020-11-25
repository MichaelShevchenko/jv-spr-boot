package spring.boot.com.sbparser.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String externalUserId;
    private String profileName;
    private String password;
    @ManyToMany
    private Set<Role> roles;

    public User() {
    }

    public User(String password, Set<Role> roles) {
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalUserId() {
        return externalUserId;
    }

    public void setExternalUserId(String externalUserId) {
        this.externalUserId = externalUserId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", externalUserId='" + externalUserId + '\''
                + ", profileName='" + profileName + '\'' + ", password='" + password
                + '\'' + ", roles=" + roles + '}';
    }

    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return Objects.equals(this.id, user.id)
                && Objects.equals(this.externalUserId, user.externalUserId)
                && Objects.equals(this.profileName, user.profileName)
                && Objects.equals(this.password, user.password)
                && Objects.equals(this.roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalUserId, profileName, password, roles);
    }
}
