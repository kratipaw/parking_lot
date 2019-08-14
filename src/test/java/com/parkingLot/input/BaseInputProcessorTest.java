package com.parkingLot.input;

import com.parkingLot.exceptions.InvalidCommand;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

public class BaseInputProcessorTest {

    @Test
    public void invalidInputLine()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CommandLineInputProcessor input = new CommandLineInputProcessor(br);
        try
        {
            input.processInputLine(null);
        }
        catch (Exception e)
        {
            assertEquals(e.getClass(), InvalidCommand.class);
        }
        try
        {
            input.processInputLine("");
        }
        catch (Exception e)
        {
            assertEquals(e.getClass(), InvalidCommand.class);
        }
    }

    @Test
    public void invalidCommand()
    {
        String invalidInput = "invalid";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CommandLineInputProcessor input = new CommandLineInputProcessor(br);
        try
        {
            input.processInputLine(invalidInput);
        }
        catch (Exception e)
        {
            assertEquals(e.getClass(), InvalidCommand.class);
        }
    }

}