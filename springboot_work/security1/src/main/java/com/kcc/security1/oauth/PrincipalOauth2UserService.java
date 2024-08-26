package com.kcc.security1.oauth;

import com.kcc.security1.auth.PrincipalDetails;
import com.kcc.security1.model.User;
import com.kcc.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    @Override
    public PrincipalDetails loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String provider = userRequest.getClientRegistration().getClientId();
        String providerId = oAuth2User.getAttribute("sub");
        String username = provider + "_" + providerId;
        String email = oAuth2User.getAttribute("email");
        String role = "ROLE_USER";
        Optional<User> user = userRepository.findByUsername(username);
        // 구글 로그인 버튼 클릭 -> 구글 로그인 창 -> 로그인 완료 -> Axccess Token 요청
        // userRequest 정보 -> loadUser 함수 호출 -> 구글로부터 회원 프로필 추출 -> 회원 가입 -> OAuth2User -> PrincipalDetails

        if (user.isEmpty()) {
            user = Optional.of(userRepository.save(new User(username, email, role, provider, providerId)));
        }

        return new PrincipalDetails(user.get(), oAuth2User.getAttributes());
    }
}
