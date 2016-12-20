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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.SystemUtils;
import org.json.simple.JSONObject;

public class ECServerImpl implements ECServer {
    
    //private static Thread _thd;
    private static Process _process;
    private final String VER = "v1";
    private static final JSONObject _settings=new JSONObject();;
    
    public ECServerImpl(){
    }
    
    private class ThreadProvisioner implements Runnable {
        
        private Process _proc;
        public ThreadProvisioner(Process proc){
            _proc=proc;
        }

        @Override
        public void run() {
      
            try{                
                final int exCode=_proc.waitFor();
                System.out.println("Exit Code:"+exCode);                
            } catch(Throwable ex){
                Logger.getLogger(ECClientImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    }
    
    private boolean writeSettingsToFile(String _path){
        try { 
            File file=new File(_path);
            file.createNewFile();  
            FileWriter fileWriter = new FileWriter(file);
  
            fileWriter.write(this._settings.toJSONString());  
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            Logger.getLogger(ECClientImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } 

        return true;
    }
    
    @Override
    public boolean launch() throws IOException {

        String _ec_art="";
        if (SystemUtils.IS_OS_LINUX){
            _ec_art="ecserver_linux";
        } else if (SystemUtils.IS_OS_WINDOWS){
            _ec_art="ecserver_windows.exe";
        } else if (SystemUtils.IS_OS_MAC){
            _ec_art="ecserver_darwin";
        }
        
        if (_process!=null&&_process.isAlive())
            return true;
        
        boolean _ok=writeSettingsToFile("./settings.json");
        if (!_ok){
            return false;
        }
        
        _process = new ProcessBuilder().command("./"+_ec_art,"&").inheritIO().start();
                
        Thread _thd = new Thread(new ThreadProvisioner(_process));
        _thd.start();
        return true;
    }

    @Override
    public boolean isAlive() {
        return _process.isAlive();
    }
    
    @Override
    public boolean terminate(){
        _process.destroy();
        _process=null;
        return true;    
        
    }

    @Override
    public void setSetting(String key, Object val){
        _settings.put(key,val);
    }

    @Override
    public String getSetting(String key) {
        Object val=_settings.get(key);
        return String.valueOf(val);
    }

    @Override
    public String version() {
        return this.VER;
    }
}