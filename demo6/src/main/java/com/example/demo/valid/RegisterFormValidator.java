package com.example.demo.valid;


import com.example.demo.model.Users;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Created by nhs3108 on 10/2/16.
 */
@Component
public class RegisterFormValidator implements Validator
{
    @Autowired  public UserService userService;
    @Override
    public boolean supports(Class<?> clazz) {
        // Chỉ ra rằng nó sẽ chỉ có hiệu lực đối với RegisterForm.
        return Users.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors)
    {
        Users user = (Users) o;
        if (userService.getUserByEmail(user.getEmail())!=null)
        {
            errors.rejectValue("email", "Email này đã được sử dụng");
        }
    }
}
