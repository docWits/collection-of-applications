package com.autogroup.AutoService.model;

import javax.persistence.*;

@Entity
public class ApplicationP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardingAddress;

    private String destinationAddress;

    private int numberPassengers;

    private String wishes;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    public ApplicationP() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardingAddress() {
        return boardingAddress;
    }

    public void setBoardingAddress(String boardingAddress) {
        this.boardingAddress = boardingAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public int getNumberPassengers() {
        return numberPassengers;
    }

    public void setNumberPassengers(int numberPassengers) {
        this.numberPassengers = numberPassengers;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
