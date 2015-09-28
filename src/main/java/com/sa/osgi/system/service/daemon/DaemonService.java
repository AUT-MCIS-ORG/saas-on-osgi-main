/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.osgi.system.service.daemon;

/**
 *
 * @author mao
 */
public interface DaemonService {
    public void registerTask(ITask t, CronFormat format);
}
