package org.alishevich.traveltelegrambot.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "info")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Info extends BaseEntity{

    @Column(name = "city_info")
    @NotBlank
    @Size(min = 15, max = 300)
    private String cityInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;

    public Info(Integer id, String cityInfo) {
        super(id);
        this.cityInfo = cityInfo;
    }
}
