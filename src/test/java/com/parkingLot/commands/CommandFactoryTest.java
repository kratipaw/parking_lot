package com.parkingLot.commands;

import com.parkingLot.constants.Messages;
import com.parkingLot.exceptions.InvalidCommand;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandFactoryTest {

    @Test
    public void invalidCommand(){
        try {
            String[] cmdTokens = {"invalid_command"};
            CommandFactory.generateCommand(cmdTokens);
        } catch (Exception e) {
            assertEquals(e.getClass(), InvalidCommand.class);
            assertEquals(Messages.INVALID_COMMAND, e.getMessage());
        }
    }

    @Test
    public void validCommand(){
        try {
            String[] cmdTokens = {"create_parking_lot"};
            CommandFactory.generateCommand(cmdTokens);
        } catch (Exception e) {
            fail();
        }
    }
}