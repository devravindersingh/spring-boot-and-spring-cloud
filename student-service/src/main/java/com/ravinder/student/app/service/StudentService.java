package com.ravinder.student.app.service;

import com.ravinder.student.app.entity.Student;
import com.ravinder.student.app.repository.StudentRepository;
import com.ravinder.student.app.request.CreateStudentRequest;
import com.ravinder.student.app.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CommonService commonService;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAddressId(createStudentRequest.getAddressId());
        student = studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
        return studentResponse;
    }

    public StudentResponse getById (long id) {
        Student student = studentRepository.findById(id).orElse(null);
        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
        return studentResponse;
    }




    
//    using webclient webClient
//    public AddressResponse getAddressById(long addressId){
//        Mono<AddressResponse> addressResponse=
//                webClient
//                        .get()
//                        .uri("/getById/" + addressId)
//                        .retrieve()
//                        .bodyToMono(AddressResponse.class);
//
//        return addressResponse.block();
//    }
}