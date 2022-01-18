package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculateOrderTest {

    @Test
    fun test_get_next_calculate_order_from_number_first() {
        assertThat(CalculateOrder.NUMBER_FIRST.getNextCalculateOrder()).isEqualTo(CalculateOrder.OPERATION)
    }

    @Test
    fun test_get_next_calculate_order_from_number_operation() {
        assertThat(CalculateOrder.OPERATION.getNextCalculateOrder()).isEqualTo(CalculateOrder.NUMBER_SECOND)
    }

    @Test
    fun test_get_next_calculate_order_from_number_second() {
        assertThat(CalculateOrder.NUMBER_SECOND.getNextCalculateOrder()).isEqualTo(CalculateOrder.OPERATION)
    }
}
