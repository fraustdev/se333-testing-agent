package org.apache.commons.lang3.text.translate;

import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.*;

public class JavaUnicodeEscaperTest {

    @Test
    public void testSurrogatePairEscape() throws Exception {
        JavaUnicodeEscaper esc = JavaUnicodeEscaper.between(0, Integer.MAX_VALUE);
        StringWriter w = new StringWriter();
        boolean translated = esc.translate(0x1F600, w); // 😀
        assertTrue(translated);
        assertEquals("\\uD83D\\uDE00", w.toString());
    }

    @Test
    public void testBasicEscape() throws Exception {
        JavaUnicodeEscaper esc = JavaUnicodeEscaper.between(0, Integer.MAX_VALUE);
        StringWriter w = new StringWriter();
        boolean translated = esc.translate('A', w);
        assertTrue(translated);
        assertEquals("\\u0041", w.toString());
    }
}
