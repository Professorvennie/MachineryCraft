package com.professorvennie.machinerycraft.api.tileentity;

import com.professorvennie.machinerycraft.client.gui.buttons.enums.RedStoneMode;

/**
 * Created by ProfessorVennie on 9/27/2014 at 1:24 PM.
 */
public interface IRedstoneControlable {

    public RedStoneMode getRedStoneMode();

    public void setRedstoneMode(RedStoneMode mode);
}
