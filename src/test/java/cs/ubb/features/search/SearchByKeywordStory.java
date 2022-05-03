package cs.ubb.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cs.ubb.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/WikiTestData.csv")
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps ion;

    public String name;
    public String definition;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_should_display_the_corresponding_article() {
        ion.is_the_home_page();
        ion.looks_for(name);
        ion.should_see_definition(definition);
    }
} 