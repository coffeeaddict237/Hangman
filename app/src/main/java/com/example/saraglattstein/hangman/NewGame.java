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

    public NewGame() {
        //random select animals/food & random select within list
        if(Math.random() > 0.5) {
            hint = "animals";
            answer = animals[(int) (Math.random() * 10)];
        }
        else {
            hint = "food";
            answer = food[(int) (Math.random() * 10)];
        }

    }

    public String getHint() { return hint;}

    public String getAnswer() {return answer;}

    public int getLength() {return answer.length();}

    public boolean guess(char input) {
        if(answer.indexOf(input) != -1) {
            return true;
        }
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


}
