/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.osgi.system.service.daemon;

/**
 * http://www.nncron.ru/help/EN/working/cron-format.htm
 * * * * * * *
| | | | | | 
| | | | | +-- Year              (range: 1900-3000)
| | | | +---- Day of the Week   (range: 1-7, 1 standing for Monday)
| | | +------ Month of the Year (range: 1-12)
| | +-------- Day of the Month  (range: 1-31)
| +---------- Hour              (range: 0-23)
+------------ Minute            (range: 0-59)
 * @author mao
 */
public class CronFormat {
    private String cronFormat = null;
    
    public CronFormat(String spec){
        this.cronFormat = spec;
    }
    
    private boolean validate(){
        return true;
    }
}
