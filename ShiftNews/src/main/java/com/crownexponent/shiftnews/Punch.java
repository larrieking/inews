/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crownexponent.shiftnews;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ISSAH OJIVO
 */
@Entity
@Table(name = "punch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Punch.findAll", query = "SELECT p FROM Punch p")
    , @NamedQuery(name = "Punch.findById", query = "SELECT p FROM Punch p WHERE p.id = :id")
    , @NamedQuery(name = "Punch.findByImage", query = "SELECT p FROM Punch p WHERE p.image = :image")
    , @NamedQuery(name = "Punch.findByTitle", query = "SELECT p FROM Punch p WHERE p.title = :title")
    , @NamedQuery(name = "Punch.findByCategory", query = "SELECT p FROM Punch p WHERE p.category = :category")
    , @NamedQuery(name = "Punch.findByTime", query = "SELECT p FROM Punch p WHERE p.time = :time")
    , @NamedQuery(name = "Punch.findByDetailsUrl", query = "SELECT p FROM Punch p WHERE p.detailsUrl = :detailsUrl")})
public class Punch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 500)
    @Column(name = "image")
    private String image;
    @Size(max = 1000)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(name = "summary")
    private String summary;
    @Size(max = 1000)
    @Column(name = "category")
    private String category;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "details")
    private String details;
    @Size(max = 50)
    @Column(name = "time")
    private String time;
    @Size(max = 1000)
    @Column(name = "detailsUrl")
    private String detailsUrl;

    public Punch() {
    }

    public Punch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
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
        if (!(object instanceof Punch)) {
            return false;
        }
        Punch other = (Punch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crownexponent.shiftnews.Punch[ id=" + id + " ]";
    }
    
}
