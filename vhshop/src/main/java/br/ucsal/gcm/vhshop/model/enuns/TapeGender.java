package br.ucsal.gcm.vhshop.model.enuns;

//Tipos de fita

public enum TapeGender {
ACTION("action tape"),
ADVENTURE("adventure tape"), 
ANIMATED("animated tape"), 
COMEDY("comedy tape"), 
HORROR("horror tape"), 
DRAMA("drama tape"), 
ROMANTIC("romantic tape"), 
FANTASY("fantays tape"), 
MUSICAL("musical tape ");

private final String displayName;

    TapeGender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

