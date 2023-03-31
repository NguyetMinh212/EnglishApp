/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

/**
 *
 * @author nguye
 */
public class Deck {
    private ArrayList<FlashCard> cardList;

    public ArrayList<FlashCard> getCardList() {
        return cardList;
    }

    public void setCardList(ArrayList<FlashCard> cardList) {
        this.cardList = cardList;
    }
    private String deckName;
    private int due;


    public Deck(ArrayList<FlashCard> cardList, String deckName) {
        this.cardList = cardList;
        this.deckName = deckName;
    }
    
    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public int getDue() {
        return due;
    }

    public void setDue(int due) {
        this.due = due;
    }
    
            
}
