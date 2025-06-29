package com.myorg.dn4;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Pass mock to service and call the method
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Step 3: Verify the interaction (was getData() called?)
        verify(mockApi).getData();
    }
}
