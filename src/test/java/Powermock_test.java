package test.java;

import static junit.framework.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.spy;

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
    public void TestStaticMethod_WithPowerMock() {

        String call = " Hi there, I'm using PowerMock with Mockito ";

        PowerMockito.mockStatic(Utility.class);
        PowerMockito.when(Utility.staticMethod(call)).thenReturn(" Call Expectation for you. ");

        String actualcall = Utility.staticMethod(call);
        assertEquals(" Call Expectation for you. ", actualcall);
    }

    @Test
    public void TestPrivateMethod_WithPowerMock() throws Exception {

        String message = " PowerMock with Mockito and JUnit ";
        String expectedmessage = " Using with EasyMock ";

        Utility mock = spy(new Utility());
        PowerMockito.doReturn(expectedmessage).when(mock, "privateMethod", message);

        String actualmessage = mock.callPrivateMethod(message);
        assertEquals(expectedmessage, actualmessage);
    }
}

/*
powermock.module.junit4 (2.0.9)
powermock.api.mockito2 (2.0.9)

Its important to take the latest versions, because the earlier versions won't work past java8,
    and its also important to take powermock.api.mockito2 since powermock.api.mockito does not work with the later versions of powermock

SUPPOSEDLY for testing final, static, or private methods

however, implementing many final or static methods isn't considered good coding practices, so in practice PowerMock shouldn't be relied upon

in addition: Mockito has already implemented the features that PowerMock has added to Mockito so there's really no reason to use PowerMock anymore,
    ESPECIALLY given that its not maintained anymore
*/