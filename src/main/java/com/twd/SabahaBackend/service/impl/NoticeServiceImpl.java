package com.twd.SabahaBackend.service.impl;

import lombok.AllArgsConstructor;
import com.twd.SabahaBackend.dto.NoticeDto;
import com.twd.SabahaBackend.entity.Notice;
import com.twd.SabahaBackend.exception.ResourceNotFoundException;
import com.twd.SabahaBackend.mapped.NoticeMapped;
import com.twd.SabahaBackend.repository.NoticeRepo;
import com.twd.SabahaBackend.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepo noticeRepository;

    @Override
    public NoticeDto createNotice(NoticeDto noticeDto) {
        Notice notice = NoticeMapped.mapToNotice(noticeDto);
        Notice savedNotice = noticeRepository.save(notice);

        return NoticeMapped.mapToNoticeDto(savedNotice);
    }

    @Override
    public NoticeDto getNoticeById(Long noticeId) {
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new ResourceNotFoundException("Notice does not exist with given ID: " + noticeId));

        return NoticeMapped.mapToNoticeDto(notice);
    }

    @Override
    public List<NoticeDto> getAllNotices() {
        List<Notice> notices = noticeRepository.findAll();
        return notices.stream().map(NoticeMapped::mapToNoticeDto)
                .collect(Collectors.toList());
    }

    @Override
    public NoticeDto updateNotice(Long noticeId, NoticeDto updatedNotice) {
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(
                () -> new ResourceNotFoundException("Notice does not exist with given ID: " + noticeId)
        );
        notice.setTopic(updatedNotice.getTopic());
        notice.setDate(updatedNotice.getDate());
        notice.setUrl(updatedNotice.getUrl());

        Notice updatedNoticeObj = noticeRepository.save(notice);

        return NoticeMapped.mapToNoticeDto(updatedNoticeObj);
    }

    @Override
    public void deleteNotice(Long noticeId) {
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(
                () -> new ResourceNotFoundException("Notice does not exist with given ID: " + noticeId)
        );
        noticeRepository.deleteById(noticeId);
    }
}
