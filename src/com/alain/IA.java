package com.alain;

import java.io.IOException;

public class IA extends RechercheGame{

    public IA(String levelName) {
        super(levelName);
        setNbDigitsAndNbTrials(levelName);
        trialNb = 0;
    }

    @Override
    public void startGame() {
        this.displayGameTitle("Recherche +/-", "Défenseur", levelName);
        System.out.println("Entrez une combinaison de " + RechercheGame.getNbDigits() + " chiffres, que devra deviner l'ordinateur\n");
        this.playerCombination();
        this.splitInput();
        while (this.trialNb <= RechercheGame.getNbTrials() && !this.isWin()) {
            System.out.println("Essai n° " + (this.trialNb+1) + " sur " + RechercheGame.getNbTrials() + "\n");
            this.generateCombination();
            String result = RechercheGame.compareInput(this.getGeneratedCombination(), this.getPlayerCombinationArray());
            this.displayResult(result);
            this.trialNb ++;
            System.out.println("Appuyez sur la touche entrée pour continuer");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (this.isWin()){
            System.out.println("\nDésolé ! Vous avez perdu, l'ordinateur a trouvé la combinaison  en " + (this.trialNb) +" essais !");
        }else{
            System.out.println("\nBravo, vous avez gagné ! L'ordinateur n'a pas trouvé votre combinaison secrète, qui était : " + (combinationFormat(combinationToString(this.getPlayerCombinationArray()))) + "\n");
        }
        System.out.println("Appuyez sur la touche entrée pour revenir au menu principal");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
