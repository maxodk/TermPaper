package command;

import data.EquipmentData;
import data.KnightData;
import data.WeaponData;

public interface InterfaceConsole {
    public CommandResult<String> execute() throws Exception;
}


