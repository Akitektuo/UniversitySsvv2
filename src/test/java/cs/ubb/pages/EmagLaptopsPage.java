package cs.ubb.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.emag.ro/laptopuri/")
public class EmagLaptopsPage extends PageObject {
    public void lookupBrand(String brand) {
        List<WebElement> buttons = new ArrayList<>(this.getDriver().findElements(By.tagName("a")));
        WebElement brandButton = buttons.stream()
                .filter(e -> e.getText().contains(brand))
                .findFirst()
                .orElse(null);
        if (brandButton != null) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,600)", "");
            brandButton.click();
        }
    }

    public List<String> getFiltered() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, -600)", "");
        return findAll(By.cssSelector("#main-container > section.page-section.page-listing-v2 > div > div.clearfix.pad-btm-md > div.page-container > div.listing-panel.has-floating-listing-panel-footer > div.listing-panel-heading > div > span.title-phrasing.title-phrasing-xl"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
