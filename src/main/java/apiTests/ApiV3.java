package apiTests;

import org.apache.http.client.utils.URIBuilder;

/**
 * Created by DimaM on 11/24/2015.
 */
public class ApiV3 {


    public static String host = "www.pdffiller.com";
    public static String scheme = "https";
    public static String appKey = "web_fds3w43342Sbs";//"AutoTest343_13FmciS";
    public static String device = "web";

    public URIBuilder uriBuilder =  new URIBuilder().setScheme(scheme).setHost(host)
            .setParameter("appKey", appKey).setParameter("device", device);

}
