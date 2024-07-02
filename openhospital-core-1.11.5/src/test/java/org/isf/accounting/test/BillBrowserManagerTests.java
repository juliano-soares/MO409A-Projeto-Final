package org.isf.accounting.test;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.isf.accounting.manager.BillBrowserManager;
import org.isf.accounting.model.Bill;
import org.isf.accounting.model.BillItems;
import org.isf.accounting.model.BillPayments;
import org.isf.accounting.service.AccountingIoOperations;
import org.isf.patient.model.Patient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@GraphWalker(value = "random(edge_coverage(100))")
public class BillBrowserManagerTests extends ExecutionContext implements BillBrowserManagerTestInterface {

    private BillBrowserManager manager;

    @Autowired
    private AccountingIoOperations ioOperations;

    @Before
    public void setUp() {
        ioOperations = Mockito.mock(AccountingIoOperations.class);
        manager = new BillBrowserManager(ioOperations);
    }

    @Override
    public void validateBill() {
        // Configuração do teste
        Bill bill = new Bill();
        bill.setDate(new GregorianCalendar());
        List<BillItems> billItems = new ArrayList<>();
        List<BillPayments> billPayments = new ArrayList<>();

        // Teste de validação de uma bill válida
        try {
            manager.validateBill(bill, billItems, billPayments);
        } catch (Exception e) {
            Assert.fail("validateBill should not have thrown an exception");
        }

        // Teste de validação de uma bill inválida
        bill.setDate(new GregorianCalendar(2025, 1, 1)); // Data futura
        try {
            manager.validateBill(bill, billItems, billPayments);
            Assert.fail("validateBill should have thrown an exception");
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("bills in the future are not allowed"));
        }
    }

    @Override
    public void getItems() {
        try {
            Mockito.when(ioOperations.getItems(0)).thenReturn(new ArrayList<>());
            List<BillItems> items = manager.getItems();
            Assert.assertNotNull(items);
        } catch (Exception e) {
            Assert.fail("getItems should not have thrown an exception");
        }
    }

    @Override
    public void getBills() {
        try {
            GregorianCalendar dateFrom = new GregorianCalendar(2020, 0, 1);
            GregorianCalendar dateTo = new GregorianCalendar(2020, 11, 31);
            Patient patient = new Patient();  // Crie um objeto paciente conforme necessário
            Mockito.when(ioOperations.getBillsBetweenDatesWherePatient(dateFrom, dateTo, patient)).thenReturn(new ArrayList<>());
            List<Bill> bills = manager.getBills(dateFrom, dateTo, patient);
            Assert.assertNotNull(bills);
        } catch (Exception e) {
            Assert.fail("getBills should not have thrown an exception");
        }
    }

    @Override
    public void newBill() {
        try {
            Bill newBill = new Bill();
            newBill.setDate(new GregorianCalendar());
            List<BillItems> billItems = new ArrayList<>();
            List<BillPayments> billPayments = new ArrayList<>();
            
            Mockito.when(ioOperations.newBill(newBill)).thenReturn(1);
            boolean result = manager.newBill(newBill, billItems, billPayments);
            Assert.assertTrue(result);
        } catch (Exception e) {
            Assert.fail("newBill should not have thrown an exception");
        }
    }

    @Override
    public void updateBill() {
        try {
            Bill updateBill = new Bill();
            updateBill.setId(1);
            updateBill.setDate(new GregorianCalendar());
            List<BillItems> billItems = new ArrayList<>();
            List<BillPayments> billPayments = new ArrayList<>();

            Mockito.when(ioOperations.updateBill(updateBill)).thenReturn(true);
            boolean result = manager.updateBill(updateBill, billItems, billPayments);
            Assert.assertTrue(result);
        } catch (Exception e) {
            Assert.fail("updateBill should not have thrown an exception");
        }
    }

    @Override
    public void deleteBill() {
        try {
            Bill deleteBill = new Bill();
            deleteBill.setId(1);

            Mockito.when(ioOperations.deleteBill(deleteBill)).thenReturn(true);
            boolean result = manager.deleteBill(deleteBill);
            Assert.assertTrue(result);
        } catch (Exception e) {
            Assert.fail("deleteBill should not have thrown an exception");
        }
    }
}
