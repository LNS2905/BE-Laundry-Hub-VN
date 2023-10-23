package laundryhubvn.Controller;
import laundryhubvn.Entity.Feedback;
import laundryhubvn.Service.FeedbackService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService ;
    @GetMapping
    public List<Feedback> GetListFeedBack(){
        return feedbackService.getAllFeedback();
    }
    @PostMapping
    public void createFeedback(@RequestBody Feedback request){
        feedbackService.createFeedback(request);
    }

    @DeleteMapping("/{feedbackId}")
    public void deleteFeedback(@PathVariable("feedbackId") int id){
        feedbackService.deleteFeedback(id);
    }

    @PostMapping("/{feedbackId}")
    public void UpdateFeedback(@PathVariable ("feedbackId") int id, String description){
        feedbackService.UpdateFeedback(id , description);
    }
}
