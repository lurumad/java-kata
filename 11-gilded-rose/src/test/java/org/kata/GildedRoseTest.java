package org.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {

//    @Test
//    void an_item_name_does_not_change_when_name_is_foo() {
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("foo", app.items[0].name);
//    }
//
//    @Test
//    void an_error_happens_when_name_is_null() {
//        Item[] items = new Item[] { new Item(null, 0, 0) };
//        GildedRose app = new GildedRose(items);
//        assertThrows(NullPointerException.class, app::updateQuality);
//    }
//
//    @Test
//    void an_item_name_does_not_change_when_name_is_empty() {
//        Item[] items = new Item[] { new Item("", 0, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("", app.items[0].name);
//    }
//
//    @ParameterizedTest
//    @MethodSource("sellInDecrease")
//    void when_update_quality_sellin_decrease_by_one(int sellIn, int expectedSellIn) {
//        Item[] items = new Item[] { new Item("foo", sellIn, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(expectedSellIn, app.items[0].sellIn);
//    }
//
//    @Test
//    void foo() {
//        Item[] items = new Item[] { new Item("foo", 1, 1) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(0, app.items[0].sellIn);
//    }
//
//    private static Stream<Arguments> sellInDecrease() {
//        return Stream.of(
//                Arguments.of(1, 0),
//                Arguments.of(2, 1),
//                Arguments.of(0, -1),
//                Arguments.of(-1, -2)
//        );
//    }
}