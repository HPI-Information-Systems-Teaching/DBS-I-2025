package de.hpi.dbs1;

import de.hpi.dbs1.entities.Actor;
import de.hpi.dbs1.entities.Movie;
import org.junit.jupiter.api.*;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import static de.hpi.dbs1.fixtures.Actors.*;
import static de.hpi.dbs1.fixtures.Movies.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JDBCExerciseImplementationTests {

	static JDBCExercise implementation;
	static ConnectionConfig config;

	@BeforeAll
	static void setUp() {
		implementation = ChosenImplementationKt.getChosenImplementation();
		config = new PropertiesConnectionConfig(new File("database.properties"));
		Assertions.assertFalse(config.getUsername().isBlank(), "please provide your database username in the \"database.properties\" file");
		Assertions.assertFalse(config.getPassword().isBlank(), "please provide your database password in the \"database.properties\" file");
	}

	@Test
	@Order(1)
	@DisplayName("connectDatabase(config) should return a valid connection to the Postgres server")
	void testConnectDatabase() throws SQLException {
		try(var connection = implementation.createConnection(config)) {
			Assertions.assertTrue(connection.isValid(0), "connection is not valid");
		}
	}

	@Test
	@Order(2)
	@DisplayName("Movie query 1: Wolf of Wall Street")
	void testQueryMovies1() throws SQLException {
		try(var connection = implementation.createConnection(config)) {
			List<Movie> results = implementation.queryMovies(connection, "Wolf of Wall Street");
			Assertions.assertIterableEquals(List.of(WWS_1929, WWS_2013), results);
		}
	}

	@Test
	@Order(2)
	@DisplayName("Movie query 2: Ghost in the Shell")
	void testQueryMovies2() throws SQLException {
		try(var connection = implementation.createConnection(config)) {
			List<Movie> results = implementation.queryMovies(connection, "Ghost in the Shell");

			Assertions.assertEquals(GITS_1995, results.get(0), "The first result should be \"Ghost in the Shell\" from 1995");
			Assertions.assertEquals(GITS_1995.actorNames, results.get(0).actorNames, "\"Ghost in the Shell (1995)\" did not contain the correct actors");
			Assertions.assertTrue(results.contains(GITS_TNM_2015), "The result should contain \"Ghost in the Shell: The New Movie\" from 2015");
		}
	}

	@Test
	@Order(2)
	@DisplayName("Movie query 3: Willkommen in Berlin")
	void testQueryMovies3() throws SQLException {
		try(var connection = implementation.createConnection(config)) {
			List<Movie> results = implementation.queryMovies(connection, "Willkommen in Berlin");
			Assertions.assertIterableEquals(List.of(WIB_2009), results);
			results.forEach(movie -> Assertions.assertEquals(0, movie.actorNames.size()));
		}
	}

	@Test
	@Order(2)
	@DisplayName("Movie query 4: A New Hope")
	void testQueryMovies4() throws SQLException {
		try(var connection = implementation.createConnection(config)) {
			List<Movie> results = implementation.queryMovies(connection, "A New Hope");
			Assertions.assertIterableEquals(List.of(ANH_1977), results);
			results.forEach(movie -> Assertions.assertEquals(10, movie.actorNames.size()));
		}
	}

	@Test
	@Order(2)
	@DisplayName("Movie query 5: Ratatouille")
	void testQueryMovies5() throws SQLException {
		try(var connection = implementation.createConnection(config)) {
			List<Movie> results = implementation.queryMovies(connection, "Ratatouille");
			Assertions.assertIterableEquals(List.of(RTT_2007), results);
			results.forEach(movie ->
					Assertions.assertTrue(
							movie.actorNames.size() == 10 || movie.actorNames.size() == 11,
							"Expected 10 or 11 actors, but got " + movie.actorNames.size()
					)
			);
		}
	}

	@Test
	@Order(3)
	@DisplayName("Actor/Actress query 1: Anne Hathaway")
	void testQueryActors1() throws SQLException {
		try(var connection = implementation.createConnection(config)) {
			List<Actor> results = implementation.queryActors(connection, "Anne Hathaway");
			Assertions.assertEquals(1, results.size());

			Assertions.assertEquals(ANNE_HATHAWAY, results.get(0));
			Assertions.assertEquals(ANNE_HATHAWAY.playedIn, results.get(0).playedIn);
			Assertions.assertEquals(ANNE_HATHAWAY.costarNameToCount, results.get(0).costarNameToCount);
		}
	}

	@Test
	@Order(3)
	@DisplayName("Actor/Actress query 2: Freeman")
	void testQueryActors2() throws SQLException {
		try(var connection = implementation.createConnection(config)) {
			List<Actor> results = implementation.queryActors(connection, "Freeman");
			Assertions.assertEquals(List.of(MORGAN_FREEMAN, FREEMAN_WOOD, KATHLEEN_FREEMAN, HOWARD_FREEMAN, MONA_FREEMAN), results);

			Assertions.assertEquals(MORGAN_FREEMAN, results.get(0));
			Assertions.assertEquals(MORGAN_FREEMAN.playedIn, results.get(0).playedIn);
			Assertions.assertEquals(MORGAN_FREEMAN.costarNameToCount, results.get(0).costarNameToCount);
		}
	}

	@Test
	@Order(3)
	@DisplayName("Actor/Actress query 3: Luna")
	void testQueryActors3() throws SQLException {
		try(var connection = implementation.createConnection(config)) {
			List<Actor> results = implementation.queryActors(connection, "Luna");
			Assertions.assertEquals(List.of(ALVARO_LUNA, MANUEL_LUNA, CONSUELO_LUNA, DIEGO_LUNA, LUNA_MAYA), results);

			Assertions.assertEquals(DIEGO_LUNA, results.get(3));
			Assertions.assertEquals(DIEGO_LUNA.playedIn, results.get(3).playedIn);
			Assertions.assertTrue(results.get(3).costarNameToCount.equals(DIEGO_LUNA.costarNameToCount) || results.get(3).costarNameToCount.equals(DIEGO_LUNA_ACTORS_ONLY.costarNameToCount),
					"Expected " + DIEGO_LUNA.costarNameToCount + " or " + DIEGO_LUNA_ACTORS_ONLY.costarNameToCount + " but got " + results.get(3).costarNameToCount);
		}
	}

	@Test
	@Order(3)
	@DisplayName("Actor query 2: Jack Black")
	void testQueryJackBlack() throws SQLException {
		try (var connection = implementation.createConnection(config)) {
			List<Actor> results = implementation.queryActors(connection, "Jack Black");

			Assertions.assertEquals(List.of(JACK_BLACK, JACK_BLACK2), results);

			Assertions.assertEquals(JACK_BLACK, results.get(0));

			List<String> expectedMovies = List.of(
					"Borderlands",
					"Kung Fu Panda 4",
					"Free LSD",
					"The Super Mario Bros. Movie"
			);
			List<String> actualMovies = results.get(0).playedIn;
			Assertions.assertEquals(expectedMovies, actualMovies.subList(0, expectedMovies.size()));

			// Letzte Filmzeile wird nur auf Apollo geprüft, da es Probleme mit den Sonderzeichen gibt
			String lastMovie = actualMovies.get(actualMovies.size() - 1);
			Assertions.assertTrue(lastMovie.contains("Apollo 10"),
					"Expected last movie to contain 'Apollo 10', but was: " + lastMovie);

			Assertions.assertEquals(JACK_BLACK.costarNameToCount, results.get(0).costarNameToCount);
		}
	}
}
