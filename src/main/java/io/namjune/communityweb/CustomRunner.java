package io.namjune.communityweb;

import io.namjune.communityweb.domain.Board;
import io.namjune.communityweb.domain.User;
import io.namjune.communityweb.domain.enums.BoardType;
import io.namjune.communityweb.repository.BoardRepository;
import io.namjune.communityweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.IntStream;


@RequiredArgsConstructor
@Component
public class CustomRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.save(User.builder()
                .name("NJ")
                .password("1234")
                .email("namjunemy@gmail.com")
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
