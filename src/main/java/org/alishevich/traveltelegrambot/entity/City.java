package org.alishevich.traveltelegrambot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class City extends BaseEntity{

    @Column(name = "name")
    @NotBlank
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    @JsonManagedReference
    private List<Info> infos;

    public City(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
