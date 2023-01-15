package com.acmeflix.transfer.resource;

import lombok.Data;

@Data
public class MovieResource extends BaseResource {
    String movieName;
    Long id;
}
