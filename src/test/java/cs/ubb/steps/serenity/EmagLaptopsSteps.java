package cs.ubb.steps.serenity;

import cs.ubb.pages.EmagLaptopsPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EmagLaptopsSteps {
    private EmagLaptopsPage page;

    @Step
    public void openHomePage() {
        page.open();
    }

    @Step
    public void lookupForBrand(String brand) {
        page.lookupBrand(brand);
    }

    @Step
    public void shouldSeeFiltered(String brand) {
        assertThat(page.getFiltered(), hasItem(containsString(brand)));
    }
}
