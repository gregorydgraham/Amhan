package nz.co.gregs.amhan.browser.views.selecttable;

import nz.co.gregs.amhan.browser.grid.DataModelTablesGrid;
import nz.co.gregs.amhan.browser.data.Database;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import nz.co.gregs.amhan.browser.views.main.MainView;
import nz.co.gregs.dbvolution.DBRow;
import nz.co.gregs.dbvolution.reflection.DataModel;

@Route(value = "selecttable", layout = MainView.class)
@PageTitle("Select Table")
@CssImport("./styles/views/selecttable/select-table-view.css")
public class SelectTableView extends Div {

	private final Logger LOG = Logger.getLogger(this.getClass().getCanonicalName());

	private DataModelTablesGrid grid = new DataModelTablesGrid();

	private Database database;

	public SelectTableView(@Autowired Database db) {
		setId("quick-query-view");
		this.database = database;
		configureGrid();

		add(grid);
	}

	private void configureGrid() {
		// Configure Grid

		// when a row is selected, switch to showing the rows
		grid.asSingleSelect().addValueChangeListener(event -> handleSelection(event));
	}

	private void handleSelection(AbstractField.ComponentValueChangeEvent<Grid<DBRow>, DBRow> event) {
		final String canonicalName = event.getValue().getClass().getCanonicalName();
		UI.getCurrent().navigate(ShowRows.class, canonicalName);
	}
}
