import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args)
    {
        // Agregar la propiedad webdriver.chrome.driver y crear instancia
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\alejandro\\Documents\\chromedriver_win32\\chromedriver.exe"
        );

        WebDriver driver = new ChromeDriver();

        // Llamar una pagina en el navegador
        driver.get("http://formy-project.herokuapp.com/switch-window");

        // Encontrar y hacer click en el boton de nueva pestaña
        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        String originalHandle = driver.getWindowHandle();

        for (String handle1: driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }

        driver.switchTo().window(originalHandle);

        // Interactuar con el boton de alerta
        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();

        driver.switchTo().alert().accept();
    }
}
