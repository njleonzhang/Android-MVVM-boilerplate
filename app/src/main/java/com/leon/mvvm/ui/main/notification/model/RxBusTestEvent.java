package com.leon.mvvm.ui.main.notification.model;

public class RxBusTestEvent {
    private int removeIndex;

    public RxBusTestEvent(int removeIndex) {
        this.removeIndex = removeIndex;
    }

    public int getRemoveIndex() {
        return removeIndex;
    }

    public RxBusTestEvent setRemoveIndex(int removeIndex) {
        this.removeIndex = removeIndex;
        return this;
    }
}
