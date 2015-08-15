/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.nfe.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author everaldo
 */
public class NFEProperties {

    Properties properties = new Properties();

    public NFEProperties() {

        try {
            InputStream defaultIS = this.getClass().getResourceAsStream("/nfe.default.properties");
            if (defaultIS != null) {
                properties.load(defaultIS);
            }

            InputStream propFile = this.getClass().getResourceAsStream("/nfe.properties");

            if (propFile != null) {
                properties.load(propFile);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

}
