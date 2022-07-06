package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{

    private int[] decrementArray;

    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);

        decrementArray = new int[capacity];
    }

    @Override
    public void setCarouselDecrement(int index) {
        decrementArray[index]++;
        int temp = this.carousel[index] - decrementArray[index];

        if (temp <= 0) {
            this.carousel[index] = 0;
        }
        else {
            this.carousel[index] = temp;
        }
    }
}
