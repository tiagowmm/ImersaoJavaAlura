package br.com.tw.util;

import br.com.tw.manager.LeituraAPIFilmeIMDB;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Tiago
 */
public class PropertiesUtil {

    private static PropertiesUtil instancia;

    private Map<String, String> propriedades = new HashMap<>();

    private PropertiesUtil() {
        super();
    }

    public static PropertiesUtil  newPropertiesUtil() {
        if (instancia == null) {
            instancia = new PropertiesUtil();
        }
        return instancia;
    }

    private void lerConfiguracao() {
        try {

            InputStream resource = LeituraAPIFilmeIMDB.class.getClassLoader().getResourceAsStream("config.properties");

            Properties props = new Properties();
            props.load(resource);

            Set<Map.Entry<Object, Object>> entries = props.entrySet();
            for (Map.Entry<Object, Object> pros : entries) {
                getPropriedades().put(pros.getKey().toString(), pros.getValue().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> getPropriedades() {
        if (propriedades == null || propriedades.isEmpty()) {
            propriedades = new HashMap<>();
            lerConfiguracao();
        }
        return propriedades;
    }

    public String getAPIKey(){
        return getPropriedades().get("apiKey");
    }

}
