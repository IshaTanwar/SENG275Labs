package lab06;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class InvoiceFilterTest {
    private InvoiceFilter invoiceFilter;
    private IssuedInvoices issuedInvoices;

    @Test
    void allHighValueInvoices() {
        // every invoice in the list should be high-value
        Invoice i1 = new Invoice(100);
        Invoice i2 = new Invoice(299);
        Invoice i3 = new Invoice(102);
        Invoice i4 = new Invoice(145);
        // Dummy object into constructor
        issuedInvoices = mock(IssuedInvoices.class);
        invoiceFilter = new InvoiceFilter(issuedInvoices);
        // promoting to stub (hard coded answer to method)
        when(issuedInvoices.all()).thenReturn(List.of(i1,i2,i3,i4));
        //now invoiceFilter is tested in isolation
        // Since no values in the list have lower value than 100, so empty
        assertThat(invoiceFilter.lowValueInvoices()).containsExactlyInAnyOrder();
        // promoting to mock (verifying behaviour)
        verify(issuedInvoices).all();
        verify(issuedInvoices, times(1)).all();
        verifyNoMoreInteractions(issuedInvoices);
    }

    @Test
    void allLowValueInvoices() {
        // every invoice in the list should be low-value
        Invoice i1 = new Invoice(43);
        Invoice i2 = new Invoice(99);
        Invoice i3 = new Invoice(55);
        Invoice i4 = new Invoice(22);
        // Dummy object into constructor
        issuedInvoices = mock(IssuedInvoices.class);
        invoiceFilter = new InvoiceFilter(issuedInvoices);
        // promoting to stub (hard coded answer to method)
        when(issuedInvoices.all()).thenReturn(List.of(i1,i2,i3,i4));
        assertThat(invoiceFilter.lowValueInvoices()).containsExactlyInAnyOrder(i1, i2,i3,i4);
        // promoting to mock (verifying behaviour)
        verify(issuedInvoices).all();
        verify(issuedInvoices, times(1)).all();
        verifyNoMoreInteractions(issuedInvoices);
    }

    @Test
    void someLowValueInvoices() {
        // Some low value invoices, some high
        Invoice i1 = new Invoice(43);
        Invoice i2 = new Invoice(99);
        Invoice i3 = new Invoice(102);
        Invoice i4 = new Invoice(145);
        // Dummy object into constructor
        issuedInvoices = mock(IssuedInvoices.class);
        invoiceFilter = new InvoiceFilter(issuedInvoices);
        // promoting to stub (hard coded answer to method)
        when(issuedInvoices.all()).thenReturn(List.of(i1,i2,i3,i4));
        assertThat(invoiceFilter.lowValueInvoices()).containsExactlyInAnyOrder(i1, i2);
        // promoting to mock (verifying behaviour)
        verify(issuedInvoices).all();
        verify(issuedInvoices, times(1)).all();
        verifyNoMoreInteractions(issuedInvoices);
    }

}
