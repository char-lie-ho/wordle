package org.example.wordle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    @FXML
    private TextField guessInput;
    @FXML
    private Label welcomeText;
    @FXML
    private HBox row1, row2, row3, row4, row5;
    @FXML
    private Label box00 = new Label();
    @FXML
    private Label box01 = new Label();
    @FXML
    private Label box02 = new Label();
    @FXML
    private Label box03 = new Label();
    @FXML
    private Label box04 = new Label();
    @FXML
    private Label box10 = new Label();
    @FXML
    private Label box11 = new Label();
    @FXML
    private Label box12 = new Label();
    @FXML
    private Label box13 = new Label();
    @FXML
    private Label box14 = new Label();
    @FXML
    private Label box20 = new Label();
    @FXML
    private Label box21 = new Label();
    @FXML
    private Label box22 = new Label();
    @FXML
    private Label box23 = new Label();
    @FXML
    private Label box24 = new Label();
    @FXML
    private Label box30 = new Label();
    @FXML
    private Label box31 = new Label();
    @FXML
    private Label box32 = new Label();
    @FXML
    private Label box33 = new Label();
    @FXML
    private Label box34 = new Label();
    @FXML
    private Label box40 = new Label();
    @FXML
    private Label box41 = new Label();
    @FXML
    private Label box42 = new Label();
    @FXML
    private Label box43 = new Label();
    @FXML
    private Label box44 = new Label();
    @FXML
    private Label box50 = new Label();
    @FXML
    private Label box51 = new Label();
    @FXML
    private Label box52 = new Label();
    @FXML
    private Label box53 = new Label();
    @FXML
    private Label box54 = new Label();


    public int count = 0;

    String word = WordList.getWord();

    @FXML
    protected void checkGuess() {
        String guess = guessInput.getText().toUpperCase();

        if (guess.length() == 5 && WordList.checkGuess(guess)) {
            Label[] row = null;
            if (count == 0) {
                row = new Label[]{box00, box01, box02, box03, box04};
            } else if (count == 1) {
                row = new Label[]{box10, box11, box12, box13, box14};
            } else if (count == 2) {
                row = new Label[]{box20, box21, box22, box23, box24};
            } else if (count == 3) {
                row = new Label[]{box30, box31, box32, box33, box34};
            } else if (count == 4) {
                row = new Label[]{box40, box41, box42, box43, box44};
            } else if (count == 5) {
                row = new Label[]{box50, box51, box52, box53, box54};
            }

//            Set visibility of rows
            if (!guess.equals(word)) {
                count++;
                row1.setVisible(count >= 1);
                row2.setVisible(count >= 2);
                row3.setVisible(count >= 3);
                row4.setVisible(count >= 4);
                row5.setVisible(count >= 5);
            }

            for (int i = 0; i < guess.length(); i++) {
                String letter = guess.substring(i, i + 1);
                assert row != null;
                row[i].setText(letter);
                if (letter.equals(word.substring(i, i + 1))) {
                    row[i].setStyle("-fx-background-color: #5dc74e;");
                } else if (word.contains(letter)) {
                    row[i].setStyle("-fx-background-color: #2454c9;");
                } else {
                    row[i].setStyle("-fx-background-color: #b93737;");
                }
            }
            welcomeText.setText("Try: " + count + " / 6");
        } else {
            welcomeText.setText("Please enter a valid word.");
        }
        // Empty the textField after each input
        guessInput.clear();
        if (guess.equalsIgnoreCase(word)) {
            welcomeText.setText("Your guess is correct!");
        }
    }

    @FXML
    private void restartGame() {
        // TODO: add a popup window to show the answer
        count = 0;
        welcomeText.setText("");
        word = WordList.getWord();
        setInvisible(row1, row2, row3, row4, row5);
        resetBox();
    }

    public void setInvisible(HBox... rows) {
        for (HBox row : rows) {
            row.setVisible(false);
        }
    }

    private void resetBox() {
        Label[] row = {box00, box01, box02, box03, box04, box10, box11, box12, box13, box14, box10, box11,
                box12, box13, box14, box20, box21, box22, box23, box24, box30, box31, box32, box33, box34,
                box40, box41, box42, box43, box44, box50, box51, box52, box53, box54};
        for (Label label : row) {
            label.setText("");
            label.setStyle("-fx-background-color: #ffffff;");
        }
    }

    public void showHint(ActionEvent e) {
        // TODO: display the answer on screen when clicked
        List<Character> charList = new ArrayList<>();
        for (char c : word.toCharArray()) {
            charList.add(c);
        }

        // Shuffle the list
        Collections.shuffle(charList);
        welcomeText.setText(charList.toString());
    }
}

