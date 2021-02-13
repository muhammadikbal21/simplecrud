package com.enigma.simplecrud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity <ID> {

    @JsonIgnore //mengabaikan ini untuk ditampilkan di json
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @JsonIgnore //mengabaikan ini untuk ditampilkan di json
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    public abstract ID getId();

    public abstract void setId(ID id);

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedDate = LocalDateTime.now();
    }
}
