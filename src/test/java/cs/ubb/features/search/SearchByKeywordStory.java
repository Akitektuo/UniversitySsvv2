package cs.ubb.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cs.ubb.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps ion;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        ion.is_the_home_page();
        ion.looks_for("apple");
        ion.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");

    }

    @Test
    public void searching_by_keyword_pear_should_display_the_corresponding_article() {
        ion.is_the_home_page();
        ion.looks_for("pear");
        ion.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but typically elongated towards the stem.");
    }

    @Test
    public void searching_by_keyword_car_should_display_the_corresponding_article() {
        ion.is_the_home_page();
        ion.looks_for("car");
        ion.should_see_definition("A wheeled vehicle that moves independently, with at least three wheels, powered mechanically, steered by a driver and mostly for personal transportation.");
    }

    @Test
    public void searching_by_keyword_phone_should_display_the_corresponding_article() {
        ion.is_the_home_page();
        ion.looks_for("phone");
        ion.should_see_definition("A device for transmitting conversations and other sounds in real time across distances, now often a small portable unit also capable of running software etc.");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
} 