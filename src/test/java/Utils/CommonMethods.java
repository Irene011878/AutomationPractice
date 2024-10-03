package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CommonMethods extends BaseClass {

     public WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Método para hacer clic en un elemento
    public void clickElement(By selector) {
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();
    }

    // Método para enviar texto a un campo
    public void sendText(By selector, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        element.clear();
        element.sendKeys(text);
    }

    // Método para obtener el texto de un elemento
    public String getElementText(By selector) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).getText();
    }

    // Método para esperar a que un elemento sea visible
    public void waitForVisibility(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    // Método para verificar si un elemento está presente en la página
    public boolean isElementPresent(By selector) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Método para obtener el título de la página
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Método para navegar a una URL
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Método para encontrar múltiples elementos
    public List<WebElement> findElements(By selector) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    // Método para hacer aserciones sobre el texto de un elemento
    public boolean verifyElementText(By selector, String expectedText) {
        String actualText = getElementText(selector);
        return actualText.equals(expectedText);
    }

    // Método para hacer aserciones sobre el título de la página
    public boolean verifyPageTitle(String expectedTitle) {
        String actualTitle = getPageTitle();
        return actualTitle.equals(expectedTitle);
    }

    // Método para hacer scroll hacia un elemento
    public void scrollToElement(By selector) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Método para hacer clic en todos los elementos encontrados por un localizador
    public void clickAllElements(By selector) {
        List<WebElement> elements = findElements(selector);
        for (WebElement element : elements) {
            element.click();
        }
    }

    // Método para obtener texto de todos los elementos encontrados por un localizador
    public List<String> getTextFromElements(By selector) {
        List<WebElement> elements = findElements(selector);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // Método para seleccionar un elemento de una lista por texto
    public void selectElementFromListByText(By selector, String text) {
        List<WebElement> elements = findElements(selector);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            }
        }
    }

    // Método para verificar si un elemento está seleccionado
    public boolean isElementSelected(By selector) {
        return driver.findElement(selector).isSelected();
    }

    // Método para verificar si un elemento está visible
    public boolean isElementDisplayed(By selector) {
        return driver.findElement(selector).isDisplayed();
    }

    // Método para verificar si un elemento está habilitado
    public boolean isElementEnabled(By selector) {
        return driver.findElement(selector).isEnabled();
    }

    // Wait for an element to be invisible
    public void waitForElementToBeInvisible(By selector) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    // Wait for an element to be present
    public void waitForElementToBePresent(By selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    // Wait for an element to be clickable
    public void waitForElementToBeClickable(By selector) {
        wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    // Select a dropdown option by visible text
    public void selectDropdownOptionByVisibleText(By selector, String optionText) {
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
    }

    // Método para seleccionar una categoría del dropdown por texto visible
    public void selectCategoryByVisibleText(String dropdownLocator, String category) {
        WebElement dropdown = driver.findElement(By.id(dropdownLocator));  // Localiza el dropdown
        Select select = new Select(dropdown);  // Crea un objeto Select
        select.selectByVisibleText(category);  // Selecciona la opción por el texto visible

    }
    public void selectCategoryByVisibleTextString(By dropdownLocator, String category) {
        WebElement dropdown = driver.findElement(dropdownLocator);  // Localiza el dropdown usando By
        Select select = new Select(dropdown);  // Crea un objeto Select
        select.selectByVisibleText(category);  // Selecciona la opción por el texto visible
    }

    public void clickUsingJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    //Hide
    public void hideElementById(String id) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.getElementById('" + id + "').style.display='none';"; js.executeScript(script);
    }

    // Method to click using JavaScriptExecutor
    public void clickElementByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void deleteElementByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].remove();", element);
    }

    // Método para seleccionar una opción por valor
    public void selectByValue(By locator, String value) {
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    // Método para hacer clic en un elemento usando JavaScriptExecutor con un wait
    public void clickElementByJSd(By locator) {
        try {
            // Esperar hasta que el elemento sea clickeable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

            // Usar JavaScriptExecutor para hacer clic en el elemento
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);

            System.out.println("Successfully clicked on the element using JavaScriptExecutor.");
        } catch (Exception e) {
            System.out.println("Error while clicking on the element using JavaScriptExecutor: " + e.getMessage());
        }


    }




}
