package com.algore.application.notice.service;

import com.algore.application.notice.dao.NoticeMapper;
import com.algore.application.notice.dto.NoticeDTO;
import com.algore.application.notice.dto.NoticeDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public NoticeService(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public List<NoticeDTO> noticeList() {
        List<NoticeDTO> noticeDTO = noticeMapper.noticeList();
        System.out.println(noticeDTO);
        return noticeDTO;
    }

    public NoticeDetailDTO detailRead(int notiNum) {

        NoticeDetailDTO noticeDetailDTO = noticeMapper.detailRead(notiNum);
        return noticeDetailDTO;
    }

    public int writeNotice(NoticeDetailDTO noticeDetailDTO) {
        int reuslt = noticeMapper.writeNotice(noticeDetailDTO);
        return reuslt;
    }
}
