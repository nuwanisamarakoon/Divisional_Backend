package com.twd.SabahaBackend.mapped;

import com.twd.SabahaBackend.dto.NoticeDto;
import com.twd.SabahaBackend.entity.Notice;

public class NoticeMapped {
    public static NoticeDto mapToNoticeDto(Notice notice){
        return new NoticeDto(
                notice.getId(),
                notice.getDate(),
                notice.getTopic(),
                notice.getUrl()
        );
    }

    public static Notice mapToNotice(NoticeDto noticeDto){
        return new Notice(
                noticeDto.getId(),
                noticeDto.getDate(),
                noticeDto.getTopic(),
                noticeDto.getUrl()
        );
    }

}