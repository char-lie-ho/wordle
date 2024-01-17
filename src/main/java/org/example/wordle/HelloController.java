package org.example.wordle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField guessInput;
    @FXML
    private Label welcomeText;
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
    private String word = "HELLO";

    @FXML
    protected void checkGuess() {
        String guess = guessInput.getText().toUpperCase();
        if (guess.length() == 5) {
            Label[] row = {box00, box01, box02, box03, box04};
            if (!guess.equals(word)) {
                count++;
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
            welcomeText.setText("Try: "+ String.valueOf(count) + " / 6");
        } else {
            welcomeText.setText(String.valueOf("Please enter 5 character word."));
        }
    }
}