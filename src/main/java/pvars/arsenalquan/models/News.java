package pvars.arsenalquan.models;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

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
    private String title;

    @Size(max = 200)
    private String shortDesciption;

    @NotBlank(message = "Thông tin không được bỏ trống")
    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @CreatedBy
    private String createBy;

    @LastModifiedBy
    private String updateBy;

    public News() {
    }

    public Long getId() {
        return id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesciption() {
        return shortDesciption;
    }

    public void setShortDesciption(String shortDesciption) {
        this.shortDesciption = shortDesciption;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public News(Long id, String thumbnail, @NotBlank(message = "Thông tin không được để trống") String title, @Size(max = 200) String shortDesciption, @NotBlank(message = "Thông tin không được bỏ trống") String content, Category category, Date createDate, Date updateDate, String createBy, String updateBy) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.shortDesciption = shortDesciption;
        this.content = content;
        this.category = category;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }
}
