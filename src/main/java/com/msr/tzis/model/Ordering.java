package com.msr.tzis.model;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Ordering {

    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
    private Date datum;
    String message;
    private int status;

    @ManyToOne
    private Kabine kabine;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ItemLine> items;

    @ManyToOne
    private Desktop desktop;

    public Ordering(){}

    public Ordering(Date datum, String message, int status, Kabine kabine, List<ItemLine> items, Desktop desktop)
    {
        this.datum = datum;
        this.message = message;
        this.status = status;
        this.kabine = kabine;
        this.items = items;
        this.desktop = desktop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Kabine getKabine() {
        return kabine;
    }

    public void setKabine(Kabine kabine) {
        this.kabine = kabine;
    }

    public List<ItemLine> getItems() {
        return items;
    }
    public void setItems(List<ItemLine> items) { this.items = items; }

    public Desktop getDesktop() {
        return desktop;
    }

    public void setDesktop(Desktop desktop) {
        this.desktop = desktop;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Ordering))
            return false;
        Ordering ordering = (Ordering) o;
        return Objects.equals(this.id, ordering.id) &&
                Objects.equals(this.datum, ordering.datum) &&
                Objects.equals(this.message, ordering.message) &&
                Objects.equals(this.status, ordering.status) &&
                Objects.equals(this.kabine, ordering.kabine) &&
                Objects.equals(this.items, ordering.items) &&
                Objects.equals(this.desktop, ordering.desktop);
    }

    @Override
    public String toString(){
        return "Order{" + "id=" + this.id + ", datum='" + this.datum.toString() + '\'' +
                ", message=" + message + ", status=" + status + "kabine=" +
                kabine.toString() + ", items=" + items.toString() + ", desktop=" + desktop.toString() + "}";
    }
}
