import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class TabPaneExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        // ---------------- Tab 1: User Registration ----------------
        GridPane regPane = new GridPane();
        regPane.setVgap(10);
        regPane.setHgap(10);
        regPane.add(new Label("Name:"), 0, 0);
        TextField nameField = new TextField();
        regPane.add(nameField, 1, 0);
        regPane.add(new Label("Email:"), 0, 1);
        TextField emailField = new TextField();
        regPane.add(emailField, 1, 1);
        regPane.add(new Label("Password:"), 0, 2);
        PasswordField passField = new PasswordField();
        regPane.add(passField, 1, 2);
        Button regButton = new Button("Register");
        regPane.add(regButton, 1, 3);
        Tab regTab = new Tab("User Registration", regPane);

        // ---------------- Tab 2: Product Details ----------------
        GridPane prodPane = new GridPane();
        prodPane.setVgap(10);
        prodPane.setHgap(10);
        prodPane.add(new Label("Product ID:"), 0, 0);
        TextField pidField = new TextField();
        prodPane.add(pidField, 1, 0);
        prodPane.add(new Label("Product Name:"), 0, 1);
        TextField pnameField = new TextField();
        prodPane.add(pnameField, 1, 1);
        prodPane.add(new Label("Price:"), 0, 2);
        TextField priceField = new TextField();
        prodPane.add(priceField, 1, 2);
        Button prodButton = new Button("Save Product");
        prodPane.add(prodButton, 1, 3);
        Tab prodTab = new Tab("Product Details", prodPane);
        // ---------------- Tab 3: Sales Record ----------------
        GridPane salesPane = new GridPane();
        salesPane.setVgap(10);
        salesPane.setHgap(10);
        salesPane.add(new Label("Sale ID:"), 0, 0);
        TextField sidField = new TextField();
        salesPane.add(sidField, 1, 0);
        salesPane.add(new Label("Product:"), 0, 1);
        TextField sproductField = new TextField();
        salesPane.add(sproductField, 1, 1);
        salesPane.add(new Label("Quantity:"), 0, 2);
        TextField qtyField = new TextField();
        salesPane.add(qtyField, 1, 2);
        Button salesButton = new Button("Record Sale");
        salesPane.add(salesButton, 1, 3);
        Tab salesTab = new Tab("Sales Record", salesPane);
        // ---------------- Add Tabs to TabPane ----------------
        tabPane.getTabs().addAll(regTab, prodTab, salesTab);
        // Disable tab closing
        tabPane.getTabs().forEach(tab -> tab.setClosable(false));
        // ---------------- Setup Scene and Stage ----------------
        Scene scene = new Scene(tabPane, 400, 300);
        primaryStage.setTitle("TabPane Example - Multiple Forms");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}





