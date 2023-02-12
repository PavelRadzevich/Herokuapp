package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.Typos;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest extends BaseTest{

    @Test
    public void typosTest(){
        final String RIGHT_TXT = "Sometimes you'll see a typo, other times you won't.";
        final String ERR_MSG1 = "The option is invalid";

        Typos typosPage = new Typos();
        Assert.assertEquals(typosPage.getParagraphTxt(),RIGHT_TXT,ERR_MSG1);

    }

}
