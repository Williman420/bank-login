package bank;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Account {

    private ArrayList<String> AccountUsernameList = new ArrayList<String>();
    private ArrayList<String> AccountPasswordList = new ArrayList<String>();
    private ArrayList<Integer> AccountBalanceList = new ArrayList<Integer>();
    public FileWriter writeToFile;
    public FileReader readFromFile;
    public BufferedWriter writeToBuffer;
    public BufferedReader readFromBuffer;

    public void setAccUsername(String newAcc) {
        AccountUsernameList.add(newAcc);
    }

    public void setAccPassword(String newPass) {
        AccountPasswordList.add(newPass);
    }

    public void setAccBalance(int newAccBalance) {
        AccountBalanceList.add(newAccBalance);

    }

    public ArrayList getAccUsername() {
        return AccountUsernameList;
    }

    public ArrayList getAccPassword() {
        return AccountPasswordList;
    }

    public ArrayList getAccBalance() {
        return AccountBalanceList;
    }

    public int getAccBalancePos(int Pos) {
        return AccountBalanceList.get(Pos);
    }

    public int getAccUsernamePos(int Pos) {
        return AccountBalanceList.get(Pos);
    }

    public int getAccPasswordPos(int Pos) {
        return AccountBalanceList.get(Pos);
    }

    public void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // clear screen untuk windows
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
        } catch (final Exception e) {
            System.out.println("Error karena: " + e.getMessage());
        }

    }

    public void writeToLog(String log, String message) throws IOException {
        writeToFile = new FileWriter("C:\\Dwika\\programs\\logText\\Log.txt", true);
        writeToBuffer = new BufferedWriter(writeToFile);
        writeToBuffer.write(log + message);
        writeToBuffer.newLine();
        writeToBuffer.flush();

    }

    public static void main(String[] args) {
    }
}
