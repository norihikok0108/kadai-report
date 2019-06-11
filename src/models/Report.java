package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "reports")
@NamedQueries({
    @NamedQuery(
        name = "getAllReports",
        query = "select r from Report as r order by r.id desc"
        ),
    @NamedQuery(
        name = "getReportsCount",
        query = "select count(r) from Report as r"
        ),
})
@Entity
public class Report {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // リソース内での連番

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee; // 日報を登録した社員の社員番号

    @Column(name = "report_date", nullable = false)
    private Date report_date; // いつの日報かを示す日付

    @Column(name = "title", length = 255, nullable = false)
    private String title; // 日報のタイトル

    @Lob
    @Column(name = "content", nullable = false)
    private String content; // 日報の内容

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at; // 登録日時

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at; // 更新日時

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void getEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}