package com.parkingLot.commands;

import com.parkingLot.constants.Commands;
import com.parkingLot.constants.Messages;
import com.parkingLot.exceptions.InvalidCommand;

public class CommandFactory {

    public static BaseCommand generateCommand(String[] cmdTokens) throws Exception {

        BaseCommand out;

        Commands command = Commands.getEnumByCommand(cmdTokens[0]);

        if (command == null)
            throw new InvalidCommand(Messages.INVALID_COMMAND);

        switch (command) {

            case CREATE_PARKING_LOT:
                out = new CreateParkingLotCommand();
                break;
            case PARK:
                out = new ParkCommand();
                break;

            case STATUS:
                out = new StatusCommand();
                break;

            case LEAVE:
                out = new LeaveCommand();
                break;

            case GET_SLOT_NUM_FROM_REG_NUM:
                out = new SlotNumForGivenRegNumCommand();
                break;

            case GET_SLOT_NUM_FROM_COLOR:
                out = new SlotNumsForCarsWithGivenColorCommand();
                break;

            case GET_REG_NUM_FROM_COLOR:
                out = new RegNumForCarsWithGivenColorCommand();
                break;
            case EXIT:
                System.exit(0);

            default:
                throw new InvalidCommand(Messages.INVALID_COMMAND);
        }

        return out;
    }
}
