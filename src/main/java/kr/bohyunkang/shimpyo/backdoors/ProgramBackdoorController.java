package kr.bohyunkang.shimpyo.backdoors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/backdoor")
@Transactional
public class ProgramBackdoorController {
    private JdbcTemplate jdbcTemplate;

    public ProgramBackdoorController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/setup-program")
    public String setupDatabase() {
        LocalDateTime now = LocalDateTime.now();

        jdbcTemplate.execute("DELETE FROM program");

        // TEMPLE
        jdbcTemplate.update("" +
                "INSERT INTO program(id, location, title, price, address, " +
                "category, created_at, updated_at) " +
                "VALUES (1, '백련사', '따뜻한 위로의 차담, 만덕산 옛길 산책', 70000, " +
                "'전라남도 강진군 도암면 백련사길 145', " +
                "'TEMPLE', ?, ?)", now.minusDays(1), now.minusDays(1)
        );

        jdbcTemplate.update("" +
                "INSERT INTO program(id, location, title, price, address, " +
                "category, created_at, updated_at) " +
                "VALUES (2, '구인사', '깨어있는 휴식, 여러가지 명상 체험', 50000, " +
                "'충청북도 단양군 영춘면 구인사길 73', " +
                "'TEMPLE', ?, ?)", now.minusDays(1).plusHours(1), now.minusDays(1).plusHours(1)
        );

        jdbcTemplate.update("" +
                "INSERT INTO program(id, location, title, price, address, " +
                "category, created_at, updated_at) " +
                "VALUES (3, '백양사', '고즈넉한 풍경, 타종 체험, 외국인 가능', 70000, " +
                "'전라남도 장성군 북하면 백양로 1239', " +
                "'TEMPLE', ?, ?)", now.minusDays(1).plusHours(2), now.minusDays(1).plusHours(2)
        );

        // TODO: 다른 카테고리들도 추가 필요

        //    FARM


        //    RELAX


        //    EXPERIENCE


        //    ONE_DAY

        return "Insert programs completed!";
    }
}
