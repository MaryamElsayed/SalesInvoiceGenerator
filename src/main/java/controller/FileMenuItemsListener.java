package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.*;
import view.GUI;
public class FileMenuItemsListener implements ActionListener{

    private model.fileOperations fileOperations;
    private InvoiceTableListener invoiceTableListener;
    private GUI gui;

    public FileMenuItemsListener(GUI gui, model.fileOperations fileOperations, InvoiceTableListener invoiceTableListener) {
        this.gui = gui;
        this.fileOperations = fileOperations;
        this.invoiceTableListener = invoiceTableListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load Files" -> {
                while (InvoicesHeaderTableModel.setInvoicesHeaderTableModel(gui).getRowCount() > 0) {
                    InvoicesHeaderTableModel.setInvoicesHeaderTableModel(gui).removeRow(0);
                }

                while (InvoicesLineTableModel.setInvoicesLineTableModel(gui).getRowCount() > 0) {
                    InvoicesLineTableModel.setInvoicesLineTableModel(gui).removeRow(0);
                }

                gui.getInvoiceTotalLabel().setText("");
                fileOperations.getPath();
                if ((model.fileOperations.InvoiceHeaderFile != null) && (model.fileOperations.InvoiceLineFile != null)) {
                    mainController.invoices = fileOperations.readFile();
                    fileOperations.main(mainController.invoices);
                    InvoicesHeaderController.calculateInvoiceTableTotal(mainController.invoices);
                    TablesController.loadInvoicesHeaderTable(gui, mainController.invoices);
                    fileOperations.getMaxNumberOfExistedInvoices(mainController.maxNumberOfExistedInvoices, mainController.invoices);
                }
            }
            case "Save File" -> {
                try {
                    fileOperations.writeFile(mainController.invoices);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

}
