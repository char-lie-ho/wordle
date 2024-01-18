package org.example.wordle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

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

    public int count = 0;
    WordList wordList = new WordList();
    String word = WordList.main(null);
    @FXML
    protected void checkGuess() {
        String guess = guessInput.getText().toUpperCase();
        if (guess.length() == 5) {
            Label[] row = {box00, box01, box02, box03, box04};
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
                row[i].setText(letter);
                if (letter.equals(word.substring(i, i + 1))) {
                    row[i].setStyle("-fx-background-color: #5dc74e;");
                } else if (word.contains(letter)) {
                    row[i].setStyle("-fx-background-color: #2454c9;");
                } else {
                    row[i].setStyle("-fx-background-color: #b93737;");
                }
            }
            welcomeText.setText("Try: " + String.valueOf(count) + " / 6");
        } else {
            welcomeText.setText(String.valueOf("Please enter 5 character word."));
        }
    }
}

