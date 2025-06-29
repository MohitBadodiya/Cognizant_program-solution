import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MyServiceMockingStubbingTest {

    private com.myorg.dn4.ExternalApi externalApiMock;
    private com.myorg.dn4.MyService myService;

    @Before
    public void initializeMocks() {
        // 1. Create mock for ExternalApi
        externalApiMock = mock(com.myorg.dn4.ExternalApi.class);

        // 2. Stub getData() with sequential return values
        when(externalApiMock.getData())
                .thenReturn("firstCall")
                .thenReturn("secondCall");

        // 3. Inject mock into service
        myService = new com.myorg.dn4.MyService(externalApiMock);
    }

    @Test
    public void testFetchDataReturnsStubbedValues() {
        // First invocation
        String result1 = myService.fetchData();
        assertEquals("firstCall", result1);

        // Second invocation
        String result2 = myService.fetchData();
        assertEquals("secondCall", result2);
    }

    @Test
    public void testProcessAndSendAppendsProcessed() {
        // Stub sendData() to do nothing
        doNothing().when(externalApiMock).sendData(anyString());

        // Call method under test
        myService.processAndSend("inputVal");

        // Verify sendData was called with the processed value
        verify(externalApiMock).sendData("inputVal:processed");
    }
}
