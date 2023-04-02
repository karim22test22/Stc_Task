package Stc;

import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;

public class Stc_Login {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\111\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        //Mazimize current window
        //driver.manage().window().maximize();

        driver.get("https://subscribe.stctv.com/");
        Thread.sleep(500);

        //provide test data csv file
        String CSV_path = "D:\\My automation\\Stc_Task\\Values.csv";
        CSVReader csvReader;
        String[] csvCell;

        // create an object of csvReader
        csvReader = new CSVReader(new FileReader(CSV_path));
        while ((csvCell = csvReader.readNext()) != null) {
            String Country = csvCell[0];
            String Locator = csvCell[1];



            //country selection
            driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[1]/span/img")).click();
            //select country
            driver.findElement(By.xpath(Locator)).click();




            // Get the country currency
            String typeValue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div[1]/div[3]/div[1]")).getText();

        // retrieving html attribute value using getAttribute() method
            ;


            System.out.println("Value of subscription for " + Country + " is " + typeValue);


        }

        System.out.println("Test completed, Please check the results");
    }
}
