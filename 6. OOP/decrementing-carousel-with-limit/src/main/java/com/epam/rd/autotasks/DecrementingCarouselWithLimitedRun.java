package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{

    private int leftLimit;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);

        leftLimit = actionLimit;
    }

    @Override
    public void setCarouselDecrement(int index) {
        if (leftLimit != 0){
            carousel[index]--;
            leftLimit--;
        }

        if (leftLimit == 0) {
            setAllZero();
        }
    }

    private void setAllZero() {
        for (int i = 0; i < this.getCapacity(); i++) {
            carousel[i] = 0;
        }
    }
}
