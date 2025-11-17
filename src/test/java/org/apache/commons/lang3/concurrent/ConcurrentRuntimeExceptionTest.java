package org.apache.commons.lang3.concurrent;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConcurrentRuntimeExceptionTest {

    @Test
    public void testCheckedCause() {
        Exception cause = new Exception("checked");
        ConcurrentRuntimeException ex = new ConcurrentRuntimeException(cause);
        assertNotNull(ex.getCause());
        assertEquals(cause, ex.getCause());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRuntimeCauseThrows() {
        RuntimeException re = new RuntimeException("runtime");
        new ConcurrentRuntimeException(re);
    }

    @Test
    public void testMessageAndCause() {
        Exception cause = new Exception("checked");
        ConcurrentRuntimeException ex = new ConcurrentRuntimeException("msg", cause);
        assertEquals("msg", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }
}
