package skyselect_Maven.skyselect_Maven;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElementsPage {
	 // Example WebElement
    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    private WebElement btn_Login;
    
    @FindBy(xpath ="//button[@class='button-element blue-dark-2']")
    private WebElement btn_newonDashboard;
    
    @FindBy(id= "location-select-input")
    private WebElement text_location;
 
    
    
    //Overview Link
    @FindBy(xpath = "//li[@index='overview-dashboard']")
    private WebElement lnk_Overview;
    
    //Dashboard Link
    @FindBy(xpath = "//li[@index='requests-sub-menu']")
    private WebElement lnk_Dashboard;
    
    //AwardingDashboard Link
    @FindBy(xpath = "//li[@index='awarding']")
    private WebElement lnk_AwardingDashboard;
    
    //Order Dashboard
    @FindBy(xpath = "//li[@index='orders-dashboard']")
    private WebElement lnk_OrderDashboard;
    
    //SRM Dashboard
    @FindBy(xpath = "//li[@index='suppliers']")
    private WebElement lnk_SRMDashboard;
      
    //Analytics Dashboard
    @FindBy(xpath = "//li[@index='analytics']")
    private WebElement lnk_Analytics;
    
    
    // Constructor to initialize elements using PageFactory
    public WebElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void Login(String user,String pass) {
    	usernameField.sendKeys(user);
    	passwordField.sendKeys(pass);
    	btn_Login.click();
    	
    }
    
    
//    // Getters for WebElements
//    public WebElement getUsernameField() {
//        return usernameField;
//    }
//
//    public WebElement getPasswordField() {
//        return passwordField;
//    }
//
//    public WebElement getLoginButton() {
//        return btn_Login;
//    }
    public WebElement getbutton_new() {
    	return btn_newonDashboard;
    }
    public WebElement txt_location() {
    	return text_location;
    }
    
  
}
