package cargument.dantomdev.com.cargument.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import cargument.dantomdev.com.cargument.BuildConfig;
import cargument.dantomdev.com.cargument.ui.main.MainPresenter;
import cargument.dantomdev.com.cargument.ui.main.MainScreen;
import cargument.dantomdev.com.cargument.utils.RoboelectricDaggerTestRunner;

import static cargument.dantomdev.com.cargument.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RoboelectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainTest {

    private MainPresenter mainPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainPresenter = new MainPresenter();
    }

    @Test
    public void testConversations() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
        mainPresenter.getConversations("1");

        ArgumentCaptor<String> conversationsCaptor = ArgumentCaptor.forClass(String.class);
        //verify(mainScreen, times(2)).showMessage(conversationsCaptor.capture());

        List<String> capturedConversations = conversationsCaptor.getAllValues();
        assertEquals(capturedConversations.size(), 0);
    }



    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}