package laundryhubvn.DTO;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedbackDTO {
    private int orderID;
    private String description;
    private int rate;

}
