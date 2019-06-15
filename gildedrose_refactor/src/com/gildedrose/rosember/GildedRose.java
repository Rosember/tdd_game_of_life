/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose.rosember;

/**
 *
 * @author rcarrasco
 */
public class GildedRose {
    final Item[] items;
    private Strategy strategy;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            if (item.getName().equals("Aged Brie")) {
                strategy = new AgedBrie();
                strategy.upgrade(item);
            } else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                strategy = new Backstage();
                strategy.upgrade(item);
            } else {
                strategy = new NormalItem();
                strategy.upgrade(item);
            }
        }
    }
}
