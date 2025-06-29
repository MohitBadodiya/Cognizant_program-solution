package com.myorg.dn4;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class MyServiceVerifyInteractionsTest {

    private com.myorg.dn4.ExternalApi externalApiMock;
    private com.myorg.dn4.MyService myService;

    @Before
    public void initializeMocks() {
        // Create mock for ExternalApi
        externalApiMock = mock(com.myorg.dn4.ExternalApi.class);

        // Stub getData() to prevent null return in fetchData()
        when(externalApiMock.getData()).thenReturn("data");

        // Inject mock into service
        myService = new com.myorg.dn4.MyService(externalApiMock);
    }

    @Test(expected = RuntimeException.class)
    public void testVoidMethodThrowsException() {
        // Stub sendData() to throw exception when called with "bad:processed"
        doThrow(new RuntimeException("boom"))
                .when(externalApiMock).sendData("bad:processed");

        // This should now throw RuntimeException
        myService.processAndSend("bad");
    }

    @Test
    public void testVerifyGetDataCalledOnce() {
        // Call fetchData()
        myService.fetchData();

        // Verify getData() was called exactly once
        verify(externalApiMock, times(1)).getData();
    }

    @Test
    public void testVerifyOrderOfInteractions() {
        // Call methods in order
        myService.fetchData();
        myService.processAndSend("x");

        // Create InOrder verifier
        InOrder inOrder = inOrder(externalApiMock);

        // Verify the order of method calls
        inOrder.verify(externalApiMock).getData();
        inOrder.verify(externalApiMock).sendData("x:processed");
    }
}
