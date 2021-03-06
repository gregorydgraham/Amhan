/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.amhan.components;

import com.vaadin.flow.component.textfield.TextField;
import nz.co.gregs.dbvolution.DBRow;
import nz.co.gregs.dbvolution.datatypes.DBStringTrimmed;

/**
 *
 * @author gregorygraham
 * @param <ROW>
 */
public class DBStringTrimmedField<ROW extends DBRow> extends QueryableDatatypeField<ROW, String, DBStringTrimmed> {

	TextField field = new TextField();

	public DBStringTrimmedField(ROW row, DBStringTrimmed qdt) {
		super("", row, qdt);
	}

	@Override
	protected final void setPresentationValue(String newPresentationValue) {
		field.setValue(newPresentationValue == null ? "" : newPresentationValue);
	}

	@Override
	protected void addInternalComponents(DBStringTrimmed qdt) {
		add(field);
	}

	@Override
	protected void createInternalComponents() {
		field = new TextField();
	}

	@Override
	protected void addInternalValueChangeListeners() {
		field.addValueChangeListener(e -> updateQDT(e));
	}

}
