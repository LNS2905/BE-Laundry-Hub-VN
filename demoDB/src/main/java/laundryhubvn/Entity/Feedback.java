package laundryhubvn.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Feedback")
public class Feedback {
    @Id
    @Column(name="feedback_id")
    private int feedbackID;
    @Column(name="order_id")
    private int orderID;
    @Column(name="description")
    private String description;
    @Column(name="rate")
    private int rate;

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackID=" + feedbackID +
                ", orderID=" + orderID +
                ", description='" + description + '\'' +
                ", rate=" + rate +
                '}';
    }
}
