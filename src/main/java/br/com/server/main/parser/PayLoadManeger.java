package br.com.server.main.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Leonardo
 */
public class PayLoadManeger {//NOPMD

    /**
     * Looger da classe
     */
    private static final Logger LOG =  LoggerFactory.getLogger(PayLoadManeger.class.getName());

    /** flag para o metodo checkPayLoad */
    private transient  boolean retorno ;

    /**
     * Metodo para checar se o PayLoad esta correto
     * @param requestPayLoad
     * @return true : false
     */
    public boolean checkPayLoad(final String requestPayLoad ){
        retorno = false;
        try{
            if(checkValidPayLoad( requestPayLoad )){
                final String[]payLoad = requestPayLoad.split(":", -1);
                final String queryLength = payLoad[0];
                final int query =  payLoad[1].length();

                final int payloadLength = Integer.parseInt(queryLength);

                retorno = payloadLength ==  query  ;
            }
        }catch( NumberFormatException ex){
            if(LOG.isErrorEnabled()){
                LOG.error("Payload incorreto." + ex.getMessage());
            }
        }
        return retorno;
    }


    private boolean checkValidPayLoad( final String requestPayLoad ){
        return requestPayLoad != null && !requestPayLoad.equals("") && requestPayLoad.contains(":");
    }

    /**
     * Metodo para capturar o titulo do filme no Payload
     * @param requestPayLoad
     * @return String
     */
    public String payloadToSentece(final String requestPayLoad ){
        final String[] payLoad = requestPayLoad.split(":");
        return payLoad[1];

    }

    /**
     * Metodo que cria o PayLoad de Retorno
     * @param payload
     * @return String
     */
    public String mountPayLoadOut(final String payload){

        final StringBuilder payLoadFormatted = new StringBuilder();
        if(payload != null){
            payLoadFormatted.append(payload.length())
                    .append(':')
                    .append(payload)
                    .append('\n');
        }
        return payLoadFormatted.toString();
    }
}
