package test.java;


import main.java.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "Examples Of PowerMock")
@PowerMockIgnore("jdk.internal.reflect.*")
public class ExampleTest {


    @Test
    public void test() throws Exception {
        Example mock = mock(Example.class);

        whenNew(Example.class).withNoArguments().thenReturn(mock);

        Example collaborator = new Example();
        verifyNew(Example.class).withNoArguments();

        when(collaborator.helloMethod()).thenReturn("Hello Java Heroes");

        String welcome = collaborator.helloMethod();

        Mockito.verify(collaborator).helloMethod();
        assertEquals("Hello Java Heroes", welcome);
    }
}
