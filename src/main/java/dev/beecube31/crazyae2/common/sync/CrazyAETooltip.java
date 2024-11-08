package dev.beecube31.crazyae2.common.sync;

import dev.beecube31.crazyae2.Tags;
import net.minecraft.util.text.translation.I18n;

public enum CrazyAETooltip {
    NOT_DEFINED,

    SHIFT_FOR_DETAILS,
    ENCODED_BY,
    AUTO_PICKUP,
    AUTO_PICKUP_TIP,
    AUTO_PICKUP_HOW_TO_ENABLE,

    MANA_CONNECTOR_BLOCK_LINKED,
    MANA_CONNECTOR_BLOCK_SAVED,
    MANA_CONNECTOR_CLEAR,

    ENABLED_LOWERCASE,
    DISABLED_LOWERCASE,
    ENABLED,
    DISABLED,

    PASSIVE_GENERATION_DAY,
    PASSIVE_GENERATION_NIGHT,
    MAX_SOLAR_CAPACITY,
    USE_NET_TOOL_TO_CONTROL_SOLARS,

    QUANTUM_WIRELESS_BOOSTER_DESC,
    MANA_CONNECTOR_DESC,
    MANA_CONNECTOR_LETS_CONNECT_TO_BUS,
    LINKED_WITH_MANA_POOL_AT_POS,

    QCM_DESC,
    QCM_DESC1,
    QCM_DESC2,

    CONNECTED_TO,
    NO_CONNECTION;


    private final String root;

    CrazyAETooltip() {
        this.root = "tooltip." + Tags.MODID;
    }

    CrazyAETooltip(String r) {
        this.root = r;
    }

    public String getLocal() {
        return I18n.translateToLocal(this.getUnlocalized().toLowerCase());
    }

    public String getLocalWithSpaceAtEnd() {
        return I18n.translateToLocal(this.getUnlocalized().toLowerCase()) + " ";
    }

    public String getUnlocalized() {
        return this.root + '.' + this + ".name";
    }
}
