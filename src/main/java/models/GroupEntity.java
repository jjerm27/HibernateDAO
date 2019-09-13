package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "good_group", schema = "FirstJavaBase")
public class GroupEntity {
    @Id
    @Column(name = "GroopId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    @Column(name = "GroopNumber")
    private String groupNumber;

    @OneToMany(targetEntity = UsersEntity.class,mappedBy = "group",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<UsersEntity>users;

    public GroupEntity(){}

    public GroupEntity(String groupNumber) {
        this.groupNumber = groupNumber;
        users = new ArrayList<>();
    }

    public void addUser(UsersEntity user){
        user.setGroup(this);
        users.add(user);
    }

    public void removeUser(UsersEntity user){
        users.remove(user);
    }

    public List<UsersEntity> getUsers(){
        return users;
    }

    public void setUsers(List<UsersEntity> list){
        this.users = list;
    }

    public int getGroopId() {
        return groupId;
    }

    public void setGroopId(int groopId) {
        this.groupId = groopId;
    }

    public String getGroopNumber() {
        return groupNumber;
    }

    public void setGroopNumber(String groopNumber) {
        this.groupNumber = groopNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupEntity that = (GroupEntity) o;

        if (groupId != that.groupId) return false;
        if (groupNumber != null ? !groupNumber.equals(that.groupNumber) : that.groupNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + (groupNumber != null ? groupNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "groupId = " + groupId +
                ", groupNumber= " + groupNumber;
    }
}
