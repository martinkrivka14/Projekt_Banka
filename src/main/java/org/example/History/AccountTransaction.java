package org.example.History;

import java.time.LocalDateTime;

public class AccountTransaction {

    private Boolean action;
    private Boolean fromAccount;
    private Double amount;
    private Boolean wasDone;
    private Boolean success;


    public AccountTransaction( Boolean action, Boolean fromAccount, Double amount, Boolean success, Boolean wasDone) {
        this.action = action;
        this.fromAccount = fromAccount;
        this.amount = amount;
        this.success = success;
        this.wasDone = wasDone;
    }

/*
    public LocalDateTime getDate() {
        return date;
    }*/

    public Boolean getAction() {
        return action;
    }

    public Boolean getFromAccount() {
        return fromAccount;
    }

    public Double getAmount() { return amount;}

    public Boolean getWasDone() {
        return wasDone;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setWasDone(Boolean wasDone) {
        this.wasDone = wasDone;
    }
}
