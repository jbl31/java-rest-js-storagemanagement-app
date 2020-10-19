package com.personaltraining.storagemanagement.model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Transaction> transactionList;

    public Long getStorageAmount(){
        Long amount = 0L;
        try {
            for (Transaction trans : transactionList) {
                amount += trans.getAmount();
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("Transaction not found");
        }
        return amount;
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

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
