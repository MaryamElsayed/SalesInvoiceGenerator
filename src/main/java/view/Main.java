package view;

import controller.mainController;
import java.io.FileNotFoundException;
import model.InvoiceHeader;
import model.InvoiceLine;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.setLocations();
        gui.setResizable(false);
        gui.loadFiles();
        new mainController(new InvoiceHeader(), new InvoiceLine(), gui);
    }
}
