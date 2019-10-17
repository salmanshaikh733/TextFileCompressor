//Author: mshaikh52 StudentNumber: 250959996, Created 2018/02/05. Professor Roberto Solis-Oba
//class for creating codepair objects.

//import java libaries and other things
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//declare class and instance variables
public class CodePair {
    private char character;
    private String code1;

    //declare constructor
    public CodePair(char c, String code) {
        this.character = c;
        this.code1 = code;

    }
    //accessor method to get code
    public String getCode() {
        return code1;

    }
    //accessor method to get character
    public char getCharacter() {

        return character;

    }

    //mutator method to set character
    public void setCharacter(char c) {
        character = c;

    }

    //mutator method to set code
    public void setCode(String code) {
        code1 = code;
    }

    //method to compare two CodePair objects
    public boolean equals(CodePair anotherPair) {

        if (this.getCharacter() == (anotherPair.getCharacter())) {
            return true;
        }

        else {
            return false;
        }
    }


}//end of class
