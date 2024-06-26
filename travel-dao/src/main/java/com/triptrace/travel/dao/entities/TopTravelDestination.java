package com.triptrace.travel.dao.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.triptrace.travel.core.constants.Month;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Entity
@Table(name = "top_travel_destination")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopTravelDestination implements Serializable {
    private static final long serialVersionUID = 6523378609296366113L;
    private Integer destinationId;
    private Month month;
    private String country;
    private String city;
    private String state;
    private String description;
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destination_id")
    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="month")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Column(name="country", length = 100)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "city", length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "state", length = 100)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name="description", length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Transient
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
