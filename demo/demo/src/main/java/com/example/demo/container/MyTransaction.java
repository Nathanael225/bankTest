package com.example.demo.container;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.demo.container.Amount.amountOf;

public class MyTransaction {
    private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

    private Amount amount;
    private Date date;

    public MyTransaction(Amount amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public Amount balanceAfterTransaction(Amount currentBalance) {
        return currentBalance.positiveValue(amount);
    }


    public void printMyTransaction(PrintStream printer, Amount currentBalance) {
        StringBuilder builder = new StringBuilder();
        addDateTo(builder);
        addValueTo(builder);
        addCurrentBalanceTo(builder, currentBalance);
        printer.println(builder.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        MyTransaction other = (MyTransaction) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
        return true;
    }

    private void addCurrentBalanceTo(StringBuilder builder, Amount currentBalance) {
        builder.append("| ")
                .append(currentBalance.moneyRepresentation());
    }

    private void addValueTo(StringBuilder builder) {
        if (amount.isGreaterThan(amountOf(0))) {
            addCreditTo(builder);
        } else {
            addDebitTo(builder);
        }
    }

    private void addDebitTo(StringBuilder builder) {
        builder.append("          ")
                .append("|")
                .append(valueToString());
    }

    private void addCreditTo(StringBuilder builder) {
        builder.append(valueToString())
                .append("|")
                .append("          ");
    }

    private String valueToString() {
        String stringValue = " " + amount.absoluteValue().moneyRepresentation();
        return  stringValue.toString();
    }

    private void addDateTo(StringBuilder builder) {
        builder.append(formatDate.format(date));
        builder.append(" |");
    }

}
