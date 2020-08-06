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
public class Controller extends Application {

    // Player variables
    private String playerName = "Jeff";
    public int previousRoundScore = 0;
    public int lifetimeScore = 0;
    public int balanceEarnt = 0;
    public int balance = 0;
    public int payRate = 5; // The current amount of pay you get per correct order evaluation.

    // Order variables
    public int orderSize = 3; // The amount of items in a order;
    public double incorrectItemChance = 0.25; // This value is the percentage chance of an item being incorrect.
    public double missingItemChance = 0.05; // This value is the percentage chance of an item being missing.

    //story variables
    public StoryTreeNode storyNode;//basically if a node is null make a new random one if not do what it says

    private final String SAVE_FILE = "tncSaveFile.ser";

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
     * This method is used for reading the game save from internal storage.
     * It reads in a serialised HashMap, deserialises it and updates Controller's
     * data fields.
     * @param context The activity context for the FileInputStream.
     */
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

        playerName = (String) gameData.get("playerName");
        previousRoundScore = (int) gameData.get("previousRoundScore");
        lifetimeScore = (int) gameData.get("lifetimeScore");
        balanceEarnt = (int) gameData.get("balanceEarnt");
        balance = (int) gameData.get("balance");
        payRate = (int) gameData.get("payRate");
        orderSize = (int) gameData.get("orderSize");
        incorrectItemChance = (double) gameData.get("incorrectItemChance");
        missingItemChance = (double) gameData.get("missingItemChance");
        storyNode = (StoryTreeNode) gameData.get("storyNode");

    }

    /**
     * This method is used for saving the state of the Controller variables.
     * It creates a HashMap of the Controller data fields and serialises it
     * to internal storage.
     * @param context The activity context for the FileOutputStream.
     */
    public void createSave(Context context) {

        HashMap<String, Object> gameData = new HashMap<>();

        gameData.put("playerName", playerName);
        gameData.put("previousRoundScore", previousRoundScore);
        gameData.put("lifetimeScore", lifetimeScore);
        gameData.put("balanceEarnt", balanceEarnt);
        gameData.put("balance", balance);
        gameData.put("payRate", payRate);
        gameData.put("orderSize", orderSize);
        gameData.put("incorrectItemChance", incorrectItemChance);
        gameData.put("missingItemChance", missingItemChance);
        gameData.put("storyNode", storyNode);

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

    /**
     * @return returns an instance of Order.
     */
    public Order newOrder() {
        return new Order(this);
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

}
