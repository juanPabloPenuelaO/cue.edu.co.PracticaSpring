package cue.edu.co.PracticaSpringBoot.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class model {
    private String id;
    private String name;
    private int age;
    private String email;
    private String cellphone;
}
