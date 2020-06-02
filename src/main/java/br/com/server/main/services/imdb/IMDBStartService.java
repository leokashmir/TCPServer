package br.com.server.main.services.imdb;

import br.com.server.main.interfaces.IServerListener;
import br.com.server.main.parser.PayLoadManeger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classe para iniciar o servico IMDBService
 * @author Leonardo
 */
public class IMDBStartService implements IServerListener {

    /** Gerenmcimaneto do PayLoad*/
    private final PayLoadManeger payLoadManeger ;

    /** Classe de Servico IMDB*/
    private final IMDBService service ;

    /**
     * Construtor da Classe IMDBStartService
     * Instancia a classe com o PayLoadManeger e IMDBService
     */
    public IMDBStartService() {
        this.payLoadManeger =  new PayLoadManeger();
        this.service =  new IMDBService();
    }

    /**
     * Metodo que inicia o serviço IMDBService
     * @param socket
     * @throws IOException
     */
    @Override
    public void startListener(final ServerSocket socket) throws IOException {

        while (true) {
            final Socket connectionSocket = socket.accept();//NOPMD
            final IMDBListener listener = new IMDBListener( service, payLoadManeger, connectionSocket);//NOPMD
            final Thread thread = new Thread(listener);//NOPMD
            thread.start();
        }
    }

    public PayLoadManeger getPayLoadManeger() {
        return payLoadManeger;
    }

    public IMDBService getService() {
        return service;
    }
}
