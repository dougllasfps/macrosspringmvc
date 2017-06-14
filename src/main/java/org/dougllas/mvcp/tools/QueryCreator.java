package org.dougllas.mvcp.tools;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Criado por dougllas.sousa em 07/06/2017.
 */
public class QueryCreator {

    private AbstractMap.SimpleEntry<StringBuilder, Map<String, Object>> builder;

    public QueryCreator(String query, Map<String, Object> params) {
        this.builder = new AbstractMap.SimpleEntry<StringBuilder, Map<String, Object>>(new StringBuilder(query), params);
    }

    public QueryCreator() {
        this("", new HashMap<>());
    }

    public QueryCreator append(String append){
        builder.getKey().append(append);
        return this;
    }

    public QueryCreator addParam(String name, Object value){
        builder.getValue().put(name, value);
        return this;
    }

    public String query(){
        return builder.getKey().toString();
    }

    public Map<String, Object> params(){
        return builder.getValue();
    }
}
