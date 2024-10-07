package dev.beecube31.crazyae2.common.containers;

import appeng.api.config.SecurityPermissions;
import appeng.api.config.Settings;
import appeng.api.config.YesNo;
import appeng.api.util.IConfigManager;
import appeng.container.guisync.GuiSync;
import appeng.container.slot.IOptionalSlotHost;
import appeng.container.slot.OptionalSlotRestrictedInput;
import appeng.container.slot.SlotOversized;
import appeng.container.slot.SlotRestrictedInput;
import dev.beecube31.crazyae2.common.duality.PatternsInterfaceDuality;
import dev.beecube31.crazyae2.common.interfaces.ICrazyAEPatternsInterface;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerPatternsInterface extends ContainerCrazyAEUpgradeable implements IOptionalSlotHost {

    private final PatternsInterfaceDuality myDuality;

    @GuiSync(3)
    public YesNo bMode = YesNo.NO;

    @GuiSync(4)
    public YesNo iTermMode = YesNo.YES;

    public ContainerPatternsInterface(final InventoryPlayer ip, final ICrazyAEPatternsInterface te) {
        super(ip, te.getInterfaceDuality().getHost());

        this.myDuality = te.getInterfaceDuality();

        for (int row = 0; row < 8; ++row) {
            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new OptionalSlotRestrictedInput(SlotRestrictedInput.PlacableItemType.ENCODED_PATTERN, this.myDuality
                        .getPatterns(), this, x + row * 9, 8 + 18 * x, 25 + (18 * row), row, this.getInventoryPlayer()).setStackLimit(1));
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < 3; x++) {
                this.addSlotToContainer(new SlotOversized(this.myDuality.getStorage(), x + i * 3, 186 + (18 * x), 92 + (18 * i)));
            }
        }
    }

    @Override
    protected int getHeight() {
        return 256;
    }

    @Override
    protected void setupConfig() {
        this.setupUpgrades();
    }

    @Override
    public int availableUpgrades() {
        return 4;
    }

    @Override
    public boolean isSlotEnabled(final int idx) {
        return true;
    }

    @Override
    public void detectAndSendChanges() {
        this.verifyPermissions(SecurityPermissions.BUILD, false);
        super.detectAndSendChanges();
    }

    @Override
    public void onUpdate(final String field, final Object oldValue, final Object newValue) {
        super.onUpdate(field, oldValue, newValue);
    }

    @Override
    protected void loadSettingsFromHost(final IConfigManager cm) {
        this.setBlockingMode();
        this.setInterfaceTerminalMode((YesNo) cm.getSetting(Settings.INTERFACE_TERMINAL));
    }

    public YesNo getBlockingMode() {
        return this.bMode;
    }

    private void setBlockingMode() {
        this.bMode = YesNo.NO;
    }

    public YesNo getInterfaceTerminalMode() {
        return this.iTermMode;
    }

    private void setInterfaceTerminalMode(final YesNo iTermMode) {
        this.iTermMode = iTermMode;
    }

}