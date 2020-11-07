/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.amhan.browser.data;

import nz.co.gregs.amhan.browser.data.schema.BrowserUser;
import nz.co.gregs.amhan.browser.data.schema.Comments;
import com.vaadin.flow.spring.annotation.SpringComponent;
import java.sql.SQLException;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author gregorygraham
 */
@SpringComponent
public class DataLoader {

	@Bean
	public CommandLineRunner loadDatabase(Database dbRepository) {
		return args -> {
			Logger logger = LoggerFactory.getLogger(getClass());
				// all of this could possibly be done in the Database constructor
				// but this does avoid any issues with unfinished initialisation
				setData(dbRepository);

			logger.info("Generated demo database schema");
				return;
		};
	}

	private void setData(Database db) throws SQLException {
		db.createTable(new BrowserUser());
		db.createTable(new Comments());
		final BrowserUser alice = new BrowserUser("alice", "password");
		
		db.insert(alice,
				new BrowserUser("bart5", "password"),
				new BrowserUser("cindy", "password"),
				new BrowserUser("denny", "password"),
				new BrowserUser("eruditeOtter", "shibboleth")
				);
		
		db.insert(
				new Comments().withOwner(alice).postedAt(Instant.now()).withText("Great website"),
				new Comments().withOwner(alice).withText("Is anyone else here?")
				);
	}


}