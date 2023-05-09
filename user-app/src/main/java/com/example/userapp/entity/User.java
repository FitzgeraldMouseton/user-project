package com.example.userapp.entity;

import com.example.userapp.entity.enums.GenderEnum;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode(of = {"id"})
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findAllByPhoneIdsIn",
                query = "SELECT DISTINCT u FROM User u JOIN u.phones p WHERE p.id IN :phoneIds")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum gender;

    @Column(name = "age")
    private int age;

    @Column(name = "department_id")
    private String departmentId;

    @ToString.Exclude
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList<>();


    /*
     * TODO Связь один к одному игнорирует FetchType.LAZY и создает n+1 проблему. optional = false помогает решить эту проблему, но не для всех версий хибернэйта.
     *  Если, например, Account у нас может быть для юзера null, то при получении пачки юзеров хибернэйт будет по одному проверять
     *  аккаунты - не null ли там, и если нет - то оборачивать в прокси.
     *
     * TODO Второй здесь вопрос - тут у меня эксепшен при удалении из-за того, что user_id - это foreign key для аккаунта, и че-то каскады и orphanRemoval не помогли.
     *  Но тут вообще вопрос, насколько уместно каскадное удаление. Если предположить, что без юзера аккаунт не существует и не нужен,
     *  и здесь имеет смысл делать такое удаление. то у аккаунта потом могут появиться свои связи, где уже он будет foreign key, и там уже по
     *  логике приложения будет какая-то таблица, из которой нельзя будет удалять данные при удалении юзера (например, общий счет какой-то, к которому будут привязываться аккаунты).
     *  Соответственно, наверно, лучше сразу завести поле deleted и его изменять.
     */

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "account_id", insertable = false, updatable = false)
    private Long accountId;

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
