package com.acmeflix.transfer;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiError {
    Integer status;
    String message;
    String path;
}
