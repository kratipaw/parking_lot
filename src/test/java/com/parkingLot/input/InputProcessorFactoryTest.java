package com.parkingLot.input;

import org.junit.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class InputProcessorFactoryTest {

    @Test
    public void getCommandLineInput()
    {
        try
        {
            BaseInputProcessor input = InputProcessorFactory.getInputProcessor(null);
            assertNotNull(input);
            assertEquals(input.getClass(), CommandLineInputProcessor.class);
        }
        catch (Exception e)
        {
            fail();
        }
    }

    @Test
    public void getFileInput()
    {
        try
        {
            File inputFile = new File("valid.txt");
            inputFile.delete();
            if(inputFile.createNewFile())
            {
                String[] args = new String[1];
                args[0] = "valid.txt";
                BaseInputProcessor input = InputProcessorFactory.getInputProcessor(inputFile);
                assertNotNull(input);
                assertEquals(input.getClass(), FileInputProcessor.class);
                inputFile.delete();
            }
            else
            {
                fail();
            }
        }
        catch (Exception e)
        {
            fail();
        }
    }

}