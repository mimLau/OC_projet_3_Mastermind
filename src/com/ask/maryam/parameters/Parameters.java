package com.ask.maryam.parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.Integer.parseInt;

public enum Parameters {
    INSTANCE;

    private int secretNbSize;
    private int trialNbMax;
    private int maxUsableDigit;
    private boolean devMode;

    final static Logger LOGGER = LogManager.getLogger(Parameters.class);

    public void setSecretNbSize() {
        String secretNbSize = retrieveProperties().getProperty("secretNbSize");

        // Verify if the parameter secretNbSize isn't empty.
        if(!secretNbSize.equals("")){

            //Verify if the parameter secretNbSize contains only number
            if(stringContainsNb(secretNbSize)) {
                this.secretNbSize = parseInt(retrieveProperties().getProperty("secretNbSize"));
            } else {
                System.out.println("\nVeuillez saisir un nombre pour le secretNbSize dans le fichier config.properties.");
                this.secretNbSize = 0;
            }

            if(this.secretNbSize > maxUsableDigit){
                System.out.println("\nDans le fichier config.properties, veuillez choisir un secretNbSize inférieur au maxUsableDigit.");
                this.secretNbSize = 0;
            }
        }
        else {
            System.out.println("\nVeuillez paramétrer le secretNbSize dans le fichier config.properties.");
            this.secretNbSize = 0;
        }
    }

    public void setTrialNbMax() {
        String trialNbMax = retrieveProperties().getProperty("trialNbMax");

        // Verify if the parameter trialNbMax isn't empty.
        if(!trialNbMax.equals("")) {

            // Verify if the parameter trialNbMax contains only number
            if(stringContainsNb(trialNbMax)) {
                this.trialNbMax = parseInt(retrieveProperties().getProperty("trialNbMax"));
            } else {
                System.out.println("\nVeuillez saisir un nombre pour le trialNbMax dans le fichier config.properties.");
                this.trialNbMax = 0;
            }
        }
        else {
            System.out.println("\nVeuillez paramétrer le trialNbMax dans le fichier config.properties.");
            this.trialNbMax = 0;
        }
    }

    public void setMaxUsableDigit() {
        String maxUsableDigit = retrieveProperties().getProperty("maxUsableDigit");

        // Verify if the parameter maxUsableDigit isn't empty.
        if(!maxUsableDigit.equals("")){

            // Verify if the parameter maxUsableDigit contains only number
            if(stringContainsNb(maxUsableDigit)) {
                int intMaxUsableDigit = parseInt(retrieveProperties().getProperty("maxUsableDigit"));

                // The maxUsableDigit must be between 4 and 9.
                if(intMaxUsableDigit >= 4 && intMaxUsableDigit <10){
                    this.maxUsableDigit = parseInt(retrieveProperties().getProperty("maxUsableDigit"));
                } else {
                    System.out.println("\nVeuillez choisir un maxUsableDigit entre 4 et 9 dans le fichier config.properties.");
                    this.maxUsableDigit = 0;
                }
            } else {
                System.out.println("\nVeuillez saisir un nombre pour le maxUsableDigit dans le fichier config.properties.");
                this.maxUsableDigit = 0;
            }
        }
        else {
            System.out.println("\nVeuillez paramétrer le maxUsableDigit dans le fichier config.properties.");
            this.maxUsableDigit = 0;
        }
    }

    public void setDevMode(boolean devMode) { // this setter is used to put the devMode in parameter when launching the games in the Main class.
        this.devMode = devMode;
    }

    public void setDevMode() {
            this.devMode = Boolean.parseBoolean((retrieveProperties().getProperty("devMode")));
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


    /**
     * Retrieve all properties or game parameters in the config.properties file.
     * @return A Properties Object with all parameters which are in the config.properties file.
     */
    private Properties retrieveProperties(){
        final Properties prop = new Properties();
        InputStream input = null;

        try{
            input = new FileInputStream("C:/Projects/Java/Workspace/Project3_Mastermind_MoreAndLess_Games/src/resources/config.properties");
            prop.load(input);
            LOGGER.info("Le fichier config.properties a été chargé.");

        } catch (final IOException ex) {
            ex.printStackTrace();
            LOGGER.error("IOException: Fichier introuvable.");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                    LOGGER.error("IOException: Fichier n'existe pas.");
                }
            }
        }
        return prop;
    }

    /**
     * Verify if a string is only composed by numbers.
     * @param number the String we want to verify
     * @return true if the String contains only numbers
     */
    private boolean stringContainsNb(String number){
        return number.matches("[0-9]+");
    }
}
