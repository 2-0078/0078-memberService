package com.pieceofcake.memberservice.member.dto.in;


import com.pieceofcake.memberservice.member.dto.out.FindEmailResponseDto;
import com.pieceofcake.memberservice.member.vo.in.FindEmailRequestVo;
import com.pieceofcake.memberservice.member.vo.out.FindEmailResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
public class FindEmailRequestDto {

    private String name;
    private String phoneNumber;
    private String birthdate;

    @Builder
    public FindEmailRequestDto(String name, String phoneNumber, String birthdate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
    }

    public static FindEmailRequestDto from(FindEmailRequestVo findEmailRequestVo) {
        return FindEmailRequestDto.builder()
                .name(findEmailRequestVo.getName())
                .phoneNumber(findEmailRequestVo.getPhoneNumber())
                .birthdate(findEmailRequestVo.getBirthdate())
                .build();
    }

    public FindEmailResponseVo toVo(FindEmailResponseDto findEmailResponseDto) {
        return FindEmailResponseVo.builder()
                .email(findEmailResponseDto.getEmail())
                .build();
    }
}
