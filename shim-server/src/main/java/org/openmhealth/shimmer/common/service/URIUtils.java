package org.openmhealth.shimmer.common.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.StringJoiner;

public class URIUtils {
	
    public static String appendUri(String uri, String appendQuery) {
    	try {
	        URI oldUri = new URI(uri);
	
	        String newQuery = oldUri.getQuery();
	        if (newQuery == null) {
	            newQuery = appendQuery;
	        } else {
	            newQuery += "&" + appendQuery;  
	        }
	
	        URI newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(),
	                oldUri.getPath(), newQuery, oldUri.getFragment());
	
	        return newUri.toString();
    	} catch (URISyntaxException e) {
    		e.printStackTrace();
    		return uri;
    	}
    }
    
    public static String createQuery(Map<String,String> parameters) {
    	if (parameters != null) {
    		StringJoiner result = new StringJoiner("&");
    		parameters.forEach((key,value) -> result.add(key + "=" + value));
    		return result.toString();
    	}
    	
    	return "";
    }

    
}
