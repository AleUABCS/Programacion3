package views;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import models.ProductModel;

public class ButtonEditor extends DefaultCellEditor {
    private String label;
    private boolean isPushed;
    private JButton button = new JButton();


    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button.setOpaque(true);
//        button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				fireEditingStopped();
//				
//			}
//		});
    }
    
    @Override
    public void fireEditingStopped() {
    	// TODO Auto-generated method stub
    	super.fireEditingStopped();
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) {
        if (value instanceof JButton) {
            button.setText(((JButton)value).getText());
        } else {
            button.setText("Eliminar");
        }
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        isPushed = false;
        return button;
    }

	public JButton getButton() {
		return button;
	}
    
}
