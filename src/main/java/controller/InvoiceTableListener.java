package controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.GUI;


public class InvoiceTableListener implements ListSelectionListener {

    private model.fileOperations fileOperations;
    private GUI view = null;
    private InvoicesLineTableListener invoicesLineTableListener;

    public InvoiceTableListener(GUI view, model.fileOperations fileOperations, InvoicesLineTableListener invoicesLineTableListener) {
        this.view = view;
        this.fileOperations = fileOperations;
        this.invoicesLineTableListener = invoicesLineTableListener;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (mainController.invoices.size() >= 1) {
            if (!e.getValueIsAdjusting()) {
                mainController.selectedRow = view.getInvoiceTable().getSelectedRow();
                view.getInvoicesLineTable().getSelectionModel().removeListSelectionListener(invoicesLineTableListener);
                TablesController.loadInvoicesLineTable(view, mainController.invoices);
                InvoicesLineController.updater(view, mainController.invoices, mainController.selectedRow);
                view.getInvoicesLineTable().getSelectionModel().addListSelectionListener(invoicesLineTableListener);
            }
        }
    }
}
