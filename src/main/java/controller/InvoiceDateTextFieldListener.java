package controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GUI;


public class InvoiceDateTextFieldListener implements FocusListener, ActionListener {

    private GUI view = null;

    public InvoiceDateTextFieldListener(GUI view) {
        this.view = view;
    }

    @Override
    public void focusLost(FocusEvent e) {
        if ((!(mainController.invoices.isEmpty())) && (mainController.selectedRow >= 0)) {
            if (!((view.getDate().format(mainController.invoices.get(mainController.selectedRow).getInoviceDate())).equals((view.getInvoiceDateTextField().getText())))) {
                InvoicesLineController.dateValidator(view, mainController.invoices);
                view.getInvoiceTable().setRowSelectionInterval(mainController.selectedRow, mainController.selectedRow);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!((view.getDate().format(mainController.invoices.get(mainController.selectedRow).getInoviceDate())).equals((view.getInvoiceDateTextField().getText())))) {
            InvoicesLineController.dateValidator(view, mainController.invoices);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }
}
