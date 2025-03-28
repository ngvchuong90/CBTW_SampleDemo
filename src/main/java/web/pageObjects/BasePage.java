package web.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public void waitForPageLoad(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        int timeout = 30; // Max wait time in seconds
        int pollInterval = 1000; // Polling interval in milliseconds

        for (int i = 0; i < timeout * 1000 / pollInterval; i++) {
            try {
                Thread.sleep(pollInterval); // Wait before checking again
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                throw new RuntimeException("Thread interrupted while waiting for page load", e);
            }

            String result = js.executeScript("return document.readyState").toString();
            if ("complete".equals(result)) {
                return; // Page loaded successfully
            }
        }

        throw new RuntimeException("Timeout: Page did not load within " + timeout + " seconds");
    }
}
