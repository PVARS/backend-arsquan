package pvars.arsenalquan.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
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
    private String hoTen;

    @Size(max = 30)
    private String trangThai;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"),
        inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User(Long id, @NotBlank(message = "Thông tin không được bỏ trống") @Size(min = 3, max = 50, message = "Thông tin phải nhiều hơn 3 và ít hơn 50 ký tự") String username, @NotBlank(message = "Thông tin không được bỏ trống") @Size(min = 3, max = 50, message = "Thông tin phải nhiều hơn 3 và ít hơn 50 ký tự") String password, @NotBlank(message = "Thông tin không được bỏ trống") @Size(min = 3, max = 50, message = "Thông tin phải nhiều hơn 3 và ít hơn 50 ký tự") String hoTen, @Size(max = 30) String trangThai, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.hoTen = hoTen;
        this.trangThai = trangThai;
        this.roles = roles;
    }
}

