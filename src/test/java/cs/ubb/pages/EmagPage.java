package cs.ubb.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.emag.ro/")
public class EmagPage extends PageObject {
    @FindBy(name = "query")
    private WebElementFacade searchTerms;

    @FindBy(className = "searchbox-submit-button")
    private WebElementFacade lookupButton;

    public void enterKeyword(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookupKeyword() {
        lookupButton.click();
    }

    public List<String> getTitles() {
        return findAll(By.cssSelector("a.card-v2-title.semibold.mrg-btm-xxs.js-product-url")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
