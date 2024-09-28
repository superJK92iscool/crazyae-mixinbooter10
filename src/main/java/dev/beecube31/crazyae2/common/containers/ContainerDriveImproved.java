package dev.beecube31.crazyae2.common.containers;

import appeng.container.AEBaseContainer;
import appeng.container.slot.SlotRestrictedInput;
import dev.beecube31.crazyae2.common.tile.storage.TileImprovedDrive;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerDriveImproved extends AEBaseContainer {

    public ContainerDriveImproved(final InventoryPlayer ip, final TileImprovedDrive drive) {
        super(ip, drive, null);

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 6; x++) {
                this.addSlotToContainer(new SlotRestrictedInput(SlotRestrictedInput.PlacableItemType.STORAGE_CELLS, drive
                        .getInternalInventory(), x + y * 6, 36 + x * 18, 18 + y * 18, this.getInventoryPlayer()));
            }
        }

        this.bindPlayerInventory(ip, 0, 199 - /* height of player inventory */82);
    }
}