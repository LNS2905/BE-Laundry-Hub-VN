package laundryhubvn.Entity;

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
@Table(name = "Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="service_id")
    private int service_id;
    @Column(name = "service_name")
    private  String service_name;
    @Column(name = "price")
    private float price;
    @Column(name = "store_id")
    private int store_id;
    @Column(name = "description")
    private String description;
}
