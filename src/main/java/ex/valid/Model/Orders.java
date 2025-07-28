package ex.valid.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Orders_Data")
public class Orders 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ordid;
	
	@NotBlank(message = "Product name is required")
	private String productName;
	//@Size(min = 1,message = "Quantity must be at least 1")
	@Min(1)
	private String quantity;
	
	@ManyToOne
	@JoinColumn(name = "User_id",referencedColumnName = "id")
	@JsonBackReference
	private User user;
	
}
