module tictactoe {
    requires javafx.fxml;
    requires javafx.controls;
    opens by.tms.tictactoe to javafx.fxml;
    exports by.tms.tictactoe;
}