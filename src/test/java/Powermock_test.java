package test.java;

import static junit.framework.Assert.assertEquals;

import main.java.Utility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;


import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utility.class)
@PowerMockIgnore("jdk.internal.reflect.*")
public class Powermock_test {

    @Test
    public void TestFinalMethod_WithPowerMock() throws Exception {

        String message = " PowerMock with Mockito and JUnit ";
        Utility uti = PowerMockito.mock(Utility.class);
        PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(uti);

        Utility uti2 =  new Utility();
        PowerMockito.verifyNew(Utility.class).withNoArguments();

        PowerMockito.when(uti2.finalMethod(message)).thenReturn(message);
        String message2 = uti2.finalMethod(message);
        Mockito.verify(uti2).finalMethod(message);
        assertEquals(message, message2);
    }

    @Test
    public void TestStaticMethod_WithPowerMockito() {

        String call = " Hi there, I'm using PowerMock with Mockito ";

        PowerMockito.mockStatic(Utility.class);
        PowerMockito.when(Utility.staticMethod(call)).thenReturn(" Call Expectation for you. ");

        String actualcall = Utility.staticMethod(call);
        assertEquals(" Call Expectation for you. ", actualcall);
    }
}

/*
powermock.module.junit4 (2.0.9)
powermock.api.mockito2 (2.0.9)

SUPPOSEDLY for testing final, static, or private methods

*/