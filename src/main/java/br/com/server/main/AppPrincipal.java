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


            final ServerConnect con = new ServerConnect();

            final int args = arg.length;
            final int port = (args == 0) ?  5551 :  Integer.parseInt(arg[0]);

            final ServerSocket socket = con.startServer(port);//NOPMD

            if(LOG.isInfoEnabled()){ LOG.info("Servidor Iniciado na Porta "+ port); }

            final IMDBStartService start = new IMDBStartService();
            start.startListener(socket);

        }catch (IOException | NumberFormatException ex){
            LOG.error( "Erro ao inicar o Servidor ");
        }


    }
}
