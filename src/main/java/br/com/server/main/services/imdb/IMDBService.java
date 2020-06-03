package br.com.server.main.services.imdb;

import java.io.IOException;
import br.com.server.main.enums.ImdbEnum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.List;

import java.util.regex.Pattern;

/**
 * Classe de Servico
 * @author Leonardo
 */
public class IMDBService {//NOPMD


    /** Logger da classe*/
    private static final Logger LOG =  LoggerFactory.getLogger(IMDBService.class.getName());

    /** URl base para consulta */
    private final transient String url;

    /**
     *  Construtor
     */
    public IMDBService() {
        this.url =  ImdbEnum.SITEIMDB.getUrl();
    }

    /**
     * Metodo que captura uma lista de titulos
     * @param sentece
     * @return String
     * @throws IOException
     */
    public String listFilms(final String sentece) throws IOException {

        final String url = this.urlEncoded(sentece);

        final Document doc = Jsoup.connect(url).get();
        final List<Element> element =  doc.body().getElementsByTag("td");
        final StringBuilder lsTitleFilms = new StringBuilder();

        element.forEach(e -> {
            e.getElementsByTag("a").forEach( a -> lsTitleFilms.append(a.text()).append('\n'));
        });

        return lsTitleFilms.toString();
    }


    private String urlEncoded(final String sentece) throws IOException {

        try{

            final String newSentece = removeCharacters(sentece);

            final StringBuilder creatUrl = new StringBuilder(url);
            creatUrl.append("find?q=")
                    .append(URLEncoder.encode(newSentece, String.valueOf(StandardCharsets.UTF_8)))
                    .append("&s=tt&ref_=fn_al");

            return  creatUrl.toString();

        }catch( IOException e){
            LOG.error(e.getMessage());
        }

        throw  new  IOException("Erro ao montar a url.");
    }


    private String removeCharacters(final String sentece){
        String newSentece = sentece.replaceAll("[:@#$%&><]", "");
        newSentece = Normalizer.normalize(newSentece, Normalizer.Form.NFD);

        final Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(newSentece).replaceAll("");
    }
}
