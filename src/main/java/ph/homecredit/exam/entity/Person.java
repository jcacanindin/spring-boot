package ph.homecredit.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String firstName;

    @Column
    private String middleName;

    @Column
    @NotNull
    private String lastName;

    @Column
    @NotNull
    private Integer age;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private LocalDateTime created_Date;

    @Column
    @NotNull
    private LocalDateTime last_Modified_Date;

}
