package com.mbinfotechworld.SCM_2.entitiy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.*;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String user_id;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(length = 1000)
    private String about;
    @Column(length = 1000)
    private String profilePic;
    private String phoneNo;
    private boolean enable = false;
    private boolean emailVerified = false;
    private boolean phoneVerifed = false;

    @Enumerated(value = EnumType.STRING)
    private Providers providers = Providers.SELF;
    private Providers providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roleList = new ArrayList<>();

    private String emailToken;

}
