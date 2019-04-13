package com.ask.maryam.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.Integer.parseInt;

public class Parameters {

    private int secretNbSize;
    private int trialNbMax;
    private int maxUsableDigit;
    private boolean devMode;


    private void setSecretNbSize(int secretNbSize) {
        this.secretNbSize = secretNbSize;
    }

    private void setTrialNbMax(int trialNbMax) {
        this.trialNbMax = trialNbMax;
    }

    private void setMaxUsableDigit(int maxUsableDigit) {
        this.maxUsableDigit = maxUsableDigit;
    }

    public void setDevMode(boolean devMode) {
        this.devMode = devMode;
    }

    /*
        Retrieve all properties or game parameters in the config.properties file.
     */
    private void retrieveProperties(){
        final Properties prop = new Properties();
        InputStream input = null;

        try{
            input = new FileInputStream("C:/Projects/Java/Workspace/Project3/src/resources/config.properties");

            // load a properties file
            prop.load(input);

            this.setMaxUsableDigit(parseInt(prop.getProperty("maxUsableDigit")));
            this.setSecretNbSize(parseInt(prop.getProperty("secretNbSize")));
            this.setTrialNbMax(parseInt(prop.getProperty("trialNbMax")));

        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
