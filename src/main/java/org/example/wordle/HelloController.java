package org.example.wordle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private TextArea guessInput;
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

    private String word = "hello";

    @FXML
    protected void checkGuess() {
        String guess = guessInput.getText();
        if (guess.length() == 5) {
            Label[] row = {box00, box01, box02, box03, box04};
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
            welcomeText.setText(guess);
        } else {
            welcomeText.setText("Please enter 5 characters.");
        }
    }
}