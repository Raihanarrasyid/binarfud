package com.binar.binarchallenge4.model;

import com.binar.binarchallenge4.entity.Order_Detail;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddOrderRequest {
    private Date date;

    @NotBlank
    private String destinationAddress;

    @NotBlank
    private int userId;

    @NotBlank
    private List<Order_Detail> orderDetails;
}
