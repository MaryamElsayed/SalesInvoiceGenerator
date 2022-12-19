package controller;

import java.awt.event.*;

import view.GUI;

public class CustomerNameTextFieldListener implements FocusListener, ActionListener {

    private GUI view = null;

    public CustomerNameTextFieldListener(GUI view) {
        this.view = view;
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (!((mainController.invoices.get(mainController.selectedRow).getInoviceCustomerName()).equals((view.getCustomerNameTextField().getText())))) {
            InvoicesLineController.changeCustomerNameTextField(view, mainController.invoices);
            view.getInvoiceTable().setRowSelectionInterval(mainController.selectedRow, mainController.selectedRow);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!((mainController.invoices.get(mainController.selectedRow).getInoviceCustomerName()).equals((view.getCustomerNameTextField().getText())))) {
            InvoicesLineController.changeCustomerNameTextField(view, mainController.invoices);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

}
