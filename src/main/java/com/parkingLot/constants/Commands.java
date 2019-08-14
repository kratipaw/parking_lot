package com.parkingLot.constants;

public enum Commands {

    CREATE_PARKING_LOT("create_parking_lot"),
    PARK("park"),
    STATUS("status"),
    LEAVE("leave"),
    GET_SLOT_NUM_FROM_REG_NUM("slot_number_for_registration_number"),
    GET_SLOT_NUM_FROM_COLOR("slot_numbers_for_cars_with_colour"),
    GET_REG_NUM_FROM_COLOR("registration_numbers_for_cars_with_colour"),
    EXIT("exit");

    private String command;

    public String getCommand() {
        return this.command;
    }

    Commands(String command) {
        this.command = command;
    }

    public static Commands getEnumByCommand(String command) {
        for (Commands cmd : values()) {
            if (cmd.getCommand().equalsIgnoreCase(command))
                return cmd;
        }

        return null;
    }
}
