package com.shuzijun.plantumlparser.core.refactoring;

import org.junit.Test;

import static org.junit.Assert.*;

public class PUmlIndentTest {

    @Test
    public void valueOf_depthが正_テスト() {
        assertEquals(new PUmlIndent(5), PUmlIndent.valueOf(5));
    }

    @Test
    public void valueOf_depthが0_テスト() {
        assertEquals(new PUmlIndent(0), PUmlIndent.valueOf(0));
    }

    @Test
    public void valueOf_depthが負_テスト() {
        assertEquals(new PUmlIndent(0), PUmlIndent.valueOf(-5));
    }

    @Test
    public void increment_テスト() {
        assertEquals(new PUmlIndent(6), PUmlIndent.valueOf(5).increment());
    }

    @Test
    public void getIndentAsString_depthが0_テスト() {
        assertEquals("", PUmlIndent.valueOf(0).getIndentAsString());
    }

    @Test
    public void getIndentAsString_depthが正_テスト() {
        assertEquals("\t\t\t", PUmlIndent.valueOf(3).getIndentAsString());
    }
}