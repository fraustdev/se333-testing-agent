package org.apache.commons.lang3.concurrent;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConcurrentExceptionTest {

    @Test
    public void testCheckedCause() {
        Exception cause = new Exception("checked");
        ConcurrentException ex = new ConcurrentException(cause);
        assertNotNull(ex.getCause());
        assertEquals(cause, ex.getCause());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRuntimeCauseThrows() {
        RuntimeException re = new RuntimeException("runtime");
        new ConcurrentException(re);
    }

    @Test
    public void testMessageAndCause() {
        Exception cause = new Exception("checked");
        ConcurrentException ex = new ConcurrentException("msg", cause);
        assertEquals("msg", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }
}
