package com.bhupi.demo.query;


import com.bhupi.demo.request.SampleRequest;
import com.bhupi.demo.response.StudentResponse;
import com.bhupi.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Query {

    StudentService studentService;

    @Autowired
    public Query(StudentService studentService) {
        this.studentService = studentService;
    }

    @QueryMapping
    public String firstQuery() {
        return "First Query";
    }

    @QueryMapping
    public String secondQuery() {
        return "Second Query";
    }

    @QueryMapping
    public String fullName(@Argument String firstName, @Argument String lastName) {
        return firstName + " " + lastName;
    }


    @QueryMapping
    public String fullNameWithJson(@Argument SampleRequest sampleRequest) {
        return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
    }

    @QueryMapping
    public StudentResponse student(@Argument Integer id) {
        return new StudentResponse(studentService.getStudentById(id));
    }
}
