package br.com.server.main.enums;

/**
 *  Enum de constants para o serviço IMDB
 *
 * @author Leonardo
 */
public enum ImdbEnum {

    SITEIMDB("https://www.imdb.com/");

    /**
     * Url base para pesquisa
     */
    private  String url;

    ImdbEnum(final String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}