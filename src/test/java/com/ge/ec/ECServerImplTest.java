/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 *
 * @author chia.chang@ge.com
 *
 */
package com.ge.ec;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ECServerImplTest {
    
    private final ECServerImpl instance = new ECServerImpl();
    public ECServerImplTest() {
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

    
    @Test
    public void testStart() throws Exception {
        System.out.println("Start");
        //boolean result = instance.Start();
        boolean expResult = true;
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Stop method, of class ECClientImpl.
     */
    @Test
    public void testStop() {
        System.out.println("Stop");
        
        boolean expResult = true;
        //boolean result = instance.Stop();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSettings method, of class ECClientImpl.
     */
    @Test
    public void testSetSettings() {
        System.out.println("setSettings");
        HashMap map = null;
        boolean expResult = false;
        instance.setSetting("hello", "world");
        //assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSettings method, of class ECClientImpl.
     */
    @Test
    public void testGetSettings() {
        System.out.println("getSettings");
        String expResult = "world";
        String result = instance.getSetting("hello");
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Version method, of class ECClientImpl.
     */
    @Test
    public void testVersion() {
        System.out.println("Version");
        String expResult = "";
        String result = instance.version();
        //assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
