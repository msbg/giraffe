package org.giraffe.poc1;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;


public class SimpleJettyServer {
    private Server server;

    public void start() throws Exception {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[] {connector});
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/poc1");
        context.addServlet(SimpleServlet.class, "/simple");
        server.setHandler(context);
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }

    public static void main(String[] args) throws Exception {
        SimpleJettyServer simpleJettyServer = new SimpleJettyServer();
        simpleJettyServer.start();
    }
}
