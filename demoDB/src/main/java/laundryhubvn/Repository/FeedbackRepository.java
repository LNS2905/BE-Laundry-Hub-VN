package laundryhubvn.Repository;

import laundryhubvn.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{
//    @Query("SELECT f.order_id , f.description, f.rate" +
//            "FROM [Feedback] f" +
//            "JOIN [Order] o ON f.order_id = o.order_id" +
//            "JOIN Customer c ON o.customer_id = c.customer_id\n" +
//            "WHERE c.customer_name LIKE '%customerName%'")
//    List<Feedback> findByCustomer (@Param("customerName") String customerName);
}
