package com.github.marcellodesales.advanced.algebricdatatype;

import java.math.BigDecimal;

/**
 * The record DiscountOrderLine is part of the limitation of the SealedOrderLine in the type structure while
 * the Discount code is the limitation of the Value type (Enums)
 */
public record DiscountOrderLine(DiscountCode discountCode, BigDecimal amount) implements SealedOrderLine {
}
