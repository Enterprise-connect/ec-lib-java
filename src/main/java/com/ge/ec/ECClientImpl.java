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

import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ECClientImpl implements ECClient {

    /**
     *
     * @return @throws IOException
     */
    @Override
    public boolean Start() throws IOException {

        Process iostat = new ProcessBuilder().command("./ecclient_darwin -file client_settings.json").inheritIO().start();
        int exitCode;
        try {
            exitCode = iostat.waitFor();
            System.out.println("exitCode = " + exitCode);

        } catch (InterruptedException ex) {
            Logger.getLogger(ECClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Stop() {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setSettings(HashMap map) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap getSettings() {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Version() {
        return "V1";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}