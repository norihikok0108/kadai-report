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


@Table(name = "clients")
@NamedQueries({
    @NamedQuery(
        name = "getAllClients",
        query = "SELECT c FROM Client AS c ORDER BY c.id DESC"
        ),
    @NamedQuery(
        name = "getCliestsCount",
        query = "SELECT COUNT(c) FROM Client AS c"
        ),
})

@Entity
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // リソース内での連番

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee; // 顧客情報を登録した社員の社員番号

    @Column(name = "client_date", nullable = false)
    private Date client_date; // いつの日報かを示す日付

    @Column(name = "client_name", length = 255, nullable = false)
    private String client_name; // 顧客名

    @Column(name = "client_address", length = 255, nullable = false)
    private String client_address; // 顧客住所

    @Column(name = "partner_name", length = 255, nullable = false)
    private String partner_name; // 顧客担当者名

    @Lob
    @Column(name = "client_content", nullable = false)
    private String client_content; // 商談状況

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

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getClient_date() {
        return client_date;
    }

    public void setClient_date(Date client_date) {
        this.client_date = client_date;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getPartner_name() {
        return partner_name;
    }

    public void setPartner_name(String partner_name) {
        this.partner_name = partner_name;
    }

    public String getClient_content() {
        return client_content;
    }

    public void setClient_content(String client_content) {
        this.client_content = client_content;
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
