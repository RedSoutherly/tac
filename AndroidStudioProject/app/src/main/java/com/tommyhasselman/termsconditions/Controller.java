package com.tommyhasselman.termsconditions;

import android.app.Application;
import android.content.Context;

import com.tommyhasselman.termsconditions.model.Order;
import com.tommyhasselman.termsconditions.model.StoryTreeNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Controller is an extension of the Application and hence all activities have permissions to view its variables.
 * Which centralises main variables needed between the different main classes. It also centralises
 * a few other simple methods such as generating a new order.
 */
@SuppressWarnings("unused")
public class Controller extends Application {




    private final String SAVE_FILE = "tncSaveFile.ser";



    private int roundsPlayed;

    // Player variables
    private String playerName;
    public int previousRoundScore;
    public int lifetimeScore;
    public int balanceEarnt;
    public int balance;
    public int payRate; // The current amount of pay you get per correct order evaluation.
    public int daysInDebt;

    // Order variables
    private Order currentOrder;
    public int orderSize; // The amount of items in a order;
    public double incorrectItemChance; // This value is the percentage chance of an item being incorrect.
    public double missingItemChance; // This value is the percentage chance of an item being missing.
    private int orderItemComplexity;

    //story variables
    public StoryTreeNode storyNode = null;//basically if a node is null make a new random one if not do what it says

    //order validator(keeps track of rules number of additional rules active)
    public OrderValidator validator = new OrderValidator(0);


    public HashMap<String, Object> mapVars() {
        HashMap<String, Object> gameData = new HashMap<>();

        gameData.put("roundsPlayed", roundsPlayed);
        gameData.put("playerName", playerName);
        gameData.put("previousRoundScore", previousRoundScore);
        gameData.put("lifetimeScore", lifetimeScore);
        gameData.put("balanceEarnt", balanceEarnt);
        gameData.put("balance", balance);
        gameData.put("payRate", payRate);
        gameData.put("daysInDebt", daysInDebt);
        gameData.put("orderSize", orderSize);
        gameData.put("incorrectItemChance", incorrectItemChance);
        gameData.put("missingItemChance", missingItemChance);
        gameData.put("orderItemComplexity", orderItemComplexity);
        gameData.put("storyNode", storyNode);

        return gameData;
    }


    /**
     * This is used to check if a save file is present.
     * @param context The activity context for the file path.
     * @return Returns true if a file exists with the save file name.
     */
    public boolean saveExists(Context context) {

        String path = context.getFilesDir().getAbsolutePath() + "/" + SAVE_FILE;
        File file = new File(path);
        return file.exists();

    }

    /**
     * This method is used to reset the game save back to defaults.
     * It sets all vars back to default value and calls createSave()
     * to overwrite the existing file.
     */
    public void resetSave() {
        roundsPlayed = 0;
        playerName = "Jeff";
        previousRoundScore = 0;
        lifetimeScore = 0;
        balanceEarnt = 0;
        balance = 0;
        payRate = 5;
        daysInDebt = 0;
        orderSize = 3;
        incorrectItemChance = 0.1;
        missingItemChance = 0.01;
        orderItemComplexity = 0;
        storyNode = null;

        createSave(this);
    }

    /**
     * This method is used for reading the game save from internal storage.
     * It reads in a serialised HashMap, deserializes it and updates Controller's
     * data fields.
     * @param context The activity context for the FileInputStream.
     */
    @SuppressWarnings("unchecked")
    public void readSave(Context context) {

        HashMap<String, Object> gameData = null;

        try {
            FileInputStream fileIn = context.openFileInput(SAVE_FILE);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            gameData = (HashMap<String, Object>) objIn.readObject();
            objIn.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (gameData != null) {
            try {
                roundsPlayed = (int) gameData.get("roundsPlayed");
                playerName = (String) gameData.get("playerName");
                previousRoundScore = (int) gameData.get("previousRoundScore");
                lifetimeScore = (int) gameData.get("lifetimeScore");
                balanceEarnt = (int) gameData.get("balanceEarnt");
                balance = (int) gameData.get("balance");
                payRate = (int) gameData.get("payRate");
                daysInDebt = (int) gameData.get("daysInDebt");
                orderSize = (int) gameData.get("orderSize");
                incorrectItemChance = (double) gameData.get("incorrectItemChance");
                missingItemChance = (double) gameData.get("missingItemChance");
                orderItemComplexity = (int) gameData.get("orderItemComplexity");
                storyNode = (StoryTreeNode) gameData.get("storyNode");
            } catch (Exception e) {
                resetSave(); // If the vars in the existing save do not match the current reads the save is reset.
                // This allows us to add to the save without crashing on read during development.
            }
        }

    }

    /**
     * This method is used for saving the state of the Controller variables.
     * It creates a HashMap of the Controller data fields and serialises it
     * to internal storage.
     * @param context The activity context for the FileOutputStream.
     */
    public void createSave(Context context) {

        HashMap<String, Object> gameData = mapVars();

        try {
            FileOutputStream fileOut = context.openFileOutput(SAVE_FILE, Context.MODE_PRIVATE);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(gameData);
            objOut.close();
            fileOut.close();
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public int getOrderItemComplexity() {
        return orderItemComplexity;
    }

    public void setOrderItemComplexity(int comp) {
        orderItemComplexity = comp;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public Order getNewOrder() {
        currentOrder = new Order(this);
        return currentOrder;
    }


    /**
     * This method updates the player variables when called.
     * @param ordersComplete The total number of correctly screened orders.
     */
    public void endRound(int ordersComplete) {
        previousRoundScore = ordersComplete;
        lifetimeScore += previousRoundScore;
        balanceEarnt = (ordersComplete * payRate);
        balance += balanceEarnt;
        roundsPlayed++;
        
        if (orderItemComplexity < 4 && (roundsPlayed % 5) == 0) {
            orderItemComplexity++;
        }
    }

    public StoryTreeNode getStoryNode() {
        if(storyNode == null){
            return new StoryTreeNode(null);
        }
        return storyNode;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return returns the number of correctly screened packages from the latest round as an int.
     */
    public int getPreviousRoundScore() {
        return previousRoundScore;
    }

    /**
     * @return return the total number of correctly screened packages as an int.
     */
    public int getLifetimeScore() {
        return lifetimeScore;
    }

    /**
     * @return returns the balance earn't from the latest round as an int.
     */
    public int getBalanceEarnt() {
        return balanceEarnt;
    }

    /**
     * @return returns the total balance earn't as an int.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @return returns the current pay rate as an int.
     */
    public int getPayRate() {
        return payRate;
    }

    /**
     * @return returns the current order size as an int.
     */
    public int getOrderSize() {
        return orderSize;
    }

    /**
     * @return returns the incorrect item chance as a double.
     */
    public double getIncorrectItemChance() {
        return incorrectItemChance;
    }

    /**
     * @return returns the missing item chance as a double.
     */
    public double getMissingItemChance() {
        return missingItemChance;
    }

    public void setPreviousRoundScore(int previousRoundScore) {
        this.previousRoundScore = previousRoundScore;
    }

    public void setLifetimeScore(int lifetimeScore) {
        this.lifetimeScore = lifetimeScore;
    }

    public void setBalanceEarnt(int balanceEarnt) {
        this.balanceEarnt = balanceEarnt;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPayRate(int payRate) {
        this.payRate = payRate;
    }

    public void setOrderSize(int orderSize) {
        this.orderSize = orderSize;
    }

    public void setIncorrectItemChance(double incorrectItemChance) {
        this.incorrectItemChance = incorrectItemChance;
    }

    public void setMissingItemChance(double missingItemChance) {
        this.missingItemChance = missingItemChance;
    }
    public void setStoryNode(StoryTreeNode storyNode) {
        this.storyNode = storyNode;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public int getDaysInDebt() {
        return daysInDebt;
    }

    public void setDaysInDebt(int daysInDebt) {
        this.daysInDebt = daysInDebt;
    }
}
