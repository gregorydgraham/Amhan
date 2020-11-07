/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.amhan.browser.components;

import nz.co.gregs.amhan.browser.setter.QueryableDatatypeSetter;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.data.binder.Binder;
import nz.co.gregs.amhan.browser.valueprovider.QueryableDatatypeValueProvider;
import nz.co.gregs.dbvolution.DBRow;
import nz.co.gregs.dbvolution.datatypes.QueryableDatatype;
import nz.co.gregs.dbvolution.internal.properties.PropertyWrapper;

/**
 *
 * @author gregorygraham
 * @param <ROW>
 * @param <TYPE>
 */
public class QDTComponentsBound<ROW extends DBRow, TYPE> {

	private final String columnName;
	private final String propertyName;
	private final AbstractField<?, TYPE> editor;
	private final QueryableDatatypeValueProvider<ROW, TYPE, ? extends QueryableDatatype<TYPE>> valueProvider;
	private final QueryableDatatypeSetter<ROW, TYPE, ? extends QueryableDatatype<TYPE>> setter;

	@SuppressWarnings(value = "unchecked")
	public static <R extends DBRow, T, Q extends QueryableDatatype<T>> QDTComponentsBound<R, T> getFor(R row, Q field, Binder<R> binder) {
		QDTComponentsBound qdtComponents = new QDTComponentsBound(row, field);
		final AbstractField editor = qdtComponents.getEditor();
		binder.bind(editor, qdtComponents.getValueProvider(), qdtComponents.getSetter());
		return qdtComponents;
	}

//	static <R extends DBRow, T, Q extends QueryableDatatype<T>> QDTComponentsBound<R, T> getFor(PropertyWrapper<T, Q> prop, Binder<R> binder) {
//		@SuppressWarnings("unchecked")
//		QDTComponentsBound<R, T> qdtComponents = new QDTComponentsBound<R,T>((R)prop.getRowDefinitionInstanceWrapper().adapteeRowDefinition(), prop.getQueryableDatatype());
//		binder.bind(qdtComponents.getEditor(), qdtComponents.getValueProvider(), qdtComponents.getSetter());
//		return qdtComponents;
//	}
	private <QDT extends QueryableDatatype<TYPE>> QDTComponentsBound(ROW row, QDT field) {
		editor = DBRowPropertyField.getEditor(row, field);
		valueProvider = QueryableDatatypeValueProvider.getValueProvider(row, field);
		setter = QueryableDatatypeSetter.getSetter(row, field);
		PropertyWrapper<?, ?> property = row.getPropertyWrapperOf(field);
		columnName = property.columnName();
		propertyName = property.javaName();
	}

	public AbstractField<?, TYPE> getEditor() {
		return editor;
	}

	public QueryableDatatypeValueProvider<ROW, TYPE, ? extends QueryableDatatype<TYPE>> getValueProvider() {
		return valueProvider;
	}

	public QueryableDatatypeSetter<ROW, TYPE, ? extends QueryableDatatype<TYPE>> getSetter() {
		return setter;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String getColumnName() {
		return columnName;
	}

}
