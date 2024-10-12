package com.twd.SabahaBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NoticeDto {
    private Long id;
    private String date;
    private String topic;
    private String url;
}
