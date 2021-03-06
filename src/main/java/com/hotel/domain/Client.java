/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.domain;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dasha
 */
@Entity
@Table(name = "clients")
@XmlRootElement
public class Client implements Serializable, JSONAware, Comparable<Client> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "passport")
    private String passport;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.EAGER)
    private List<Order> ordersCollection;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public Client() {
    }

    public Client(String surname, String name, String phone, String email, String passport) {
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.passport = passport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @XmlTransient
    public List<Order> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(List<Order> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }

    @Override
    public int compareTo(Client o) {
        return toString().compareTo(o.toString());
    }

    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("surname", surname);
        obj.put("name", name);
        obj.put("birthday", birthday.toString());
        obj.put("phone", phone);
        obj.put("email", email);
        obj.put("passport", passport);
        obj.put("user", user);
        return obj.toJSONString();
    }
}
