package com.msr.tzis.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kabine {

    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
    private String name;
    private boolean open;

    public Kabine(){}

    public Kabine(String name){
        this.name = name;
    }

    public Kabine(String name, boolean open){
        this.name = name;
        this.open = open;
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

    public boolean getOpen() { return open; }

    public void setOpen(boolean open) { this.open = open; }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Kabine))
            return false;
        Kabine kabine = (Kabine) o;
        return Objects.equals(this.id, kabine.id) && Objects.equals(this.name, kabine.name)
                && (kabine.open == this.open);
    }

    @Override
    public String toString(){
        return "Kabine{" + "id=" + this.id + ", name='" + this.name + '\'' + ", open='" + this.open + '\'' +  "}";
    }
}
