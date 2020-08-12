package pvars.arsenalquan.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Thông tin không được bỏ trống")
    private String vaiTro;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Role(Long id, @NotBlank(message = "Thông tin không được bỏ trống") String vaiTro) {
        this.id = id;
        this.vaiTro = vaiTro;
    }
}
