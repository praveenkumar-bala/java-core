package org.pk.annotation_plus_reflection_real_time_examples.custom.orm.application;

import org.pk.annotation_plus_reflection_real_time_examples.custom.orm.annotation.Column;
import org.pk.annotation_plus_reflection_real_time_examples.custom.orm.annotation.PrimaryKey;

public class TransactionHistory {

    @PrimaryKey
    long id;

    @Column
    int accountNo;

    @Column
    String name;

    @Column
    double amount;

    @Column
    String type;

    public TransactionHistory(){

    }
    public TransactionHistory(int accountNo, String name, double amount, String type) {
        this.accountNo = accountNo;
        this.name = name;
        this.amount = amount;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "id=" + id +
                ", accountNo=" + accountNo +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
