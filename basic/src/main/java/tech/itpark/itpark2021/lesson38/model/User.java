package tech.itpark.itpark2021.lesson38.model;

import lombok.Data;
import lombok.ToString;
import tech.itpark.itpark2021.lesson38.model.type.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users_jwt")
@Data
public class User {

    @Id
    @Column(name = "id")
    @NotNull
    private long id;

    @Column(name = "login")
    @NotNull
    private String login;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}
