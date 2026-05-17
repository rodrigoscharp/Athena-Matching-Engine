package com.athena.trading.domain;

/**
 * Whether an order intends to buy or sell the instrument.
 *
 * <p>Stored as a single character in the persistence layer ('B'/'S') to minimize storage and keep
 * the domain model self-contained.
 */
public enum OrderSide {
  BUY,
  SELL;

  public boolean isBuy() {
    return this == BUY;
  }

  public boolean isSell() {
    return this == SELL;
  }

  public OrderSide opposite() {
    return this == BUY ? SELL : BUY;
  }
}
