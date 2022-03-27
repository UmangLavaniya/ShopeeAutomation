package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class BasePage {
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }
    public String userName="<USER_NAME>";
    public String password="<PASSWORD>";
    AppiumDriver driver;


    public void login()
    {
        driver.findElement(By.xpath("//android.widget.EditText[@text='Phone/Email/Username']")).sendKeys(userName);
        driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys(password);
        driver.findElement(By.id("com.shopee.in:id/btnLogin")).click();
        driver.findElement(By.id("android:id/autofill_save_yes")).click();
    }
    public void homePage()
    {
        driver.findElement(By.id("com.shopee.in:id/ok")).click();
        driver.findElement(By.id("com.shopee.in:id/btn")).click();
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
    }

    public void selectAnItemFromCategory()
    {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Category']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Men Wallets']")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[6]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView")).click();
    }
    public void addToCart()
    {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Add to Cart']")).click();
    }
    public void clickOnBuyNow()
    {
        driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView")).click();
    }
    public void confirmBuyNow()
    {
        driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView\n")).click();
    }
    public void clickOnCheckOut()
    {
        driver.findElement(By.xpath("//android.widget.TextView[contains(text(),'Check Out')]")).click();
    }


}
