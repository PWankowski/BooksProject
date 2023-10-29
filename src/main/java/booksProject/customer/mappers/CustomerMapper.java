package booksProject.customer.mappers;

import booksProject.customer.dto.CustomerDto;
import booksProject.customer.dto.CustomerForm;
import booksProject.customer.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public static CustomerDto mapToDto(CustomerEntity customer) {

        return new CustomerDto()
                .setUuid(customer.getUuid())
                .setName(customer.getName())
                .setSurname(customer.getSurname())
                .setAge(customer.getAge())
                .setEmailAddress(customer.getEmailAddress())
                .setSex(customer.getSex());
    }

    public static CustomerDto mapToDto(CustomerForm form) {

        return new CustomerDto()
                .setUuid(UUID.randomUUID().toString())
                .setName(form.getName())
                .setSurname(form.getSurname())
                .setAge(form.getAge())
                .setEmailAddress(form.getEmailAddress())
                .setSex(form.getSex());
    }

    public static List<CustomerDto> map(List<CustomerEntity> customerList) {

       return customerList.stream()
                .map(customer -> mapToDto(customer))
                .collect(Collectors.toList());
    }

    public static CustomerEntity mapToEntity(CustomerDto customerDto) {

        return new CustomerEntity()
                .setUuid(UUID.randomUUID().toString())
                .setName(customerDto.getName())
                .setSurname(customerDto.getSurname())
                .setAge(customerDto.getAge())
                .setEmailAddress(customerDto.getEmailAddress())
                .setSex(customerDto.getSex());
    }
}