package com.twitter.developer.data;

public class DataGenerator {

    public String generateAStringWithNCharacters(Integer numberOfCharactersForString) {
        String myString = "";

        while (myString.length() < numberOfCharactersForString) {
            myString += "a";
        }

        return myString;
    }


    public String generateAStringWithNSpaces(Integer numberOfSpacesForString) {
        String myString = "";

        while (myString.length() < numberOfSpacesForString) {
            myString += " ";
        }

        return myString;
    }


}
