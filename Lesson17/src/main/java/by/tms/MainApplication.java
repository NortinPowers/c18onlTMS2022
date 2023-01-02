package by.tms;

import by.tms.model.Product;
import by.tms.model.Shop;
import by.tms.service.ShopService;
import by.tms.utils.CollectionUtils;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

import static by.tms.utils.ApplicationsUtils.*;

public class MainApplication extends Application {
    public static void main(String[] args) {
        System.out.println("the application is running");
        launch();
    }

    @Override
    public void start(@NonNull Stage stage) {
        System.out.println("Application starts");
        ArrayList<Product<Double>> products = new ArrayList<>();
        ShopService shopService = new ShopService(new Shop(products));
        setStage(stage);
        TextArea infoField = new TextArea();
        setTextArea(infoField);
        Button showAllProductButton = getButton("Products", 0);
        showAllProductButton.setOnAction(actionEvent -> {
            if (CollectionUtils.isNotEmpty(products)) {
                showProductInfo(shopService, infoField);
            } else {
                showInfoMessage(infoField, "The list of products is empty");
            }
        });
        Button filterButton = getButton("Filter", 122);
        filterButton.setOnAction(actionEvent -> {
            if (CollectionUtils.isNotEmpty(products)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                setAlertWindow(alert);
                ButtonType buttonIdMin = new ButtonType("ID (min)");
                ButtonType buttonIdMax = new ButtonType("ID (max)");
                ButtonType buttonPriceMin = new ButtonType("Price (min)");
                ButtonType buttonPriceMax = new ButtonType("Price (max)");
                ButtonType buttonCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(buttonIdMin, buttonIdMax, buttonPriceMin, buttonPriceMax, buttonCancel);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent()) {
                    if (result.get() == buttonIdMin) {
                        products.sort(Comparator.comparing(Product<Double>::getId));
                        showSortedInfo(shopService, infoField);
                    } else if (result.get() == buttonIdMax) {
                        products.sort(Comparator.comparing(Product<Double>::getId).reversed());
                        showSortedInfo(shopService, infoField);
                    } else if (result.get() == buttonPriceMin) {
                        Collections.sort(products);
                        showSortedInfo(shopService, infoField);
                    } else if (result.get() == buttonPriceMax) {
                        Collections.sort(products);
                        Collections.reverse(products);
//                products.sort(Comparator.comparing(Product<Double>::getPrice).reversed());
//                it doesn't work here, but it works in general (the problem is in the generalized type)
//                need your comments!
                        showSortedInfo(shopService, infoField);
                    } else {
                        alert.close();
                    }
                }
            } else {
                showInfoMessage(infoField, "The list of products is empty");
            }
        });
        Button buttonAddProduct = getButton("Add product", 244);
        buttonAddProduct.setOnAction(actionEvent -> {
            Dialog<Pair<String, Pair<String, String>>> dialog = new Dialog<>();
            setDialogWindowWithListDependency(products, dialog);
            ButtonType buttonConfirm = getButtonConfirm(dialog);
            GridPane grid = getGridPane();
            TextField id = getTextField("ID");
            TextField name = getTextField("Name");
            TextField price = getTextField("Price");
            setGrid(grid, "ID:", 0, id);
            setGrid(grid, "Name:", 1, name);
            setGrid(grid, "Price:", 2, price);
            Optional<Pair<String, Pair<String, String>>> result = getStringFromThreeTextFields(dialog, buttonConfirm, grid, id, name, price);
            result.ifPresent(newProduct -> {
                if (isValidData(newProduct)) {
                    if (!shopService.addProduct(new Product<>(Long.parseLong(newProduct.getKey()), newProduct.getValue().getKey(), Double.parseDouble(newProduct.getValue().getValue())))) {
                        showInfoMessage(infoField, "Product with this ID (" + Long.parseLong(newProduct.getKey()) + ") already exists");
                    } else {
                        showProductInfo(shopService, infoField);
                    }
                } else {
                    showInfoMessage(infoField, "Incorrect input data");
                }
            });
        });
        Button buttonDeleteProduct = getButton("Delete product", 366);
        buttonDeleteProduct.setOnAction(actionEvent -> {
            TextInputDialog dialog = new TextInputDialog();
            setTextDialog(dialog);
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                shopService.deleteProduct(Long.parseLong(result.get()));
                showProductInfo(shopService, infoField);
            }
        });
        Button buttonChangeProduct = getButton("Change product", 488);
        buttonChangeProduct.setOnAction(actionEvent -> {
            Dialog<Pair<String, Pair<String, String>>> dialog = new Dialog<>();
            setDialog(dialog);
            ButtonType buttonConfirm = getButtonConfirm(dialog);
            GridPane grid = getGridPane();
            TextField id = getTextField("ID");
            TextField name = getTextField("Name");
            TextField price = getTextField("Price");
            setGrid(grid, "ID:", 0, id);
            setGrid(grid, "Name:", 2, name);
            setGrid(grid, "Price:", 3, price);
            Optional<Pair<String, Pair<String, String>>> result = getStringFromThreeTextFields(dialog, buttonConfirm, grid, id, name, price);
            result.ifPresent(newValue -> {
                if (isValidData(newValue)) {
                    shopService.changeProduct(Long.parseLong(newValue.getKey()),
                            newValue.getValue().getKey(), Double.parseDouble(newValue.getValue().getValue()));
                    showProductInfo(shopService, infoField);
                } else {
                    showInfoMessage(infoField, "Incorrect input data");
                }
            });
        });

        Button buttonExitShop = getButton("Exit", 662);
        buttonExitShop.setOnAction(actionEvent -> stage.close());
        Group group = new Group(showAllProductButton, filterButton, buttonAddProduct,
                buttonDeleteProduct, buttonChangeProduct, buttonExitShop, infoField);
        FlowPane root = new FlowPane(group);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Application stops");
        try {
            super.stop();
        } catch (Exception e) {
            System.out.println("Unexpected error " + e);
        }
    }
}