package com.example.demo.container;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class MyState {
    private List<OperationLine> operationLines = new LinkedList<OperationLine>();

    public void addContentLineTransaction(MyTransaction myTransaction, Amount currentAmount) {
        operationLines.add(0, new OperationLine(myTransaction, currentAmount));
    }
    public void printHeader(PrintStream printer) {
        printer.println("date       |  credit   | debit    | Solde");
        printOperationLinesHistory(printer);
    }

    private void printOperationLinesHistory(PrintStream printer) {
        for (OperationLine operationLine : operationLines) {
            operationLine.printOperationLine(printer);
        }
    }

}
