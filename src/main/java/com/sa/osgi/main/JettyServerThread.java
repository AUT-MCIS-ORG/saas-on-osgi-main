/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.osgi.main;

import com.sa.osgi.system.ServiceFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.osgi.framework.BundleContext;

/**
 *
 * @author maochuanli
 */
public class JettyServerThread extends Thread{
    
    private BundleContext systemCtx = null;
    private Server jettyServer = null;
    
    public JettyServerThread(BundleContext ctx){
        systemCtx = ctx;
    }
    
    @Override
            public void run() {
                //1. Creating the server on port 8080
                ServiceFactory.INSTANCE.init(systemCtx);

                String portStr = System.getenv("PORT");
                int port = portStr == null ? 8080 : Integer.parseInt(portStr);
                jettyServer = new Server(port);

                        //2. Creating the WebAppContext for the created content
        //		WebAppContext ctx = new WebAppContext();
        //		ctx.setResourceBase("src/main/webapp");
                WebAppContext webapp = new WebAppContext();
                webapp.setContextPath("/");
                webapp.setWar("saas.war");

                //3. Creating the LoginService for the realm
                HashLoginService loginService = new HashLoginService("UserRealm");

                //4. Setting the realm configuration there the users, passwords and roles reside
                loginService.setConfig("db.realm.txt");

                //5. Appending the loginService to the Server
                jettyServer.addBean(loginService);

                //6. Setting the handler
                jettyServer.setHandler(webapp);

                try {
                    //7. Starting the Server
                    jettyServer.start();
//                    jettyServer.join();
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
}
