package com.epam.rd.autotasks;

public class CarouselRun {
    private final DecrementingCarousel carousel;
    private int currentElement = 0;

    public CarouselRun(DecrementingCarousel carousel) {
        this.carousel = carousel;
    }

    public int next() {
        int value;

        do {
            value = carousel.getCarousel()[currentElement];
            if (value != 0) {
                carousel.setCarouselDecrement(currentElement);
                currentElement++;
                if (currentElement == carousel.getCapacity()) {
                    currentElement = 0;
                }

                break;
            }

            if (getNumberOfZeros() == carousel.getCapacity()) {
                value = -1;
                break;
            }

            currentElement++;
            if (currentElement == carousel.getCapacity()) {
                currentElement = 0;
            }

        } while (true);

        return value;
    }

    public boolean isFinished() {
        return getNumberOfZeros() == carousel.getCapacity();
    }

    private int getNumberOfZeros() {
        int numberOfZeros = 0;
        for (int value: carousel.getCarousel()) {
            if (value == 0) {
                numberOfZeros++;
            }
        }

        return numberOfZeros;
    }

}
