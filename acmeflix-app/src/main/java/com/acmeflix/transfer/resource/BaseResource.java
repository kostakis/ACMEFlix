package com.acmeflix.transfer.resource;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class BaseResource implements Serializable {
}
