package pvars.arsenalquan.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Thông tin không được bỏ trống")
    @Size(max = 50)
    private String loaiTin;

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank(message = "Thông tin không được bỏ trống")
    private Date ngayTao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayThayDoi;

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank(message = "Thông tin không được bỏ trống")
    private Date taoBoi;

    private Date thayDoiBoi;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoaiTin() {
        return loaiTin;
    }

    public void setLoaiTin(String loaiTin) {
        this.loaiTin = loaiTin;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThayDoi() {
        return ngayThayDoi;
    }

    public void setNgayThayDoi(Date ngayThayDoi) {
        this.ngayThayDoi = ngayThayDoi;
    }

    public Date getTaoBoi() {
        return taoBoi;
    }

    public void setTaoBoi(Date taoBoi) {
        this.taoBoi = taoBoi;
    }

    public Date getThayDoiBoi() {
        return thayDoiBoi;
    }

    public void setThayDoiBoi(Date thayDoiBoi) {
        this.thayDoiBoi = thayDoiBoi;
    }

    public Category(Long id, @NotBlank(message = "Thông tin không được bỏ trống") @Size(max = 50) String loaiTin, @NotBlank(message = "Thông tin không được bỏ trống") Date ngayTao, @NotBlank(message = "Thông tin không được bỏ trống") Date ngayThayDoi, @NotBlank(message = "Thông tin không được bỏ trống") Date taoBoi, @NotBlank(message = "Thông tin không được bỏ trống") Date thayDoiBoi) {
        this.id = id;
        this.loaiTin = loaiTin;
        this.ngayTao = ngayTao;
        this.ngayThayDoi = ngayThayDoi;
        this.taoBoi = taoBoi;
        this.thayDoiBoi = thayDoiBoi;
    }
}
