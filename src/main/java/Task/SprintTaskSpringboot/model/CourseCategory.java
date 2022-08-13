package Task.SprintTaskSpringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_courseCategory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseCategory{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name; // Programming, IT, Math, Finance
}
