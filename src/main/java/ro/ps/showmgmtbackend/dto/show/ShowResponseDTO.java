package ro.ps.showmgmtbackend.dto.show;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Represents a show ResponseDTO
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowResponseDTO {
    private UUID showId;
    private String name;
    private Float price;
    private String location;
    private LocalDate eventDate;
    private String description;
    private Integer numberOfTicketsLeft;
}
