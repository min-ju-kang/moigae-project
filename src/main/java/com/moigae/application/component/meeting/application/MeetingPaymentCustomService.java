package com.moigae.application.component.meeting.application;

import com.moigae.application.component.meeting_payment.domain.MeetingPayment;
import com.moigae.application.component.meeting_payment.repository.MeetingPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MeetingPaymentCustomService {

    private final MeetingPaymentRepository meetingPaymentRepository;

    public MeetingPayment fetchMeetingPaymentByUserId(String id) {
        List<MeetingPayment> meetingPayments = meetingPaymentRepository.findAll();
        return meetingPayments.stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getUser()))
                .filter(x -> id.equals(x.getUser().getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Matching user does not exist in meeting payment info, user id : " + id));
    }

}

