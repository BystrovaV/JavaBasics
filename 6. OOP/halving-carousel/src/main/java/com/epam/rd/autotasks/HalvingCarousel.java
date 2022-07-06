package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public void setCarouselDecrement(int index) {
        this.carousel[index] /= 2;
    }
}
