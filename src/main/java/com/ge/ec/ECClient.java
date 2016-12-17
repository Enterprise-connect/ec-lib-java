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
import java.util.HashMap;

public interface ECClient {
    
    public boolean Start() throws IOException;
    
    public boolean Stop();
    
    public String Version();
    
    public boolean setSettings(HashMap map);
    
    public HashMap getSettings();

}
