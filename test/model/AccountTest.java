/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nết
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Account.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Account.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Account instance = new Account();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Account.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class Account.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "";
        Account instance = new Account();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPass method, of class Account.
     */
    @Test
    public void testGetPass() {
        System.out.println("getPass");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getPass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPass method, of class Account.
     */
    @Test
    public void testSetPass() {
        System.out.println("setPass");
        String pass = "";
        Account instance = new Account();
        instance.setPass(pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsSeller method, of class Account.
     */
    @Test
    public void testGetIsSeller() {
        System.out.println("getIsSeller");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getIsSeller();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsSeller method, of class Account.
     */
    @Test
    public void testSetIsSeller() {
        System.out.println("setIsSeller");
        int isSeller = 0;
        Account instance = new Account();
        instance.setIsSeller(isSeller);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsAdmin method, of class Account.
     */
    @Test
    public void testGetIsAdmin() {
        System.out.println("getIsAdmin");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getIsAdmin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsAdmin method, of class Account.
     */
    @Test
    public void testSetIsAdmin() {
        System.out.println("setIsAdmin");
        int isAdmin = 0;
        Account instance = new Account();
        instance.setIsAdmin(isAdmin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
