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
@Table(name = "Store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="store_id")
    private int store_id;
    @Column(name="store_name")
    private String store_name;
    @Column(name="address")
    private String address;
    @Column(name="phone_number")
    private int phone_number;
    @Column(name = "admin_id")
    private int admin_id;
    @Column(name = "status")
    private boolean status;
}
