package org.apache.commons.lang3.exception;

import org.junit.Test;

import static org.junit.Assert.*;

public class CloneFailedExceptionTest {

    @Test
    public void testMessageConstructor() {
        CloneFailedException e = new CloneFailedException("boom");
        assertEquals("boom", e.getMessage());
        assertNull(e.getCause());
    }

    @Test
    public void testCauseConstructor() {
        Throwable cause = new RuntimeException("root");
        CloneFailedException e = new CloneFailedException(cause);
        assertSame(cause, e.getCause());
    }

    @Test
    public void testMessageAndCauseConstructor() {
        Throwable cause = new RuntimeException("root");
        CloneFailedException e = new CloneFailedException("msg", cause);
        assertEquals("msg", e.getMessage());
        assertSame(cause, e.getCause());
    }
}
