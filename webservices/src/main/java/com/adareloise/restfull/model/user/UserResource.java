package com.adareloise.restfull.model.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserResource {
	
	private Integer id;

	@Size(min=2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Past
	private Date birthDay;

}
