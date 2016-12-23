package com.yezhangxin.utils;


import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PropertiesUtil {
    
    private String configPath = null;

   
    private Properties props = null;

    
    public PropertiesUtil() throws IOException {
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("LexicalAnalyzers.properties");
        props = new Properties();
        props.load(in);
     
        in.close();
    }

    public PropertiesUtil(String configPath) throws IOException{
        this.configPath = configPath;
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(configPath);
        props = new Properties();
        props.load(in);
        
        in.close();
    }

    
    public String readValue(String key) throws IOException {
        return props.getProperty(key);
    }

    
    public<T> Map<T,T> readAllProperties() throws FileNotFoundException, IOException {

        Map<T,T> map = new HashMap<T, T>();
        Enumeration en = props.propertyNames();
        while (en.hasMoreElements()) {
            T key = (T) en.nextElement();
            T Property = (T) props.getProperty(String.valueOf(key));
            map.put(key, Property);
        }
        return map;
    }

    
    public void setValue(String key, String value) throws IOException {
        Properties prop = new Properties();
        InputStream fis = new FileInputStream(this.configPath);
        
        prop.load(fis);
        
        OutputStream fos = new FileOutputStream(this.configPath);
        prop.setProperty(key, value);
        
        prop.store(fos, "last update");
      
        fis.close();
        fos.close();
    }

    public static void main(String[] args) {
        PropertiesUtil p;
        try {
            p = new PropertiesUtil();
            System.out.println(p.readAllProperties());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
