package kr.bohyunkang.shimpyo.models;

import kr.bohyunkang.shimpyo.models.valueobjects.Address;
import kr.bohyunkang.shimpyo.models.valueobjects.Description;
import kr.bohyunkang.shimpyo.models.valueobjects.Name;
import kr.bohyunkang.shimpyo.models.valueobjects.PhoneNumber;
import kr.bohyunkang.shimpyo.models.valueobjects.PickUp;
import kr.bohyunkang.shimpyo.models.valueobjects.Time;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlaceTest {

    @Test
    void creation() {
        Name name = new Name("백련사");
        Address address = new Address("전라남도 강진군 도암면 백련사길 145");
        PhoneNumber phoneNumber = new PhoneNumber("01012345678");
        PickUp pickUp = new PickUp(false);
        Description description = new Description("전남 강진에 있는 백련사는 차와 동백이 아름다운 사찰로 유명합니다. 고려 말 민간신앙 결사체인 백련결사를 맺었던 이곳은 조선 말 다산 정약용 선생이 유배 왔을 때 아암 혜...");
        Time checkInStart = new Time("13");
        Time checkInEnd = new Time("24");
        Time checkOut = new Time("12");

        Place place = new Place(name, address, phoneNumber, pickUp, description, checkInStart, checkInEnd, checkOut);

        assertThat(place.getName()).isEqualTo(name);
        assertThat(place.getAddress()).isEqualTo(address);
        assertThat(place.getPhoneNumber()).isEqualTo(phoneNumber);
    }
}
