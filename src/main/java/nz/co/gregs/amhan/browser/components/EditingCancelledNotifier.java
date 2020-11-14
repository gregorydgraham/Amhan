/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.amhan.browser.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.shared.Registration;
import nz.co.gregs.dbvolution.DBRow;

/**
 *
 * @author gregorygraham
 * @param <ROW>
 */
public interface EditingCancelledNotifier<ROW extends DBRow> {

	@SuppressWarnings(value = "unchecked")
	default Registration addEditingCancelledListener(ComponentEventListener<Event<ROW>> listener) {
		if (this instanceof Component) {
			return ComponentUtil.addListener(
					(Component) this,
					Event.class,
					(ComponentEventListener) listener
			);
		} else {
			throw new IllegalStateException(String.format(
					"The class '%s' doesn't extend '%s'. "
					+ "Make your implementation for the method '%s'.",
					getClass().getName(), Component.class.getSimpleName(),
					"addDBRowUpdatedListener"));
		}
	}

	public static class Event<ROW extends DBRow> extends ComponentEvent<DBRowEditor<ROW>> {

		private final ROW cancelledEdittingRow;

		public Event(DBRowEditor<ROW> source, ROW row) {
			super(source, true);
			cancelledEdittingRow = row;
		}

		public ROW getCancelledEdittingRow() {
			return cancelledEdittingRow;
		}
		
		
	}

}