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


    public Parameters() {
        this.setSecretNbSize();
        this.setMaxUsableDigit();
        this.setTrialNbMax();

    }

    private void setSecretNbSize() {
        this.secretNbSize = parseInt(this.retrieveProperties().getProperty("secretNbSize"));
    }

    private void setTrialNbMax() {
        this.trialNbMax = parseInt(this.retrieveProperties().getProperty("trialNbMax"));
    }

    private void setMaxUsableDigit() {
        this.maxUsableDigit = parseInt(this.retrieveProperties().getProperty("maxUsableDigit"));
    }

    public void setDevMode(boolean devMode) {
        this.devMode = devMode;
    }


    public int getSecretNbSize() {
        return secretNbSize;
    }

    public int getTrialNbMax() {
        return trialNbMax;
    }

    public int getMaxUsableDigit() {
        return maxUsableDigit;
    }

    public boolean isDevMode() {
        return devMode;
    }



    /*
        Retrieve all properties or game parameters in the config.properties file.
     */
    public Properties retrieveProperties(){
        final Properties prop = new Properties();
        InputStream input = null;

        try{
            input = new FileInputStream("C:/Projects/Java/Workspace/Project3/src/resources/config.properties");

            // load a properties file
            prop.load(input);

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

        return prop;
    }

}
