package com.ttt.datamanager;

import com.ttt.enums.ConfigPropertyKeys;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public final class ConfigPropertyManager {

    private ConfigPropertyManager(){

    }
private static final Properties CONFIG_PROPERTIES = new Properties();
private static final String FILE_CONFIG_PROPERTIES = "config.properties";
private static final HashMap<String,String> PROPERTIES_MAP= new HashMap<>();

static{
    try(InputStream fileInputStream = ConfigPropertyManager.class.getClassLoader().getResourceAsStream(FILE_CONFIG_PROPERTIES)){
        CONFIG_PROPERTIES.load(fileInputStream);
        CONFIG_PROPERTIES.forEach((k,v)->
                PROPERTIES_MAP.put(k.toString(),v.toString()));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

public static String getConfigProperty(ConfigPropertyKeys configPropertyKey){
    return PROPERTIES_MAP.get(configPropertyKey.getConfigPropertyKey());
}






}
