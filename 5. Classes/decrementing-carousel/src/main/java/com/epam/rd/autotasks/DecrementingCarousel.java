package com.epam.rd.autotasks;

public class DecrementingCarousel {
    private int [] carousel;
    int currentIndex = 0;
    private boolean isEnable;

    public DecrementingCarousel(int capacity) {
        carousel = new int[capacity];
        isEnable = true;
    }

    public boolean addElement(int element) {
        if (element <= 0 || !isEnable) {
            return false;
        }

        if (currentIndex >= carousel.length) {
            return false;
        }

        carousel[currentIndex] = element;
        currentIndex++;

        return true;
    }

    public CarouselRun run() {
        if (!isEnable) {
            return null;
        }

        isEnable = false;
        return new CarouselRun(this);
    }

    public int[] getCarousel() {
        return carousel;
    }

    public int getCapacity() {
        return this.carousel.length;
    }

    public void setCarouselDecrement(int index) {
        this.carousel[index]--;
    }
}
