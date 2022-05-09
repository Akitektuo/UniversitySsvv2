package cs.ubb.features.search;

import cs.ubb.steps.serenity.EmagLaptopsSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagFilterTestData.csv")
public class FilterByBrandEmag {
    @Steps
    public EmagLaptopsSteps steps;

    public String searchedBrand;
    public String expectedBrand;

    @Test
    public void filterByBrandShouldDisplayCorrespondingProducts() {
        steps.openHomePage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        steps.lookupForBrand(searchedBrand);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        steps.shouldSeeFiltered(expectedBrand);
    }
}
