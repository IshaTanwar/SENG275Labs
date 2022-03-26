package lab06;

import static java.util.stream.Collectors.toList;

import java.util.List;

interface IssuedInvoices {
    List<Invoice> all();
    void save(Invoice inv);
}

class Invoice {
    private final int value;

    //constructor
    public Invoice(int value) {
        this.value = value;
    }

    // getter since value is private
    int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof Invoice) {
            return value == ((Invoice) o).value;
        }
        return false;
    }
}

class InvoiceFilter {
    final IssuedInvoices issuedInvoices;

    //constructor (Passing dependency into constructor)
    public InvoiceFilter(IssuedInvoices issuedInvoices) {
        this.issuedInvoices = issuedInvoices;
    }

    public List<Invoice> lowValueInvoices() {
        return issuedInvoices.all().stream().filter(invoice -> invoice.getValue() < 100).collect(toList());
        //return issuedInvoices.all().stream().filter(invoice -> invoice.getValue() < 100).collect(toList());
    }
}



