package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.view.CrashView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Created by flip6 on 8.7.2016..
 */
@RunWith(MockitoJUnitRunner.class)
public class CrashPresenterImplIntegrationTest {
    private CrashPresenterImpl presenter;

    @Mock
    private CrashView crashView;

    private final int NO_INTERACTIONS_SWITCH_CASE = 5;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new CrashPresenterImpl();
        presenter.setView(crashView);
    }

    @Test
    public void testHandleUserClickedButtonNullPointer() throws Exception {
        presenter.handleUserClickedButton(R.id.button_null_pointer);
        verify(crashView).causeNullpointerCrash();
    }

    @Test
    public void testHandleUserClickedButtonClassCast() throws Exception {
        presenter.handleUserClickedButton(R.id.button_class_cast);
        verify(crashView).causeClassCastCrash();
    }

    @Test
    public void testHandleUserClickedButtonIOBounds() throws Exception {
        presenter.handleUserClickedButton(R.id.button_out_of_bounds);
        verify(crashView).causeIndexOutOfBoundsCrash();
    }

    @Test
    public void testHandleUserClickedButtonNoInteractions() throws Exception {
        presenter.handleUserClickedButton(NO_INTERACTIONS_SWITCH_CASE);
        verifyZeroInteractions(crashView);
    }
}