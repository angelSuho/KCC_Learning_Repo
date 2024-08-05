package kosa.mapper;

import kosa.model.Member;

public interface MemberMapper {
	int insertMember(Member member);
	Member loginMember(String userId);
}
