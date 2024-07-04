package org.isf.accounting.test;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Edge;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.TestBuilder;
import org.isf.accounting.manager.BillBrowserManager;
import org.isf.accounting.model.Bill;
import org.isf.accounting.service.AccountingIoOperations;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

@GraphWalker(value = "random(edge_coverage(100))", start = "Start", groups = { "default" })
public class AccountingTest extends ExecutionContext implements AccountingTestInterface {
    public final static Path MODEL_PATH = Paths.get("src/test/resources/AccountingTest.json");

    private BillBrowserManager billBrowserManager;
    private AccountingIoOperations mockedOperations;

    public AccountingTest() {
        mockedOperations = Mockito.mock(AccountingIoOperations.class);
        billBrowserManager = new BillBrowserManager(mockedOperations);
    }

    // Vertex methods
    @Override
    public void v_ItensRecuperados() {
        System.out.println("Verificando itens recuperados");
        try {
            Mockito.verify(mockedOperations).getItems(1);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao verificar itens recuperados", e);
        }
    }

    @Override
    public void v_BillAtualizado() {
        System.out.println("Verificando Bill atualizado");
        try {
            Mockito.verify(mockedOperations).updateBill(Mockito.any(Bill.class));
        } catch (Exception e) {
            throw new RuntimeException("Falha ao verificar atualização de Bill", e);
        }
    }

    @Override
    public void v_Inicio() {
        System.out.println("No estado inicial");
    }

    @Override
    public void v_BillDeletado() {
        System.out.println("Verificando Bill deletado");
        try {
            Mockito.verify(mockedOperations).deleteBill(Mockito.any(Bill.class));
        } catch (Exception e) {
            throw new RuntimeException("Falha ao verificar exclusão de Bill", e);
        }
    }

    @Override
    public void v_BillCriado() {
        System.out.println("Verificando Bill criado");
        try {
            Mockito.verify(mockedOperations).newBill(Mockito.any(Bill.class));
        } catch (Exception e) {
            throw new RuntimeException("Falha ao verificar criação de Bill", e);
        }
    }

    @Override
    public void v_PagamentosRecuperados() {
        System.out.println("Verificando pagamentos recuperados");
        try {
            Mockito.verify(mockedOperations).getPayments(Mockito.anyInt());
        } catch (Exception e) {
            throw new RuntimeException("Falha ao verificar pagamentos recuperados", e);
        }
    }

    // Edge methods
    @Override
    public void e_RecuperarPagamentos() {
        System.out.println("Executando ação para recuperar pagamentos");
        try {
            Mockito.when(mockedOperations.getPayments(Mockito.anyInt())).thenReturn(new ArrayList<>());
            billBrowserManager.getPayments(1);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao recuperar pagamentos", e);
        }
    }

    @Override
    public void e_RecuperarItens() {
        System.out.println("Executando ação para recuperar itens");
        try {
            Mockito.when(mockedOperations.getItems(Mockito.anyInt())).thenReturn(new ArrayList<>());
            billBrowserManager.getItems(1);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao recuperar itens", e);
        }
    }

    @Override
    public void e_AtualizarBill() {
        System.out.println("Executando ação para atualizar Bill");
        Bill bill = new Bill();
        bill.setId(1);
        try {
            billBrowserManager.updateBill(bill, new ArrayList<>(), new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException("Falha ao atualizar Bill", e);
        }
    }

    @Override
    public void e_RetornarDeItensParaBillCriado() {
        System.out.println("Retornando de Itens para Bill Criado");
    }

    @Override
    public void e_RetornarDePagamentosParaBillCriado() {
        System.out.println("Retornando de Pagamentos para Bill Criado");
    }

    @Override
    public void e_DeletarBill() {
        System.out.println("Executando ação para deletar Bill");
        Bill bill = new Bill();
        bill.setId(1);
        try {
            billBrowserManager.deleteBill(bill);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao deletar Bill", e);
        }
    }

    @Override
    public void e_CriarBill() {
        System.out.println("Executando ação para criar Bill");
        Bill bill = new Bill();
        bill.setBalance(100.0);
        bill.setDate(new GregorianCalendar());
        bill.setPatName("Test Patient");
        bill.setStatus("O");
        try {
            Mockito.when(mockedOperations.newBill(Mockito.any(Bill.class))).thenReturn(1);
            billBrowserManager.newBill(bill, new ArrayList<>(), new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException("Falha ao criar Bill", e);
        }
    }

    @Test
    public void runSmokeTest() {
        System.out.println("Running: runSmokeTest");
        try {
            new TestBuilder()
                    .addContext(new AccountingTest().setNextElement(new Edge().setName("e_isEmpty").build()),
                            MODEL_PATH,
                            new AStarPath(new ReachedVertex("v_Empty")))
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runFunctionalTest() {
        System.out.println("Running: runFunctionalTest");
        try {
            new TestBuilder()
                    .addContext(new AccountingTest().setNextElement(new Edge().setName("e_isEmpty").build()),
                            MODEL_PATH,
                            new RandomPath(new EdgeCoverage(100)))
                    .execute();
        } catch (Exception e) {
            System.err.println("Exception in runFunctionalTest: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void runStabilityTest() {
        System.out.println("Running: runStabilityTest");
        try {
            new TestBuilder()
                    .addContext(new AccountingTest().setNextElement(new Edge().setName("e_isEmpty").build()),
                            MODEL_PATH,
                            new RandomPath(new TimeDuration(120, TimeUnit.SECONDS)))
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
