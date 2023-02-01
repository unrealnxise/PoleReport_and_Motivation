package com.pole.poletable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelloController {
    @FXML
    TextField nameWorker;
    @FXML
    TextField smarts;
    @FXML
    TextField aks;
    @FXML
    TextField service;
    @FXML
    TextField plCount1;
    @FXML
    TextField plCount2;
    @FXML
    TextField plCount3;
    @FXML
    TextField minus;
    @FXML
    TextArea report;

    // ТО
    int pl1, pl2, pl3 = 0;
    String name;
    int st, ak, serv, inc = 0;

    @FXML
    void telegramSUP(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://t.me/unrealnxise"));
    }

    public void Generate(ActionEvent event){
        try {
            report.setText("");
            if(nameWorker.getText().trim().isEmpty()) {
                name = "Сотрудник";
            } else {
                name = nameWorker.getText();
            }

            if(smarts.getText().trim().isEmpty()) {
                st = 0;
            } else {
                st = Integer.parseInt(smarts.getText());
            }

            if(aks.getText().trim().isEmpty()) {
                ak = 0;
            } else {
                ak = Integer.parseInt(aks.getText());
            }

            if(service.getText().trim().isEmpty()) {
                serv = 0;
            } else {
                serv = Integer.parseInt(service.getText());
            }

            if(plCount1.getText().trim().isEmpty()) {
                pl1 = 0;
            } else {
                pl1 = Integer.parseInt(plCount1.getText());
            }

            if(plCount2.getText().trim().isEmpty()) {
                pl2 = 0;
            } else {
                pl2 = Integer.parseInt(plCount2.getText());
            }

            if(plCount3.getText().trim().isEmpty()) {
                pl3 = 0;
            } else {
                pl3 = Integer.parseInt(plCount3.getText());
            }

            if(minus.getText().trim().isEmpty()) {
                inc = 0;
            } else {
                inc = Integer.parseInt(minus.getText());
            }

            // Высчитывание ЗП
            int zpst = (int) (st * 0.03);
            int zpaks = (int) (ak * 0.15);
            int zpserv = (int) (serv * 0.3);
            int zpPL1 = (int) (pl1 * 100);
            int zpPL2 = (int) (pl2 * 120);
            int zpPL3 = (int) (pl3 * 150);

            report.setText(name + " ЗП = " + (zpst + zpaks + zpserv + zpPL1 + zpPL2 + zpPL3));
            if(st > 0){
                report.appendText("\nТелефоны/Роутеры " + st + " * 3% = " + zpst);
            }
            if(ak > 0){
                report.appendText("\nАксессуары " + ak + " * 15% = " + zpaks);
            }
            if(serv > 0){
                report.appendText("\nСервис " + serv + " * 30% = " + zpserv);
            }
            if(pl1 > 0 & pl2 == 0 & pl3 == 0){
                report.appendText("\nПленки " + pl1 + " (450) = " + zpPL1);
            }
            if(pl1 == 0 & pl2 > 0 & pl3 == 0){
                report.appendText("\nПленки " + pl2 + " (600) = " + zpPL2);
            }
            if(pl1 == 0 & pl2 == 0 & pl3 > 0){
                report.appendText("\nПленки " + pl3 + " (750) = " + zpPL3);
            }
            if(pl1 > 0 & pl2 > 0 & pl3 == 0){
                report.appendText("\nПленки " + pl1 + ", " + pl2 + " (450, 600) = " + zpPL1 + ", " + zpPL2);
            }
            if(pl1 > 0 & pl2 == 0 & pl3 > 0){
                report.appendText("\nПленки " + pl1 + ", " + pl3 + " (450, 750) = " + zpPL1 + ", " + zpPL3);
            }
            if(pl1 == 0 & pl2 > 0 & pl3 > 0){
                report.appendText("\nПленки " + pl2 + ", " + pl3 + " (600, 750) = " + zpPL2 + ", " + zpPL3);
            }
            if(pl1 > 0 & pl2 > 0 & pl3 > 0){
                report.appendText("\nПленки " + pl1 + ", " + pl2 + ", " + pl3 +
                        " (450, 600, 750) = " + zpPL1 + ", " + zpPL2 + ", " + zpPL3);
            }
            if (inc > 0){
                report.appendText("\n\nИнкассация = " + inc);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}