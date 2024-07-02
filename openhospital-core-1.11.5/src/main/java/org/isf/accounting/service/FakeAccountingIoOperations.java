package org.isf.accounting.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.isf.accounting.model.Bill;
import org.isf.accounting.model.BillItems;
import org.isf.accounting.model.BillPayments;
import org.isf.patient.model.Patient;
import org.isf.utils.exception.OHServiceException;

public class FakeAccountingIoOperations extends AccountingIoOperations {

    @Override
    public List<Bill> getPendingBills(int patID) {
        // Simule o comportamento de retornar faturas pendentes
        return new ArrayList<>();
    }

    @Override
    public List<Bill> getBills() {
        // Simule o comportamento de retornar todas as faturas
        return new ArrayList<>();
    }

    @Override
    public Bill getBill(int billID) {
        // Simule o comportamento de retornar uma fatura pelo ID
        return new Bill();
    }

    @Override
    public List<String> getUsers() {
        // Simule o comportamento de retornar todos os usuários
        Set<String> users = new TreeSet<>();
        users.add("user1");
        users.add("user2");
        return new ArrayList<>(users);
    }

    @Override
    public List<BillItems> getItems(int billID) {
        // Simule o comportamento de retornar itens da fatura
        return new ArrayList<>();
    }

    @Override
    public List<BillPayments> getPayments(GregorianCalendar dateFrom, GregorianCalendar dateTo) {
        // Simule o comportamento de retornar pagamentos entre datas
        return new ArrayList<>();
    }

    @Override
    public List<BillPayments> getPayments(int billID) {
        // Simule o comportamento de retornar pagamentos por ID da fatura
        return new ArrayList<>();
    }

    @Override
    public int newBill(Bill newBill) throws OHServiceException {
        // Simulação de salvar um novo Bill e retornar seu ID
        return 1; // Simulação de ID de bill gerado
    }

    @Override
    public boolean newBillItems(Bill bill, List<BillItems> billItems) {
        // Simule o comportamento de adicionar itens à fatura
        return true;
    }

    @Override
    public boolean newBillPayments(Bill bill, List<BillPayments> payItems) {
        // Simule o comportamento de adicionar pagamentos à fatura
        return true;
    }

    @Override
    public boolean updateBill(Bill updateBill) {
        // Simule o comportamento de atualizar uma fatura
        return true;
    }

    @Override
    public boolean deleteBill(Bill deleteBill) {
        // Simule o comportamento de deletar uma fatura
        return true;
    }

    @Override
    public List<Bill> getBillsBetweenDates(GregorianCalendar dateFrom, GregorianCalendar dateTo) {
        // Simule o comportamento de retornar faturas entre datas
        return new ArrayList<>();
    }

    @Override
    public List<Bill> getBills(List<BillPayments> payments) {
        // Simule o comportamento de retornar faturas pelos pagamentos
        return new ArrayList<>();
    }

    @Override
    public List<BillPayments> getPayments(List<Bill> bills) {
        // Simule o comportamento de retornar pagamentos pelas faturas
        return new ArrayList<>();
    }

    @Override
    public List<BillPayments> getPaymentsBetweenDatesWherePatient(GregorianCalendar dateFrom, GregorianCalendar dateTo,
            Patient patient) {
        // Simule o comportamento de retornar pagamentos para um paciente entre datas
        return new ArrayList<>();
    }

    @Override
    public List<Bill> getBillsBetweenDatesWherePatient(GregorianCalendar dateFrom, GregorianCalendar dateTo,
            Patient patient) {
        // Simule o comportamento de retornar faturas para um paciente entre datas
        return new ArrayList<>();
    }

    @Override
    public List<Bill> getPendingBillsAffiliate(int patID) {
        // Simule o comportamento de retornar faturas pendentes para um afiliado
        return new ArrayList<>();
    }

    @Override
    public List<Bill> getAllPatientsBills(int patID) {
        // Simule o comportamento de retornar todas as faturas de um paciente
        return new ArrayList<>();
    }

    @Override
    public List<BillItems> getDistictsBillItems() {
        // Simule o comportamento de retornar itens de fatura distintos
        return new ArrayList<>();
    }

    @Override
    public List<Bill> getBillsBetweenDatesWhereBillItem(GregorianCalendar dateFrom, GregorianCalendar dateTo,
            BillItems billItem) {
        // Simule o comportamento de retornar faturas entre datas com um item específico
        return new ArrayList<>();
    }
}
