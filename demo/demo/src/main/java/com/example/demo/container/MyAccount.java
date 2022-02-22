package com.example.demo.container;

import java.io.PrintStream;
import java.util.Date;

import static com.example.demo.container.Amount.amountOf;

public class MyAccount {
    private MyState myState;

    private Amount currentAmount = amountOf(0);

    public MyAccount(MyState myState) {
        this.myState = myState;
    }

    public void depositMoney(Amount value, Date date) {
        saveMyTransaction(value, date);
    }

    public void withDrawalMoney(Amount value, Date date) {
        saveMyTransaction(value.negativeValue(), date);
    }

    public void printHistory(PrintStream printer) {
        myState.printHeader(printer);
    }

    private void saveMyTransaction(Amount value, Date date) {
        MyTransaction myTransaction = new MyTransaction(value, date);
        Amount balanceAfterTransaction = myTransaction.balanceAfterTransaction(currentAmount);
        currentAmount = balanceAfterTransaction;
        myState.addContentLineTransaction(myTransaction, balanceAfterTransaction);
    }
}
