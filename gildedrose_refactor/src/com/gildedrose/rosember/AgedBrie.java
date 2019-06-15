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
public class AgedBrie implements Strategy{
    @Override
    public void upgrade(Item item) {
        item.setSellIn(item.getSellIn() - 1);
        improvqQuality(item);
        if (item.getSellIn() < 0) {
            improvqQuality(item);
        }
    }
    
    protected void improvqQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }
}
