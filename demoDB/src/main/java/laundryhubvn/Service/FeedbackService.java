package laundryhubvn.Service;
import laundryhubvn.Entity.Feedback;
import laundryhubvn.Repository.FeedbackRepository;
import lombok.AllArgsConstructor;
import laundryhubvn.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    public List<Feedback> getAllFeedback(){
        return feedbackRepository.findAll();
    }

    public void createFeedback(Feedback feedback){
        // kiểm tra order_id có tồn tại ở bảng order hay ko
        feedbackRepository.save(feedback);
    }
    public void deleteFeedback(int id) {
        feedbackRepository.deleteById(id);
    }

    public void UpdateFeedback(int id, String description) {
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new IllegalStateException("This feedback with this id is not exist"));
        feedback.setDescription(description);
        feedbackRepository.save(feedback);
    }
}
