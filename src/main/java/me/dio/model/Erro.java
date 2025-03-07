package me.dio.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_erro")
public class Erro {

    @Id
    private Long id_erro;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Date registrationTime;


    @ManyToOne
    @JoinColumn(name = "user_id_pk", nullable = false)
    private User user;


    public Long getId_erro() {
        return id_erro;
    }

    public void setId_erro(Long id_erro) {
        this.id_erro = id_erro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
