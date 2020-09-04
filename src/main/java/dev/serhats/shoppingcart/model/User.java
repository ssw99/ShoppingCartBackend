package dev.serhats.shoppingcart.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {
    @NotBlank(message = "User name can't be null!")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "User email can't be null!")
    @Email(message = "User email is not valid!")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user")
    private Cart cart;
}
