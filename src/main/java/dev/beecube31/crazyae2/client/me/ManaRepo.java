package dev.beecube31.crazyae2.client.me;

import appeng.api.storage.data.IAEItemStack;
import appeng.api.storage.data.IItemList;
import appeng.client.gui.widgets.IScrollSource;
import appeng.core.Api;
import dev.beecube31.crazyae2.core.api.storage.IManaStorageChannel;

import java.util.ArrayList;

public class ManaRepo {
    private final IItemList<IAEItemStack> list = Api.INSTANCE.storage().getStorageChannel(IManaStorageChannel.class).createList();
    private final ArrayList<IAEItemStack> view = new ArrayList<>();
    private final IScrollSource src;

    private int rowSize = 9;

    private boolean hasPower;

    public ManaRepo(IScrollSource src) {
        this.src = src;
    }

    public void updateView() {
        this.view.clear();
        this.view.ensureCapacity(this.list.size());
        for (IAEItemStack fs : this.list) {
            this.view.add(fs);
        }
    }

    public void postUpdate(final IAEItemStack is) {
        final IAEItemStack st = this.list.findPrecise(is);

        if (st != null) {
            st.reset();
            st.add(is);
        } else {
            this.list.add(is);
        }
    }

    public IAEItemStack getReferenceItem(int idx) {
        idx += this.src.getCurrentScroll() * this.rowSize;

        if (idx >= this.view.size()) {
            return null;
        }
        return this.view.get(idx);
    }

    public int size() {
        return this.view.size();
    }

    public void clear() {
        this.list.resetStatus();
    }

    public boolean hasPower() {
        return this.hasPower;
    }

    public void setPower(final boolean hasPower) {
        this.hasPower = hasPower;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public void setRowSize(final int rowSize) {
        this.rowSize = rowSize;
    }

}