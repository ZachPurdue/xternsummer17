//xtern 2017 technical screen
//Zach Perry
//perryz@purdue.edu

import java.util.*;

public class xternCoin{
    
    String userID;
    int coins;
    
    //constructor for a user
    public xternCoin(String userID, int coins){
        this.userID = userID;
        coins = 0;
    }
    
    int correctNumber = 10; //number the user is trying to guess
    
    void incrementCoins(){
        coins = coins+1;
    }
    
    boolean HandleGuess(String userId, int guess){ //matches the guess to the correct number
        if (guess == correctNumber) { //if they guess the number, congratulate them and return true
            System.out.println("Congratulations, you've earned a coin!");
            correctNumber = (int)(Math.random() * (10)); //randomize a new number (one to ten as given in instructions)
            incrementCoins();             //increment coins by 1
            return true;
        }
        else {
            System.out.println("Wrong, guess again!");
            return false; //number stays the same
        }
    }
    
    int GetCoins(String userId) { //tells a user how many coins they have, called after each guess
        return coins;
    }
    
    void StartGuessing(){ //loop to guess the next coin number
        System.out.println("Enter your user id: "); //get and store user id
        Scanner id = new Scanner(System.in);
        String myID = id.next();
        
        //create new user based on ID
        xternCoin x = new xternCoin(myID, 0);
        
        while(true){
            System.out.println("Enter your guess: "); //get and store their guess
            Scanner guess = new Scanner(System.in);
            int myGuess = guess.nextInt();
            
            //call handleGuess
            HandleGuess(myID, myGuess);
            
            //return current coin total
            int totalCoins = GetCoins(myID);
            System.out.println("You have " + totalCoins + " coins.");
        }
    }
    public void main(String[] args){
        StartGuessing();
    }
}