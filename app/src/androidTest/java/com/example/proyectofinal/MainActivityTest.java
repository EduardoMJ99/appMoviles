package com.example.proyectofinal;

import static androidx.test.espresso.Espresso.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anything;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    private void checkElementVisibility(Matcher viewMatchers) {
        onView(viewMatchers).check(matches(isDisplayed()));
    }

    private void login() {
        onView(withId(R.id.txtCorreo)).perform(typeText("derechoscopio@gmail.com"));
        onView(withId(R.id.txtClave)).perform(typeText("clave1234"));
        onView(withText("Iniciar sesión")).perform(click());
    }

    private void registerNewMigrante() {
        onView(withId(R.id.txtNombreAgregarMigrante))
                .perform(typeText("Eduardo Morgado"));
        onView(withId(R.id.txtTelefonoAgregarMigrante))
                .perform(typeText("6642961116"));
        closeSoftKeyboard();
        onView(withId(R.id.txtFechaNacAgregarMigrante))
                .perform(typeText("10/10/2022"));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.txtFechaLlegaAgregarMigrante))
                .perform(typeText("10/10/2022"));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.txtFechaConsulAgregarMigrante))
                .perform(typeText("10/10/2022"));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.spiNacionalidad))
                .perform(click());
        onData(anything()).atPosition(2)
                .perform(click());
        onView(withId(R.id.txtHoraLlegadaAgregarMigrante))
                .perform(typeText("09:59"));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.txtHoraConsulAgregarMigrante))
                .perform(typeText("09:59"));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.btnGuardar)).perform(click());
    }

    @Test
    public void testLoginWithCorrectCredentials() {
        //Check the activity has been displayed correctly
        checkElementVisibility(withId(R.id.imageView));
        checkElementVisibility(withId(R.id.txtCorreo));
        checkElementVisibility(withId(R.id.txtClave));
        checkElementVisibility(withText("Iniciar sesión"));
        //Steps to login
        login();
        //Check new activity is displayed
        onView(withId(R.id.txtTituloTabbed)).check(matches(isDisplayed()));
    }

    @Test
    public void testLoginWithIncorrectCredentials() {
        onView(withId(R.id.txtCorreo)).perform(typeText("derechoscopio@gmail.com"));
        onView(withId(R.id.txtClave)).perform(typeText("clave123"));
        onView(withText("Iniciar sesión")).perform(click());

        onView(withId(R.id.txtTituloTabbed)).check(doesNotExist());
    }

    @Test
    public void testAddMigrante() {
        login();
        onView(withText("Migrantes")).perform(click());
        onView(withId(R.id.fabMigrante)).perform(click());
        registerNewMigrante();
    }
}
