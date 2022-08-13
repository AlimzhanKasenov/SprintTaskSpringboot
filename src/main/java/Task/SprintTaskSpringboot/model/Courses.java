package Task.SprintTaskSpringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Courses{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "rating")
    private double rating; // 1,2,3,4,5

    @ManyToOne(fetch = FetchType.EAGER)
    private User author;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<CourseCategory> category;

}
