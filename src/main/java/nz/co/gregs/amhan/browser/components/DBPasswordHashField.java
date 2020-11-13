/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.amhan.browser.components;

import com.vaadin.flow.component.textfield.TextField;
import nz.co.gregs.dbvolution.DBRow;
import nz.co.gregs.dbvolution.datatypes.DBPasswordHash;

/**
 *
 * @author gregorygraham
 * @param <ROW>
 */
public class DBPasswordHashField<ROW extends DBRow> extends QueryableDatatypeField<ROW, String, DBPasswordHash> {

	TextField field = new TextField();

	public DBPasswordHashField(ROW row, DBPasswordHash qdt) {
		super("", row, qdt);
		setPresentationValue(qdt.getValue());
		field.setLabel(getLabel());
		field.addValueChangeListener(e -> updateQDT(e));
		add(field);
	}

	@Override
	protected final void setPresentationValue(String newPresentationValue) {
		field.setValue(newPresentationValue);
	}

}