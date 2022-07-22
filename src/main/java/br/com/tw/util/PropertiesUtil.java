package br.com.tw.util;

import br.com.tw.LeituraAPIFilmeIMDB;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {


    public String obterApiKey() throws IOException {

        InputStream resource = LeituraAPIFilmeIMDB.class.getClassLoader().getResourceAsStream("config.properties");


        Properties props = new Properties();
        props.load(resource);

        if (props.containsKey("apiKey")) {
            return (String) props.get("apiKey");
        }

        return null;
    }



}

