package org.common;

import static org.junit.Assert.assertTrue;

import org.common.idgen.IdGenerate;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public static void main(String[] args) {

    }
    @Test
    public void testNextCode(){ System.out.println( IdGenerate.nextCode("用户99"));}

}
