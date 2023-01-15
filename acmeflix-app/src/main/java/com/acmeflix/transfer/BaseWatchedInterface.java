package com.acmeflix.transfer;

public interface BaseWatchedInterface extends Comparable<BaseWatchedInterface> {
    Integer getCounter();

    @Override
    public default int compareTo(BaseWatchedInterface a) {
        return a.getCounter() - this.getCounter();
    }
}
