package com.acmeflix.transfer;

import com.acmeflix.domain.enumeration.Category;

public interface BaseWatchedInterface extends Comparable<BaseWatchedInterface> {
    Integer getCounter();

    Category getCategory();

    @Override
    public default int compareTo(BaseWatchedInterface a) {
        return a.getCounter() - this.getCounter();
    }
}
