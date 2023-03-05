package Docsafe.userService.entities;

import Docsafe.userService.validation.userValidation.docId.ValidateDocID;
import Docsafe.userService.validation.userValidation.id.ValidateUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long ID;
    @NotNull
    @Column
    @ValidateUserId
    private String userID;
    @Column
    @NotNull
    private String password;
    @Column
    @NotNull
    private String email;
    @Column
    @NotNull
    @ValidateDocID
    private String docID;
    @Column
    @NotNull
    private String phone;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
