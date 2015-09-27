/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.osgi.system;

/**
 *
 * @author mao
 */
public interface MaoService {
    public String getAllBundles();
    public boolean installBundle(String symbolicName, String version);
}
