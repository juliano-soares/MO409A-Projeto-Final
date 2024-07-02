
package org.testeInterface;


import org.isf.accounting.manager.BillBrowserManager;
import org.isf.accounting.model.Bill;
import org.isf.accounting.model.BillItems;
import org.isf.accounting.model.BillPayments;
import org.isf.patient.model.Patient;
import org.isf.utils.exception.OHDataValidationException;
import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.fail;

import java.util.*;

@RunWith(Enclosed.class)
public class BillBrowserManagerTest {

    @RunWith(Parameterized.class)
    public static class TC1 {
        BillBrowserManager billBrowserMgr = new BillBrowserManager();

        private Bill bill;
        private List<BillItems> billItems;
        private List<BillPayments> billPayments;

        //Bill parameters
        private static int id = 0;
        private static GregorianCalendar update = new GregorianCalendar();
        private static boolean isList = true;
        private static String listName = "";
        private static boolean isPatient = false;
        private static Patient billPatient = new Patient();
        private static String patName = "Patient Name";
        private static String user = "admin";


        public TC1(Bill b, List<BillItems> bI, List<BillPayments> bP) {
            this.bill = b;
            this.billItems = bI;
            this.billPayments = bP;
        }

       @Parameterized.Parameters(name="TC1 - Bill: {0} | Bill Items: {1} | Bill Payment: {2}")
       public static Collection data(){
            return Arrays.asList(new Object[][] {
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, "C", 0., 0., user), new ArrayList<BillItems>(), new ArrayList<BillPayments>() },
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, "O", 0.5, 0.001, user), new ArrayList<BillItems>(), new ArrayList<BillPayments>()},
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, "O", 0., 0., user), new ArrayList<BillItems>(), new ArrayList<BillPayments>() }
            });
        }

        //valid test case
        
        @Test
        public void testCase1() throws OHDataValidationException{
            try {
                billBrowserMgr.validateBill(bill, billItems, billPayments);
            } catch (Exception e) {
                fail(e.getClass().getSimpleName() + " was thrown");
            }
        }
    }

    @RunWith(Parameterized.class)
    public static class TC2 {
        BillBrowserManager billBrowserMgr = new BillBrowserManager();

        private Bill bill;
        private List<BillItems> billItems;
        private List<BillPayments> billPayments;

        //Bill parameters
        private static int id = 0;
        private static GregorianCalendar update = new GregorianCalendar();
        private static boolean isList = true;
        private static String listName = "";
        private static boolean isPatient = false;
        private static Patient billPatient = new Patient();
        private static String patName = "Patient Name";
        private static String user = "admin";


        public TC2(Bill b, List<BillItems> bI, List<BillPayments> bP) {
            this.bill = b;
            this.billItems = bI;
            this.billPayments = bP;
        }

       @Parameterized.Parameters(name="TC2 - Bill: {0} | Bill Items: {1} | Bill Payment: {2}")
       public static Collection data(){
            return Arrays.asList(new Object[][] {
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, "C", 0., 0., user), new ArrayList<BillItems>(), Arrays.asList(new BillPayments(0, null, new GregorianCalendar(2020,5,10), 2., "user")) },
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, "C", 0., 0., user), new ArrayList<BillItems>(), Arrays.asList(new BillPayments(0, null, new GregorianCalendar(2024,5,1), 2., "user")) },
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, "O", 0.5, 0.001, user), new ArrayList<BillItems>(), Arrays.asList(new BillPayments(0, null, new GregorianCalendar(2010,5,1), 2., "user")) },
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, "O", 0., 0., user), new ArrayList<BillItems>(), Arrays.asList(new BillPayments(0, null, new GregorianCalendar(2016,6,10), 2., "user")) }
            });
        }

        //valid test case
        
        @Test
        public void testCase2(){
            try {
                billBrowserMgr.validateBill(bill, billItems, billPayments);
            } catch (Exception e) {
                fail(e.getClass().getSimpleName() + " was thrown");
            }
        }
    }

    @RunWith(Parameterized.class)
    public static class TC3 {
        BillBrowserManager billBrowserMgr = new BillBrowserManager();

        private Bill bill;
        private List<BillItems> billItems;
        private List<BillPayments> billPayments;

        public TC3(Bill b, List<BillItems> bI, List<BillPayments> bP) {
            this.bill = b;
            this.billItems = bI;
            this.billPayments = bP;
        }

       @Parameterized.Parameters(name="TC3 - Bill: {0} | Bill Items: {1} | Bill Payment: {2}")
       public static Collection data(){
            return Arrays.asList(new Object[][] {
                    { null, null, null },
                    { null, new ArrayList<BillItems>() , null },
                    { null, new ArrayList<BillItems>() , new ArrayList<BillPayments>() }
            });
        }

        @Test(expected = NullPointerException.class)
        public void testCase3() throws OHDataValidationException{
            billBrowserMgr.validateBill(bill, billItems, billPayments);
        }
    }

    @RunWith(Parameterized.class)
    public static class TC4 {
        BillBrowserManager billBrowserMgr = new BillBrowserManager();

        private Bill bill;
        private List<BillItems> billItems;
        private List<BillPayments> billPayments;

        //Bill parameters
        private static int id = 0;
		private static GregorianCalendar date = new GregorianCalendar();
		private static GregorianCalendar update = new GregorianCalendar();
		private static boolean isList = true;
		private static String listName = "";
		private static boolean isPatient = false;
        private static Patient billPatient = new Patient();
		private static String status = "";
		private static Double amount = 0.;
		private static Double balance = 0.;
		private static String user = "admin";


        public TC4(Bill b, List<BillItems> bI, List<BillPayments> bP) {
            this.bill = b;
            this.billItems = bI;
            this.billPayments = bP;
        }

       @Parameterized.Parameters(name="TC4 - Bill: {0} | Bill Items: {1} | Bill Payment: {2}")
       public static Collection data(){
            return Arrays.asList(new Object[][] {
                { new Bill(id, date, update, isList, null, listName, isPatient, billPatient, "", status, amount, balance, user), new ArrayList<BillItems>(), new ArrayList<BillPayments>() },
                { new Bill(id, date, update, isList, null, listName, isPatient, billPatient, " ", status, amount, balance, user), new ArrayList<BillItems>(), new ArrayList<BillPayments>() }
            });
        }

        //empty string
        //string filled with spaces

        @Test(expected = org.isf.utils.exception.OHDataValidationException.class)
        public void testCase4() throws OHDataValidationException{
            billBrowserMgr.validateBill(bill, billItems, billPayments);
        }
    }

    @RunWith(Parameterized.class)
    public static class TC5 {
        BillBrowserManager billBrowserMgr = new BillBrowserManager();

        private Bill bill;
        private List<BillItems> billItems;
        private List<BillPayments> billPayments;

        //Bill parameters
        private static int id = 0;
		private static GregorianCalendar update = new GregorianCalendar();
		private static boolean isList = true;
		private static String listName = "";
		private static boolean isPatient = false;
        private static Patient billPatient = new Patient();
        private static String patName = "Patient Name";
		private static String status = "";
		private static Double amount = 0.;
		private static Double balance = 0.;
		private static String user = "admin";


        public TC5(Bill b, List<BillItems> bI, List<BillPayments> bP) {
            this.bill = b;
            this.billItems = bI;
            this.billPayments = bP;
        }

       @Parameterized.Parameters(name="TC5 - Bill: {0} | Bill Items: {1} | Bill Payment: {2}")
       public static Collection data(){
            return Arrays.asList(new Object[][] {
                { new Bill(id, new GregorianCalendar(2025,7,20), update, isList, null, listName, isPatient, billPatient, patName, status, amount, balance, user), new ArrayList<BillItems>(), new ArrayList<BillPayments>() },
                { new Bill(id, new GregorianCalendar(2024,7,2), update, isList, null, listName, isPatient, billPatient, patName, status, amount, balance, user), new ArrayList<BillItems>(), new ArrayList<BillPayments>() }
            });
        }

        //date in the long future (after today)
        //date right after today

        @Test(expected = org.isf.utils.exception.OHDataValidationException.class)
        public void testCase5() throws OHDataValidationException{
            billBrowserMgr.validateBill(bill, billItems, billPayments);
        }
    }

    @RunWith(Parameterized.class)
    public static class TC6 {
        BillBrowserManager billBrowserMgr = new BillBrowserManager();

        private Bill bill;
        private List<BillItems> billItems;
        private List<BillPayments> billPayments;

        //Bill parameters
        private static int id = 0;
        private static GregorianCalendar update = new GregorianCalendar();
        private static boolean isList = true;
        private static String listName = "";
        private static boolean isPatient = false;
        private static Patient billPatient = new Patient();
        private static String patName = "Patient Name";
        private static String status = "";
        private static Double amount = 0.;
        private static Double balance = 0.;
        private static String user = "admin";

        public TC6(Bill b, List<BillItems> bI, List<BillPayments> bP) {
            this.bill = b;
            this.billItems = bI;
            this.billPayments = bP;
        }

       @Parameterized.Parameters(name="TC6 - Bill: {0} | Bill Items: {1} | Bill Payment: {2}")
       public static Collection data(){
            return Arrays.asList(new Object[][] {
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, status, amount, balance, user), new ArrayList<BillItems>(), Arrays.asList(new BillPayments(0, null, new GregorianCalendar(2005,5,10), 2., "user")) },
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, status, amount, balance, user), new ArrayList<BillItems>(), Arrays.asList(new BillPayments(0, null, new GregorianCalendar(2010,2,10), 2., "user")) }
            });
        }

        //date in the long future after the first payment
        //date right after the first payment

        @Test(expected = org.isf.utils.exception.OHDataValidationException.class)
        public void testCase6() throws OHDataValidationException{
            billBrowserMgr.validateBill(bill, billItems, billPayments);
        }
    }

    @RunWith(Parameterized.class)
    public static class TC7 {
        BillBrowserManager billBrowserMgr = new BillBrowserManager();

        private Bill bill;
        private List<BillItems> billItems;
        private List<BillPayments> billPayments;

        //Bill parameters
        private static int id = 0;
		private static GregorianCalendar date = new GregorianCalendar();
		private static GregorianCalendar update = new GregorianCalendar();
		private static boolean isList = true;
		private static String listName = "";
		private static boolean isPatient = false;
        private static Patient billPatient = new Patient();
        private static String patName = "Patient Name";
		private static Double amount = 0.;
		private static String user = "admin";


        public TC7(Bill b, List<BillItems> bI, List<BillPayments> bP) {
            this.bill = b;
            this.billItems = bI;
            this.billPayments = bP;
        }

       @Parameterized.Parameters(name="TC7 - Bill: {0} | Bill Items: {1} | Bill Payment: {2}")
       public static Collection data(){
            return Arrays.asList(new Object[][] {
                { new Bill(id, date, update, isList, null, listName, isPatient, billPatient, patName, "C", amount, 0.0000000001, user), new ArrayList<BillItems>(), new ArrayList<BillPayments>() },
                { new Bill(id, date, update, isList, null, listName, isPatient, billPatient, patName, "C", amount, -0.0000000001, user), new ArrayList<BillItems>(), new ArrayList<BillPayments>() },
                { new Bill(id, date, update, isList, null, listName, isPatient, billPatient, patName, "C", amount, Double.MAX_VALUE, user), new ArrayList<BillItems>(), new ArrayList<BillPayments>() },
                { new Bill(id, date, update, isList, null, listName, isPatient, billPatient, patName, "C", amount, Double.MIN_VALUE, user), new ArrayList<BillItems>(), new ArrayList<BillPayments>() }
            });
        }

        //status closed and values ​​other than 0

        @Test(expected = org.isf.utils.exception.OHDataValidationException.class)
        public void testCase7() throws OHDataValidationException{
            billBrowserMgr.validateBill(bill, billItems, billPayments);
        }
    }

    @RunWith(Parameterized.class)
    public static class TC8 {
        BillBrowserManager billBrowserMgr = new BillBrowserManager();

        private Bill bill;
        private List<BillItems> billItems;
        private List<BillPayments> billPayments;

        //Bill parameters
        private static int id = 0;
		private static GregorianCalendar date = new GregorianCalendar();
		private static GregorianCalendar update = new GregorianCalendar();
		private static boolean isList = true;
		private static String listName = "";
		private static boolean isPatient = false;
        private static Patient billPatient = new Patient();
        private static String patName = "Patient Name";
		private static String status = "";
		private static Double amount = 0.;
		private static Double balance = 0.;
		private static String user = "admin";


        public TC8(Bill b, List<BillItems> bI, List<BillPayments> bP) {
            this.bill = b;
            this.billItems = bI;
            this.billPayments = bP;
        }

       @Parameterized.Parameters(name="TC8 - Bill: {0} | Bill Items: {1} | Bill Payment: {2}")
       public static Collection data(){
            return Arrays.asList(new Object[][] {
                { new Bill(id, date, update, isList, null, listName, isPatient, billPatient, patName, status, amount, balance, user), new ArrayList<BillItems>(), null }
            });
        }

        //Payment list null

        @Test(expected = NullPointerException.class)
        public void testCase8() throws OHDataValidationException{
            billBrowserMgr.validateBill(bill, billItems, billPayments);
        }
    }

    @RunWith(Parameterized.class)
    public static class TC9 {
        BillBrowserManager billBrowserMgr = new BillBrowserManager();

        private Bill bill;
        private List<BillItems> billItems;
        private List<BillPayments> billPayments;

        //Bill parameters
        private static int id = 0;
        private static GregorianCalendar update = new GregorianCalendar();
        private static boolean isList = true;
        private static String listName = "";
        private static boolean isPatient = false;
        private static Patient billPatient = new Patient();
        private static String patName = "Patient Name";
        private static String status = "";
        private static Double amount = 0.;
        private static Double balance = 0.;
        private static String user = "admin";


        public TC9(Bill b, List<BillItems> bI, List<BillPayments> bP) {
            this.bill = b;
            this.billItems = bI;
            this.billPayments = bP;
        }

       @Parameterized.Parameters(name="TC9 - Bill: {0} | Bill Items: {1} | Bill Payment: {2}")
       public static Collection data(){
            return Arrays.asList(new Object[][] {
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, status, amount, balance, user), new ArrayList<BillItems>(), Arrays.asList(new BillPayments(0, null, new GregorianCalendar(2029,5,10), 2., "user")) },
                { new Bill(id, new GregorianCalendar(2010, 3, 14), update, isList, null, listName, isPatient, billPatient, patName, status, amount, balance, user), new ArrayList<BillItems>(), Arrays.asList(new BillPayments(0, null, new GregorianCalendar(2024,7,2), 2., "user")) }
            });
        }

        //last payment in the long future after today
        //last payment right after today
        
        @Test(expected = org.isf.utils.exception.OHDataValidationException.class)
        public void testCase9() throws OHDataValidationException{
            billBrowserMgr.validateBill(bill, billItems, billPayments);
        }
    }

}

