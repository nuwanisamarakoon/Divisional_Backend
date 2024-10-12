package com.twd.SabahaBackend.mapped;

import com.twd.SabahaBackend.dto.CarouselDto;
import com.twd.SabahaBackend.entity.Carousel;

public class CarouselMapped {
    public static CarouselDto mapToCarouselDto(Carousel carousel){
        return new CarouselDto(
                carousel.getId(),
                carousel.getUrl()
        );
    }

    public static Carousel mapToCarousel(CarouselDto carouselDto){
        return new Carousel(
                carouselDto.getId(),
                carouselDto.getUrl()
        );
    }
}