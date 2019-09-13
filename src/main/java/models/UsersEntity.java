package models;

import javax.persistence.*;

@Entity
@Table(name = "Users", schema = "FirstJavaBase")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int userId;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "UserAge")
    private Integer userAge;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Groop_Id")
    private GroupEntity group;

    public UsersEntity() {
    }

    public UsersEntity(String userName, Integer userAge) {
        this.userAge = userAge;
        this.userName = userName;
    }

    public GroupEntity getGroop() {
        return group;
    }

    public void setGroup(GroupEntity groop) {
        this.group = groop;
    }

    public void removeGroup() {
        this.group = null;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userAge != null ? !userAge.equals(that.userAge) : that.userAge != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userAge != null ? userAge.hashCode() : 0);
        return result;
    }

    public void printWithGroup() {
        if (this.group != null)
            System.out.println(
                    "userId=" + userId +
                            ", userName='" + userName + '\'' +
                            ", userAge=" + userAge + '\'' +
                            ", groupNumber = "+this.group.getGroopNumber()+ '\'' +
                            ", groupId = "+this.group.getGroopId()
            );
        else
            System.out.println(
                    "userId=" + userId +
                            ", userName='" + userName + '\'' +
                            ", userAge=" + userAge + '\'' +
                            ", groupNumber = no group"
            );
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
