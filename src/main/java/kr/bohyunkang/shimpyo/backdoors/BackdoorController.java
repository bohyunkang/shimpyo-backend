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
public class BackdoorController {
    private JdbcTemplate jdbcTemplate;

    public BackdoorController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/reset-database")
    public String resetDatabase() {
        jdbcTemplate.execute("DELETE FROM program_offers");
        jdbcTemplate.execute("DELETE FROM program_rules");
        jdbcTemplate.execute("DELETE FROM program");
        jdbcTemplate.execute("DELETE FROM place");

        return "Reset programs completed!";
    }

    @GetMapping("/setup-program")
    public String setupProgramAndPlace() {
        LocalDateTime now = LocalDateTime.now();

        jdbcTemplate.execute("DELETE FROM program_offers");
        jdbcTemplate.execute("DELETE FROM program_rules");
        jdbcTemplate.execute("DELETE FROM program");
        jdbcTemplate.execute("DELETE FROM place");

        // TEMPLE
        jdbcTemplate.update("" +
                        "INSERT INTO place(id, name, address, phone_number, " +
                        "pick_up, check_in_start, check_in_end, check_out, " +
                        "description, created_at, updated_at) " +
                        "VALUES (1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                "백련사", "전라남도 강진군 도암면 백련사길 145", "0558624425", false, "13", "24", "12",
                "전남 강진에 있는 백련사는 차와 동백이 아름다운 사찰로 유명합니다. 고려 말 민간신앙 결사체인 백련결사를 맺었던 이곳은 조선 말 다산 정약용 선생이 유배 왔을 때 아암 혜장선사와 종교와 나이를 뛰어넘은 교유의 공간으로 잘 알려진 곳이기도 합니다.\n만덕사로 불렸던 백련사가 있는 산에는 고려시대 때부터 자생해온 야생차 밭이 있어서 다산(茶山)이라고 불리기도 합니다. 때문에 정약용이 이곳으로 유배 와서 지냈다는 의미로 다산이라는 호를 지어 사용했습니다.",
                now.minusDays(1), now.minusDays(1)
        );

        // TODO: 이미지 AWS 로 수정 필요
        jdbcTemplate.update("" +
                        "INSERT INTO program(id, title, price, image_url, " +
                        "category, place_id, created_at, updated_at) " +
                        "VALUES (1, ?, ?, ?, ?, ?, ?, ?)",
                "따뜻한 위로의 차담, 만덕산 옛길 산책", 70000L, "https://user-images.githubusercontent.com/65386533/212583629-67fc3343-1ca5-410b-9371-725ac4736615.png", "TEMPLE", 1L,
                now.minusDays(1), now.minusDays(1)
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_offers(program_id, offers) " +
                        "VALUES (?, ?)",
                1L, "주차가능"
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_offers(program_id, offers) " +
                        "VALUES (?, ?)",
                1L, "수련복"
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_offers(program_id, offers) " +
                        "VALUES (?, ?)",
                1L, "사찰음식"
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_offers(program_id, offers) " +
                        "VALUES (?, ?)",
                1L, "일출"
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_offers(program_id, offers) " +
                        "VALUES (?, ?)",
                1L, "다도"
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_offers(program_id, offers) " +
                        "VALUES (?, ?)",
                1L, "연등"
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_offers(program_id, offers) " +
                        "VALUES (?, ?)",
                1L, "카페테리아"
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_offers(program_id, offers) " +
                        "VALUES (?, ?)",
                1L, "명상"
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_rules(program_id, rules) " +
                        "VALUES (?, ?)",
                1L, "여름에 소매 없는 옷과 무릎 위 짧은 바지는 삼가주세요."
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_rules(program_id, rules) " +
                        "VALUES (?, ?)",
                1L, "수건, 칫솔 등 개인 세면도구는 각자 준비하셔야 합니다."
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_rules(program_id, rules) " +
                        "VALUES (?, ?)",
                1L, "운동화 또는 등산화를 꼭 준비하세요."
        );

        jdbcTemplate.update("" +
                        "INSERT INTO program_rules(program_id, rules) " +
                        "VALUES (?, ?)",
                1L, "미성년자는 보호자나 인솔 교사의 동반 시에만 참가가 가능합니다."
        );

//        jdbcTemplate.update("" +
//                "INSERT INTO program(id, name, title, price, address, " +
//                "category, created_at, updated_at) " +
//                "VALUES (2, '구인사', '깨어있는 휴식, 여러가지 명상 체험', 50000, " +
//                "'충청북도 단양군 영춘면 구인사길 73', " +
//                "'TEMPLE', ?, ?)", now.minusDays(1).plusHours(1), now.minusDays(1).plusHours(1)
//        );
//
//        jdbcTemplate.update("" +
//                "INSERT INTO program(id, name, title, price, address, " +
//                "category, created_at, updated_at) " +
//                "VALUES (3, '백양사', '고즈넉한 풍경, 타종 체험, 외국인 가능', 70000, " +
//                "'전라남도 장성군 북하면 백양로 1239', " +
//                "'TEMPLE', ?, ?)", now.minusDays(1).plusHours(2), now.minusDays(1).plusHours(2)
//        );

        // TODO: 다른 카테고리들도 추가 필요

        //    FARM


        //    RELAX


        //    EXPERIENCE


        //    ONE_DAY

        return "Insert programs completed!";
    }
}
