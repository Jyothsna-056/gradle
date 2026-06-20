package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import support.Config;

import static org.junit.jupiter.api.Assertions.*;

public class SmokeTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Product catalog loads in a real Chrome session")
    void catalogLoads() {
        driver.get(Config.catalogUrl());

        By catalogHeading = By.id("catalog-title");

        assertAll(
                () -> assertTrue(driver.getTitle().contains("SDET Retail")),
                () -> assertTrue(driver.findElement(catalogHeading).isDisplayed()),
                () -> assertEquals("Product Catalog", driver.findElement(catalogHeading).getText())
        );
    }
}