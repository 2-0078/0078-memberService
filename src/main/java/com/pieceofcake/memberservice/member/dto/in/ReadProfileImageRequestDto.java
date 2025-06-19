package com.pieceofcake.memberservice.member.dto.in;

import com.pieceofcake.memberservice.member.vo.in.ReadProfileImageRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReadProfileImageRequestDto {
    private String memberUuid;

    @Builder
    public ReadProfileImageRequestDto(String memberUuid) {
        this.memberUuid = memberUuid;
    }

    public static ReadProfileImageRequestDto from(ReadProfileImageRequestVo readProfileImageRequestVo) {
        return new ReadProfileImageRequestDto(readProfileImageRequestVo.getMemberUuid());
    }
}
