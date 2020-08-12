package pvars.arsenalquan.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String thumbnail;

    @NotBlank(message = "Thông tin không được để trống")
    private String tieuDe;

    @Size(max = 200)
    private String moTaNgan;

    @NotBlank(message = "Thông tin không được bỏ trống")
    @Lob
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank(message = "Thông tin không được bỏ trống")
    private Date ngayTao;

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank(message = "Thông tin không được bỏ trống")
    private Date ngayThayDoi;

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank(message = "Thông tin không được bỏ trống")
    private Date taoBoi;

    @NotBlank(message = "Thông tin không được bỏ trống")
    private Date thayDoiBoi;

    public News() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMoTaNgan() {
        return moTaNgan;
    }

    public void setMoTaNgan(String moTaNgan) {
        this.moTaNgan = moTaNgan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public News(Long id, String thumbnail, @NotBlank(message = "Thông tin không được để trống") String tieuDe, @Size(max = 200) String moTaNgan, @NotBlank(message = "Thông tin không được bỏ trống") String noiDung, Category category, @NotBlank(message = "Thông tin không được bỏ trống") Date ngayTao, @NotBlank(message = "Thông tin không được bỏ trống") Date ngayThayDoi, @NotBlank(message = "Thông tin không được bỏ trống") Date taoBoi, @NotBlank(message = "Thông tin không được bỏ trống") Date thayDoiBoi) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.tieuDe = tieuDe;
        this.moTaNgan = moTaNgan;
        this.noiDung = noiDung;
        this.category = category;
        this.ngayTao = ngayTao;
        this.ngayThayDoi = ngayThayDoi;
        this.taoBoi = taoBoi;
        this.thayDoiBoi = thayDoiBoi;
    }
}
