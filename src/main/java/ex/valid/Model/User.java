package ex.valid.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "User_Val_Data")
 public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "This field can not be empty")
	private String firstName;
	@Email(message = "This Email is NOt Valid")
	@NotBlank
	private String email;
	
	@Embedded
	private Address address;
	@ElementCollection
	@Size(min = 1, message = "At least one hobby is required")
	private List<@NotBlank(message = "Hobby cannot be blank")String> hobbies;
	
	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
	@Size(min = 1,message = "At least one order is required")
	@JsonManagedReference
	@Valid
	private List<Orders> orders;
	
}






