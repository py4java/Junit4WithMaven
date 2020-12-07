package com.urbanladder.dao;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.urbanladder.constants.DatabaseManager;
import com.urbanladder.helper.ConnectionService;
import com.urbanladder.helper.SchemaManager;

public class ProductDaoTest {

	private static ConnectionService connectionService;
	private static SchemaManager schemaManager;
	ProductDao productDao;
	int actualNumberOfProducts;
	int expectedNumberOfProducts;
	String category;

	@BeforeClass
	public static void intialize() {
		connectionService = new ConnectionService();
		schemaManager = new SchemaManager(connectionService);
		schemaManager.executeSQLScript(DatabaseManager.createSchema, "db-root.properties");
	}

	@Before
	public void setUp() {
		schemaManager.executeSQLScript(DatabaseManager.insertData, "db-test.properties");
		actualNumberOfProducts = 3;
		productDao = new ProductDao(connectionService);
		category = "hall";
	}

	@Test
	public void testGetProductsByCategory() {
		expectedNumberOfProducts = productDao.getProductsByCategory(category).size();
		assertEquals(expectedNumberOfProducts, actualNumberOfProducts);
	}

	@After
	public void tearDown() {
		productDao = null;
		schemaManager.executeSQLScript(DatabaseManager.truncateData, "db-test.properties");

	}

	@AfterClass
	public static void shutdown() {
		schemaManager.executeSQLScript(DatabaseManager.dropSchema, "db-root.properties");
	}
}
