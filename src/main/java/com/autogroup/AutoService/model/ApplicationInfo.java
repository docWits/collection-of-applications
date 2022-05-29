package com.autogroup.AutoService.model;

import javax.persistence.*;

@Entity
public class ApplicationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int price;

    @ManyToOne
    @JoinColumn(name = "id_auto")
    private Auto auto;

    @ManyToOne
    @JoinColumn(name = "id_driver")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "id_app_p")
    private ApplicationP applicationP;

    @ManyToOne
    @JoinColumn(name = "id_app_t")
    private ApplicationT applicationT;

    public ApplicationInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public ApplicationP getApplicationP() {
        return applicationP;
    }

    public void setApplicationP(ApplicationP applicationP) {
        this.applicationP = applicationP;
    }

    public ApplicationT getApplicationT() {
        return applicationT;
    }

    public void setApplicationT(ApplicationT applicationT) {
        this.applicationT = applicationT;
    }
}
