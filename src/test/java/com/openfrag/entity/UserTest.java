package com.openfrag.entity;

import com.openfrag.OpenfragApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by tmaffia on 4/9/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OpenfragApplication.class)
public class UserTest {

    private User target = null;
    private String PATH_STRING = "/home/user/Desktop";
    private String LOCALE_STRING = "en-US";
    private String MALFORMED_LOCALE_CODE = "en-us";

    @Test
    public void testCreatePathFromString() {
        target = new User();
        target.setPathString(PATH_STRING);

        assertEquals(PATH_STRING, target.getPath().toString());
    }

    @Test
    public void testCreateLocaleFromString() {
        target = new User();
        target.setLocaleString(LOCALE_STRING);

        assertEquals(LOCALE_STRING, target.getLocale().toLanguageTag());
        assertEquals("en", target.getLocale().getLanguage());
        assertEquals("US", target.getLocale().getCountry());

    }

    @Test
    public void testCreateLocaleMalformedString() {
        target = new User();
        target.setLocaleString(MALFORMED_LOCALE_CODE);

        assertEquals(LOCALE_STRING, target.getLocale().toLanguageTag());
        assertEquals("en", target.getLocale().getLanguage());
        assertEquals("US", target.getLocale().getCountry());
    }

}
