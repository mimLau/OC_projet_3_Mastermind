package com.ask.maryam.players;

import java.util.Map;

public abstract class Player {

  protected String secretNb;
  protected String proposedNb;
  protected String name;

  public String getName() {
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getSecretNb() {
    return secretNb;
  }

  public String getProposedNb() {
    return proposedNb;
  }

  public abstract void setSecretNb(String gameName);
  public abstract void setProposedNb(String gameName);
  public void setProposedNb(Map<Integer, Integer> goodPlace, Map<Integer, Integer> goodNb) {
  }
}
