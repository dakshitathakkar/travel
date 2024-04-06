package com.triptrace.travel.dao.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.triptrace.travel.core.constants.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "subscriber")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subscriber implements Serializable {
    private static final long serialVersionUID = -120346304866226610L;
    private Integer subscriberId;
    private String email;
    private Status status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_id")
    public Integer getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Integer subscriberId) {
        this.subscriberId = subscriberId;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
