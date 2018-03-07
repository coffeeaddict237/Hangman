package com.example.saraglattstein.hangman;

/**
 * Created by saraglattstein on 2/25/18.
 */

import java.util.*;

public class NewGame {

    private String hint;
    private String answer;
    private String[] animals = {"hippo", "camel", "horse", "fish", "snake", "sloth", "lion", "otter", "mouse", "sheep"};
    private String[] food = {"apple", "pear", "peach", "melon", "lemon", "lime", "grape", "mango", "kiwi", "plum"};
    private int places;
    private int lives = 6; //head, body, arm, arm, leg, leg(dead)
    private char lastGuess;
    private int current = 0;

    public NewGame() {
        //random select animals/food & random select within list
        if(Math.random() > 0.5) {
            hint = "Hint: animals";
            answer = animals[(int) (Math.random() * 10)];
        }
        else {
            hint = "Hint: fruit";
            answer = food[(int) (Math.random() * 10)];
        }
        places = answer.length();

    }

    public String getHint() { return hint;}

    public void setHint(String n) {
        hint = n;
        return;

    }

    public String getAnswer() {return answer;}

    public void setAnswer(String a) {
        answer = a;
        return;
    }

    public int getLength() {return places;}

    public void setLength(int i) {
        places = i;
        return;
    }

    public boolean guess(char input) {
        lastGuess = input;
        if(answer.indexOf(input) != -1) {
            current++;
            return true;
        }
        lives --;
        return false;
    }

    public List getIndex(char input) {
        List<Integer> places = new ArrayList<>();
        for(int i = 0; i < answer.length(); i++) {
            if(Character.toString(answer.charAt(i)).equals(Character.toString(input))) {
                places.add(i);
            }
        }
        return places;
    }

    public int getLives() {return lives;}

    public void setLives(int input) {
        lives = input;
        return;
    }

    public char getLastGuess() {
        if(lastGuess != 0) {
            return lastGuess;
        }
        return 0;
    }

    public boolean isWin() {
        return current == places;
    }
}
