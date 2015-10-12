/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.osgi.system;

import com.sa.osgi.main.Main;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

/**
 *
 * @author maochuanli
 */
public class ServiceFactory {
    public static ServiceFactory INSTANCE = new ServiceFactory();

    private ServiceFactory(){}
    private boolean initialized = false;
    private BundleContext systemCtx = null;
    
    public void init(BundleContext ctx){
        this.systemCtx = ctx;
        System.out.println("instance=="+this+",context=="+ctx);
        this.initialized = true;
        System.out.println("Factory Initialized.....");
    }
    
    public  synchronized UIService getUIService(Credential credential){
//        if(!initialized) throw new RuntimeException("ServiceFactory not initialized yet!");
        UIService uiService = null;
        System.out.println("in getUIService instance=="+this+",context=="+systemCtx);
        
        if (systemCtx != null) {
            try {

                String defaultFilter = "(&(objectClass=" + UIService.class.getName() + ")"
                        + "(vendor=SA) )";

                String tenantName = credential.getTennantName();
                String filter = null;
                if (tenantName != null) {
                    filter = "(&(objectClass=" + UIService.class.getName() + ")"
                            + "(vendor=" + credential.getTennantName() + ") )";
                } else {
                    filter = defaultFilter;
                }

                System.out.println("filter: " + filter);
                ServiceReference<?>[] serviceReferences = systemCtx.getServiceReferences(UIService.class.getName(), filter);
                if (serviceReferences != null && serviceReferences.length > 0) {
                    System.out.println("How many services available? " + serviceReferences.length);
                    return (UIService) systemCtx.getService(serviceReferences[0]);
                } 
                    System.out.println("Using default filter: "+defaultFilter);
                    serviceReferences = systemCtx.getServiceReferences(UIService.class.getName(), defaultFilter);
                    

                    ServiceReference<?> maoRef = serviceReferences[0];
                    return (UIService) systemCtx.getService(maoRef);
                

            } catch (InvalidSyntaxException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return uiService;
    }
    
    public synchronized MaoService getMaoService() {
        MaoService maoService = null;
       
        if (systemCtx != null) {
            ServiceReference<?> maoRef = systemCtx.getServiceReference(MaoService.class.getName());
            maoService = (MaoService) systemCtx.getService(maoRef);
        }

        return maoService;
    }
}
