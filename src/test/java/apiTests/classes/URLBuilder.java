package apiTests.classes;

public class URLBuilder {

    private final static String URL = "http://gateway.marvel.com/v1/public/";
    private final static String AUTHORIZATION = "?ts=1&apikey=07b0d846cafe9b5b9b8a341ee25876fa&hash=7754b05bf99ad4b66a62ab72e670ba34";

    public static String getURL (String url){
    return URL + url + AUTHORIZATION;
    }
}
