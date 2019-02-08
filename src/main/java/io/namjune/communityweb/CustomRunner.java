package io.namjune.communityweb;

import io.namjune.communityweb.domain.Board;
import io.namjune.communityweb.domain.User;
import io.namjune.communityweb.domain.enums.BoardType;
import io.namjune.communityweb.repository.BoardRepository;
import io.namjune.communityweb.repository.UserRepository;
import io.namjune.communityweb.resolver.UserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;


@RequiredArgsConstructor
@Component
public class CustomRunner implements CommandLineRunner, WebMvcConfigurer {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final UserArgumentResolver userArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.save(User.builder()
                .name("havi")
                .password("test")
                .email("havi@gmail.com")
                .createdDate(LocalDateTime.now())
                .build());

        IntStream.rangeClosed(1, 200).forEach(index ->
                boardRepository.save(Board.builder()
                        .title("게시글" + index)
                        .subTitle("순서" + index)
                        .content("컨텐츠")
                        .boardType(BoardType.free)
                        .createdDate(LocalDateTime.now())
                        .updatedDate(LocalDateTime.now())
                        .user(user).build())
        );
    }
}
