package br.com.server.main.server;

import br.com.server.main.interfaces.IServerConnect;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author Leonardo
 */
public class ServerConnect implements IServerConnect {//NOPMD

    /**
     * Metodo para iniciar o servidor
     * @param port
     * @return ServerSocket
     * @throws IOException
     */
    @Override
    public ServerSocket startServer(final int port) throws IOException {
        return  new ServerSocket(port);
    }
}
