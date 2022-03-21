package io.github.babakahmadi.springtemplate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Message {
    private String name;
    private String description;
    private int value;
}
