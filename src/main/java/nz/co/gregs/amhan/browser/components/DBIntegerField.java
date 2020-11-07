/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.amhan.browser.components;

import com.vaadin.flow.component.textfield.AbstractNumberField;
import com.vaadin.flow.function.SerializableFunction;
import java.text.CompactNumberFormat;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Server-side component for the {@code vaadin-number-field} element.
 *
 * @author Vaadin Ltd.
 */
public class DBIntegerField extends AbstractNumberField<DBIntegerField, Long> {

	/**
	 * Constructs an empty {@code NumberField}.
	 */
	public DBIntegerField() {
		this(new Formatter());
	}

	/**
	 * Constructs an empty {@code NumberField} with the given label.
	 *
	 * @param label the text to set as the label
	 */
	public DBIntegerField(String label) {
		this();
		setLabel(label);
	}

	/**
	 * Constructs an empty {@code NumberField} with the given label and
	 * placeholder text.
	 *
	 * @param label the text to set as the label
	 * @param placeholder the placeholder text to set
	 */
	public DBIntegerField(String label, String placeholder) {
		this(label);
		setPlaceholder(placeholder);
	}

	/**
	 * Constructs an empty {@code NumberField} with a value change listener.
	 *
	 * @param listener the value change listener
	 *
	 * @see
	 * #addValueChangeListener(com.vaadin.flow.component.HasValue.ValueChangeListener)
	 */
	public DBIntegerField(
			ValueChangeListener<? super ComponentValueChangeEvent<DBIntegerField, Long>> listener) {
		this();
		addValueChangeListener(listener);
	}

	/**
	 * Constructs an empty {@code NumberField} with a value change listener and a
	 * label.
	 *
	 * @param label the text to set as the label
	 * @param listener the value change listener
	 *
	 * @see #setLabel(String)
	 * @see
	 * #addValueChangeListener(com.vaadin.flow.component.HasValue.ValueChangeListener)
	 */
	public DBIntegerField(String label,
			ValueChangeListener<? super ComponentValueChangeEvent<DBIntegerField, Long>> listener) {
		this(label);
		addValueChangeListener(listener);
	}

	/**
	 * Constructs a {@code NumberField} with a value change listener, a label and
	 * an initial value.
	 *
	 * @param label the text to set as the label
	 * @param initialValue the initial value
	 * @param listener the value change listener
	 *
	 * @see #setLabel(String)
	 * @see #setValue(Object)
	 * @see
	 * #addValueChangeListener(com.vaadin.flow.component.HasValue.ValueChangeListener)
	 */
	public DBIntegerField(String label, Long initialValue,
			ValueChangeListener<? super ComponentValueChangeEvent<DBIntegerField, Long>> listener) {
		this(label);
		setValue(initialValue);
		addValueChangeListener(listener);
	}

	/**
	 * Constructs an empty {@code NumberField}.
	 *
	 * @param formatter Formatter for the field.
	 */
	private DBIntegerField(Formatter formatter) {
		super(
				formatter::parse,
				formatter,
				Long.MAX_VALUE,
				Long.MIN_VALUE
		);
	}

	@Override
	public void setMin(double min) {
		super.setMin(min);
	}

	/**
	 * The minimum value of the field.
	 *
	 * @return the {@code min} property from the webcomponent
	 */
	public double getMin() {
		return getMinDouble();
	}

	@Override
	public void setMax(double max) {
		super.setMax(max);
	}

	/**
	 * The maximum value of the field.
	 *
	 * @return the {@code max} property from the webcomponent
	 */
	public double getMax() {
		return getMaxDouble();
	}

	/**
	 * Sets the allowed number intervals of the field. This specifies how much the
	 * value will be increased/decreased. It is also used to invalidate the field,
	 * if the value doesn't align with the specified step and
	 * {@link #setMin(double) min} (if specified by user).
	 *
	 * @param step the new step to set
	 * @throws IllegalArgumentException if the argument is less or equal to zero.
	 */
	@Override
	public void setStep(double step) {
		if (step <= 0) {
			throw new IllegalArgumentException("The step cannot be less or equal to zero.");
		}
		super.setStep(step);
	}

	/**
	 * Specifies the allowed number intervals of the field.
	 *
	 * @return the {@code step} property from the webcomponent
	 */
	public double getStep() {
		return getStepDouble();
	}

	/**
	 * Maximum number of characters (in Unicode code points) that the user can
	 * enter.
	 *
	 * @param maxLength the maximum length
	 *
	 * @deprecated Not supported by NumberField (as it's built on
	 * {@code <input type="number">} in HTML). You can set numeric value
	 * constraints with {@link #setMin(double)},
	 *             {@link #setMax(double)} and {@link #setStep(double)}.
	 */
	@Deprecated
	public void setMaxLength(int maxLength) {
		super.setMaxlength(maxLength);
	}

	/**
	 * Maximum number of characters (in Unicode code points) that the user can
	 * enter.
	 *
	 * @return the {@code maxlength} property from the webcomponent
	 *
	 * @deprecated Not supported by NumberField (as it's built on
	 * {@code <input type="number">} in HTML). You can set numeric value
	 * constraints with {@link #setMin(double)},
	 *             {@link #setMax(double)} and {@link #setStep(double)}.
	 */
	@Deprecated
	public int getMaxLength() {
		return (int) getMaxlengthDouble();
	}

	/**
	 * Minimum number of characters (in Unicode code points) that the user can
	 * enter.
	 *
	 * @param minLength the minimum length
	 *
	 * @deprecated Not supported by NumberField (as it's built on
	 * {@code <input type="number">} in HTML). You can set numeric value
	 * constraints with {@link #setMin(double)},
	 *             {@link #setMax(double)} and {@link #setStep(double)}.
	 */
	@Deprecated
	public void setMinLength(int minLength) {
		super.setMinlength(minLength);
	}

	/**
	 * Minimum number of characters (in Unicode code points) that the user can
	 * enter.
	 *
	 * @return the {@code minlength} property from the webcomponent
	 *
	 * @deprecated Not supported by NumberField (as it's built on
	 * {@code <input type="number">} in HTML). You can set numeric value
	 * constraints with {@link #setMin(double)},
	 *             {@link #setMax(double)} and {@link #setStep(double)}.
	 */
	@Deprecated
	public int getMinLength() {
		return (int) getMinlengthDouble();
	}

	/**
	 * When set to <code>true</code>, user is prevented from typing a value that
	 * conflicts with the given {@code pattern}.
	 *
	 * @return the {@code preventInvalidInput} property from the webcomponent
	 *
	 * @deprecated Not supported by NumberField (as it's built on
	 * {@code <input type="number">} in HTML). You can set numeric value
	 * constraints with {@link #setMin(double)},
	 *             {@link #setMax(double)} and {@link #setStep(double)}. For setting a custom
	 * value pattern and preventing invalid input, use the TextField component
	 * instead.
	 */
	@Deprecated
	public boolean isPreventInvalidInput() {
		return isPreventInvalidInputBoolean();
	}

	/**
	 * @deprecated Not supported by NumberField (as it's built on
	 * {@code <input type="number">} in HTML). You can set numeric value
	 * constraints with {@link #setMin(double)},
	 *             {@link #setMax(double)} and {@link #setStep(double)}. For setting a custom
	 * value pattern and preventing invalid input, use the TextField component
	 * instead.
	 */
	@Override
	@Deprecated
	public void setPreventInvalidInput(boolean preventInvalidInput) {
		super.setPreventInvalidInput(preventInvalidInput);
	}

	/**
	 * @deprecated Not supported by NumberField (as it's built on
	 * {@code <input type="number">} in HTML). You can set numeric value
	 * constraints with {@link #setMin(double)},
	 *             {@link #setMax(double)} and {@link #setStep(double)}. For setting a custom
	 * value pattern, use the TextField component instead.
	 */
	@Override
	@Deprecated
	public void setPattern(String pattern) {
		super.setPattern(pattern);
	}

	/**
	 * A regular expression that the value is checked against. The pattern must
	 * match the entire value, not just some subset.
	 *
	 * @return the {@code pattern} property from the webcomponent
	 *
	 * @deprecated Not supported by NumberField (as it's built on
	 * {@code <input type="number">} in HTML). You can set numeric value
	 * constraints with {@link #setMin(double)},
	 *             {@link #setMax(double)} and {@link #setStep(double)}. For setting a custom
	 * value pattern, use the TextField component instead.
	 */
	@Deprecated
	public String getPattern() {
		return getPatternString();
	}

	private static class Formatter
			implements SerializableFunction<Long, String> {

		// Using Locale.ENGLISH to keep format independent of JVM locale
		// settings. The value property always uses period as the decimal
		// separator regardless of the browser locale.
		private final NumberFormat decimalFormat = CompactNumberFormat.getCurrencyInstance(Locale.ENGLISH);

		private Formatter() {
			decimalFormat.setMaximumFractionDigits(Integer.MAX_VALUE);
		}

		@Override
		public String apply(Long valueFromModel) {
			return valueFromModel == null ? ""
					: decimalFormat.format(valueFromModel.doubleValue());
		}

		private Long parse(String valueFromClient) {
			try {
				return valueFromClient == null || valueFromClient.isEmpty()
						? null
						: decimalFormat.parse(valueFromClient).longValue();
			} catch (ParseException e) {
				throw new NumberFormatException(valueFromClient);
			}
		}
	}
}
