/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.osgi.system;

import java.io.FileInputStream;
import java.util.List;

/**
 *
 * @author mao
 */
public interface MaoService {
    public List<String> getAllBundles(Credential cred);
    public boolean installBundle(String fileName);
    public boolean installBundle(FileInputStream fin);
}
