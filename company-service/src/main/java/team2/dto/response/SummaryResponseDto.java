package team2.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryResponseDto {
    private Long id;
    private String name;
    private String title;
    private String phone;
    private String address;
    private String email;
}
