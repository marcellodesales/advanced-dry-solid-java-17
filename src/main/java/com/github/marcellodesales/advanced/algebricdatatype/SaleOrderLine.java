package com.github.marcellodesales.advanced.algebricdatatype;

import com.github.marcellodesales.advanced.records.Product;

import java.math.BigDecimal;

public record SaleOrderLine(Product product, int quantity, BigDecimal amount) implements SealedOrderLine {
}
