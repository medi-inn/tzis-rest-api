package com.msr.tzis.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Desktop {

    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
    private String name;
    private Boolean changes_allowed;
    private Boolean receives_demands;

    public Desktop(){}

    public Desktop(String name, Boolean changes_allowed, Boolean receives_deamnds, String url){
        this.name = name;
        this.changes_allowed = changes_allowed;
        this.receives_demands = receives_deamnds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChanges_allowed() {
        return changes_allowed;
    }

    public void setChanges_allowed(Boolean changes_allowed) {
        this.changes_allowed = changes_allowed;
    }

    public Boolean getReceives_demands() {
        return receives_demands;
    }

    public void setReceives_demands(Boolean receives_demands) {
        this.receives_demands = receives_demands;
    }


    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Desktop))
            return false;
        Desktop desktop = (Desktop) o;
        return Objects.equals(this.id, desktop.id) &&
                Objects.equals(this.name, desktop.name) &&
                Objects.equals(this.changes_allowed, desktop.changes_allowed) &&
                Objects.equals(this.receives_demands, desktop.receives_demands);
    }

    @Override
    public String toString(){
        return "Desktop{" + "id=" + this.id + ", name='" + this.name + '\'' +
                ", changes_allowed=" + changes_allowed.toString() +
                ", receives_demands=" + receives_demands.toString();
    }
}
