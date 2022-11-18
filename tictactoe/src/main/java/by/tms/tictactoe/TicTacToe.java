package by.tms.tictactoe;

import by.tms.tictactoe.model.Figure;
import by.tms.tictactoe.service.Logic;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    private static final String TITLE = "Крестики-нолики";
    private final int size = 3;
    private final Figure[][] cells = new Figure[size][size];
    private final Logic logic = new Logic(cells);
    private BorderPane border;

    @Override
    public void start(Stage stage) {
        border = new BorderPane();
        HBox control = new HBox();
        control.setPrefHeight(40);
        control.setSpacing(10.0);
        control.setAlignment(Pos.BASELINE_CENTER);
        Button start = new Button("Начать");
        start.setOnMouseClicked(
                event -> border.setCenter(this.buildGrid())
        );
        control.getChildren().addAll(start);
        border.setBottom(control);
        border.setCenter(this.buildGrid());
        stage.setScene(new Scene(border, 300, 300));
        stage.setTitle(TITLE);
        stage.setResizable(false);
        stage.show();
    }

    private Group buildGrid() {
        Group panel = new Group();
        for (int y = 0; y != this.size; y++) {
            for (int x = 0; x != this.size; x++) {
                Figure rect = this.buildRectangle(x, y, 50);
                this.cells[y][x] = rect;
                panel.getChildren().add(rect);
                rect.setOnMouseClicked(this.buildMouseEvent(panel));
            }
        }
        return panel;
    }

    private Figure buildRectangle(int x, int y, int size) {
        Figure rect = new Figure();
        rect.setX(x * size);
        rect.setY(y * size);
        rect.setHeight(size);
        rect.setWidth(size);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        return rect;
    }

    private Group buildMarkO(double x, double y, int size) {
        Group group = new Group();
        int radius = size / 2;
        Circle circle = new Circle(x + radius, y + radius, radius - 10);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        group.getChildren().add(circle);
        return group;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(TITLE);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        border.setCenter(TicTacToe.this.buildGrid());
    }

    private boolean checkState() {
        boolean state = this.logic.checkEmptyCells();
        if (!state) {
            this.showAlert("Все поля заполнены! Начните новую Игру!");
        }
        return state;
    }

    private void checkWinner() {
        if (this.logic.isWinnerX()) {
            this.showAlert("Победили Крестики! Начните новую Игру!");
        } else if (this.logic.isWinnerO()) {
            this.showAlert("Победили Нолики! Начните новую Игру!");
        }
    }

    private Group buildMarkX(double x, double y, int size) {
        Group group = new Group();
        group.getChildren().addAll(
                new Line(x + 10, y + 10, x + size - 10, y + size - 10),
                new Line(x + size - 10, y + 10, x + 10, y + size - 10)
        );
        return group;
    }

    private EventHandler<MouseEvent> buildMouseEvent(Group panel) {
        return event -> {
            Figure rect = (Figure) event.getTarget();
            if (this.checkState() && !rect.hasMarkX() && !rect.hasMarkO()) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    rect.take(true);
                    panel.getChildren().add(this.buildMarkX(rect.getX(), rect.getY(), 50));
                } else {
                    rect.take(false);
                    panel.getChildren().add(this.buildMarkO(rect.getX(), rect.getY(), 50));
                }
                this.checkWinner();
                this.checkState();
            }
        };
    }
}
