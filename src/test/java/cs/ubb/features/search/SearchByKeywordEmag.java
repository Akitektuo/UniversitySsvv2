package cs.ubb.features.search;

import cs.ubb.steps.serenity.EmagSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagSearchTestData.csv")
public class SearchByKeywordEmag {
    @Steps
    public EmagSteps steps;

    public String name;
    public String title;


    @Issue("#Emag-1")
    @Test
    public void searchByKeywordsShouldDisplayCorrespondingTitles() {
        steps.openHomePage();
        steps.lookFor(name);
        steps.shouldSeeTitle(title);
    }
}
