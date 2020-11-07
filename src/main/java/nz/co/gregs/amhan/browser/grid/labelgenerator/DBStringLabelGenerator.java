/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.amhan.browser.grid.labelgenerator;

import nz.co.gregs.dbvolution.DBRow;
import nz.co.gregs.dbvolution.datatypes.DBString;

/**
 *
 * @author gregorygraham
 * @param <A>
 */
public class DBStringLabelGenerator<A extends DBRow> extends AbstractDBRowPropertyLabelGenerator<A, DBString> {

	public DBStringLabelGenerator(A example, DBString string) {
		super(example, string);
	}

	@Override
	public String apply(A item) {
		return getQDT(item).stringValue();
	}
	
}
