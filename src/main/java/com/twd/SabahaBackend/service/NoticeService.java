package com.twd.SabahaBackend.service;

import com.twd.SabahaBackend.dto.NoticeDto;

import java.util.List;

public interface NoticeService {
    NoticeDto createNotice(NoticeDto noticeDto);

    NoticeDto getNoticeById(Long NoticeId);

    List<NoticeDto> getAllNotices();

    NoticeDto updateNotice(Long noticeId,NoticeDto updatedNotice);

    void deleteNotice(Long NoticeId);
}
