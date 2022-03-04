package com.example.clavesui;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class ContrasenaUI extends Application {

    StringProperty title = new SimpleStringProperty();
    String mensaje;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        int longitudCadena = 8;
        Button button = new Button(" click aqui ");
        Button buttonCerrar = new Button("Cerrar");


        Label label = new Label("Numero de  caracteres: ");
        TextField textField = new TextField("");
        TextField textFieldContrasena = new TextField("");


        HBox hBox = new HBox(label, textField);
        VBox vBox = new VBox( hBox, button, textFieldContrasena, buttonCerrar);

        button.setOnAction(e -> {
            int valido = 0;
            do {
                valido = Funciones.esNumero(textField.getText());
                if (valido == 0){
                    System.out.println("Intente de nuevo ");
                    break;
                }
                else {

                Integer valor = Integer.valueOf(textField.getText());

                if (valor >= 8 && valor <=50) {

                    mensaje = Funciones.KeyGenerator(valor);
                    textFieldContrasena.setText(mensaje);
                  }
                else{
                    System.out.println("Longitud erronea vuelva a intentar ");
                    valido = 0;
                    break;
                 }
                }
            }while (valido == 0);
        });

        buttonCerrar.setOnAction(e -> stage.close());

        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle(mensaje);
        stage.setScene(scene);
        stage.show();
    }
    
}