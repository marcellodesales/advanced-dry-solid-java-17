package com.github.marcellodesales.advanced.algebricdatatype;

import java.util.List;

public record AlgebricOrder(List<SealedOrderLine> orderLines) {

    public AlgebricOrder {
        orderLines = List.copyOf(orderLines);
    }
}
