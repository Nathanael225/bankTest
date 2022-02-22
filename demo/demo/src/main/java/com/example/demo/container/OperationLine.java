package com.example.demo.container;

import java.io.PrintStream;

public class OperationLine {
    private MyTransaction myTransaction;
    private Amount currentAmount;

    public OperationLine(MyTransaction myTransaction, Amount currentAmount) {
        this.myTransaction = myTransaction;
        this.currentAmount = currentAmount;
    }


    public void printOperationLine(PrintStream printer) {
        this.myTransaction.printMyTransaction(printer, currentAmount);
    }
}
