package com.moigae.application.component.meeting.domain;

import com.moigae.application.component.meeting.domain.enumeraion.*;
import com.moigae.application.component.meeting_image.domain.MeetingImage;
import com.moigae.application.component.user.domain.User;
import com.moigae.application.component.user.domain.enumeration.Gender;
import com.moigae.application.component.user.domain.enumeration.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MeetingSymTest {
    private static final String PHONE = "010";
    private static final String EMAIL = "email";
    private ParticipantRange participantRange;
    private MeetingAddress meetingAddress;
    private MeetingContact meetingContact;
    private MeetingImage meetingImage;
    private MeetingType meetingType = MeetingType.ONLINE;
    private MeetingCategory meetingCategory = MeetingCategory.PARTY;
    private MeetingPrice meetingPrice = MeetingPrice.PAY;
    private PetAllowedStatus petAllowedStatus = PetAllowedStatus.WITH_OUT;
    private MeetingStatus meetingStatus = MeetingStatus.AVAILABLE;
    private User user;
    private Meeting meeting;

    @BeforeEach
    void setUp() {
        user = createUser();
        meeting = createMeeting();
    }

    @Test
    @DisplayName("관심 모임 생성 테스트")
    void 관심_모임_생성_테스트() {
        //given & when
        MeetingSym meetingSym = new MeetingSym(meeting, user, true);
        //then
        assertThat(meetingSym.isSym()).isTrue();
        assertThat(meetingSym.getMeeting().getMeetingTitle()).isEqualTo("타이틀");
        assertThat(meetingSym.getUser().getUserName()).isEqualTo("홍정완");
    }

    private User createUser() {
        return User.builder()
                .userName("홍정완")
                .password("패스워드")
                .gender(Gender.MAN)
                .phone(PHONE)
                .account("계좌")
                .hostIntroduction("호스트 자기소개")
                .email(EMAIL)
                .userRole(UserRole.USER)
                .flag(true)
                .deactivateAt(null)
                .build();
    }

    private Meeting createMeeting() {
        return Meeting.builder()
                .meetingTitle("타이틀")
                .meetingType(meetingType)
                .meetingCategory(meetingCategory)
                .nickName("닉네임")
                .meetingImage(meetingImage)
                .meetingDescription("모임 소개")
                .participantRange(participantRange)
                .meetingAddress(meetingAddress)
                .meetingPrice(meetingPrice)
                .petAllowedStatus(petAllowedStatus)
                .meetingContact(meetingContact)
                .meetingFreeFormDetails("모임 정보 자유 작성")
                .meetingStatus(meetingStatus)
                .build();
    }
}