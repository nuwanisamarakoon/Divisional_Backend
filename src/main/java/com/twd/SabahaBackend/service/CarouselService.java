package com.twd.SabahaBackend.service;

import com.twd.SabahaBackend.dto.CarouselDto;

import java.util.List;

public interface CarouselService {
    CarouselDto createCarousel(CarouselDto CarouselDto);

    CarouselDto getCarouselById(Long CarouselId);

    List<CarouselDto> getAllCarousels();

    CarouselDto updateCarousels(Long carouselId,CarouselDto updatedCarousel);

    void deleteCarousel(Long CarouselId);
}
