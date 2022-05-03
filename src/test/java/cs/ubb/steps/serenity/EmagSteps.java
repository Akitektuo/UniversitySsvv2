package cs.ubb.steps.serenity;

import cs.ubb.pages.EmagPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EmagSteps {
    private EmagPage page;

    @Step
    public void shouldSeeTitle(String title) {
        assertThat(page.getTitles(), hasItem(containsString(title)));
    }

    @Step
    public void openHomePage() {
        page.open();
    }

    @Step
    public void lookFor(String term) {
        enter(term);
        startSearch();
    }

    @Step
    private void enter(String keyword) {
        page.enterKeyword(keyword);
    }

    @Step
    private void startSearch() {
        page.lookupKeyword();
    }
}
