package services;

import dao.UserDao;
import models.GroupEntity;
import models.UsersEntity;

import java.util.List;

public class UserService implements CommonService<UsersEntity> {
    private UserDao userDao = new UserDao();
    private UsersEntity user = new UsersEntity();

    public UserService() {
    }

    @Override
    public UsersEntity find(int id) {
        return userDao.findById(id);
    }

    @Override
    public void save(UsersEntity obj) {
        userDao.save(obj);
    }

    @Override
    public void delete(UsersEntity obj) {
        userDao.delete(obj);
    }

    @Override
    public void update(UsersEntity obj) {
        userDao.update(obj);
    }

    @Override
    public List<UsersEntity> getAll() {
        return userDao.getAll();
    }

    public void addUser(String name, int age) {
        save(new UsersEntity(name, age));
        System.out.println("\nStudent saved");
    }

    public void changeGroupForStudent(int idUser, int idGroup) {
        GroupService groupService = new GroupService();
        user = find(idUser);
        GroupEntity group = groupService.find(idGroup);

        user.setGroup(group);
        group.addUser(user);

        update(user);
        groupService.update(group);
        System.out.println("\nAdded");
    }

    public void changeUserInfo(int idUser, String name, int age) {
        user = find(idUser);
        user.setUserName(name);
        user.setUserAge(age);
        update(user);
    }

    public void deleteUser(int idUser) {
        delete(find(idUser));
        System.out.println("\nUser deleted");
    }

    public void showAll() {
        List<UsersEntity> list = getAll();
        System.out.println("=====================");
        if(list.size()==0)
            System.out.println("There are no students");
        else {
            for (UsersEntity g : list) {
                g.printWithGroup();
            }
        }
        System.out.println("=====================");
    }
}
