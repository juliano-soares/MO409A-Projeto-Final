/*
 * This file was automatically generated by EvoSuite
 * Thu Jun 27 15:03:32 GMT 2024
 */

package org.testEvo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.System;
import org.evosuite.runtime.mock.java.util.MockGregorianCalendar;
import org.isf.accounting.manager.BillBrowserManager;
import org.isf.accounting.model.Bill;
import org.isf.accounting.model.BillItems;
import org.isf.accounting.model.BillPayments;
import org.isf.accounting.service.AccountingIoOperations;
import org.isf.accounting.service.FakeAccountingIoOperations;
import org.isf.patient.model.Patient;
import org.isf.priceslist.model.PriceList;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class BillBrowserManager_ESTest extends BillBrowserManager_ESTest_scaffolding {
  private BillBrowserManager billBrowserManager;

  @Before
  public void setUp() {
    AccountingIoOperations fakeIoOperations = new FakeAccountingIoOperations();
    billBrowserManager = new BillBrowserManager(fakeIoOperations);
  }

  @Test(timeout = 100000)
  public void test00() throws Throwable {
    AccountingIoOperations accountingIoOperations0 = new AccountingIoOperations();
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(accountingIoOperations0);

    Locale locale0 = Locale.ENGLISH;
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(locale0);
    MockGregorianCalendar mockGregorianCalendar1 = new MockGregorianCalendar(locale0);
    mockGregorianCalendar1.set(2023, GregorianCalendar.JANUARY, 1); // Exemplo de configuração de data

    BillItems billItems0 = new BillItems();

    // Certifique-se de que os objetos não são nulos e estão inicializados
    // corretamente
    assertNotNull(accountingIoOperations0);
    assertNotNull(billBrowserManager0);
    assertNotNull(mockGregorianCalendar0);
    assertNotNull(mockGregorianCalendar1);
    assertNotNull(billItems0);

    // Chame o método e verifique se a exceção esperada é lançada
    try {
      billBrowserManager0.getBills((GregorianCalendar) mockGregorianCalendar0,
          (GregorianCalendar) mockGregorianCalendar1, billItems0);
      fail("Expecting exception: NoClassDefFoundError");
    } catch (NoClassDefFoundError e) {
      verifyException("org.isf.accounting.service.AccountingIoOperations", e);
    } catch (NullPointerException e) {
      // Verifique se a exceção correta é lançada em caso de parâmetros inválidos
      verifyException("org.isf.accounting.service.AccountingIoOperations", e);
    }
  }

  @Test(timeout = 100000)
  public void test01() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, (-1), 23, 1555, (-1), (-1));
    // Undeclared exception!
    try {
      billBrowserManager0.getPayments((GregorianCalendar) mockGregorianCalendar0, (GregorianCalendar) null);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test02() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, 0, 0);
    MockGregorianCalendar mockGregorianCalendar1 = new MockGregorianCalendar(1, 1, 946, 0, 2114, (-35));
    // Undeclared exception!
    try {
      billBrowserManager0.getBills((GregorianCalendar) mockGregorianCalendar1,
          (GregorianCalendar) mockGregorianCalendar0);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test03() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getPayments(1587);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test04() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-1736), (-3656), (-1736), (-3656),
        (-3656), (-3656));
    MockGregorianCalendar mockGregorianCalendar1 = new MockGregorianCalendar((-1736), (-1736), (-1736), (-1736),
        (-3656));
    // Undeclared exception!
    try {
      billBrowserManager0.getPayments((GregorianCalendar) mockGregorianCalendar0,
          (GregorianCalendar) mockGregorianCalendar1, (Patient) null);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test05() throws Throwable {
    GregorianCalendar dateFrom = new GregorianCalendar(2023, GregorianCalendar.JANUARY, 1);
    GregorianCalendar dateTo = new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 31);
    Patient patient = new Patient();

    List<Bill> bills = billBrowserManager.getBills(dateFrom, dateTo, patient);

    assertNotNull(bills);
    assertTrue(bills.isEmpty());
  }

  @Test(timeout = 100000)
  public void test06() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    Bill bill0 = new Bill();
    LinkedList<BillItems> linkedList0 = new LinkedList<BillItems>();
    LinkedList<BillPayments> linkedList1 = new LinkedList<BillPayments>();
    BillPayments billPayments0 = new BillPayments();
    linkedList1.add(billPayments0);
    linkedList1.add(billPayments0);
    // Undeclared exception!
    try {
      billBrowserManager0.newBill(bill0, linkedList0, linkedList1);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test07() throws Throwable {
    Bill bill0 = new Bill();
    LinkedList<BillItems> linkedList0 = new LinkedList<BillItems>();
    LinkedList<BillPayments> linkedList1 = new LinkedList<BillPayments>();
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    try {
      billBrowserManager0.validateBill(bill0, linkedList0, linkedList1);
      fail("Expecting exception: Exception");

    } catch (Exception e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test08() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    LinkedList<BillPayments> linkedList0 = new LinkedList<BillPayments>();
    // Undeclared exception!
    try {
      billBrowserManager0.validateBill((Bill) null, (List<BillItems>) null, linkedList0);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test09() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    Bill bill0 = new Bill();
    LinkedList<BillItems> linkedList0 = new LinkedList<BillItems>();
    LinkedList<BillPayments> linkedList1 = new LinkedList<BillPayments>();
    try {
      billBrowserManager0.updateBill(bill0, linkedList0, linkedList1);
      fail("Expecting exception: Exception");

    } catch (Exception e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test10() throws Throwable {
    LinkedList<BillPayments> linkedList0 = new LinkedList<BillPayments>();
    Bill bill0 = new Bill();
    bill0.setPatName("fk");
    // Utilize a instância fake de AccountingIoOperations
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    // Execute o método e verifique o comportamento
    boolean result = billBrowserManager0.updateBill(bill0, null, linkedList0);
    assertTrue(result);
  }

  @Test(timeout = 100000)
  public void test11() throws Throwable {
    LinkedList<BillPayments> linkedList0 = new LinkedList<BillPayments>();
    SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone((-1179), "9K");
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(simpleTimeZone0);
    PriceList priceList0 = new PriceList();
    Double double0 = new Double(865.467213);
    Bill bill0 = new Bill(0, mockGregorianCalendar0, mockGregorianCalendar0, false, priceList0, "9K", false,
        (Patient) null, "C", "c19d{'*0>/|NVtj", double0, double0, "ENUM$VALUES");
    boolean result = billBrowserManager.newBill(bill0, new LinkedList<BillItems>(), linkedList0);
    assertTrue(result);
  }

  @Test(timeout = 100000)
  public void test12() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    // Execute o método e verifique o comportamento
    List<String> users = billBrowserManager0.getUsers();
    assertNotNull(users);
    assertEquals(2, users.size());
  }

  @Test(timeout = 100000)
  public void test13() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    // Execute o método e verifique o comportamento
    List<Bill> bills = billBrowserManager0.getPendingBillsAffiliate(13);
    assertNotNull(bills);
    assertTrue(bills.isEmpty());
  }

  @Test(timeout = 100000)
  public void test14() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getPendingBills(11);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test15() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    // Execute o método e verifique o comportamento
    List<BillPayments> payments = billBrowserManager0.getPayments((List<Bill>) null);
    assertNotNull(payments);
    assertTrue(payments.isEmpty());
  }

  @Test(timeout = 100000)
  public void test16() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    // Execute o método e verifique o comportamento
    List<BillPayments> payments = billBrowserManager0.getPayments(-4838);
    assertNotNull(payments);
    assertTrue(payments.isEmpty());
  }

  @Test(timeout = 100000)
  public void test17() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    // Execute o método e verifique o comportamento
    List<BillPayments> payments = billBrowserManager0.getPayments();
    assertNotNull(payments);
    assertTrue(payments.isEmpty());
  }

  @Test(timeout = 100000)
  public void test18() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    // Execute o método e verifique o comportamento
    List<BillItems> items = billBrowserManager0.getItems(946);
    assertNotNull(items);
    assertTrue(items.isEmpty());
  }

  @Test(timeout = 100000)
  public void test19() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    // Execute o método e verifique o comportamento
    List<BillItems> items = billBrowserManager0.getItems();
    assertNotNull(items);
    assertTrue(items.isEmpty());
  }

  @Test(timeout = 100000)
  public void test20() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getBills((List<BillPayments>) null);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
    }
  }

  @Test(timeout = 100000)
  public void test21() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    BillItems billItems0 = new BillItems();
    // Undeclared exception!
    try {
      billBrowserManager0.getBills((GregorianCalendar) null, (GregorianCalendar) null, billItems0);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test22() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
    // Execute o método e verifique o comportamento
    List<Bill> bills = billBrowserManager0.getBills(mockGregorianCalendar0, mockGregorianCalendar0);
    assertNotNull(bills);
    assertTrue(bills.isEmpty());
  }

  @Test(timeout = 100000)
  public void test23() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getBills();
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test24() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    LinkedList<BillPayments> linkedList0 = new LinkedList<BillPayments>();
    List<Bill> list0 = billBrowserManager0.getBills((List<BillPayments>) linkedList0);
    assertTrue(list0.isEmpty());
  }

  @Test(timeout = 100000)
  public void test25() throws Throwable {
    AccountingIoOperations accountingIoOperations0 = new AccountingIoOperations();
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(accountingIoOperations0);
    Bill bill0 = new Bill();
    LinkedList<BillPayments> linkedList0 = new LinkedList<BillPayments>();
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(870, (-12), 2522, 2522, 870);
    BillPayments billPayments0 = new BillPayments(2522, bill0, mockGregorianCalendar0, (-12), "H^0");
    linkedList0.add(billPayments0);
    List<Bill> list0 = billBrowserManager0.getBills((List<BillPayments>) linkedList0);
    assertTrue(list0.contains(bill0));
  }

  @Test(timeout = 100000)
  public void test26() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    List<BillPayments> list0 = billBrowserManager0.getPayments(0);
    assertEquals(0, list0.size());
  }

  @Test(timeout = 100000)
  public void test27() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    List<BillItems> list0 = billBrowserManager0.getItems(0);
    assertTrue(list0.isEmpty());
  }

  @Test(timeout = 100000)
  public void test28() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getItems(1);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test29() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    LinkedList<BillPayments> linkedList0 = new LinkedList<BillPayments>();
    PriceList priceList0 = new PriceList();
    Double double0 = new Double(0.0);
    Locale locale0 = Locale.KOREAN;
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(locale0);
    Bill bill0 = new Bill((-1045), mockGregorianCalendar0, mockGregorianCalendar0, false, priceList0,
        "{} property Aot found: default is }}", false, (Patient) null, "C", "C", double0, double0, "C");
    // Undeclared exception!
    try {
      billBrowserManager0.updateBill(bill0, (List<BillItems>) null, linkedList0);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test30() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    LinkedList<BillPayments> linkedList0 = new LinkedList<BillPayments>();
    SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone((-1179), "9K");
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(simpleTimeZone0);
    PriceList priceList0 = new PriceList();
    Double double0 = new Double((-1179));
    Bill bill0 = new Bill((-1179), mockGregorianCalendar0, mockGregorianCalendar0, true, priceList0,
        "{} property Aot found: default is }}", true, (Patient) null, "{} property Aot found: default is }}", "C",
        double0, double0, "9K");
    try {
      billBrowserManager0.newBill(bill0, (List<BillItems>) null, linkedList0);
      fail("Expecting exception: Exception");

    } catch (Exception e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test31() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    LinkedList<BillPayments> linkedList0 = new LinkedList<BillPayments>();
    Bill bill0 = new Bill();
    System.setCurrentTimeMillis(0L);
    try {
      billBrowserManager0.newBill(bill0, (List<BillItems>) null, linkedList0);
      fail("Expecting exception: Exception");

    } catch (Exception e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test32() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager((AccountingIoOperations) null);
  }

  @Test(timeout = 100000)
  public void test33() throws Throwable {
    AccountingIoOperations accountingIoOperations0 = new FakeAccountingIoOperations();
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(accountingIoOperations0);
    // Execute o método e verifique o comportamento
    Bill bill = billBrowserManager0.getBill(1);
    assertNotNull(bill);
  }

  @Test(timeout = 100000)
  public void test34() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getItems();
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test35() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getUsers();
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test36() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    Bill bill0 = new Bill();
    // Execute o método e verifique o comportamento
    boolean result = billBrowserManager0.deleteBill(bill0);
    assertTrue(result);
  }

  @Test(timeout = 100000)
  public void test37() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getPendingBillsAffiliate(47);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test38() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getDistinctItems();
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test39() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getPayments((List<Bill>) null);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test40() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    // Execute o método e verifique o comportamento
    List<Bill> bills = billBrowserManager0.getPendingBills(-35);
    assertNotNull(bills);
    assertTrue(bills.isEmpty());
  }

  @Test(timeout = 100000)
  public void test41() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    // Undeclared exception!
    try {
      billBrowserManager0.getPayments();
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test42() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-3005), (-1), (-3005));
    // Execute o método e verifique o comportamento
    List<BillPayments> payments = billBrowserManager0.getPayments(mockGregorianCalendar0, mockGregorianCalendar0);
    assertNotNull(payments);
    assertTrue(payments.isEmpty());
  }

  @Test(timeout = 100000)
  public void test43() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager();
    MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
    // Undeclared exception!
    try {
      billBrowserManager0.getBills((GregorianCalendar) mockGregorianCalendar0, (GregorianCalendar) null,
          (Patient) null);
      fail("Expecting exception: NullPointerException");

    } catch (NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
      verifyException("org.isf.accounting.manager.BillBrowserManager", e);
    }
  }

  @Test(timeout = 100000)
  public void test44() throws Throwable {
    BillBrowserManager billBrowserManager0 = new BillBrowserManager(new FakeAccountingIoOperations());
    // Execute o método e verifique o comportamento
    List<Bill> bills = billBrowserManager0.getBills();
    assertNotNull(bills);
    assertTrue(bills.isEmpty());
  }
}