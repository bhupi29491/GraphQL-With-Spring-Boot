package com.bhupi.demo.response;

import com.bhupi.demo.entity.Student;
import com.bhupi.demo.entity.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class StudentResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;

    private List<SubjectResponse> learningSubjects;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();

        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();

        if (student.getLearningSubjects() != null) {
            learningSubjects = new ArrayList<SubjectResponse>();
            for(Subject subject : student.getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }
    }
}
