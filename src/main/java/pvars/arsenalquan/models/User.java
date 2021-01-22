package pvars.arsenalquan.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Thông tin không được bỏ trống")
    @Size(min = 3, max = 50, message = "Thông tin phải nhiều hơn 3 và ít hơn 50 ký tự")
    private String username;

    @NotBlank(message = "Thông tin không được bỏ trống")
    @Size(min = 3, max = 50, message = "Thông tin phải nhiều hơn 3 và ít hơn 50 ký tự")
    private String password;

    @NotBlank(message = "Thông tin không được bỏ trống")
    @Size(min = 3, max = 50, message = "Thông tin phải nhiều hơn 3 và ít hơn 50 ký tự")
    private String fullName;

    @Size(max = 30)
    private String status;

    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @CreatedBy
    private String createBy;

    @LastModifiedBy
    private String updateBy;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"),
        inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public User(Long id, @NotBlank(message = "Thông tin không được bỏ trống") @Size(min = 3, max = 50, message = "Thông tin phải nhiều hơn 3 và ít hơn 50 ký tự") String username, @NotBlank(message = "Thông tin không được bỏ trống") @Size(min = 3, max = 50, message = "Thông tin phải nhiều hơn 3 và ít hơn 50 ký tự") String password, @NotBlank(message = "Thông tin không được bỏ trống") @Size(min = 3, max = 50, message = "Thông tin phải nhiều hơn 3 và ít hơn 50 ký tự") String fullName, @Size(max = 30) String status, Date createDate, Date updateDate, String createBy, String updateBy, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.roles = roles;
    }
}

