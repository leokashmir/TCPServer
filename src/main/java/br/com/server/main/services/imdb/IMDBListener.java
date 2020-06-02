package br.com.server.main.services.imdb;


import br.com.server.main.parser.PayLoadManeger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;

/**
 * Classe Listener do Servico IMDBService
 * @author Leonardo
 */
public class IMDBListener implements Runnable {

    /** Looger da classe  */
    private static final Logger LOG =  LoggerFactory.getLogger(IMDBListener.class.getName());

    /** Servicos IMDBS  */
    private final IMDBService service;

    /** Gerenciamento do PayLoad  */
    private final PayLoadManeger payLoadManeger ;

    /** Socket para conexão  */
    private final Socket connectionSocket;

    /** BufferedReader  */
    private transient  BufferedReader inFromClient;

    /** DataOutputStream  */
    private transient  DataOutputStream outToClient;

    /** Texto da busca do usuario  */
    private transient  String clientSentence ;


    /**
     * Construtor
     * @param service
     * @param payLoadManeger
     * @param socket
     */
    public IMDBListener(final IMDBService service, final PayLoadManeger payLoadManeger, final Socket socket) {
        this.service = service;
        this.payLoadManeger = payLoadManeger;
        this.connectionSocket = socket;
    }



    @Override
    public void run() {

        try {


            if(LOG.isInfoEnabled()) {
                LOG.info("Conexao Estabelecida: " + connectionSocket.getLocalAddress());
            }
            inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            while (true) {

                String sentece = inFromClient.readLine();
                if (payLoadManeger.checkPayLoad(sentece)) {
                    sentece = payLoadManeger.payloadToSentece(sentece);

                    if(LOG.isInfoEnabled()) {
                        LOG.info("Realizando Busca Por: " + sentece);
                    }

                    final String listTitlesFilms = service.listFilms(sentece);

                    clientSentence = payLoadManeger.mountPayLoadOut(listTitlesFilms);

                    outToClient.writeBytes(clientSentence);


                }else{
                    outToClient.writeBytes("Payload incorreto, encerrando conexao.\n");
                    inFromClient.close();
                    outToClient.close();
                    connectionSocket.close();
                }
            }

        } catch ( IOException e) {
            LOG.error("Erro ao Conectar no Servidor");
        } finally {
            LOG.info("Conexao fechada");
        }
    }


    public IMDBService getService() {
        return service;
    }

    public PayLoadManeger getPayLoadManeger() {
        return payLoadManeger;
    }

    public Socket getConnectionSocket() {
        return connectionSocket;
    }
}
