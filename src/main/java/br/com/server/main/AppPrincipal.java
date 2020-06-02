package br.com.server.main;

import br.com.server.main.server.ServerConnect;
import br.com.server.main.services.imdb.IMDBStartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author Leonardo
 */
public final class AppPrincipal {

    /** Log */
    private static final Logger LOG =  LoggerFactory.getLogger(AppPrincipal.class.getName());

    private AppPrincipal() {
    }

    /**
     * Classe Main
     * @param arg
     */
    public static void main(final String arg[])   {
        try{
            if(LOG.isInfoEnabled()){
                LOG.info("Iniciando Servidor");
            }

            final ServerConnect con = new ServerConnect();
            final ServerSocket socket = con.startServer(5551);//NOPMD
            final IMDBStartService start = new IMDBStartService();
            start.startListener(socket);

        }catch (IOException e){
            LOG.error( "Erro ao inicar o Servidor ");
        }


    }
}
