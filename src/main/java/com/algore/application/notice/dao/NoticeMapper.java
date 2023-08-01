package com.algore.application.notice.dao;

import com.algore.application.notice.dto.NoticeDTO;
import com.algore.application.notice.dto.NoticeDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeDTO> noticeList();

    NoticeDetailDTO detailRead(int notiNum);

    int writeNotice(NoticeDetailDTO noticeDetailDTO);

    int modifyNotice(NoticeDetailDTO noticeDetailDTO);

    int deleteNotice(int notiNum);
}
