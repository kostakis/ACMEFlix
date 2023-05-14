package com.acmeflix.transfer.resource;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class BaseResource implements Serializable {
}
