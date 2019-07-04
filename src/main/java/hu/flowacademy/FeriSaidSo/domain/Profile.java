package hu.flowacademy.FeriSaidSo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@Data
@EqualsAndHashCode(callSuper = false)
public class Profile extends User {

    @Column
    private boolean following;

}
