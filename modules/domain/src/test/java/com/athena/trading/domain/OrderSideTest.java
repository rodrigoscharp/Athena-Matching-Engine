package com.athena.trading.domain;

import static org.assertj.core.api.Assertions.assertThat;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

class OrderSideTest {

  @Test
  void should_identify_buy_side() {
    assertThat(OrderSide.BUY.isBuy()).isTrue();
    assertThat(OrderSide.BUY.isSell()).isFalse();
  }

  @Test
  void should_identify_sell_side() {
    assertThat(OrderSide.SELL.isSell()).isTrue();
    assertThat(OrderSide.SELL.isBuy()).isFalse();
  }

  @Test
  void should_return_correct_opposite() {
    assertThat(OrderSide.BUY.opposite()).isEqualTo(OrderSide.SELL);
    assertThat(OrderSide.SELL.opposite()).isEqualTo(OrderSide.BUY);
  }

  @Property
  void opposite_is_involution(@ForAll OrderSide side) {
    assertThat(side.opposite().opposite()).isEqualTo(side);
  }

  @Property
  void side_and_opposite_are_never_equal(@ForAll OrderSide side) {
    assertThat(side).isNotEqualTo(side.opposite());
  }
}
