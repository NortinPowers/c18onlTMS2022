package by.tms.utils;

import by.tms.model.Product;
import by.tms.service.ShopService;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

@UtilityClass
public class ApplicationsUtils {
    public static void showProductInfo(@NonNull ShopService shopService, TextArea area) {
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < shopService.getAllProduct().size(); i++) {
            info.append(shopService.getAllProduct().get(i)).append("\n");
        }
        area.clear();
        area.appendText(info.toString());
    }

    public static @NonNull TextField getTextField(String name) {
        TextField id = new TextField();
        id.setPromptText(name);
        return id;
    }

    public static @NonNull GridPane getGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        return grid;
    }

    public static @NonNull ButtonType getButtonConfirm(@NonNull Dialog<Pair<String, Pair<String, String>>> dialog) {
        ButtonType buttonConfirm = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonConfirm, ButtonType.CANCEL);
        return buttonConfirm;
    }

    public static Optional<Pair<String, Pair<String, String>>> getStringFromThreeTextFields(@NonNull Dialog<Pair<String, Pair<String, String>>> dialog, ButtonType type, GridPane grid, @NonNull TextField id, TextField name, TextField price) {
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(id::requestFocus);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == type) {
                return new Pair<>(id.getText(), new Pair<>(name.getText(), price.getText()));
            }
            return null;
        });
        return dialog.showAndWait();
    }

    public static @NonNull Button getButton(String name, int position) {
        Button buttonDeleteProduct = new Button(name);
        buttonDeleteProduct.setPrefSize(120, 40);
        buttonDeleteProduct.setLayoutX(position);
        buttonDeleteProduct.setLayoutY(15);
        return buttonDeleteProduct;
    }

    public static void showInfoMessage(@NonNull TextArea area, String message) {
        area.clear();
        area.appendText(message);
    }

    public static boolean isValidData(@NonNull Pair<String, Pair<String, String>> value) {
        return value.getKey().matches("\\d+L?") && value.getValue().getValue().matches("\\d+");
    }

    public static void showSortedInfo(@NonNull ShopService shopService, @NonNull TextArea area) {
        area.clear();
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < shopService.getAllProduct().size(); i++) {
            info.append(shopService.getAllProduct().get(i)).append("\n");
        }
        area.appendText(info.toString());
    }

    public static void setAlertWindow(@NonNull Alert alert) {
        alert.setTitle("Product filter");
        alert.setHeaderText("Select the necessary filter and sort condition");
        alert.setContentText("Choose one:");
    }

    public static void setTextArea(@NonNull TextArea area) {
        area.setLayoutY(80);
        area.setPrefWidth(783);
        area.setPrefHeight(300);
    }

    public static void setStage(@NonNull Stage stage) {
        stage.getIcons().add(new Image("img/shop.png"));
        stage.setTitle("Shop Application");
        stage.setWidth(800);
        stage.setHeight(400);
        stage.setResizable(false);
    }

    public static void setDialogWindowWithListDependency(ArrayList<Product<Double>> products, @NonNull Dialog<Pair<String, Pair<String, String>>> dialog) {
        dialog.setTitle("Add Product Dialog");
        if (CollectionUtils.isNotEmpty(products)) {
            dialog.setHeaderText("Fill in all the fields for the new product\n" +
                    "(last entered product with ID: " + products.stream()
                    .max(Comparator.comparing(Product<Double>::getId)).get().getId() + ")");
        } else {
            dialog.setHeaderText("The list of products is empty. Fill in all the fields for the new product");
        }
    }

    public static void setDialog(@NonNull Dialog<Pair<String, Pair<String, String>>> dialog) {
        dialog.setTitle("Change Product Dialog");
        dialog.setHeaderText("Enter the ID of the product you want to change, as well as the name " +
                "and price of the new product");
    }

    public static void setTextDialog(@NonNull TextInputDialog dialog) {
        dialog.setTitle("Delete Product Dialog");
        dialog.setHeaderText("Enter the ID of the product you want to delete");
    }

    public static void setGrid(@NonNull GridPane grid, String s, int position, TextField id) {
        grid.add(new Label(s), 0, position);
        grid.add(id, 1, position);
    }
}